package racingcar.domain;

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

    public void printCar() {

        String count = "";

        for(int i = 0; i < position; i++){
            count = count + "-";
        }

        System.out.println(name + " : " + count );
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
