package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceCountGenerator {

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
