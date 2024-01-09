package racingcar.domain;

import racingcar.util.RaceCountGenerator;

public class Car implements Comparable<Car> {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;
    private final String name;
    public RaceCountGenerator raceCountGenerator = new RaceCountGenerator();
    private int position = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이내만 가능합니다.");
        }
        this.name = name;
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            position++;
        }
    }

    public void move() {
        int number = raceCountGenerator.makeRandomNumber();
        move(number);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return this.getPosition() - o.getPosition();
    }

    public boolean equalsPosition(Car car) {
        return this.getPosition() == car.getPosition();
    }
}
