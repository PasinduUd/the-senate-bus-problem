public class BusArrivalScheduler extends ArrivalScheduler {
    private final float busMeanArrivalTime;

    public BusArrivalScheduler(SharedResourceStore sharedResourceStore) {
        super(sharedResourceStore);
        this.busMeanArrivalTime = 2 * 60f * 1000;
    }

    @Override
    public void run() {
        while (true) {
            try {
                float lambda = 1 / busMeanArrivalTime;
                Thread.sleep(Math.round(-Math.log(1 - random.nextFloat()) / lambda));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new Thread(new Bus(sharedResourceStore)).start();
        }
    }
}
