package budget.commands.sort;

import budget.Expense;

import java.util.LinkedList;

public interface SortingMethod {
    void sort(LinkedList<Expense> list);
}
