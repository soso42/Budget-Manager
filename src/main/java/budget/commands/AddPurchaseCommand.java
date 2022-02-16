package budget.commands;

import budget.ExpenseService;

import static budget.Main.scanner;

public class AddPurchaseCommand implements CommandInterface {

    private ExpenseService expenseService;

    public AddPurchaseCommand(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute() {
        String name;
        double price;
        String typeOfPurchase;

        while (true) {

            typeOfPurchase = getTypeOfPurchase();

            if (typeOfPurchase.equals("Back")) {
                System.out.println();
                return;
            }

            System.out.println("\nEnter purchase name:");
            name = scanner.nextLine();
            System.out.println("Enter its price:");
            price = Double.parseDouble(scanner.nextLine());

            expenseService.addExpense(name, price, typeOfPurchase);

            System.out.println("Purchase was added!");
        }

    }

    private String getTypeOfPurchase() {
        System.out.println("\nChoose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");

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
                return "Back";
        }
    }
}
