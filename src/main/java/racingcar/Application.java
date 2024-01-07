package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String inputNames = Console.readLine();
        String[] carNames = inputNames.split(",");

        int attempts = 0;
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            attempts = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            return;
        }

        int[] totalDistances = new int[carNames.length];

        System.out.println("\n실행 결과");
        for(int attempt=0; attempt < attempts; attempt++) {
            for(int i=0; i < carNames.length; i++) {
                int randomCount = Randoms.pickNumberInRange(1, 10);
                totalDistances[i] += randomCount;
                
                String result = repeateString("-", randomCount);
                System.out.println(carNames[i]+ " : "+ result);
            }
        }

        String winner = determineWinner(carNames, totalDistances);
        System.out.println("\n최종 우승자: "+ winner);

    }

    private static String repeateString(String str, int n) {
        return new String(new char[n]).replace('\0', str.charAt(0));
    }

    private static String determineWinner(String[] carNames, int[] totalDistances) {
        String winner = carNames[0];
        int maxDistance = totalDistances[0];

        for(int i=1; i < carNames.length; i++) {
            if(totalDistances[i] > maxDistance) {
                winner = carNames[i];
                maxDistance = totalDistances[i];
            }
        }

        return winner;
    }
}

