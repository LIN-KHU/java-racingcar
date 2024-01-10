package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputCar {
    public static List<Car> start() {
        String[] carNameArray = inputName();
        List<Car> cars = new ArrayList<>();
        for (String name : carNameArray) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static String[] inputName() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carName = Console.readLine();
            String[] returnArr = carName.split(",");
            try {
                inputError(returnArr);
                return returnArr;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void inputError(String[] arr) {
        for (String str : arr) {
            if (str.isEmpty() || (str.length() >= 6)) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름이 비어있거나 6자 이상임");
            }
        }
    }
}
