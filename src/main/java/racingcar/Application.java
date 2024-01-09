package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = MakeCar();
        RunCar(cars);
        System.out.print("최종 우승자 : ");
        PrintWinner(cars);
    }

    public static List<Car> MakeCar() {
        String[] carnameArray = InputName();
        List<Car> cars = new ArrayList<>();
        for (String name : carnameArray) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static String[] InputName() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carname = Console.readLine();
            String[] returnArr = carname.split(",");
            try {
                InputError(returnArr);
                return returnArr;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void InputError(String[] arr) {
        for (String str : arr) {
            if (str.isEmpty() || (str.length() >= 6)) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름이 비어있거나 6자 이상임");
            }
        }
    }

    public static void RunCar(List<Car> cars) {
        int trycount = InputCnt();
        System.out.println("실행 결과");
        for (int i = 0; i < trycount; i++) {
            Try(cars);
        }
    }

    public static void Try(List<Car> cars) {
        for (Car c : cars) {
            c.Run();
        }
        System.out.print("\n");
    }

    public static int InputCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static void PrintWinner(List<Car> cars) {
        List<Integer> posList = GetPos(cars);
        int maxpos = posList.get(posList.size() - 1);
        int winner = 0;
        StringJoiner sj = new StringJoiner(", ");
        for (Car c : cars) {
            if (c.getPosition() == maxpos) {
                sj.add(c.getName());
            }
        }
        System.out.println(sj.toString());
    }
    public static List<Integer> GetPos(List<Car> cars) {
        List<Integer> position = new ArrayList<>();
        for (Car c : cars) {
            position.add(c.getPosition());
        }
        Collections.sort(position);
        return position;
    }
}