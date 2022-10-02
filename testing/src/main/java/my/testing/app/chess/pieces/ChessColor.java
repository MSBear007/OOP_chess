package my.testing.app.chess.pieces;

import lombok.Getter;
import lombok.Setter;

public enum ChessColor {
    WHITE(0),
    BLACK(1);

    @Getter @Setter private int colorCode;

    private ChessColor(int colorCode) {
        this.colorCode = colorCode;
    }
}
