package budget.commands;

import budget.ExpenseService;
import budget.commands.sort.ListSorter;
import budget.commands.sort.SortAllMethod;
import budget.commands.sort.SortByTypeMethod;
import budget.commands.sort.SortCertainTypeMethod;

import static budget.Main.scanner;

public class AnalyzerCommand implements CommandInterface {

    private ExpenseService expenseService;

    public AnalyzerCommand(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute() {
        ListSorter listSorter = new ListSorter();
        String input;

        while (true) {
            System.out.println("\nHow do you want to sort?");
            System.out.println("1) Sort all purchases");
            System.out.println("2) Sort by type");
            System.out.println("3) Sort certain type");
            System.out.println("4) Back");

            input = scanner.nextLine().trim();

            switch (input) {
                case "1": {
                    listSorter.setMethod(new SortAllMethod());
                    listSorter.sort(expenseService.getList());
                    break;
                }
                case "2": {
                    listSorter.setMethod(new SortByTypeMethod());
                    listSorter.sort(expenseService.getList());
                    break;
                }
                case "3": {
                    listSorter.setMethod(new SortCertainTypeMethod());
                    listSorter.sort(expenseService.getList());
                    break;
                }
                default: {
                    System.out.println();
                    return;
                }
            }


        }
    }
}
