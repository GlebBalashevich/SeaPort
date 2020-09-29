package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Port;
import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.state.ShipState;
import org.apache.logging.log4j.Level;

public class UploadStateImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        Port port = Port.getInstance();
        port.unloadingStorage(ship);
        ship.nextState(new LeavingPortStateImpl());
        logger.log(Level.INFO, ship.getName() + " uploaded cargo");
    }
}
