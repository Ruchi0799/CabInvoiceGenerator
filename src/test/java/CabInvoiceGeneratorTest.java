import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class CabInvoiceGeneratorTest {

    @Test
    public void CalculateFare_WhenGiven_DistanceAndTime() {
       CabInvoice cabinvoice=new CabInvoice();
        double distance=2.0;
        int time=5;
        double fare=cabinvoice.calculateFare(distance,time,RateType.NORMAL);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        CabInvoice cabinvoice=new CabInvoice();
        double distance=0.1;
        int time=1;
        double fare=cabinvoice.calculateFare(distance,time,RateType.NORMAL);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_WithType_ShouldReturnInvoiceSummary() {
      CabInvoice cabinvoice=new CabInvoice();
        HashMap<Integer,InvoiceSummary> multipleUsers=new HashMap<Integer, InvoiceSummary>();

        Rides[] ride1={new Rides(1,2.0,5),new Rides(1,0.1,1)};
        Rides[] ride2={new Rides(2,4,6),new Rides(2,2,3),new Rides(2,5,6)};
        InvoiceSummary fare1=cabinvoice.calculateFare(ride1,RateType.NORMAL);
        InvoiceSummary fare2=cabinvoice.calculateFare(ride2,RateType.PREMIUM);
        InvoiceSummary fare3=cabinvoice.calculateFare(ride2,RateType.NORMAL);
        Assert.assertEquals("InvoiceSummary{noOfRides=3, totalFare=195.0, averageFare=65.0}",cabinvoice.findFareOfGivenId(2));
        Assert.assertEquals("InvoiceSummary{noOfRides=3, totalFare=125.0, averageFare=41.666666666666664}",cabinvoice.findFareOfGivenId(3));

    }


}
