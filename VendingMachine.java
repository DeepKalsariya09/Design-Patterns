// FACTORY MACHINE

// Product Interface
// The Drink interface defines the common behavior (prepare method) that all drink types will implement. 
// This ensures that different drinks have a consistent way of being prepared.
interface Drink {
    void prepare();
}

// Concrete Product - Coffee
class Coffee implements Drink {
    @Override
    public void prepare() {
        System.out.println("Preparing a hot coffee.");
    }
}

// Concrete Product - Tea
class Tea implements Drink {
    @Override
    public void prepare() {
        System.out.println("Brewing a hot tea.");
    }
}

// Concrete Product - Juice
class Juice implements Drink {
    @Override
    public void prepare() {
        System.out.println("Pouring fresh juice.");
    }
}

// Factory Class to Create Drinks
// It centralizes the logic of creating different Drink objects.
class DrinkFactory {

    // Factory method to return the correct Drink object based on input
    // This method takes a string parameter (drinkType), and based on the value provided, 
    // it returns an instance of the appropriate drink class (Coffee, Tea, or Juice).
    public static Drink getDrink(String drinkType) {
        switch (drinkType.toLowerCase()) {
            case "coffee":
                return new Coffee();
            case "tea":
                return new Tea();
            case "juice":
                return new Juice();
            default:
                throw new IllegalArgumentException("Unknown drink type: " + drinkType);
        }
    }
}

// This class demonstrates how the factory pattern is used to abstract away the creation of different drinks. 
// The client code does not need to know how the drinks are created—just that they can be prepared once retrieved from the factory.
public class VendingMachine {
    public static void main(String[] args) {
        // Get the drink from the factory
        Drink drink1 = DrinkFactory.getDrink("Coffee");
        drink1.prepare();

        Drink drink2 = DrinkFactory.getDrink("Tea");
        drink2.prepare();

        Drink drink3 = DrinkFactory.getDrink("Juice");
        drink3.prepare();
    }
}
