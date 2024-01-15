package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String[] getNames() {
        while(true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();
            String[] carNameList = carNames.split(",");
            try {
                validateName(carNameList);
                return carNameList;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public static void validateName(String[] CarsList) {
        for (String str : CarsList) {
            if (str.isEmpty() || str.length() >= 6) { //5자 이하여야 하나 공백 역시 허용 안됨
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 합니다");
            }
        }
    }

    public static int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Car> createCars() {
        String[] carList = getNames();
        List<Car> Cars = new ArrayList<>();
        for (String car : carList) {
            Cars.add(new Car(car));
        }
        return Cars;
    }

    public static void playGame(List<Car> CarsList) {
        int count = getCount();
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            for (Car car : CarsList) {
                car.moveCar();
            }
            System.out.print("\n");
        }
    }

    public static Integer getMaxPosition(List<Car> CarsList) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : CarsList) {
            positions.add(car.getPosition());
        }
        return Collections.max(positions);
    }

    public static void printMultipleWinners(int winnersCount) {
        if (winnersCount > 1) {
            System.out.print(", ");
        }
    }

    public static void printWinners(List<Car>CarsList) {
        int winnersCount = 0;
        int maxPosition = getMaxPosition(CarsList);
        System.out.print("최종 우승자 : ");
        for (Car car : CarsList) {
            if (car.getPosition() == maxPosition) {
                winnersCount++;
                printMultipleWinners(winnersCount);
                System.out.print(car.getName());
            }
        }
    }

    public static void main(String[] args) {
        List<Car> Cars = createCars();
        playGame(Cars);
        printWinners(Cars);
    }

}
