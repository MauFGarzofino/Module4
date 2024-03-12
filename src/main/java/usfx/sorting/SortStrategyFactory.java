package usfx.sorting;

public interface SortStrategyFactory {
    SortStrategy getSortStrategy(String field, String order, SortStrategy currentStrategy);
}
