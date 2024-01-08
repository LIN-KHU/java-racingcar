package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList = inputCar();
        System.out.println("시도할 회수는 몇회인가요?");
        int attempts = inputAttempts();
    }

    public static List<Car> inputCar() {
        String str = Console.readLine();
        List<String> carNameList = Arrays.asList(str.split(","));
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }
    public static int inputAttempts(){
        String str = Console.readLine();
        int attempts = Integer.parseInt(str);
        return attempts;
    }
}
