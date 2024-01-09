package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final Cars cars;

    private Winner(Cars cars) {
        this.cars = cars;
    }

    public static Winner create(Cars cars) {
        return new Winner(cars);
    }

    public List<String> getWinnerNames() {
        Car winnerCandidate = cars.getMaxPositionCar();
        return getWinnerNames(winnerCandidate);
    }

    private List<String> getWinnerNames(Car maxPositionCar) {
        return cars.getCars()
                .stream()
                .filter(maxPositionCar::equalsPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
