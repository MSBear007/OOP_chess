package my.testing.app.chess.board;

import my.testing.app.chess.moves.ChessMove;
import my.testing.app.chess.pieces.*;
import java.util.ArrayList;

public class BoardPresets {
    public Board emptyBoard(int w, int h) {
        ArrayList<ArrayList<ChessPiece<? extends ChessMove>>> standard = new ArrayList<ArrayList<ChessPiece<? extends ChessMove>>>(8);
        for (int i = 0; i < w; i++) {
            standard.add(new ArrayList<ChessPiece<? extends ChessMove>>(h));
            for (int j = 0; j < h; j++) {
                standard.get(i).add(new EmptyPiece());
            }
        }
        return new Board(standard);
    }
}
