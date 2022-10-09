package my.testing.app.chess.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import my.testing.app.chess.board.Board;
import my.testing.app.chess.moves.ChessMove;
import my.testing.app.chess.notation.ChessNotation;

@AllArgsConstructor
public class GameRule {
    @Getter private Board startPos;
    @Getter private ChessNotation notation;
    
}
