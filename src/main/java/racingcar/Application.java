package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        //차 이름 입력 받음
        Car[] carArray = getCarName();

    private static Car[] getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine(); //String
        return setCars(cars);
    }
    }
}
