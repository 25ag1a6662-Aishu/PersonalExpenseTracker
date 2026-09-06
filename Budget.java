public class Budget {

    private double monthlyBudget;

    public Budget() {
        monthlyBudget = 0;
    }

    public void setBudget(double amount) {
        monthlyBudget = amount;
    }

    public double getBudget() {
        return monthlyBudget;
    }

    public double getRemainingBudget(double totalExpense) {
        return monthlyBudget - totalExpense;
    }

    public void displayBudget(double totalExpense) {

        double remaining = getRemainingBudget(totalExpense);

        System.out.println("\n========== BUDGET DETAILS ==========");
        System.out.printf("Monthly Budget : ₹%.2f%n", monthlyBudget);
        System.out.printf("Total Expense  : ₹%.2f%n", totalExpense);
        System.out.printf("Remaining      : ₹%.2f%n", remaining);
        System.out.println("====================================");
    }
}