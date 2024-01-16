package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        // 경주할 자동차이름 입력받기
            // 입력받은 자동차이름을 쉼표로 잘라서 스트링 배열로 저장

        String[] CarNames = readCarNames();

            // 배열을 이용하여 카 객체를 만든다.
        Car[] Cars = new Car[CarNames.length];

        for (int i = 0; i < CarNames.length; i++){
            Cars[i] = new Car(CarNames[i]);
        }

        // 시도할 횟수 입력받기

        int Try = getTry();

        // 게임 진행
        Play(Try, Cars);

        // 우승자 안내문구 출력
        Result(Cars);
    }

    // 함수 구현
    public static String[] getCarNames(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String str = scanner.nextLine();
        String[] carNames = str.split(",");
        return carNames;
    }

    public static String[] readCarNames(){
        try{
            String[] carNames = getCarNames();
            validateCarNames(carNames);
            return carNames;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }

    public static void validateCarNames(String[] str){
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
            }
        }

    }

    public static int getTry(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("시도할 회수는 몇회인가요?");
            int num = scanner.nextInt();
            return num;
        } catch(InputMismatchException e){
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return getTry();
        }
    }

    public static void Play(int Try, Car[] Cars){
        System.out.println("실행 결과");
        // 0~9사이의 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진
        for (int i = 0; i < Try; i++) {
            for (int j = 0; j < Cars.length; j++) {
                if ((int)(Math.random() * 10) >= 4){
                    Cars[j].SetCarPosition(Cars[j].GetCarPosition() + 1);
                }
                // 각 차수별 실행 결과 출력
                System.out.println(Cars[j].GetCarName() + " : " + new String(new char[Cars[j].GetCarPosition()]).replace("\0", "-"));
            }
            System.out.println("");
        }
    }
    public static void Result(Car[] Cars){
        // 모든 Cars 배열을 돌며 최대값 구하기
        int max = 0;
        for (int i = 0; i < Cars.length; i++) {
            if (Cars[i].GetCarPosition() > max){
                max = Cars[i].GetCarPosition();
            }
        }
        // 최댓값을 배열 내의 포지션을 비교하여 최대값과 같은 차의 이름을 스트링 배열에 저장
        String str = "";
        for (int i = 0; i < Cars.length; i++) {
            if (Cars[i].GetCarPosition() == max){
                str = str + Integer.toString(i);
            }
        }

        System.out.print("최종 우승자 : ");
        if (str.length() == 1){
            System.out.println(Cars[Integer.parseInt(str)].GetCarName());
        }
        else{
            System.out.print(Cars[str.charAt(0) - '0'].GetCarName());
            for (int i = 1; i < str.length(); i++) {
                System.out.print(", " + Cars[str.charAt(i) - '0'].GetCarName());
            }
        }
    }

}