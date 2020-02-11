package CarGame;

import java.util.Random;

class Car implements Comparable<Car> {

    private final String car_name;
    private int position = 0;
    private Random random = new Random();

    Car(String name) {
        this.car_name = name;
    }

    public String getName() {
        return this.car_name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean forwardCheck() {
        return (4 <= random.nextInt(10));
    }

    public void addPosition() {
        if (forwardCheck()) {
            this.position++;
        }
    }

    public void printPosition() {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public int compareTo(Car car) {
        return car.getPosition() - position;
    }

}