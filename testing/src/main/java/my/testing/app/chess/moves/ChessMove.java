package my.testing.app.chess.moves;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ChessMove {
    @Getter @Setter protected BoardPoint from;
    @Getter @Setter protected BoardPoint to;
}
