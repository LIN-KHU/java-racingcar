package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String[] GetNames() {
        while(true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();
            String[] carNameList = carNames.split(",");
            try {
                checkError(carNameList);
                return carNameList;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public static void checkError(String[] CarsList) {
        for (String str : CarsList) {
            if (str.isEmpty() || str.length() >= 6) { //5자 이하여야 하나 공백 역시 허용 안됨
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 합니다");
            }
        }
    }

    public static int GetCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Car> CreateCars() {
        String[] carList = GetNames();
        List<Car> Cars = new ArrayList<>();
        for (String car : carList) {
            Cars.add(new Car(car));
        }
        return Cars;
    }

    public static void PlayGame(List<Car> CarsList) {
        int count = GetCount();
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            for (Car car : CarsList) {
                car.moveCar();
            }
            System.out.print("\n");
        }
    }

    public static Integer[] GetPosition(List<Car> CarsList) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : CarsList) {
            positions.add(car.Position());
        }
        Integer[] positionsArray = positions.toArray(new Integer[0]); // positions 리스트의 길이를 가진 Array 새롭게 생성 어차피 0과 positions의 길이를 비교한 후 큰 값으로 생성됨
        Arrays.sort(positionsArray);
        return positionsArray;
    }

    public static void multiplewinners(int winnercount) {
        if (winnercount > 1) {
            System.out.print(", ");
        }
    }

    public static void PrintWinners(List<Car>CarsList) {
        Integer[] positionsArray = GetPosition(CarsList);
        int winnercount = 0;
        int maxposition = positionsArray[positionsArray.length - 1];
        System.out.print("최종 우승자 : ");
        for (Car car : CarsList) {
            if (car.Position() == maxposition) {
                winnercount++;
                multiplewinners(winnercount);
                System.out.print(car.Name());
            }
        }
    }

    public static void main(String[] args) {
        List<Car> Cars = CreateCars();
        PlayGame(Cars);
        PrintWinners(Cars);
    }
}