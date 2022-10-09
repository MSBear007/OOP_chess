package my.testing.app.chess.game;

import lombok.Getter;

public enum GameState {
    START_GAME(0),
    IN_GAME(1),
    DRAW(2),
    WHITE_WIN(3),
    BLACK_WIN(4),
    SOMETHING_ELSE(5);
    //...

    private @Getter int code;


    GameState(int code) {
        this.code = code;
    }


}
