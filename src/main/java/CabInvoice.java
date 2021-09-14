import java.util.HashMap;
import java.util.Scanner;

public class CabInvoice {

//    private static final double MINIMUM_COST_PER_KILOMETER = 10;
//    private static final int COST_PER_TIME = 1;
//    private static final double MINIMUM_FARE = 5;
    public double totalFare=0;
    Rates rates=new Rates(10,1,5,15,2,20);
    private int number=1;
    HashMap<Integer,InvoiceSummary> multipleUsers=new HashMap<Integer, InvoiceSummary>();

    Scanner sc=new Scanner(System.in);

    public double calculateFare(double distance, int time,Enum Ratetype) {
        if (Ratetype == RateType.NORMAL) {
            totalFare = distance * rates.pricePerKmReg + time * rates.costPerMinReg;
            if (totalFare < rates.minFareReg) {
                return rates.minFareReg;
            }
            return totalFare;
        } else if(Ratetype == RateType.PREMIUM)
        {
            totalFare = distance * rates.pricePerKmPre + time * rates.costPerMinPre;
            if (totalFare < rates.minFarePre) {
                return rates.minFarePre;
            }
            return totalFare;

        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Rides[] ride,Enum Ratetype) {
        double totalFare=0;
        for (Rides rides : ride) {
           totalFare+= this.calculateFare(rides.distance, rides.time,Ratetype);
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

