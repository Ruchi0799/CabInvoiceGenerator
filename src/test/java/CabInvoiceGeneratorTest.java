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
}
