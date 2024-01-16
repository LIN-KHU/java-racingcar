package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            position++;
        }
        System.out.print(this.name+" : ");
        for (int i = 0; i < position; i++){
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}