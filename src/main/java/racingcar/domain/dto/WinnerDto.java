package racingcar.domain.dto;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Winner;

public class WinnerDto {

    private final List<String> winnerNames;

    private WinnerDto(final List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public static Winner create(final Cars cars) {
        return Winner.create(cars);
    }

    public List<String> getWinnerNames(Winner winner) {
        return winner.getWinnerNames();
    }
}
