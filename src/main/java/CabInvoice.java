import java.util.HashMap;
import java.util.Scanner;

public class CabInvoice {

    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    private int number=1;
    HashMap<Integer,InvoiceSummary> multipleUsers=new HashMap<Integer, InvoiceSummary>();

    Scanner sc=new Scanner(System.in);

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Rides[] ride) {
        double totalFare=0;
        for (Rides rides : ride) {
           totalFare+= this.calculateFare(rides.distance, rides.time);
        }
        multipleUsers.put(number,new InvoiceSummary(ride.length,totalFare));
        number++;
        return new InvoiceSummary(ride.length, totalFare);
    }

    public String findFareOfGivenId(int i)
    {

        System.out.println(multipleUsers.get(i));
        return String.valueOf(multipleUsers.get(i));

    }
}

