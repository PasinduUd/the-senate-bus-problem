public class Main {
    public static void main(String[] args) {
        SharedResourceStore sharedResourceStore = new SharedResourceStore();

        Thread riderArrivalScheduler = new Thread(new RiderArrivalScheduler(sharedResourceStore));
        Thread busArrivalScheduler = new Thread(new BusArrivalScheduler(sharedResourceStore));

        System.out.println("...Program started. Initially, there are no riders at the bus stop...");

        riderArrivalScheduler.start();
        busArrivalScheduler.start();

        try {
            riderArrivalScheduler.join();
            busArrivalScheduler.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}