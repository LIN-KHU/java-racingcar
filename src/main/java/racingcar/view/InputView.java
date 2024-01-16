package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.InputValidator;

public class InputView {
    public static List<String> getCarNames() {
        List<String> carNames = null;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = Console.readLine();
                carNames = Arrays.asList(input.split(","));
                InputValidator.validateCarNames(carNames);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return carNames;
    }

    public static int getRounds() {
        int rounds = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = Console.readLine();
                InputValidator.verifyRounds(input);
                rounds = Integer.parseInt(input);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return rounds;
    }
}