package my.testing.app.chess.pieces;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.ChessMove;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class ChessPiece<Move extends ChessMove> {
    protected ChessColor color;

    public boolean checkMoveColor(Move move, Board board) {
        if (board.getPoint(move.getFrom()).color == this.color) return true;
        else return false;
    }

    abstract public boolean canMove(Move move, Board board); // and board
    public ChessPiece(ChessColor color) {
        this.color = color;
    }

    public void setColor(ChessColor color) {
        this.color = color;
    }

    public ChessColor getColor() {
        return color;
    }
}
