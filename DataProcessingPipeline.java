// STRATERGY

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Strategy Interface
// The DataProcessingStrategy interface defines a contract for processing data. 
// It allows different strategies to implement their specific logic, decoupling the algorithm from the client.
interface DataProcessingStrategy {
    List<Integer> process(List<Integer> data);
}

// Concrete Strategy - Filtering Data
class FilterDataStrategy implements DataProcessingStrategy {
    @Override
    public List<Integer> process(List<Integer> data) {
        return data.stream().filter(d -> d > 10).collect(Collectors.toList());
    }
}

// Concrete Strategy - Sorting Data
class SortDataStrategy implements DataProcessingStrategy {
    @Override
    public List<Integer> process(List<Integer> data) {
        return data.stream().sorted().collect(Collectors.toList());
    }
}

// Concrete Strategy - Normalizing Data
class NormalizeDataStrategy implements DataProcessingStrategy {
    @Override
    public List<Integer> process(List<Integer> data) {
        int max = data.stream().max(Integer::compare).orElse(1);
        return data.stream().map(d -> d * 100 / max).collect(Collectors.toList());
    }
}

// Context Class - Data Processing Context
// The context class holds a reference to the current strategy. 
// It allows the strategy to be changed dynamically
class DataProcessingContext {
    private DataProcessingStrategy strategy;

    // Methods to set & Execute the current strategy dynamically
    public void setStrategy(DataProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Integer> executeStrategy(List<Integer> data) {
        return strategy.process(data);
    }
}

// This class demonstrates the flexibility of the Strategy Pattern 
// by dynamically switching between different processing strategies on the same data set.
public class DataProcessingPipeline {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(15, 3, 22, 1, 17);

        DataProcessingContext context = new DataProcessingContext();

        // Using Filter Strategy
        context.setStrategy(new FilterDataStrategy());
        System.out.println("Filtered Data: " + context.executeStrategy(data));

        // Using Sort Strategy
        context.setStrategy(new SortDataStrategy());
        System.out.println("Sorted Data: " + context.executeStrategy(data));

        // Using Normalize Strategy
        context.setStrategy(new NormalizeDataStrategy());
        System.out.println("Normalized Data: " + context.executeStrategy(data));
    }
}

