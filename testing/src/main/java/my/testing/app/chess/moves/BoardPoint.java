package my.testing.app.chess.moves;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardPoint {
    @Getter @Setter public int x;
    @Getter @Setter public int y;
}
