package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = makeCar();
        doRace(cars);
        System.out.print("최종 우승자 : ");
        printWinner(cars);
    }

    public static List<Car> makeCar() {
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

    public static void printWinner(List<Car> cars) {
        List<Integer> posList = getPosList(cars);
        int maxPos = Collections.max(posList);
        int winner = 0;
        StringJoiner sj = new StringJoiner(", ");
        for (Car c : cars) {
            if (c.getPosition() == maxPos) {
                sj.add(c.getName());
            }
        }
        System.out.println(sj.toString());
    }
    public static List<Integer> getPosList(List<Car> cars) {
        List<Integer> posList = new ArrayList<>();
        for (Car c : cars) {
            posList.add(c.getPosition());
        }
        return posList;
    }
}