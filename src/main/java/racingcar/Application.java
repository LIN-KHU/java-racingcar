package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        List<String> carNamesList = getInput("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)", s -> Arrays.asList(s.split(",")), "[ERROR] 각 자동차의 이름은 5자 이하여야 합니다.");
        int attempts = getInput("시도할 횟수는 몇 회인가요?", Integer::parseInt, "[ERROR] 시도 횟수는 숫자여야 합니다.");

        Car[] cars = initializeCars(carNamesList);

        System.out.println("\n실행 결과");
        for(int attempt = 0; attempt < attempts; attempt++) {
            moveCars(cars);
            printCarStatus(cars);
        }

        List<String> winners = determineWinners(cars);
        System.out.println("\n최종 우승자: " + winners);
    }

    private static <T> T getInput(String prompt, Function<String, T> parser, String errorMessage) {
        T input;
        do {
            try {
                System.out.println(prompt);
                String userInput = Console.readLine();
                input = parser.apply(userInput);
                return input;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        } while (true);
    }

    private static Car[] initializeCars(List<String> carNamesList) {
        List<Car> validCars = carNamesList.stream().filter(name -> name.length() <= 5).map(Car::new).collect(Collectors.toList());

        return validCars.toArray(new Car[0]);
    }
    //less than 5 word carNames can be saved as Car object

    private static void moveCars(Car[] cars) {
        for(Car car : cars) {
            int randomCount = Randoms.pickNumberInRange(1, 10);
            car.move(randomCount);
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

        for (int i =1 ; i < cars.length; i++) {
            if(cars[i].getPosition() > maxDistance) {
                winners.clear();
                winners.add(cars[i].getName());
                maxDistance = cars[i].getPosition();
                continue;
            }
            
            if (cars[i].getPosition() == maxDistance) {
                winners.add(cars[i].getName());
            }
        }

        if (winners.isEmpty()) {
            winners.add(cars[0].getName());
        }
        
        return winners;
    }

    private static String repeatString(String str, int n) {
        return new String(new char[n]).replace('\0', str.charAt(0));
    }

}



