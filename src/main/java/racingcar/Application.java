package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {

        //차 이름 입력 받음
        Car[] carArray = getCarName();

        //시도 회수 입력 받음
        int count = getTryNumber();

        //시도 횟수 만큼 실행
        startCount(count, carArray);

        //우승자
        getWinner(carArray);

    }

    private static int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return getTryNumber();
        }
    }

    private static Car[] getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine(); //String
        return setCars(cars);
    }

    private static Car[] setCars(String cars){
        String[] carName = cars.split(","); //쉼표 단위로 잘라 문자열 배열에 넣음
        validateCarName(carName); //이름 예외 확인

        Car[] carArray = new Car[carName.length];

        //Car 배열 생성
        for(int i = 0; i < carName.length; i++) {
            carArray[i] = new Car(carName[i]);
        }

        return carArray;
    }

    private static void validateCarName(String[] carName) {

        for(String car : carName) {
            try{
                if(car.length()>5) throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 자동차 이름은 5자 이하여야 한다.");
                getCarName();
            }
        }
    }
}
