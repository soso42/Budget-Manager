package budget;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class ExpenseService {

    private LinkedList<Expense> list = new LinkedList<>();
    private double balance;

    public LinkedList<Expense> getList() {
        return list;
    }

    public LinkedList<Expense> getListByCategory(String category) {
       return list.stream()
                .filter(expense -> expense.getCategory().equals(category))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addIncome(double amount) {
        this.balance += amount;
    }

    public void addExpense(String name, double price, String category) {
        this.balance -= price;
        this.list.add(new Expense(name, price, category));
    }

    public void importExpenseFromFile(String name, double price, String category) {
        this.list.add(new Expense(name, price, category));
    }
}
