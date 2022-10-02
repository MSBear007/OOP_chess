package my.testing.app;

import static org.junit.Assert.*;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.board.BoardPresets;
import my.testing.app.chess.moves.*;
import my.testing.app.chess.pieces.ChessPiece;
import my.testing.app.chess.pieces.CommonChessPiece;
import my.testing.app.chess.pieces.King;
import my.testing.app.chess.pieces.Pawn;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestStandardChessMoves()
    {
        BoardPoint p1 = new BoardPoint(2, 7);
        BoardPoint p2 = new BoardPoint(-9, -19868765);
        StandardChessMove scm = new StandardChessMove(p1, p2);
        assertEquals(p1, scm.getFrom());
        assertEquals(p2, scm.getTo());
    }

    @Test
    public void isInstance() {
        CommonChessPiece king = new King();
        BoardPresets presets = new BoardPresets();
        Board example = presets.emptyBoard(1, 1);
        assertTrue(king instanceof ChessPiece<? extends ChessMove>);
        Pawn pawn = new Pawn();
        assertFalse(pawn.canMove(new StandardChessMove(), example));
    }
}
