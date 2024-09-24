// BUILDER

// Product - Pizza
// The Pizza class represents the final product being built. The fields like size, crust type, toppings, 
// and extra cheese define the configuration of the pizza. The constructor is private to enforce the use of the Builder.
class Pizza {
    private String size;  
    private String crustType;  
    private String toppings;  
    private boolean extraCheese;

    // The constructor is private to prevent direct instantiation,
    // ensuring Pizza objects are only created through the PizzaBuilder.
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crustType = builder.crustType;
        this.toppings = builder.toppings;
        this.extraCheese = builder.extraCheese;
    }

    @Override
    public String toString() {
        return "Pizza [Size: " + size + ", Crust: " + crustType + ", Toppings: " + toppings 
                + ", Extra Cheese: " + (extraCheese ? "Yes" : "No") + "]";
    }

    // Static inner Builder class
    // This static inner class (PizzaBuilder) is responsible for building Pizza objects. 
    // By using the builder pattern, process of constructing complex objects like Pizza can be simplified
    public static class PizzaBuilder {
        private String size;
        private String crustType;
        private String toppings;
        private boolean extraCheese;

        // Constructor with mandatory field
        public PizzaBuilder(String size) {
            this.size = size;
        }

        // Methods for optional fields
        public PizzaBuilder crustType(String crustType) {
            this.crustType = crustType;
            return this;
        }

        public PizzaBuilder toppings(String toppings) {
            this.toppings = toppings;
            return this;
        }

        public PizzaBuilder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        // Build method to create Pizza object
        public Pizza build() {
            return new Pizza(this);
        }
    }
}

// This class demonstrates how to use the Builder pattern to create instances of Pizza. 
// It shows flexibility in customizing different pizza configurations.
public class PizzaOrder {
    public static void main(String[] args) {
        // Building a customized pizza
        Pizza pizza1 = new Pizza.PizzaBuilder("Large")
                .crustType("Stuffed")
                .toppings("Pepperoni")
                .extraCheese(true)
                .build();
        System.out.println(pizza1);

        // Building a simple pizza
        Pizza pizza2 = new Pizza.PizzaBuilder("Medium")
                .crustType("Thin")
                .toppings("Veggies")
                .build();
        System.out.println(pizza2);
    }
}
