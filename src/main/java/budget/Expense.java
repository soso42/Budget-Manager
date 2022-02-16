package budget;

public class Expense {

    private String name;
    private double price;
    private String category;

    public Expense(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " $" + String.format("%.2f", price);
    }
}
