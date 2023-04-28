package edu.iu.c322.finalproject.paymentservice.model;

public class SummaryTemplateSeller extends SummaryTemplate{
    @Override
    public Summary instantiateSummary() {
        return new SummarySeller();
    }

    @Override
    public void setShipping(Summary summary, Receipt receipt) {
        ((SummarySeller)summary).setShippedFrom(receipt.getOrder().getSellerShipping());
    }

    @Override
    public void setMisc(Summary summary, Receipt receipt) {
        ((SummarySeller)summary).setSiteFee(receipt.getSiteFee());
    }

    @Override
    public void setTotal(Summary summary, Receipt receipt) {
        ((SummarySeller)summary).setProfit(receipt.getCustomerTotal()- receipt.getSiteFee());
    }

}
