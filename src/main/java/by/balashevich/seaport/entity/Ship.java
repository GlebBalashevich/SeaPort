package by.balashevich.seaport.entity;

import by.balashevich.seaport.state.ShipState;
import by.balashevich.seaport.state.impl.EnteringPortImpl;

public class Ship extends Entity implements Runnable {
    public enum TripTask {
        DELIVER_CARGO,
        ACCEPT_CARGO_DELIVERY,
    }

    private TripTask task;
    private ShipState state;
    private String name;
    private int holdAmount;
    private int containerValue;

    public Ship(String name, int holdAmount, int containerValue, TripTask task) {
        this.name = name;
        this.holdAmount = holdAmount;
        this.containerValue = containerValue;
        this.task = task;
        state = new EnteringPortImpl();
    }

    public TripTask getTask() {
        return task;
    }

    public void setTask(TripTask task) {
        this.task = task;
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

    public void doAction() {
        state.doAction(this);
    }

    public void nextState(ShipState state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            doAction();
        }
    }
}
