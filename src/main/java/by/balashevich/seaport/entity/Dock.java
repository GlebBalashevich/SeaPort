package by.balashevich.seaport.entity;

public class Dock extends Entity{
    private boolean isBusy;

    public Dock(){
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void registerShip(){
        isBusy = true;
    }

    public void unregisterShip(){
        isBusy = false;
    }
}
