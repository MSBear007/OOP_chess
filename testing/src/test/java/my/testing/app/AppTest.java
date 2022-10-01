package my.testing.app;

import static org.junit.Assert.*;

import my.testing.app.chess.moves.*;

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
}
