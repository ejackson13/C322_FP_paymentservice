package edu.iu.c322.finalproject.paymentservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ooiGen")
    @SequenceGenerator(name = "ooiGen", sequenceName = "oorderIdSeq", allocationSize = 1)
    private int id;



    //@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_Id", referencedColumnName = "id")
    private int customerId;

    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id")
    private int sellerId;

    private int total;

    private String dateRented;

    private String returnByDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private CustomerShippingAddress customerShipping;

    //@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentMethodId", referencedColumnName = "id")
    private int paymentMethodId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_shipping_address_id", referencedColumnName = "id")
    private SellerShippingAddress sellerShipping;



    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer() {
        return customerId;
    }

    public void setCustomer(int customer) {
        this.customerId = customer;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDateRented() {
        return dateRented;
    }

    public void setDateRented(String dateRented) {
        this.dateRented = dateRented;
    }

    public String getReturnByDate() {
        return returnByDate;
    }

    public void setReturnByDate(String returnByDate) {
        this.returnByDate = returnByDate;
    }

    public CustomerShippingAddress getCustomerShipping() {
        return customerShipping;
    }

    public void setCustomerShipping(CustomerShippingAddress customerAddress) {
        this.customerShipping = customerAddress;
    }

    public int getPaymentMethod() {
        return paymentMethodId;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethodId = paymentMethod;
    }

    public SellerShippingAddress getSellerShipping() {
        return sellerShipping;
    }

    public void setSellerShipping(SellerShippingAddress sellerShipping) {
        this.sellerShipping = sellerShipping;
    }
}
