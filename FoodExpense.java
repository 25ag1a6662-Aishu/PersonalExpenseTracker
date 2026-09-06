public class FoodExpense extends Expense {

    public FoodExpense(int id, String expenseName,
                       double amount, String date) {

        super(id, expenseName, "Food", amount, date);
    }

    @Override
    public void displayExpense() {
        System.out.println("Food Expense:");
        super.displayExpense();
    }
}
