package edu.iu.c322.finalproject.paymentservice.model;

public class SummaryTemplateCustomer extends SummaryTemplate{
    @Override
    public Summary instantiateSummary() {
        return new SummaryCustomer();
    }

    @Override
    public void setShipping(Summary summary, Receipt receipt) {
        ((SummaryCustomer)summary).setShippedTo(receipt.getOrder().getCustomerShipping());
    }

    @Override
    public void setTotal(Summary summary, Receipt receipt) {
        ((SummaryCustomer)summary).setTotalCost(receipt.getCustomerTotal());
    }
}
