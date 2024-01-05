package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;



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

    public static void main(String[] args) {
        // TODO 구현 진행
        // 1. 자동차명 입력
        boolean bool = false;
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

    }
}
