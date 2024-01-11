package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class EndGame {
    static int N = StartGame.getN();
    static int T = StartGame.getT();

    public static void gameResult() {
        for (int i = 0; i < N; i++) {
            Car car;
            String carName = StartGame.getNames(i);
            car = new Car(carName);

            for (int j = 0; j < T; j++) {
                car.move();
            }

            System.out.println(carName + " : " + car.getPosition());
        }
    }
}
