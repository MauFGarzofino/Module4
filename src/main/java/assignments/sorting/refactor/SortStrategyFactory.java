package assignments.sorting.refactor;

public interface SortStrategyFactory {
    SortStrategy getSortStrategy(String field, String order, SortStrategy currentStrategy);
}
