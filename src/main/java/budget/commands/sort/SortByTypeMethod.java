package budget.commands.sort;

import budget.Expense;

import java.util.*;
import java.util.stream.Collectors;

public class SortByTypeMethod implements SortingMethod {
    @Override
    public void sort(LinkedList<Expense> list) {

        LinkedHashMap<String, Double> map = new LinkedHashMap<>();
        Double total;

        list.forEach(expense -> {
            String key = expense.getCategory();
            Double valueToAdd = expense.getPrice();
            Double existingValue = Optional.ofNullable(map.get(key)).orElse(0.0);

            map.put(key, existingValue + valueToAdd);
        });

        total = list.stream()
                .map(Expense::getPrice)
                .reduce(0.0, (sum, next) -> sum += next);

        System.out.println("\nTypes:");

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%s - $%.2f\n", entry.getKey(), entry.getValue()));

        System.out.printf("Total sum: $%.2f\n", total);
    }
}
