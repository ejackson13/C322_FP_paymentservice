package edu.iu.c322.finalproject.paymentservice.model;

import jakarta.persistence.*;

@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "returnGen")
    @SequenceGenerator(name = "returnGen", sequenceName = "returnSeq", allocationSize = 1)
    private int id;

    @OneToOne
    private Order order;

    private String dateReceived;

    private int latePenalty;

    private int siteFee;

    private double customerTotal;

    //public Receipt(){}

    /*
    public Receipt(ItemReturnDto itemReturnDto){
        this.orderId = itemReturnDto.getOrderId();
        this.dateReceived = itemReturnDto.getDateReceived();
        this.latePenalty = itemReturnDto.getLatePenalty();
        this.siteFee = itemReturnDto.getSiteFee();
        this.customerTotal = itemReturnDto.getCustomerTotal();

    }
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    /*
    public void setOrderId(Order) {
        this.order = orderId;
    }
     */

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public int getLatePenalty() {
        return latePenalty;
    }

    public void setLatePenalty(int latePenalty) {
        this.latePenalty = latePenalty;
    }

    public int getSiteFee() {
        return siteFee;
    }

    public void setSiteFee(int siteFee) {
        this.siteFee = siteFee;
    }

    public double getCustomerTotal() {
        return customerTotal;
    }

    public void setCustomerTotal(double customerTotal) {
        this.customerTotal = customerTotal;
    }


}
