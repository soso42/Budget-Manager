package budget.commands.sort;

import budget.Expense;

import java.util.LinkedList;

public class ListSorter {

    private SortingMethod method;

    public void setMethod(SortingMethod method) {
        this.method = method;
    }

    public void sort(LinkedList<Expense> list) {
        this.method.sort(list);
    }
}
