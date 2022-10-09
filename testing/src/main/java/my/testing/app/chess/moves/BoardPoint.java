package my.testing.app.chess.moves;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BoardPoint {
    @Getter @Setter public int x;
    @Getter @Setter public int y;

}
