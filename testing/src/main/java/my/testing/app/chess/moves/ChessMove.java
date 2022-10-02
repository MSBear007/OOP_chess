package my.testing.app.chess.moves;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ChessMove {
    @Getter @Setter protected BoardPoint from;
    @Getter @Setter protected BoardPoint to;

    public ChessMove() {
        from = new BoardPoint(0, 0);
        to = new BoardPoint(0, 0);
    }
}
