package edu.iu.c322.finalproject.paymentservice.model;

import java.util.ArrayList;
import java.util.List;

public abstract class SummaryTemplate {

    public final Summary createSummary(Receipt receipt) {
        Summary summary = instantiateSummary();

        // add dates and order id to summary
        addDatesAndID(summary, receipt);

        // set shipping
        setShipping(summary, receipt);

        setBasePriceAndLateFee(summary, receipt);

        setMisc(summary, receipt);

        setTotal(summary, receipt);

        return summary;
    }

    public final List<Summary> createSummary(List<Receipt> receipts) {
        ArrayList<Summary> summaries = new ArrayList<>();

        for(Receipt r:receipts) {
            summaries.add(createSummary(r));
        }

        return summaries;
    }

    public abstract Summary instantiateSummary();

    public void addDatesAndID(Summary summary, Receipt receipt) {
        summary.setOrderId(receipt.getOrder().getId());
        summary.setDateRented(receipt.getOrder().getDateRented());
        summary.setDateReturned(receipt.getDateReceived());
    }

    public abstract void setShipping(Summary summary, Receipt receipt);

    public void setBasePriceAndLateFee(Summary summary, Receipt receipt) {
        summary.setBasePrice(receipt.getCustomerTotal()-receipt.getLatePenalty());
        summary.setLateFees(receipt.getLatePenalty());
    }

    public void setMisc(Summary summary, Receipt receipt) {

    }

    public abstract void setTotal(Summary summary, Receipt receipt);
}
