package budget.commands;

import budget.ExpenseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class LoadCommand implements CommandInterface {

    private static final String IMPORT_FILE_NAME = "purchases.txt";
    private ExpenseService expenseService;

    public LoadCommand(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute() {


        try (Stream<String> stream = Files.lines(Paths.get(IMPORT_FILE_NAME))) {
            Optional<String> firstElem = stream.findFirst();
            firstElem.ifPresent(s -> expenseService.setBalance(Double.parseDouble(s)));
        } catch (IOException e) {
            System.out.println("\nFile \"purchases.txt\" not found...\n");
            return;
        }


        try (Stream<String> stream = Files.lines(Paths.get(IMPORT_FILE_NAME))) {
            stream
                    .skip(1)
                    .forEach(line -> {
                        String[] arr = line.split(":");
                        expenseService.importExpenseFromFile(arr[0], Double.parseDouble(arr[1]), arr[2]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nPurchases were loaded!\n");
    }
}
