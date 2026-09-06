import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpenseManager implements ExpenseOperations {

    private ArrayList<Expense> expenses;
    private int nextId;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        nextId = 1;
    }

    @Override
    public void addExpense(Expense expense) {

        expenses.add(expense);

        System.out.println("\nExpense added successfully!");
    }

    @Override
    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses found.");
            return;
        }

        System.out.println("\n================ ALL EXPENSES ================");
        System.out.printf("%-5s %-20s %-15s %-11s %-12s%n",
                "ID", "Name", "Category", "Amount", "Date");

        System.out.println("-----------------------------------------------");

        for (Expense expense : expenses) {
            expense.displayExpense();
        }

        System.out.println("===============================================");
    }

    @Override
    public double calculateTotal() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    @Override
    public void categoryWiseExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses available.");
            return;
        }

        HashMap<String, Double> categoryTotals = new HashMap<>();

        for (Expense expense : expenses) {

            String category = expense.getCategory();

            categoryTotals.put(
                    category,
                    categoryTotals.getOrDefault(category, 0.0)
                            + expense.getAmount()
            );
        }

        System.out.println("\n========== CATEGORY-WISE EXPENSES ==========");

        for (Map.Entry<String, Double> entry :
                categoryTotals.entrySet()) {

            System.out.printf("%-15s : ₹%.2f%n",
                    entry.getKey(), entry.getValue());
        }

        System.out.println("============================================");
    }

    @Override
    public void deleteExpense(int id) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {

                expenses.remove(expense);

                System.out.println("\nExpense deleted successfully!");
                return;
            }
        }

        System.out.println("\nExpense ID not found.");
    }

    public int getNextId() {
        return nextId++;
    }
}