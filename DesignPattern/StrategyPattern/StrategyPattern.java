class Order {
    // Order details
    private double weight;
    public Order(double rate, double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

// Strategy interface
interface ShippingStrategy{
    double calculateShippingCost(Order order);
}
//concrete strategy for fixed rate shipping
class FixedRateShipping implements ShippingStrategy{
    private double fixedRate ;
        public FixedRateShipping(double fixedRate) {
            this.fixedRate = fixedRate;
        }
     @Override
    public double calculateShippingCost(Order order) {
        return fixedRate; // Fixed rate
    }
}

//concrete strategy for weighted shipping
class WeightedShipping implements ShippingStrategy{
    private double rate;
    public WeightedShipping(double rate) {
        this.rate = rate;
    }
    @Override
    public double calculateShippingCost(Order order) {
        return rate * order.getWeight();
    }
}

// Context class that uses the strategy
class ShoppingService{
    private ShippingStrategy shippingStrategy;
    public ShoppingService(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public void setStrategy(ShippingStrategy strategy) {
        System.out.println("ShoppingService: Strategy changed to " + strategy.getClass().getSimpleName());
        this.shippingStrategy = strategy;
    }

    public  double calculateShippingCost(Order order) {
        return shippingStrategy.calculateShippingCost(order);
    }

}


public class StrategyPattern { 
    public static void main(String[] args) {
        Order order = new Order(10, 5); // rate, weight
        ShippingStrategy fixedRateStrategy = new FixedRateShipping(50);
        ShippingStrategy weightedStrategy = new WeightedShipping(10);

        ShoppingService shoppingService = new ShoppingService(fixedRateStrategy);
        System.out.println("Shipping Cost (Fixed Rate): " + shoppingService.calculateShippingCost(order));

        shoppingService.setStrategy(weightedStrategy);
        System.out.println("Shipping Cost (Weighted): " + shoppingService.calculateShippingCost(order));
    }
}