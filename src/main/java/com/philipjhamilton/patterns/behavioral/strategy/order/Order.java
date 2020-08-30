package com.philipjhamilton.patterns.behavioral.strategy.order;

import com.philipjhamilton.patterns.behavioral.strategy.strategies.PayStrategy;

public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public Order(){}

    public Order(int totalCost, boolean isClosed) {
        this.totalCost = totalCost;
        this.isClosed = isClosed;
    }

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
        // Here we could collect and store payment data from the strategy.
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
