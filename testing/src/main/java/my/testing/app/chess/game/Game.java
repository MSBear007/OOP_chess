package my.testing.app.chess.game;


import lombok.Getter;
import lombok.Setter;
import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.BoardPoint;
import my.testing.app.chess.moves.ChessMove;
import my.testing.app.chess.moves.StandardChessMove;
import my.testing.app.chess.notation.ChessNotation;
import my.testing.app.chess.pieces.ChessColor;
import my.testing.app.chess.pieces.ChessPiece;
import my.testing.app.chess.pieces.CommonChessPiece;
import my.testing.app.chess.pieces.EmptyPiece;
import my.testing.app.chess.pieces.King;
import my.testing.app.chess.pieces.Pawn;
import my.testing.app.exceptions.InvalidChessNotation;

public class Game {
    @Getter @Setter private GameRule rule;
    @Getter private Board position;
    @Getter @Setter private GameState state;

    private ChessColor moveColor;
    /**
     * Number of consecutive moves without capture and pawn moves
     */
    private int dryMovesCount;

    public Game(GameRule rule) throws CloneNotSupportedException {
        this.rule = rule;
        position = rule.getStartPos();
        position.setPiece(new BoardPoint(0, 0), new Pawn(ChessColor.BLACK));
    }

    public boolean isCheck() {
        // TODO (i'm not gonna implement this)
        return false;
    }

    public boolean isCheckmate() {
        // TODO (i'm not gonna implement this)
        return false;
    }

    public <T extends ChessMove> void move(String s) throws InvalidChessNotation {
        if (isCheckmate()) {
            state = moveColor == ChessColor.BLACK ? GameState.WHITE_WIN : GameState.BLACK_WIN;
        }
        if (state.equals(GameState.BLACK_WIN) || state.equals(GameState.WHITE_WIN) || state.equals(GameState.DRAW)) {
            return;
        }
        
        ChessNotation notation = rule.getNotation();
        ChessMove move = notation.toMove(s);
        if (!moveColor.equals(position.getPiece(move.getFrom()).getColor())) {
            return;
        }

        ChessPiece<? extends ChessMove> piece = position.getPiece(move.getFrom());
        if (piece instanceof Pawn) {
            Pawn pawn = (Pawn)piece;
            if (pawn.canMove(move, position)) {
                position.setPiece(move.getFrom(), new EmptyPiece());
                position.setPiece(move.getTo(), piece);
                if (move instanceof StandardChessMove) {
                    if (((StandardChessMove)move).getPawnPromotion() != null) {
                        ChessPiece<? extends ChessMove> promoted = ((StandardChessMove)move).getPawnPromotion();
                        promoted.setColor(moveColor);
                        position.setPiece(move.getTo(), promoted);
                    }
                }
                // check en passant
            }
        } else if (piece instanceof King && move instanceof StandardChessMove) {
            King king = (King)piece;
            
            if (king.canMove((StandardChessMove)move, position)) {
                StandardChessMove stMove = (StandardChessMove)move;
                if (!stMove.isLongCastling() && !stMove.isShortCastling()) {
                    position.setPiece(move.getFrom(), new EmptyPiece());
                    position.setPiece(move.getTo(), piece);
                }
                else if (stMove.isLongCastling()) {
                    // todo whatever
                }
                else if (stMove.isShortCastling()) {
                    // todo whatever
                }
            }
        } else if (piece instanceof EmptyPiece){
            return;
        } else if (piece instanceof CommonChessPiece) {
            if (((CommonChessPiece)piece).canMove(move, position)) {
                position.setPiece(move.getFrom(), new EmptyPiece());
                position.setPiece(move.getTo(), piece);
            }
        }

        if (isCheck()) {
            position.setPiece(move.getFrom(), piece);
            position.setPiece(move.getTo(), new EmptyPiece());
            return;
        }
    }
}
