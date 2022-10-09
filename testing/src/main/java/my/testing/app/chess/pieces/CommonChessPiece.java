package my.testing.app.chess.pieces;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.ChessMove;

public abstract class CommonChessPiece extends ChessPiece<ChessMove> {

    public CommonChessPiece() {
        super();
    }

    public CommonChessPiece(ChessColor color) {
        super(color);
    }
    
    @Override
    public abstract boolean canMove(ChessMove move, Board board);
}
