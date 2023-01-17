public class Bus implements Runnable {
    private final SharedResourceStore sharedResourceStore;
    private int loadedRiderCount;

    public Bus(SharedResourceStore sharedResourceStore) {
        this.sharedResourceStore = sharedResourceStore;
        this.loadedRiderCount = 0;
    }

    public int getLoadedRiderCount() {
        return loadedRiderCount;
    }

    public void incrementLoadedRiderCount() {
        this.loadedRiderCount += 1;
    }

    private void depart() {
        System.out.println("Bus departed with " + loadedRiderCount + " riders. (Remaining : " + sharedResourceStore.getWaitingRiderCount() + ")");
    }

    @Override
    public void run() {
        try {
            sharedResourceStore.getMutex().acquire();    // Avoids new riders when bus is boarding
            System.out.println("Bus arrived at the bus stop.");
            if (sharedResourceStore.getWaitingRiderCount() > 0) {
                sharedResourceStore.setBus(this);
                sharedResourceStore.getBusWait().release();  // Signals riders that bus has arrived
                sharedResourceStore.getAllAboard().acquire();    // Waits until riders are aboard
            }
            depart();
            sharedResourceStore.getMutex().release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
