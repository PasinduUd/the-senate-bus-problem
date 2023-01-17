public class Rider implements Runnable {
    private final SharedResourceStore sharedResourceStore;

    public Rider(SharedResourceStore sharedResourceStore) {
        this.sharedResourceStore = sharedResourceStore;
    }

    private void boardBus() {
        System.out.println("Rider boarded to bus.");
    }

    @Override
    public void run() {
        try {
            sharedResourceStore.getMutex().acquire();    // Avoids new riders when bus is boarding
            sharedResourceStore.incrementWaitingRiderCount();
            System.out.println("Rider arrived and waiting at the stop for the next bus. (Total waiting : " + sharedResourceStore.getWaitingRiderCount() + ")");
            sharedResourceStore.getMutex().release();

            // One rider boards at a time
            sharedResourceStore.getBusWait().acquire();  // Waits for bus
            boardBus();
            sharedResourceStore.getBus().incrementLoadedRiderCount();
            if ((sharedResourceStore.getBus().getLoadedRiderCount() == sharedResourceStore.getMaximumRiderCount()) || (sharedResourceStore.getBus().getLoadedRiderCount() == sharedResourceStore.getWaitingRiderCount())) {
                sharedResourceStore.setWaitingRiderCount(Math.max(sharedResourceStore.getWaitingRiderCount() - sharedResourceStore.getMaximumRiderCount(), 0));
                sharedResourceStore.getAllAboard().release();
            } else {
                sharedResourceStore.getBusWait().release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
