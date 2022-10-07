package my.testing.app.chess.pieces;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.BoardPoint;
import my.testing.app.chess.moves.ChessMove;

public class Knight extends ChessPiece<ChessMove> {

    public Knight(ChessColor color) {
        super(color);
    }
    public Knight() {
        super();
    }
    // surprised that it's easiest
    @Override
    public boolean canMove(ChessMove move, Board board) {
        if (!checkMoveColor(move, board))
            return false;
        BoardPoint to = move.getTo();
        BoardPoint from = move.getFrom();
        try {
            if (!(board.getPoint(from) instanceof Knight))
                return false;
            if (board.getPoint(to).color == this.color) return false; // throws out of bounds
            int xsh = Math.abs(to.x - from.x);
            int ysh = Math.abs(to.y - from.y);
            if (xsh == 1 && ysh == 2 || ysh == 1 && xsh == 2)
                return true;
        }
        catch (IndexOutOfBoundsException exc) {
            return false;
        }
        return false;
    }
    
}
