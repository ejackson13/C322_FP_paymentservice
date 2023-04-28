package edu.iu.c322.finalproject.paymentservice.model;

public abstract class Summary {
    private int orderId;

    private String dateRented;

    private String dateReturned;
    private double basePrice;
    private double lateFees;




    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDateRented() {
        return dateRented;
    }

    public void setDateRented(String dateTakenOut) {
        this.dateRented = dateTakenOut;
    }

    public String getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(String dateReturned) {
        this.dateReturned = dateReturned;
    }

    public double getLateFees() {
        return lateFees;
    }

    public void setLateFees(double lateFees) {
        this.lateFees = lateFees;
    }
}
