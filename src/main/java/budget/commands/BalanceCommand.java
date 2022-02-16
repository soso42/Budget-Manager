package budget.commands;

import budget.ExpenseService;

public class BalanceCommand implements CommandInterface {

    private ExpenseService expenseService;

    public BalanceCommand(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute() {
        System.out.printf("\nBalance: $%.2f\n\n", expenseService.getBalance());
    }
}
