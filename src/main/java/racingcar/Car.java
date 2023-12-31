package racingcar;

public class Car {
    private static final int MIN_MOVE_SOCRE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int score) {
        if (score >= MIN_MOVE_SOCRE) {
            position++
        }
    }
}
