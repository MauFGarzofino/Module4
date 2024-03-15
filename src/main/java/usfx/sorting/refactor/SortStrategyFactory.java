package usfx.sorting.refactor;

public interface SortStrategyFactory {
    SortStrategy getSortStrategy(String field, String order, SortStrategy currentStrategy);
}
