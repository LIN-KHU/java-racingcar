package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String GetCarName() { return this.name; }
    public void SetCarPosition(int i) { this.position = i; }
    public int GetCarPosition() { return this.position; }
}
