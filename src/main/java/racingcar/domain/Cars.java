package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RaceCountGenerator;

public class Cars {
    private final List<Car> cars;
    private final RaceCountGenerator raceCountGenerator;

    public Cars(final String carNames, final RaceCountGenerator raceCountGenerator) {
        this.cars = create(carNames);
        this.raceCountGenerator = raceCountGenerator;
        validateDuplicateCarName();
    }

    public static Cars create(String carNames, RaceCountGenerator raceCountGenerator) {
        return new Cars(carNames, raceCountGenerator);
    }

    public void startRace() {
        cars.forEach(car -> car.move(raceCountGenerator.makeRandomNumber()));
    }

    private List<Car> create(String carNames) {
        String[] names = carNames.split(",");
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateDuplicateCarName() {
        int uniqueCarCount = new HashSet<>(cars).size();
        if (cars.size() != uniqueCarCount) {
            throw new IllegalArgumentException("중복된 차량 이름이 있습니다.");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}