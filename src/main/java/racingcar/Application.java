package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // StartGame 클래스의 startGame 메서드 직접 호출
        StartGame.startGame();

        // EndGame 클래스의 gameResult 메서드 호출
        EndGame.gameResult();
    }
}
