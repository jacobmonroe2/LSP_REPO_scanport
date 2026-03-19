package org.howard.edu.lsp.midterm.strategy;

public class VipPricing implements PricingStrategy {
    @Override
    public double computePrice(double basePrice) { return basePrice * 0.50; }
}