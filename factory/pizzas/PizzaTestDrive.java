package factory.pizzas;

public class PizzaTestDrive {
    public static void main() {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);
    }
}
