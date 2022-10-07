package my.testing.app;

import static org.junit.Assert.*;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.board.BoardPresets;
import my.testing.app.chess.moves.*;
import my.testing.app.chess.pieces.ChessColor;
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
        BoardPresets presets = new BoardPresets();
        Board stBoard = presets.standardBoard();
        BoardPoint p1 = new BoardPoint(1, 0);
        BoardPoint p2 = new BoardPoint(1, 1);
        BoardPoint p3 = new BoardPoint(3, 0);
        BoardPoint p4 = new BoardPoint(2, 0);
        ChessMove m1 = new StandardChessMove(p1, p2);
        ChessMove m2 = new StandardChessMove(p1, p3);
        ChessMove m3 = new StandardChessMove(p1, p4);
        ChessMove m4 = new StandardChessMove(p2, p1);
        Pawn pawn = new Pawn(ChessColor.BLACK);
        assertTrue(!pawn.canMove(m1, stBoard));
        assertTrue(pawn.canMove(m2, stBoard));
        assertTrue(pawn.canMove(m3, stBoard));
        assertTrue(!pawn.canMove(m4, stBoard));
    }
}
