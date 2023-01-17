import java.util.Random;

public abstract class ArrivalScheduler implements Runnable {
    protected final SharedResourceStore sharedResourceStore;
    protected Random random;

    public ArrivalScheduler(SharedResourceStore sharedResourceStore) {
        this.sharedResourceStore = sharedResourceStore;
        this.random = new Random();
    }
}
