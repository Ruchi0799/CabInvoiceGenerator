public class Rates {
    public double pricePerKmReg;
    public int costPerMinReg;
    public double minFareReg;

    public double pricePerKmPre;
    public int costPerMinPre;
    public double minFarePre;

    public Rates(double pricePerKmReg, int costPerMinReg, double minFareReg, double pricePerKmPre, int costPerMinPre, double minFarePre) {
        this.pricePerKmReg = pricePerKmReg;
        this.costPerMinReg = costPerMinReg;
        this.minFareReg = minFareReg;

        this.pricePerKmPre = pricePerKmPre;
        this.costPerMinPre = costPerMinPre;
        this.minFarePre = minFarePre;
    }
}
