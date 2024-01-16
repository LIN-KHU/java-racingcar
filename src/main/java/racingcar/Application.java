package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.List;

/*
메소드 상세
1. 자동차명 입력 받기 inputCarName
  1-1. 자동차명 예외 체크 checkCarName
2. 자동차 객체 생성 makeCars
3. 시도할 횟수 입력 받기 inputAttemptCount
  3-1. 시도할 횟수 예외 체크 checkAttemptCount
4. 경주 실행 결과 raceStartAndPrintResult
5. 우승자 getWinner
*/

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행
        // 1. 자동차명 입력
        String[] carNameList = inputCarName();

        // 2. 자동차 객체 생성
        List<Car> carList = makeCars(carNameList);

        // 3. 시도할 수 입력
        int num = inputAttemptCount();

        // 4. 경주 실행 결과
        raceStartAndPrintResult(num, carList);

        // 5. 우승자 출력
        System.out.println(getWinner(carList));
    }

    private static String input(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }

    private static boolean catchException(Runnable callback) {
         try {
            callback.run();
            return false;
         } catch (IllegalArgumentException e) {
             System.out.println(e.getMessage());
             return true;
         }
    }

    //============================================================================================================

    private static void checkCarName(String carNameStr) {
        String[] carNameList = carNameStr.split(",");
        for (String carName:carNameList) {
            carName = carName.trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 명은 5글자 이하");
            }
        }
    }

    private static String[] inputCarName() {
        String carNameStr = input("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        if (catchException(() -> checkCarName(carNameStr))) {
            inputCarName();
        }
        return carNameStr.split(",");
    }

    //============================================================================================================

    private static List<Car> makeCars(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName:carNameList) {
            carList.add(new Car(carName.trim()));
        }
        return carList;
    }

    //============================================================================================================

    private static void checkAttemptCount(String numStr) {
        try {
            int num = Integer.parseInt(numStr);
            if (num < 0) {
                throw new IllegalArgumentException("[ERROR] 숫자는 0이상");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    private static int inputAttemptCount() {
        String numStr = input("시도할 회수는 몇회인가요?");
        if (catchException(() -> checkAttemptCount(numStr))) {
            inputAttemptCount();
        }
        return Integer.parseInt(numStr);
    }

    //============================================================================================================

    private static void raceStartAndPrintResult(int num, List<Car> carList) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < num; i++) {
            for (Car car : carList) {
                car.move(Randoms.pickNumberInRange(1, 9));
                String bar = makeBar(car.getPosition());
                System.out.printf("%s : %s\n", car.getName(), bar);
            }
            System.out.println();
        }
    }

    private static String makeBar(int num) {
        String bar = "";
        for (int k = 0; k < num; k++) {
            bar += "-";
        }
        return bar;
    }

    private static String getWinner(List<Car> carList) {
        int maxNum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList) {
            if (car.getPosition() == maxNum) {
                stringBuilder.append(", ");
                stringBuilder.append(car.getName());
            }
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
                stringBuilder.setLength(0);
                stringBuilder.append(car.getName());
            }
        }
        return stringBuilder.toString();
    }
}
