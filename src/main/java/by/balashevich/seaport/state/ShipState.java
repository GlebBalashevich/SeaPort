package by.balashevich.seaport.state;

import by.balashevich.seaport.entity.Ship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ShipState {
    public static Logger logger = LogManager.getLogger();

    void doAction(Ship ship);
}
