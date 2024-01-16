package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    String getName() {
        return this.name;
    }

    void move(int num) {
        if (num > 3) {
            this.position++;
        }
    }

    int getPosition() {
        return this.position;
    }
}
