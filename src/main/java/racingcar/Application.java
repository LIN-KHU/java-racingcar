package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        String[] carNames = getNames();
        int tries = getTries();
        ArrayList<Car> Cars = new ArrayList<>();
        for (String car : carNames) {
            Car c = new Car(car);
            Cars.add(c);
        }
        for (int i = 0; i <= tries; i++) {
            for (Car car : Cars) {
                int number = RandomNum.randomNum();
                if (number >= 4) {
                    car.move();
                }
            }
            for (Car car: Cars){
            System.out.println(car.getName() +" : "+ car.printPosition());}
        }

        int maxPosition = 0;
        ArrayList<String> Winners = new ArrayList<>();
        for (Car car : Cars) {
            if (car.getPosition() >= maxPosition) {
                maxPosition = car.getPosition();
                Winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : "+Winners);
    }



    public static String[] getNames() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String cars = Console.readLine();
                String[] carArray = cars.split(",");

                for (String aCar : carArray) {
                    if (aCar.length() > 5) {
                        throw new IllegalArgumentException("부적절한 이름입니다.");
                    }
                }
                return carArray;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static int getTries() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇 회인가요?");
                String tries = Console.readLine();
                int T = Integer.parseInt(tries);

                if (T < 0 || T > 9) {
                    throw new IllegalArgumentException("시도 횟수는 0부터 9 사이여야 합니다.");
                }

                return T;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

}

