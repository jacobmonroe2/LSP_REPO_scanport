package org.howard.edu.lsp.midterm.strategy;

public class HolidayPricing implements PricingStrategy {
    @Override
    public double computePrice(double basePrice) { return basePrice * 0.75; }
}