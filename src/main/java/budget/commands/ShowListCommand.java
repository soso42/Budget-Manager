package budget.commands;

import budget.Expense;
import budget.ExpenseService;

import java.util.LinkedList;

import static budget.Main.scanner;

public class ShowListCommand implements CommandInterface {

    private ExpenseService expenseService;

    public ShowListCommand(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute() {
        LinkedList<Expense> list;
        String typeOfPurchase;

        while (true) {
            typeOfPurchase = getTypeOfPurchase();
            if (typeOfPurchase.equals("Back")) {
                System.out.println();
                return;
            }

            if (typeOfPurchase.equals("All")) {
                list = expenseService.getList();
            } else {
                list = expenseService.getListByCategory(typeOfPurchase);
            }


            if (list.isEmpty()) {
                System.out.println("\nThe purchase list is empty\n");
                return;
            }

            Double total = list.stream()
                    .map(Expense::getPrice)
                    .reduce(0D, (sum, next) -> sum += next);

            System.out.println();

            System.out.println(typeOfPurchase + ":");

            list.forEach(System.out::println);

            System.out.printf("Total sum: $%.2f\n", total);

        }


    }

    private String getTypeOfPurchase() {
        System.out.println("\nChoose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");

        switch (scanner.nextLine().trim()) {
            case "1":
                return "Food";
            case "2":
                return "Clothes";
            case "3":
                return "Entertainment";
            case "4":
                return "Other";
            case "5":
                return "All";
            default:
                return "Back";
        }
    }
}
