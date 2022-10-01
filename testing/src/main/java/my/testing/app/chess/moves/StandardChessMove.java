package my.testing.app.chess.moves;
import lombok.Getter;
import lombok.Setter;

public class StandardChessMove extends ChessMove {
    @Getter @Setter private boolean isLongCastling;
    @Getter @Setter private boolean isShortCastling;
    // todo pawn promotion

    public StandardChessMove(BoardPoint p1, BoardPoint p2) {
        super(p1, p2);
    }

    public StandardChessMove() {
        super();
    }
}
