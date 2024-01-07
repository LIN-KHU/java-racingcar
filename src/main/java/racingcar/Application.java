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

    static String[] inputCarName() {
        boolean bool;
        String[] carNameList;
        do {
            bool = false;
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNameStr = Console.readLine();
            carNameList = carNameStr.split(",");
            for (int i = 0; i< carNameList.length; i++) {
                String carName = carNameList[i].trim();
                carNameList[i] = carName;
                if (checkCarName(carName)) {
                    bool = true;
                }
            }
        } while (bool);
        return carNameList;
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

    static String getFinalWinner(String[] carNameList, int[] carRunNumList) {
        int maxNum = 0;
        String winner = "";
        for (int i = 0; i < carRunNumList.length; i++) {
            if (carRunNumList[i] == maxNum) {
                winner += ", " + carNameList[i];
            }
            if (carRunNumList[i] > maxNum) {
                maxNum = carRunNumList[i];
                winner = carNameList[i];
            }
        }
        return winner;
    }

    static int[]  getEachCarRunNumList(int num, String[] carNameList) {
        int[] carRunNumList = new int[carNameList.length];
        System.out.println("\n실행 결과");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < carNameList.length; j++) {
                int ranNum = Randoms.pickNumberInRange(0, 9);
                if (ranNum >= 4) {
                    carRunNumList[j] += 1;
                }
                String bar = makeBar(carRunNumList[j]);
                System.out.printf("%s : %s\n", carNameList[j], bar);
            }
            System.out.println();
        }
        return carRunNumList;
    }

    public static void main(String[] args) {
        // TODO 구현 진행
        // 1. 자동차명 입력
        String[] carNameList = inputCarName();
        // 2. 시도할 수 입력
        int num = inputAttemptCount();
        // 3. 실행 결과
        int[] carRunNumList = getEachCarRunNumList(num, carNameList);
        String winner = getFinalWinner(carNameList, carRunNumList);
        System.out.println("최종 우승자 : " + winner);
    }
}
