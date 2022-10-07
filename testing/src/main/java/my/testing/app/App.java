package my.testing.app;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import my.testing.app.chess.board.Board;
import my.testing.app.chess.board.BoardPresets;
import my.testing.app.chess.moves.*;
import my.testing.app.chess.pieces.*;

public class App 
{
    private static final Logger logger = LogManager.getLogger();

    private static void printPieceChar(ChessPiece<? extends ChessMove> p) {
        if (p instanceof King) {
            System.out.print("K");
        }
        if (p instanceof Rook) {
            System.out.print("R");
        }
        if (p instanceof Bishop) {
            System.out.print("B");
        }
        if (p instanceof Knight) {
            System.out.print("N");
        }
        if (p instanceof Pawn) {
            System.out.print("p");
        }
        if (p instanceof Queen) {
            System.out.print("Q");
        }
        if (p instanceof EmptyPiece) {
            System.out.print("e");
        }
        System.out.print(p.getColor() == ChessColor.BLACK ? "b" : "w");
    }
    public static void main( String[] args )
    {
        try {
            logger.info("App started");
            BoardPresets boardPresets = new BoardPresets();
            Board board = boardPresets.standardBoard();
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    printPieceChar(board.getPoint(new BoardPoint(i, j)));
                }
                System.out.println();
            }
            BoardPoint p1 = new BoardPoint(7, 0);
            BoardPoint p2 = new BoardPoint(7, 1);
            BoardPoint p3 = new BoardPoint(7, 2);
            BoardPoint p4 = new BoardPoint(5, 0);
            ChessMove m1 = new StandardChessMove(p1, p2);
            ChessMove m2 = new StandardChessMove(p1, p3);
            ChessMove m3 = new StandardChessMove(p1, p4);
            ChessMove m4 = new StandardChessMove(p2, p1);
            Rook knight = new Rook(ChessColor.WHITE);

            System.out.println(knight.canMove(m1, board));
            System.out.println(knight.canMove(m2, board));
            System.out.println(knight.canMove(m3, board));
            System.out.println(knight.canMove(m4, board));
        } catch (RuntimeException err) {
            logger.error(err.toString());
        } finally {
            logger.info("App terminated");
        }
    }
}
