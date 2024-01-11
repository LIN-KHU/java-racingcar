package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        String[] carNames = getValidCarNames();

        int attempts = getAttempts();
        Car[] cars = initializeCars(carNames);

        runRaceSimulation(attempts, cars);

        List<String> winners = determineWinners(cars);
        System.out.println("\n최종 우승자: " + winners);
    }

    private static String[] getValidCarNames() {
        String[] carNames;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
            String inpuNames = Console.readLine();
            carNames = inpuNames.split(",");
        } while(!checkNameLength(carNames));

        return carNames;

    }

    private static boolean checkNameLength(String[] carNames) {
        for(String carName : carNames) {
            if(carName.length() > 5) {
                System.out.println("[ERROR] 각 자동차의 이름은 5자 이하여야 합니다.");
                return false;
            }
        }
        return true;
    }

    private static void runRaceSimulation(int attemps, Car[] cars) {
        System.out.println("\n실행 결과");
        for(int attempt =0; attempt < attemps; attempt++) {
            moveCars(cars);
            printCarStatus(cars);
        }

    }

    private static int getAttempts() {
        int attemps = 0;
        do {
            try{
                System.out.println("시도할 횟수는 몇 회인가요?");
                attemps = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            }
        } while(true);
        return attemps;
    }

    private static Car[] initializeCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for(int i =0; i< carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars; 
    }

    private static void moveCars(Car[] cars) {
        for(Car car : cars) {
            int randomCount = Randoms.pickNumberInRange(1, 10);
            if(randomCount >3) {
                car.move();
            }
        }
    }

    private static void printCarStatus(Car[] cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + repeatString("-", car.getPosition()));
        }
        System.out.println("\n");
    }

    private static List<String> determineWinners(Car[] cars) {
        List<String> winners = new ArrayList<>();
        int maxDistance = cars[0].getPosition();

        for (int i =1 ; i<cars.length; i++) {
            if(cars[i].getPosition() > maxDistance) {
                winners.clear();
                winners.add(cars[i].getName());
                maxDistance = cars[i].getPosition();
            } else if (cars[i].getPosition() == maxDistance) {
                winners.add(cars[i].getName());
            }
        }
        return winners;
    }

    private static String repeatString(String str, int n) {
        return new String(new char[n]).replace('\0', str.charAt(0));
    }

}



