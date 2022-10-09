package my.testing.app.chess.pieces;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.ChessMove;

public class EmptyPiece extends CommonChessPiece {

    public ChessColor getColor() {
        return color;
    }

    public void setColor(ChessColor color) {
        this.color = color;
    }

    public boolean canMove(ChessMove move, Board board) {
        return false;
    }

}
