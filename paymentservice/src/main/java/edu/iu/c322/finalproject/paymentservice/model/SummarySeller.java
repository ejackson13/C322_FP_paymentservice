package edu.iu.c322.finalproject.paymentservice.model;

public class SummarySeller extends Summary{

    private SellerShippingAddress shippedFrom;

    private double siteFee;

    private double profit;


    public SellerShippingAddress getShippedFrom() {
        return shippedFrom;
    }

    public void setShippedFrom(SellerShippingAddress shippedFrom) {
        this.shippedFrom = shippedFrom;
    }

    public double getSiteFee() {
        return siteFee;
    }

    public void setSiteFee(double siteFee) {
        this.siteFee = siteFee;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
