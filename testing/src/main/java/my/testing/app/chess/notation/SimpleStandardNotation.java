package my.testing.app.chess.notation;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import my.testing.app.chess.moves.BoardPoint;
import my.testing.app.chess.moves.StandardChessMove;
import my.testing.app.chess.pieces.Bishop;
import my.testing.app.chess.pieces.Knight;
import my.testing.app.chess.pieces.Queen;
import my.testing.app.chess.pieces.Rook;
import my.testing.app.exceptions.InvalidChessNotation;

public class SimpleStandardNotation implements ChessNotation {

    
    @Override
    public StandardChessMove toMove(String s) throws InvalidChessNotation {
        StandardChessMove res = new StandardChessMove();
        if (s.equals("0--0")) {
            res.setShortCastling(true);
            return res;
        }
        if (s.equals("0--0--0")) {
            res.setLongCastling(true);
        }
        List<String> points = Pattern.compile("[a-h][1-8]")
            .matcher(s)
            .results()
            .map(MatchResult::group)
            .collect(Collectors.toList());
        if (points.size() < 2) throw new InvalidChessNotation("Not enough cells");
        else {
            int y1 = (int)points.get(0).charAt(0) - (int)'a';
            int x1 = 8 - ((int)points.get(0).charAt(1) - (int)'0');
            int y2 = (int)points.get(1).charAt(0) - (int)'a';
            int x2 = 8 - ((int)points.get(1).charAt(1) - (int)'0');
            res.setFrom(new BoardPoint(x1, y1));
            res.setTo(new BoardPoint(x2, y2));
        }
        Pattern promotion = Pattern.compile("[QNRB]$");
        Matcher matcher = promotion.matcher(s);
        if (matcher.find()) {
            switch (s.charAt(s.length() - 1)) {
                case 'N':
                    res.setPawnPromotion(new Knight());
                    break;
                case 'Q':
                    res.setPawnPromotion(new Queen());
                    break;
                case 'R':
                    res.setPawnPromotion(new Rook());
                    break;
                case 'B':
                    res.setPawnPromotion(new Bishop());
                    break;
                default:
                    throw new InvalidChessNotation("Wrong pawn promotion symbol");
            }
        }
        return res;
    }
    
}
