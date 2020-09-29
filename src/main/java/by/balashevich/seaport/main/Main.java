package by.balashevich.seaport.main;

import by.balashevich.seaport.entity.Ship;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ship> shipList = new ArrayList<>();
        shipList.add(new Ship("Mary", 4, 4, Ship.TripTask.DELIVER_CARGO));
        shipList.add(new Ship("Ann", 5, 0, Ship.TripTask.LOAD_CARGO));
        shipList.add(new Ship("Lucy", 2, 2, Ship.TripTask.DELIVER_CARGO));
        shipList.add(new Ship("Violet", 3, 0, Ship.TripTask.LOAD_CARGO));
        shipList.add(new Ship("Kate", 5, 5, Ship.TripTask.DELIVER_CARGO));
        shipList.add(new Ship("Helen", 4, 4, Ship.TripTask.DELIVER_AND_LOAD));
        shipList.add(new Ship("Eliza", 3, 3, Ship.TripTask.DELIVER_CARGO));
        shipList.add(new Ship("Sofi", 5, 0, Ship.TripTask.LOAD_CARGO));
        shipList.add(new Ship("Neli", 2, 0, Ship.TripTask.DELIVER_AND_LOAD));
        shipList.add(new Ship("Olha", 4, 0, Ship.TripTask.LOAD_CARGO));
        shipList.add(new Ship("Iren", 3, 3, Ship.TripTask.DELIVER_CARGO));

        for (Ship ship : shipList) {
            new Thread(ship).start();
        }
    }
}
