package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.service.PortManager;
import by.balashevich.seaport.state.ShipState;
import org.apache.logging.log4j.Level;

public class DockerPierImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        PortManager manager = PortManager.getInstance();
        manager.arriveDock();
        logger.log(Level.INFO, ship.getName() + " arrived to dock");
        if (ship.getTask() == Ship.TripTask.DELIVER_CARGO) {
            ship.nextState(new UnloadImpl());
        }
        if (ship.getTask() == Ship.TripTask.ACCEPT_CARGO_DELIVERY) {
            ship.nextState(new UploadImpl());
        }
    }
}
