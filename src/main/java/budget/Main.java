package budget;

import budget.commands.*;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        CommandExecutor commandExecutor = new CommandExecutor();
        ExpenseService expenseService = new ExpenseService();

        while (true) {
            printMenu();

            switch (scanner.nextLine().trim()) {
                case "1": {
                    commandExecutor.setCommand(new AddIncomeCommand(expenseService));
                    commandExecutor.execute();
                    break;
                }
                case "2": {
                    commandExecutor.setCommand(new AddPurchaseCommand(expenseService));
                    commandExecutor.execute();
                    break;
                }
                case "3": {
                    commandExecutor.setCommand(new ShowListCommand(expenseService));
                    commandExecutor.execute();
                    break;
                }
                case "4": {
                    commandExecutor.setCommand(new BalanceCommand(expenseService));
                    commandExecutor.execute();
                    break;
                }
                case "5": {
                    commandExecutor.setCommand(new SaveCommand(expenseService));
                    commandExecutor.execute();
                    break;
                }
                case "6": {
                    commandExecutor.setCommand(new LoadCommand(expenseService));
                    commandExecutor.execute();
                    break;
                }
                case "7": {
                    commandExecutor.setCommand(new AnalyzerCommand(expenseService));
                    commandExecutor.execute();
                    break;
                }
                case "0": {
                    System.out.println("\nBye!");
                    return;
                }
                default: {
                    System.out.println("Unknown command. Try again...");
                }
            }
        }

    }

    private static void printMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
    }

}