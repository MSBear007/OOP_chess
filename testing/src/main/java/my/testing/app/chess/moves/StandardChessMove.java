package my.testing.app.chess.moves;
import lombok.Getter;
import lombok.Setter;
import my.testing.app.chess.pieces.ChessPiece;

public class StandardChessMove extends ChessMove {
    @Getter @Setter private boolean isLongCastling;
    @Getter @Setter private boolean isShortCastling;
    @Getter @Setter private ChessPiece<ChessMove> pawnPromotion;

    public StandardChessMove(BoardPoint p1, BoardPoint p2) {
        super(p1, p2);
        isLongCastling = false;
        isShortCastling = false;
    }

    public StandardChessMove() {
        super();
    }
}
