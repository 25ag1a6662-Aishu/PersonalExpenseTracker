public class Expense {

    private int id;
    private String expenseName;
    private String category;
    private double amount;
    private String date;

    // Constructor
    public Expense(int id, String expenseName, String category,
                   double amount, String date) {
        this.id = id;
        this.expenseName = expenseName;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    // Method that can be overridden
    public void displayExpense() {
        System.out.printf("%-5d %-20s %-15s ₹%-10.2f %-12s%n",
                id, expenseName, category, amount, date);
    }
}