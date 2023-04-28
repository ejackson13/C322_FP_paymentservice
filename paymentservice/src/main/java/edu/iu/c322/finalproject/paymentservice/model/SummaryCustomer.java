package edu.iu.c322.finalproject.paymentservice.model;

public class SummaryCustomer extends Summary{

    private CustomerShippingAddress shippedTo;

    private double totalCost;


    public CustomerShippingAddress getShippedTo() {
        return shippedTo;
    }

    public void setShippedTo(CustomerShippingAddress shippedTo) {
        this.shippedTo = shippedTo;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
