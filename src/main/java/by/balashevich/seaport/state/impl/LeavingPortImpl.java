package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.service.PortManager;
import by.balashevich.seaport.state.ShipState;
import org.apache.logging.log4j.Level;

public class LeavingPortImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        PortManager manager = PortManager.getInstance();
        manager.leaveDock();
        logger.log(Level.INFO, ship.getName() + " leaving port");
        Thread.currentThread().interrupt();
    }
}
