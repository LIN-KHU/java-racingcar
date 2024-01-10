package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class StartGame {
    public static void startGame()
    {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        String[] carsArray = cars.split(",");
        int N = carsArray.length;
        System.out.println("시도할 회수는 몇회인가요?");
        String tries = Console.readLine();
        int T = Integer.parseInt(tries);
    }

}
