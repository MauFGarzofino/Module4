package usfx.sorting.anterior;

public class ConcreteSortStrategyFactory implements SortStrategyFactory{
    @Override
    public SortStrategy getSortStrategy(String field, String order, SortStrategy currentStrategy) {
        SortStrategy strategy;
        switch (field) {
            case "name":
                strategy = order.equals("asc") ? new SortByName() : new SortByNameDesc();
                break;
            case "age":
                strategy = order.equals("asc") ? new SortByAge() : new SortByAgeDesc();
                break;
            case "grade":
                strategy = order.equals("asc") ? new SortByGrade() : new SortByGradeDesc();
                break;
            default:
                throw new IllegalArgumentException("Invalid field or order: " + field);
        }
        return (currentStrategy == null) ? strategy : new SortDecorator(currentStrategy, strategy);
    }
}
