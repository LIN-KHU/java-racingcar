package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void run() {
        if(Randoms.pickNumberInRange(0,10) >= 4) position++;
        System.out.print(this.name+" : ");
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
