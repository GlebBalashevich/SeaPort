package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.service.PortManager;
import by.balashevich.seaport.state.ShipState;
import org.apache.logging.log4j.Level;

public class UnloadImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        PortManager manager = PortManager.getInstance();
        if (manager.loadingStorage(ship)){
            ship.nextState(new LeavingPortImpl());
        }
        logger.log(Level.INFO, ship.getName() + " unloaded, leave dock");
    }
}
