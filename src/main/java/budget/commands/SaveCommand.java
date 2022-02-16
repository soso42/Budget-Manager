package budget.commands;

import budget.Expense;
import budget.ExpenseService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class SaveCommand implements CommandInterface {

    private static final String EXPORT_FILE_NAME = "purchases.txt";
    private ExpenseService expenseService;

    public SaveCommand(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute() {
        LinkedList<Expense> list = expenseService.getList();
        String balance = expenseService.getBalance() + "\n";
        StringBuilder sb = new StringBuilder();

        writeToFile(balance, EXPORT_FILE_NAME, false);

        list.forEach(e -> {
            sb.append(e.getName()).append(":").append(e.getPrice()).append(":").append(e.getCategory()).append("\n");
        });

        writeToFile(sb.toString(), EXPORT_FILE_NAME, true);

        System.out.println("\nPurchases were saved!\n");
    }

    private void writeToFile(String text, String fileName, boolean append) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName, append);
            fos.write(text.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
