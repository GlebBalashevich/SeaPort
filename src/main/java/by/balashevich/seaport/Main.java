package by.balashevich.seaport;

import by.balashevich.seaport.entity.Ship;

public class Main {
    public static void main(String[] args) {
        Ship ship1 = new Ship("Mary", 4, 4, Ship.TripTask.DELIVER_CARGO);
        Ship ship2 = new Ship("Ann", 5, 0, Ship.TripTask.ACCEPT_CARGO_DELIVERY);
        Ship ship3 = new Ship("Lucy", 2, 2, Ship.TripTask.DELIVER_CARGO);
        Ship ship4 = new Ship("Violet", 3, 0, Ship.TripTask.ACCEPT_CARGO_DELIVERY);
        Ship ship5 = new Ship("Kate", 5, 5, Ship.TripTask.DELIVER_CARGO);
        Ship ship6 = new Ship("Helen", 4, 4, Ship.TripTask.DELIVER_CARGO);
        Ship ship7 = new Ship("Eliza", 3, 3, Ship.TripTask.DELIVER_CARGO);
        Ship ship8 = new Ship("Sofi", 5, 0, Ship.TripTask.ACCEPT_CARGO_DELIVERY);
        Ship ship9 = new Ship("Neli", 2, 0, Ship.TripTask.ACCEPT_CARGO_DELIVERY);
        Ship ship10 = new Ship("Olha", 4, 0, Ship.TripTask.ACCEPT_CARGO_DELIVERY);
        Ship ship11 = new Ship("Iren", 3, 3, Ship.TripTask.DELIVER_CARGO);
        Thread thread1 = new Thread(ship1);
        Thread thread2 = new Thread(ship2);
        Thread thread3 = new Thread(ship3);
        Thread thread4 = new Thread(ship4);
        Thread thread5 = new Thread(ship5);
        Thread thread6 = new Thread(ship6);
        Thread thread7 = new Thread(ship7);
        Thread thread8 = new Thread(ship8);
        Thread thread9 = new Thread(ship9);
        Thread thread10 = new Thread(ship10);
        Thread thread11 = new Thread(ship11);

        try {
            thread1.start();
            Thread.sleep(300);
            thread2.start();
            Thread.sleep(500);
            thread3.start();
            Thread.sleep(800);
            thread4.start();
            Thread.sleep(900);
            thread5.start();
            Thread.sleep(1000);
            thread6.start();
            Thread.sleep(700);
            thread7.start();
            Thread.sleep(400);
            thread8.start();
            Thread.sleep(200);
            thread9.start();
            Thread.sleep(900);
            thread10.start();
            Thread.sleep(100);
            thread11.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
