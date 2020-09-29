package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Port;
import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.state.ShipState;

public class LeavingPortStateImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        Port port = Port.getInstance();
        port.leaveDock(ship.getName());
        Thread.currentThread().interrupt();
    }
}
