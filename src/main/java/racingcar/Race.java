package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Race {
    public static void doRace(List<Car> cars) {
        int tryCount = inputTryCnt();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            runCarsInList(cars);
        }
    }

    public static void runCarsInList(List<Car> cars) {
        for (Car c : cars) {
            c.run();
        }
        System.out.print("\n");
    }

    public static int inputTryCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

}
