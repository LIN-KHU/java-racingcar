package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO 구현 진행
        List<Car> carList = inputCar();
        int attempts = inputAttempts();
        startRacing(carList, attempts);
        printFinalWinner(getWinnerList(carList));
    }

    public static List<Car> inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList;
        while (true) {
            String str = Console.readLine();
            List<String> carNameList = Arrays.asList(str.split(","));
            try {
                carList = makeCars(carNameList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carList;
    }

    public static List<Car> makeCars(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            validateInputCar(carName);
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public static void validateInputCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 이름은 5자 이하여야 한다.");
        }
    }

    public static int inputAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attempts;
        while (true) {
            try {
                String str = Console.readLine();
                attempts = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MESSAGE + " 시도 횟수는 숫자여야 한다.");
            }
        }
        return attempts;
    }

    public static void startRacing(List<Car> carList, int attempts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            startGameByAttempts(carList, attempts);
            printResult(carList);
        }
    }

    public static void startGameByAttempts(List<Car> carList, int attempts) {
        for (Car car : carList) {
            moveCar(car);
        }
    }

    public static void moveCar(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            car.moveCar();
        }
    }

    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    public static void printFinalWinner(List<String> winnerCarList) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", winnerCarList);
        System.out.println(result);
    }

    public static List<String> getWinnerList(List<Car> carList) {
        int maxCarPosition = carList.get(0).getPosition();
        List<String> winnerCarList = new ArrayList<>();
        for (Car car : carList) {
            int currentPosition = car.getPosition();
            if (currentPosition > maxCarPosition) {
                maxCarPosition = currentPosition;
                winnerCarList.clear();
            }
            if (currentPosition >= maxCarPosition) {
                winnerCarList.add(car.getName());
            }
        }
        return winnerCarList;
    }
}
