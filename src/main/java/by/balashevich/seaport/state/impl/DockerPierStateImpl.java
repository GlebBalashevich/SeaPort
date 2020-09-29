package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Port;
import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.state.ShipState;

public class DockerPierStateImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        Port port = Port.getInstance();
        port.arriveDock(ship.getName());
        if (ship.getTripTask() == Ship.TripTask.DELIVER_CARGO ||
                ship.getTripTask() == Ship.TripTask.DELIVER_AND_LOAD) {
            ship.nextState(new UnloadStateImpl());
        }
        if (ship.getTripTask() == Ship.TripTask.LOAD_CARGO) {
            ship.nextState(new UploadStateImpl());
        }
    }
}
