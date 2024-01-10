package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = InputCar.start();
        Race.doRace(cars);
        System.out.print("최종 우승자 : ");
        Winner.printWinner(cars);
    }
}