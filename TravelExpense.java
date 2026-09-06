public class TravelExpense extends Expense {

    public TravelExpense(int id, String expenseName,
                         double amount, String date) {

        super(id, expenseName, "Transport", amount, date);
    }

    @Override
    public void displayExpense() {
        System.out.println("Travel Expense:");
        super.displayExpense();
    }
}
