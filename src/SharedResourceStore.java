import java.util.concurrent.Semaphore;

public class SharedResourceStore {
    private final int maximumRiderCount;   // Maximum number of riders that can be loaded into a bus
    private final Semaphore mutex;  // Protects riders, which keeps track of how many riders are waiting
    private final Semaphore busWait;    // Signals when the bus has arrived
    private final Semaphore allAboard;  // Signals that a rider has boarded
    private int waitingRiderCount;  // Number of riders in the boarding area
    private Bus bus;

    public SharedResourceStore() {
        this.waitingRiderCount = 0;
        this.maximumRiderCount = 50;
        this.mutex = new Semaphore(1);
        this.busWait = new Semaphore(0);
        this.allAboard = new Semaphore(0);
    }

    public int getWaitingRiderCount() {
        return waitingRiderCount;
    }

    public void setWaitingRiderCount(int waitingRiderCount) {
        this.waitingRiderCount = waitingRiderCount;
    }

    public void incrementWaitingRiderCount() {
        this.waitingRiderCount += 1;
    }

    public int getMaximumRiderCount() {
        return maximumRiderCount;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public Semaphore getBusWait() {
        return busWait;
    }

    public Semaphore getAllAboard() {
        return allAboard;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
