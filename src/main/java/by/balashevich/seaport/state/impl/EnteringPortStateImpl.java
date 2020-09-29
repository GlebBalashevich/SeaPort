package by.balashevich.seaport.state.impl;

import by.balashevich.seaport.entity.Ship;
import by.balashevich.seaport.state.ShipState;
import org.apache.logging.log4j.Level;

public class EnteringPortStateImpl implements ShipState {
    @Override
    public void doAction(Ship ship) {
        logger.log(Level.INFO, "the ship " + ship.getName() + " entered the port");
        ship.nextState(new DockerPierStateImpl());
    }
}
