package racingcar.domain;

public class Race {
    private final int raceCount;

    public Race(int raceCount) {
        this.raceCount = raceCount;
    }

    public boolean isFinished(int raceCount) {
        return raceCount >= this.getRaceCount();
    }

    public int getRaceCount() {
        return raceCount;
    }
}
