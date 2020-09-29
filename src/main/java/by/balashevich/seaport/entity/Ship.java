package by.balashevich.seaport.entity;

import by.balashevich.seaport.state.ShipState;
import by.balashevich.seaport.state.impl.EnteringPortStateImpl;

public class Ship implements Runnable {
    public enum TripTask {
        DELIVER_CARGO,
        LOAD_CARGO,
        DELIVER_AND_LOAD,
    }

    private TripTask tripTask;
    private ShipState state;
    private String name;
    private int holdAmount;
    private int containerValue;

    public Ship(String name, int holdAmount, int containerValue, TripTask tripTask) {
        this.name = name;
        this.holdAmount = holdAmount;
        this.containerValue = containerValue;
        this.tripTask = tripTask;
        state = new EnteringPortStateImpl();
    }

    public TripTask getTripTask() {
        return tripTask;
    }

    public void setTripTask(TripTask task) {
        this.tripTask = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoldAmount() {
        return holdAmount;
    }

    public void setHoldAmount(int holdAmount) {
        this.holdAmount = holdAmount;
    }

    public int getContainerValue() {
        return containerValue;
    }

    public void addContainer() {
        containerValue++;
    }

    public void removeContainer() {
        containerValue--;
    }

    public void nextState(ShipState state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            state.doAction(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ship ship = (Ship) o;

        return holdAmount == ship.holdAmount
                && containerValue == ship.containerValue
                && tripTask == ship.tripTask
                && name.equals(ship.name);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 37 * result + tripTask.ordinal();
        result += 37 * result + name.hashCode();
        result += 37 * result + holdAmount;
        result += 37 * result + containerValue;

        return result;
    }

    @Override
    public String toString() {
        return String.format("Ship, name %s, tripTask %s, holdAmount %d, containerValue %d",
                name, tripTask.name(), holdAmount, containerValue);
    }
}
