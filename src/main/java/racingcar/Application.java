package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;


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

    private static void getWinner(Car[] carArray){
        List<String> winnerList = new ArrayList<String>();
        int max = carArray[0].getPosition();

        //max 값 구하기
        for (int i = 1; i < carArray.length; i++) {
            if (carArray[i].getPosition() > max) {
                max = carArray[i].getPosition();
            }
        }

        for (Car car : carArray) {
            if (car.getPosition() == max) {
                winnerList.add(car.getName());
            }
        }

        String winner = String.join(",", winnerList);

        System.out.println("최종 우승자 : " + winner + max);
    }

    private static void startCount(Integer count, Car[] carArray) {

        System.out.println("실행 결과");
        for(int i = 0; i < count; i++) {
            for(int j = 0; j < carArray.length; j++) {
                moveCar(carArray[j]);
            }
            System.out.println();
        }
    }

    private static void moveCar(Car car) {

        int randomNum = Randoms.pickNumberInRange(1,9); //숫자 랜덤으로 받음
        if(randomNum >= 4) {car.move();} //숫자가 4 이상인 경우 전진
        car.printCar();

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
