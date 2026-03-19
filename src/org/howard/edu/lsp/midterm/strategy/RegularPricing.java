package org.howard.edu.lsp.midterm.strategy;

public class RegularPricing implements PricingStrategy {
    @Override
    public double computePrice(double basePrice) { return basePrice; }
}