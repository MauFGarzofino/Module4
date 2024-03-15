package usfx.sorting.anterior;

public interface SortStrategyFactory {
    SortStrategy getSortStrategy(String field, String order, SortStrategy currentStrategy);
}
