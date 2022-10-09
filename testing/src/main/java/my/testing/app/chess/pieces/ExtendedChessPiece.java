package my.testing.app.chess.pieces;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.StandardChessMove;

public abstract class ExtendedChessPiece extends ChessPiece<StandardChessMove> {

    public ExtendedChessPiece(ChessColor color) {
        super(color);
    }
    public ExtendedChessPiece() {
        super();
    }
    @Override
    abstract public boolean canMove(StandardChessMove move, Board board);
}
