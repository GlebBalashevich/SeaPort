package by.balashevich.seaport.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static final Logger logger = LogManager.getLogger();
    private static final Port INSTANCE = new Port();
    private static final int DOCK_NUMBER = 5;
    private static final int STORAGE_CAPACITY = 10;

    private int storageFullness;
    private final Deque<Dock> freeDocks;
    private final Deque<Dock> surrenderedDocks;
    private final Lock cargoLock = new ReentrantLock();
    private final Lock dockLock = new ReentrantLock();

    private Port() {
        freeDocks = new ArrayDeque<>(DOCK_NUMBER);
        surrenderedDocks = new ArrayDeque<>(DOCK_NUMBER);
        for (int i = 0; i < DOCK_NUMBER; i++) {
            freeDocks.add(new Dock(i + 1));
        }
    }

    public static Port getInstance() {
        return INSTANCE;
    }

    public Collection<Dock> getDockList() {
        return Collections.unmodifiableCollection(freeDocks);
    }

    public int getStorageFullness() {
        return storageFullness;
    }

    public void arriveDock(String shipName) {
        boolean isArrived = false;
        while (!isArrived) {
            dockLock.lock();
            if (!freeDocks.isEmpty()) {
                Dock availableDock = freeDocks.poll();
                surrenderedDocks.offer(availableDock);
                isArrived = true;
                logger.log(Level.INFO, shipName + " arrived to " + availableDock);
            }
            dockLock.unlock();
        }
    }

    public void leaveDock(String shipName) {
        dockLock.lock();
        Dock releasingDock = surrenderedDocks.poll();
        if (releasingDock != null) {
            freeDocks.offer(releasingDock);
            logger.log(Level.INFO, shipName + " left " + releasingDock);
        } else {
            logger.log(Level.ERROR, "error in application, lost checksum of docks");
        }
        dockLock.unlock();
    }

    public void loadingStorage(Ship ship) {
        while (ship.getContainerValue() > 0) {
            try {
                cargoLock.lock();
                if (STORAGE_CAPACITY - storageFullness > 0) {
                    storageFullness++;
                    ship.removeContainer();
                    logger.log(Level.INFO, ship.getName() + " UN_loading.." +
                            ship.getContainerValue() + " " + storageFullness);
                    TimeUnit.SECONDS.sleep(2);
                } else {
                    logger.log(Level.INFO, ship.getName() + " port storage is full, ship stopped unloading");
                    break;
                }
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, ship.getName() + " unloading interrupted");
            } finally {
                cargoLock.unlock();
            }
        }
    }

    public void unloadingStorage(Ship ship) {
        while (ship.getHoldAmount() - ship.getContainerValue() > 0) {
            try {
                cargoLock.lock();
                if (storageFullness != 0) {
                    storageFullness--;
                    ship.addContainer();
                    logger.log(Level.INFO, ship.getName() + " UP_loading.." +
                            (ship.getContainerValue()) + " " + storageFullness);
                    TimeUnit.SECONDS.sleep(2);
                } else {
                    logger.log(Level.INFO, ship.getName() + " port storage is empty, ship stopped uploading");
                    break;
                }
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, ship.getName() + " uploading interrupted");
            } finally {
                cargoLock.unlock();
            }
        }
    }
}
