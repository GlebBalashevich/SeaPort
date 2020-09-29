package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Port;
import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.state.ShipState;
import org.apache.logging.log4j.Level;

public class UnloadStateImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        Port port = Port.getInstance();
        port.loadingStorage(ship);
        if (ship.getTripTask() == Ship.TripTask.DELIVER_CARGO) {
            ship.nextState(new LeavingPortStateImpl());
            logger.log(Level.INFO, ship.getName() + " delivered cargo");
        }
        if(ship.getTripTask() == Ship.TripTask.DELIVER_AND_LOAD){
            ship.nextState(new UploadStateImpl());
            logger.log(Level.INFO, ship.getName() + " delivered, start to load cargo");
        }
    }
}
