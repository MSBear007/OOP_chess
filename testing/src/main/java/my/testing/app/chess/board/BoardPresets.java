package my.testing.app.chess.board;

import my.testing.app.chess.moves.ChessMove;
import my.testing.app.chess.pieces.*;
import java.util.ArrayList;

public class BoardPresets {
    
    public Board standardBoard() {
        ArrayList<ArrayList<ChessPiece<? extends ChessMove>>> standard = new ArrayList<ArrayList<ChessPiece<? extends ChessMove>>>(8);
        for (int i = 0; i < 8; i++) {
            standard.add(new ArrayList<ChessPiece<? extends ChessMove>>(8));
            for (int j = 0; j < 8; j++) {
                standard.get(i).add(new EmptyPiece());
            }
        }
        for (int i = 0; i < 8; ++i) {
            standard.get(1).set(i, new Pawn(ChessColor.BLACK));
            standard.get(6).set(i, new Pawn(ChessColor.WHITE));
        }
        //hor ver
        standard.get(0).set(0, new Rook(ChessColor.BLACK));
        standard.get(0).set(1, new Knight(ChessColor.BLACK));
        standard.get(0).set(2, new Bishop(ChessColor.BLACK));
        standard.get(0).set(3, new Queen(ChessColor.BLACK));
        standard.get(0).set(7, new Rook(ChessColor.BLACK));
        standard.get(0).set(6, new Knight(ChessColor.BLACK));
        standard.get(0).set(5, new Bishop(ChessColor.BLACK));
        standard.get(0).set(4, new King(ChessColor.BLACK));
        standard.get(7).set(0, new Rook(ChessColor.WHITE));
        standard.get(7).set(1, new Knight(ChessColor.WHITE));
        standard.get(7).set(2, new Bishop(ChessColor.WHITE));
        standard.get(7).set(3, new Queen(ChessColor.WHITE));
        standard.get(7).set(7, new Rook(ChessColor.WHITE));
        standard.get(7).set(6, new Knight(ChessColor.WHITE));
        standard.get(7).set(5, new Bishop(ChessColor.WHITE));
        standard.get(7).set(4, new King(ChessColor.WHITE));
        ((King)standard.get(7).get(4)).setAllowLongCastling(true);
        ((King)standard.get(7).get(4)).setAllowShortCastling(true);
        ((King)standard.get(0).get(4)).setAllowLongCastling(true);
        ((King)standard.get(0).get(4)).setAllowShortCastling(true);
        return new Board(standard);
    }
}
