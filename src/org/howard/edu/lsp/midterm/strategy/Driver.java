package org.howard.edu.lsp.midterm.strategy;

public class Driver {
    public static void main(String[] args) {
        double amount = 100.0;
        PricingStrategy strategy;

        strategy = new RegularPricing();
        System.out.println("Regular: " + strategy.computePrice(amount));

        strategy = new VipPricing();
        System.out.println("VIP: " + strategy.computePrice(amount));
    }
}