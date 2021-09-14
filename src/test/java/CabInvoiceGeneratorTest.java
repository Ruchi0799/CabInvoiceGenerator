import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void CalculateFare_WhenGiven_DistanceAndTime() {
        CabInvoice cabinvoice=new CabInvoice();
        double distance=2.0;
        int time=5;
        double fare=cabinvoice.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        CabInvoice cabinvoice=new CabInvoice();
        double distance=0.1;
        int time=1;
        double fare=cabinvoice.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        CabInvoice cabinvoice=new CabInvoice();
//        double distance=0.1;
//        int time=1;
        Rides[] ride={new Rides(2.0,5),new Rides(0.1,1)
        };
        double fare=cabinvoice.calculateFare(ride);
        Assert.assertEquals(30,fare,0.0);
    }
}
