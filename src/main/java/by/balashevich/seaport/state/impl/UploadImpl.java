package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.service.PortManager;
import by.balashevich.seaport.state.ShipState;
import org.apache.logging.log4j.Level;

public class UploadImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        PortManager manager = PortManager.getInstance();
        if (manager.shipmentStorage(ship)){
            ship.nextState(new LeavingPortImpl());
        }
        logger.log(Level.INFO, ship.getName() + " uploaded, leaving dock");
    }
}
