public class CabInvoice {

    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }
        return totalFare;
    }

    public double calculateFare(Rides[] ride) {
        double totalFare=0;
        for (Rides rides : ride) {
           totalFare+= this.calculateFare(rides.distance, rides.time);
        }
        return totalFare;
    }
}

