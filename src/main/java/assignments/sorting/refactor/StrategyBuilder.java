package assignments.sorting.refactor;

public class StrategyBuilder {
    private final SortStrategyFactory factory;

    public StrategyBuilder(SortStrategyFactory factory) {
        this.factory = factory;
    }

    public SortStrategy buildStrategy(String[] parts) {
        SortStrategy strategy = null;
        for (String part : parts) {
            String[] fieldOrder = part.trim().split("\\s+");
            String field = fieldOrder[0].toLowerCase();
            String order = fieldOrder.length > 1 ? fieldOrder[1].trim().toLowerCase() : "asc";
            strategy = factory.getSortStrategy(field, order, strategy);
        }
        return strategy;
    }
}



// La clase abstracta que define el esqueleto del algoritmo.
abstract class Beverage {

    // Template method, define the sequence of steps to make a beverage.
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew(); // Abstract method, subclasses will provide the implementation.

    abstract void addCondiments(); // Another abstract method for subclasses.

    public void boilWater() { // Common method used by all subclasses.
        System.out.println("Boiling water");
    }

    public void pourInCup() { // Common method used by all subclasses.
        System.out.println("Pouring into cup");
    }

    // Hook method, provides a default implementation that subclasses can override.
    boolean customerWantsCondiments() {
        return true; // default behavior
    }
}


