public interface ExpenseOperations {

    void addExpense(Expense expense);

    void viewExpenses();

    double calculateTotal();

    void categoryWiseExpenses();

    void deleteExpense(int id);
}