package my.testing.app.chess.board;

import my.testing.app.chess.moves.BoardPoint;
import my.testing.app.chess.moves.ChessMove;
import my.testing.app.chess.pieces.*;
import java.util.ArrayList;
import lombok.Getter;


public class Board {
    @Getter private ArrayList<ArrayList<ChessPiece<? extends ChessMove>>> board;
    
    public Board(ArrayList<ArrayList<ChessPiece<? extends ChessMove>>> board) {
        this.board = board;
    }

    public void setPoint(BoardPoint point, ChessPiece<? extends ChessMove> piece) throws IndexOutOfBoundsException {
        board.get(point.x).set(point.y, piece);
    }

    public ChessPiece<? extends ChessMove> getPoint(BoardPoint point) throws IndexOutOfBoundsException {
        return board.get(point.x).get(point.y);
    }

    public ArrayList<ChessPiece<? extends ChessMove>> getLine(int index) throws IndexOutOfBoundsException{
        return board.get(index);
    }
}
