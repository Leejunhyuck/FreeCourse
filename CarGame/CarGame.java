package CarGame;

import java.util.Scanner;
import java.util.Arrays;

class CarGame {

    private Car cars[];
    private int round;

    Scanner scann = new Scanner(System.in);

    public void run() {
        System.out.println("게임을 시작합니다.");
        setCar();
        setRound();

        for (int i = 0; i < round; i++) {
            printProcess();
        }

        printResult();
    }

    public void setCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String input = scann.nextLine();

        final String arr[] = input.split(",");
        cars = new Car[arr.length];

        for (int i = 0; i < arr.length; i++) {
            cars[i] = new Car(arr[i]);
        }

    }

    public void setRound() {
        System.out.println("시도 할 횟수는 몇회인가요?");
        round = scann.nextInt();
    }

    public void printProcess() {
        System.out.println("실행 결과");

        for (final Car car : cars) {
            car.addPosition();
            System.out.print(car.getName() + " : ");
            car.printPosition();
        }
    }

    public void printResult() {
        StringBuilder str = new StringBuilder();
        Arrays.sort(cars);
        str.append(cars[0].getName());

        for (int i = 1; i < cars.length; i++) {
            if (cars[0].getPosition() != cars[i].getPosition()) {
                break;
            }
            str.append(",").append(cars[i].getName());
        }
        str.append(" 가 최종 우승 했습니다.");
        System.out.println(str);

    }

}