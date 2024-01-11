package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/*
메소드 상세
1. 자동차명 입력 및 오류 체크
2. 자동차 객체 생성
3. 시도할 횟수 입력
4. 경주 실행
5. 결과 출력
*/

public class Application {

    private static String[] inputCarName() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNameStr = Console.readLine();
            String[] carNameList = carNameStr.split(",");
            try {
                checkCarName(carNameList);
                return carNameList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkCarName(String[] carNameList) {
        for (String carName:carNameList) {
            carName = carName.trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 명은 5글자 이하");
            }
        }
    }

    private static List<Car> makeCars() {
        List<Car> carList = new ArrayList<>();
        String[] carNameList = inputCarName();
        for (String carName:carNameList) {
            carList.add(new Car(carName.trim()));
        }
        return carList;
    }

    private static int inputAttemptCount() {
        int num = 0;
        System.out.println("시도할 회수는 몇회인가요?");
        String numStr = Console.readLine();
        try {
            num = Integer.parseInt(numStr);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            inputAttemptCount();
        }
        return num;
    }

    private static void raceStart(int num, List<Car> carList) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < carList.size(); j++) {
                int ranNum = Randoms.pickNumberInRange(0, 9);
                carList.get(j).move(ranNum);
                String bar = makeBar(carList.get(j).getPosition());
                System.out.printf("%s : %s\n", carList.get(j).getName(), bar);
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

    private static List<String> getWinnerList(List<Car> carList) {
        int maxNum = 0;
        List<String> winner = new ArrayList<String>();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            if (car.getPosition() == maxNum) {
                winner.add(car.getName());
            }
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
                winner.clear();
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private static void printWinner(List<String> winnerList) {
        String winner = "";
        for (int i = 0; i < winnerList.size(); i++) {
            winner += winnerList.get(i);
            if (i < winnerList.size() - 1) {
                winner += ", ";
            }
        }
        System.out.println("최종우승자 : " + winner);
    }

    public static void main(String[] args) {
        // TODO 구현 진행
        // 1. 자동차 객체 생성
        List<Car> carList = makeCars();

        // 2. 시도할 수 입력
        int num = inputAttemptCount();

        // 3. 실행 결과
        raceStart(num, carList);

        printWinner(getWinnerList(carList));
    }
}
