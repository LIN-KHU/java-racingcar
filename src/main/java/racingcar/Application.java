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
                int number = randomNum();
                if (number >= 4) {
                    car.move();
                }
            }
        }
            int maxPosition = 0;
            ArrayList<String> Winners = new ArrayList<>();
            for (Car car : Cars) {
                if (car.getPosition() >= maxPosition) {
                    maxPosition = car.getPosition();
                    Winners.add(car.getName());
                }
            }
            System.out.println(Winners);
    }



            public static int randomNum ()
            {
                return Randoms.pickNumberInRange(1, 9);
            }


            public static String[] getNames ()
            {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String cars = Console.readLine();
                return cars.split(",");
            }
            public static int getTries ()
            {
                System.out.println("시도할 회수는 몇회인가요?");
                String tries = Console.readLine();
                int T = Integer.parseInt(tries);
                return T;
            }


        }
