/*
 Вариант А

3. Автостоянка. Доступно несколько машиномест. 
На одном месте может находиться только один автомобиль. 
Если все места заняты, то автомобиль не
станет ждать больше определенного времени и уедет на другую стоянку.
*/

package firstproject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class ParkingLot {
    private final Semaphore parkingSpaces;

    public ParkingLot(int numberOfSpaces) {
        parkingSpaces = new Semaphore(numberOfSpaces);
    }

    public boolean tryToPark(String carName, long waitTime, TimeUnit unit) throws InterruptedException {
        if (parkingSpaces.tryAcquire(waitTime, unit)) {
            System.out.println(carName + " припарковался.");
            return true;
        } else {
            System.out.println(carName + " не смог найти место для парковки и уехал.");
            return false;
        }
    }

    public void leave(String carName) {
        parkingSpaces.release();
        System.out.println(carName + " выехал со стоянки.");
    }
}

class Car implements Runnable {
    private final String name;
    private final ParkingLot parkingLot;
    private final long waitTime;

    public Car(String name, ParkingLot parkingLot, long waitTime) {
        this.name = name;
        this.parkingLot = parkingLot;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        try {
            if (parkingLot.tryToPark(name, waitTime, TimeUnit.SECONDS)) {
                
                Thread.sleep((long) (Math.random() * 10000));
                parkingLot.leave(name);
            }
        } catch (InterruptedException e) {
            System.err.println(name + " был прерван.");
        }
    }
}

public class main {
    public static void main(String[] args) {
        int numberOfSpaces = 3;
        int numberOfCars = 10;
        long waitTime = 5; 
        
        ParkingLot parkingLot = new ParkingLot(numberOfSpaces);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCars);

        for (int i = 1; i <= numberOfCars; i++) {
            executorService.execute(new Car("Car " + i, parkingLot, waitTime));
        }

        executorService.shutdown();
    }
}
