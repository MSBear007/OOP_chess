package my.testing.app.chess.pieces;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.BoardPoint;
import my.testing.app.chess.moves.ChessMove;

public class Bishop extends ChessPiece<ChessMove> {
    @Override
    public boolean canMove(ChessMove move, Board board) {
        if (!checkMoveColor(move, board))
            return false;
        
        BoardPoint to = move.getTo();
        BoardPoint from = move.getFrom();
        
        try {
            if (!(board.getPoint(from) instanceof Rook))
            return false;
            if (board.getPoint(to).color == this.color) return false; // throw out of bounds
            if (Math.abs(to.x - from.x) == Math.abs(to.y - from.y)) {
                int xdir = to.x > from.x ? 1 : -1;
                int ydir = to.y > from.y ? 1 : -1;
                BoardPoint current = new BoardPoint(from.x + xdir, from.y + ydir);
                while (!current.equals(to)) {
                    if (!(board.getPoint(current) instanceof EmptyPiece)) {
                        return false;
                    }
                    current.x += xdir;
                    current.y += ydir;
                }
                return true;
            }
        } catch (IndexOutOfBoundsException exc) {
            return false;
        }
        return false;
    }
}