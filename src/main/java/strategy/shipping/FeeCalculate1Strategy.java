package strategy.shipping;

import strategy.shipping.FeeCalculateStrategy;

public class FeeCalculate1Strategy : FeeCalculateStrategy{
    @Override
    protected int calculateShippingFee(DistanceCalculator distanceCalculator, String address, String province){
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }
}