package my.testing.app.chess.notation;

import my.testing.app.chess.moves.ChessMove;
import my.testing.app.exceptions.InvalidChessNotation;

public interface ChessNotation {
    ChessMove toMove(String s) throws InvalidChessNotation;
}
