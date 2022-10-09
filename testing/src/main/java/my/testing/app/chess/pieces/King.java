package my.testing.app.chess.pieces;

import lombok.Getter;
import lombok.Setter;
import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.BoardPoint;
import my.testing.app.chess.moves.StandardChessMove;

public class King extends ExtendedChessPiece {
    public King(ChessColor color) {
        super(color);
    }
    public King() {
        super();
    }
    // handled by class-caller
    @Getter
    @Setter
    private boolean allowLongCastling;
    @Getter
    @Setter
    private boolean allowShortCastling;

    @Override
    public boolean canMove(StandardChessMove move, Board board) {
        if (!checkMoveColor(move, board))
            return false;
        if (allowLongCastling && move.isLongCastling())
            return true;
        if (allowShortCastling && move.isShortCastling())
            return true;
        BoardPoint to = move.getTo();
        BoardPoint from = move.getFrom();
        try {
            if (!(board.getPiece(from) instanceof King)) {
                return false;
            }
            if (board.getPiece(to).color == this.color) return false; // throws out of bounds
            if (Math.abs(to.x - from.x) <= 1 && Math.abs(to.y - from.y) <= 1
                    && Math.abs(to.x - from.x) + Math.abs(to.y - from.x) != 0) {
                return true;
            }
        }
        catch (IndexOutOfBoundsException exc) {
            return false;
        }
        return false;
    }
}
