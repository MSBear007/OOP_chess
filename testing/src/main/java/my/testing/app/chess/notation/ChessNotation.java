package my.testing.app.chess.notation;

import my.testing.app.chess.moves.ChessMove;
import my.testing.app.exceptions.InvalidChessNotation;

public interface ChessNotation<T extends ChessMove> {
    T toMove(String s) throws InvalidChessNotation;
}
