package assignments.sorting;

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

