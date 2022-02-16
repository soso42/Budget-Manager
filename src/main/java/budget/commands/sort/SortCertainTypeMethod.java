package budget.commands.sort;

import budget.Expense;

import java.util.Comparator;
import java.util.LinkedList;

import static budget.Main.scanner;

public class SortCertainTypeMethod implements SortingMethod {
    @Override
    public void sort(LinkedList<Expense> list) {

        String category = getCategoryToSort();

        if (list.isEmpty()) {
            System.out.println("\nPurchase list is empty!");
            return;
        }

        Double total = list.stream()
                .filter(expense -> expense.getCategory().equals(category))
                .map(Expense::getPrice)
                .reduce(0.0, (sum, next) -> sum += next);

        System.out.println("\n" + category + ":");

        list.stream()
                .filter(expense -> expense.getCategory().equals(category))
                .sorted(Comparator.comparing(Expense::getPrice, Comparator.reverseOrder()))
                .forEach(System.out::println);

        System.out.printf("Total sum: $%.2f\n", total);
    }

    private String getCategoryToSort() {
        System.out.println("\nChoose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");

        switch (scanner.nextLine().trim()) {
            case "1":
                return "Food";
            case "2":
                return "Clothes";
            case "3":
                return "Entertainment";
            case "4":
                return "Other";
            default:
                return "0";
        }
    }
}
