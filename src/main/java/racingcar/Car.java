package racingcar;

import java.util.ArrayList;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move() {
        position++;
    }

    public String printPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}

