package by.balashevich.seaport.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Port {
    private static final Port INSTANCE = new Port();
    private static final int DOCK_NUMBER = 5;
    private static final int STORAGE_CAPACITY = 10;
    private int storageFullness;
    private final List<Dock> dockList;

    private Port() {
        dockList = new ArrayList<>(DOCK_NUMBER);
        for (int i = 0; i < DOCK_NUMBER; i++) {
            dockList.add(new Dock());
        }
    }

    public static Port getInstance() {
        return INSTANCE;
    }

    public List<Dock> getDockList() {
        return Collections.unmodifiableList(dockList);
    }

    public int getStorageFullness() {
        return storageFullness;
    }

    public boolean addContainer(){
        boolean isAdded = false;

        if (STORAGE_CAPACITY - storageFullness > 0){
            storageFullness++;
            isAdded = true;
        }

        return isAdded;
    }

    public boolean removeContainer(){
        boolean isRemoved = false;

        if (storageFullness != 0){
            storageFullness--;
            isRemoved = true;
        }

        return isRemoved;
    }

}
