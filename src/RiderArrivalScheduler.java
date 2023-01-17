public class RiderArrivalScheduler extends ArrivalScheduler {
    private final float riderMeanArrivalTime;

    public RiderArrivalScheduler(SharedResourceStore sharedResourceStore) {
        super(sharedResourceStore);
        this.riderMeanArrivalTime = 3f * 1000;
    }

    @Override
    public void run() {
        while (true) {
            new Thread(new Rider(sharedResourceStore)).start();
            try {
                float lambda = 1 / riderMeanArrivalTime;
                Thread.sleep(Math.round(-Math.log(1 - random.nextFloat()) / lambda));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
