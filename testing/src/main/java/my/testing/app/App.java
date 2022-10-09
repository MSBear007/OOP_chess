package my.testing.app;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import my.testing.app.chess.moves.*;
import my.testing.app.chess.notation.ChessNotation;
import my.testing.app.chess.notation.SimpleStandardNotation;
import my.testing.app.chess.pieces.*;
import my.testing.app.exceptions.InvalidChessNotation;

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
            ChessNotation<? extends ChessMove> notation = new SimpleStandardNotation();
            ChessMove move = notation.toMove("e8-e6");
            logger.info(move.toString());
        } catch (RuntimeException err) {
            logger.error(err.toString());
        } catch(InvalidChessNotation inv) {
            logger.error(inv.toString());
        } finally {
            logger.info("App terminated");
        }
    }
}
