package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void Run() {
        if(Randoms.pickNumberInRange(0,10) >= 4) position++;
    }

    public int Position() {
        return this.position;
    }

    public String Name() {
        return this.name;
    }
}
