package my.testing.app.chess.pieces;

import lombok.Getter;
import lombok.Setter;
import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.BoardPoint;
import my.testing.app.chess.moves.ChessMove;

public class Pawn extends ChessPiece<ChessMove> {

    @Getter
    @Setter
    private boolean allowEnPassant; // handled by caller
    @Getter
    @Setter
    private boolean alreadyMoved; // handled by caller

    @Override
    public boolean canMove(ChessMove move, Board board) throws IndexOutOfBoundsException {
        if (!checkMoveColor(move, board))
            return false;
        if (!(board.getPoint(move.getFrom()) instanceof Pawn)) {
            return false;
        }
        int direction = 0;
        switch (color) {
            case BLACK:
                direction = 1;
                break;
            case WHITE:
                direction = -1;
                break;
        }
        try {
            BoardPoint to = move.getTo();
            BoardPoint from = move.getFrom();
            // i think pawn promotion should be handled by caller class

            if (board.getPoint(to) instanceof EmptyPiece // common move
                    && to.y == from.y + direction
                    && to.x == from.x) {
                return true;
            } else if (!(board.getPoint(to) instanceof EmptyPiece) // capture move
                    && to.y == from.y + direction
                    && (to.x == from.x + 1 || from.x == from.x - 1)) {
                return true;
            } else if (!alreadyMoved && to.y == from.y + 2 * direction // double move
                    && to.x == from.x) {
                return true;
            }

        } catch (IndexOutOfBoundsException exc) { // todo: is it need?
            return false;
        }
        return false;
    }

    public void setColor(ChessColor color) {
        this.color = color;
    }

    public ChessColor getColor() {
        return color;
    }
}
