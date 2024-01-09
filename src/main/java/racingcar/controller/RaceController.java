package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public void start() {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        int rounds = InputView.getRounds();
        RaceResult raceResult = new RaceResult(cars);

        System.out.println("\n실행 결과");
        IntStream.range(0, rounds).forEach(i -> {
//             TODO: Cars.startRace 메소드로 대체했으므로 버려야 함
//            moveCars(cars);
            raceResult.addRoundResult(cars);
            OutputView.displayRoundProgress(cars);
        });

        OutputView.displayWinners(raceResult.getWinners());
    }
}
