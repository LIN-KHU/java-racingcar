package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    static boolean checkCarName(String carName) {
        try {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 명은 5글자 이하");
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    static Car[] inputCarName() {
        boolean bool;
        Car[] carList;
        do {
            bool = false;
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNameStr = Console.readLine();
            String[] carNameList = carNameStr.split(",");
            carList = new Car[carNameList.length];
            for (int i = 0; i< carNameList.length; i++) {
                if (checkCarName(carNameList[i].trim())) {
                    bool = true;
                }
                carList[i] = new Car(carNameList[i].trim());
            }
        } while (bool);
        return carList;
    }

    static int inputAttemptCount() {
        int num;
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            String numStr = Console.readLine();
            try {
                num = Integer.parseInt(numStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
        }
        return num;
    }

    static String makeBar(int num) {
        String bar = "";
        for (int k = 0; k < num; k++) {
            bar += "-";
        }
        return bar;
    }

    static String getFinalWinner(Car[] carList) {
        int maxNum = 0;
        String winner = "";
        for (int i = 0; i < carList.length; i++) {
            if (carList[i].getPosition() == maxNum) {
                winner += ", " + carList[i].getName();
            }
            if (carList[i].getPosition() > maxNum) {
                maxNum = carList[i].getPosition();
                winner = carList[i].getName();
            }
        }
        return winner;
    }

    static void raceStart(int num, Car[] carList) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < carList.length; j++) {
                int ranNum = Randoms.pickNumberInRange(0, 9);
                if (ranNum >= 4) {
                    carList[j].run();
                }
                String bar = makeBar(carList[j].getPosition());
                System.out.printf("%s : %s\n", carList[j].getName(), bar);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO 구현 진행
        // 1. 자동차명 입력
        Car[] carList = inputCarName();

        // 2. 시도할 수 입력
        int num = inputAttemptCount();

        // 3. 실행 결과
        raceStart(num, carList);
        String winner = getFinalWinner(carList);
        System.out.println("최종 우승자 : " + winner);
    }
}
