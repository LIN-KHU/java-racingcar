package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Winner {
    public static void printWinner(List<Car> cars) {
        List<Integer> posList = getPosList(cars);
        int maxPos = Collections.max(posList);
        int winner = 0;
        StringJoiner sj = new StringJoiner(", ");
        for (Car c : cars) {
            if (c.getPosition() == maxPos) {
                sj.add(c.getName());
            }
        }
        System.out.println(sj.toString());
    }
    private static List<Integer> getPosList(List<Car> cars) {
        List<Integer> posList = new ArrayList<>();
        for (Car c : cars) {
            posList.add(c.getPosition());
        }
        return posList;
    }
}
