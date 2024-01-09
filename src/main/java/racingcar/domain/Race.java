package racingcar.domain;

public class Race {
    private final int raceCount;
    private Winner winner;

    public Race(int raceCount) {
        this.raceCount = raceCount;
    }

    public boolean isFinished(int raceCount) {
        return raceCount >= this.getRaceCount();
    }

    public int getRaceCount() {
        return raceCount;
    }

    public Winner getWinnerCar() {
        return winner;
    }

    public void setWinnerCar(Winner winner) {
        this.winner = winner;
    }
}
