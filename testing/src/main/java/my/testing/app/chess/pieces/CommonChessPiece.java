package my.testing.app.chess.pieces;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.StandardChessMove;

public abstract class CommonChessPiece extends ChessPiece<StandardChessMove> {

    @Override
    abstract public boolean canMove(StandardChessMove move, Board board); // and board
}
