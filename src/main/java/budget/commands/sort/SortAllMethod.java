package budget.commands.sort;

import budget.Expense;

import java.util.Comparator;
import java.util.LinkedList;

public class SortAllMethod implements SortingMethod {
    @Override
    public void sort(LinkedList<Expense> list) {

        if (list.isEmpty()) {
            System.out.println("\nPurchase list is empty!");
            return;
        }

        System.out.println("\nAll:");

        list.stream()
                .sorted(Comparator.comparing(Expense::getPrice, Comparator.reverseOrder()))
                .forEach(System.out::println);

        double total = list.stream()
                .map(Expense::getPrice)
                .reduce(0D, (sum, next) -> sum += next);

        System.out.printf("Total: $%.2f\n", total);
    }
}
