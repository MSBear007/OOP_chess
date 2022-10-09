package my.testing.app.chess.pieces;

import lombok.Getter;
import lombok.Setter;
import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.BoardPoint;
import my.testing.app.chess.moves.ChessMove;

public class Pawn extends CommonChessPiece {

    @Getter
    @Setter
    private boolean allowEnPassant; // handled by caller
    @Getter
    @Setter
    private boolean alreadyMoved; // handled by caller

    public Pawn() {
        super();
        allowEnPassant = false;
        alreadyMoved = false;
        
    }

    public Pawn(ChessColor color) {
        super(color);
        allowEnPassant = false;
        alreadyMoved = false;
    }

    @Override
    public boolean canMove(ChessMove move, Board board) {
        if (!checkMoveColor(move, board))
            return false;
        if (!(board.getPiece(move.getTo()) instanceof EmptyPiece)) {
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
            boolean enPassantPossible = board.getPiece(new BoardPoint(from.x, to.y)) instanceof Pawn 
                && ((Pawn)board.getPiece(new BoardPoint(from.x, to.y))).allowEnPassant == true;
            if (board.getPiece(to) instanceof EmptyPiece // common move
                    && to.x == from.x + direction
                    && to.y == from.y) {
                return true;
            } else if (!(board.getPiece(to) instanceof EmptyPiece) || enPassantPossible // capture move
                    && to.x == from.x + direction
                    && (to.y == from.y + 1 || from.y == from.y - 1)
                    && board.getPiece(to).color != this.color) {
                return true;
            } else if (!alreadyMoved && to.x == from.x + 2 * direction // double move
                    && to.y == from.y) {
                return true;
            }

        } catch (IndexOutOfBoundsException exc) { // todo: is it need?
            return false;
        }
        return false;
    }


}
