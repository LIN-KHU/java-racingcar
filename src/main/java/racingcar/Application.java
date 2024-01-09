package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO 구현 진행
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList = inputCar();
        System.out.println("시도할 회수는 몇회인가요?");
        int attempts = inputAttempts();
        System.out.println("\n실행 결과");
        startRacing(carList, attempts);
    }

    public static List<Car> inputCar() {
        String str = Console.readLine();
        List<String> carNameList = Arrays.asList(str.split(","));
        return addCarList(carNameList);
    }

    public static List<Car> addCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            try {
                validateInputCar(carName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputCar();
            }
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
        try {
            String str = Console.readLine();
            int attempts = Integer.parseInt(str);
            return attempts;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE + " 시도 횟수는 숫자여야 한다.");
            return inputAttempts();
        }
    }

    public static void startRacing(List<Car> carList, int attempts) {
        List<List<String>> winnerList = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            startGameByAttempts(carList, attempts);
            getWinnerByAttempts(winnerList, carList);
            printResult(carList);
            carList = makeNewCar(carList); //새로운 car list 생성
        }
        printFinalWinner(getFinalWinner(winnerList));
    }

    public static void startGameByAttempts(List<Car> carList, int attempts) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : carList) {
                checkRandomNum(car);
            }
        }
    }

    public static void checkRandomNum(Car car) {
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

    public static List<Car> makeNewCar(List<Car> carList) {
        List<Car> newCarList = new ArrayList<>();
        for (Car carIdx : carList) {
            Car car = new Car(carIdx.getName());
            newCarList.add(car);
        }
        return newCarList;
    }

    public static void getWinnerByAttempts(List<List<String>> winnerList, List<Car> carList) {
        List<String> winnerCarListByAttempts = getWinnerList(carList);
        winnerList.add(winnerCarListByAttempts);
    }

    public static List<String> getWinnerList(List<Car> carList) {
        int highestPosition = carList.get(0).getPosition();
        List<String> winnerCarList = new ArrayList<>();
        for (Car car : carList) {
            int currentPosition = car.getPosition();
            if (currentPosition > highestPosition) {
                highestPosition = currentPosition;
                winnerCarList.clear();
            }
            if (currentPosition >= highestPosition) {
                winnerCarList.add(car.getName());
            }
        }
        return winnerCarList;
    }

    public static List<String> getFinalWinner(List<List<String>> winnerList) {
        Map<String, Integer> carWinnerMap = new HashMap<>();
        for (List<String> carNameList : winnerList) {
            for (String carName : carNameList) {
                carWinnerMap.put(carName, carWinnerMap.getOrDefault(carName, 0) + 1);
            }
        }
        int maxCarWinCnt = Collections.max(carWinnerMap.values());
        return getFinalWinnerList(carWinnerMap, maxCarWinCnt);
    }

    public static List<String> getFinalWinnerList(Map<String, Integer> carWinnerMap, int maxCarWinCnt) {
        List<String> finalWinnerList = new ArrayList<>();
        carWinnerMap.forEach((key, value) -> {
            if (value == maxCarWinCnt) {
                finalWinnerList.add(key);
            }
        });
        return finalWinnerList;
    }

    public static void printFinalWinner(List<String> finalWinnerList) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", finalWinnerList);
        System.out.println(result);
    }
}
