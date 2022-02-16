package budget.commands;

import budget.ExpenseService;

import static budget.Main.scanner;

public class AddIncomeCommand implements CommandInterface {

    private ExpenseService expenseService;

    public AddIncomeCommand(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute() {
        System.out.println("\nEnter income:");

        double amount = Double.parseDouble(scanner.nextLine());

        expenseService.addIncome(amount);

        System.out.println("Income was added!\n");
    }
}
