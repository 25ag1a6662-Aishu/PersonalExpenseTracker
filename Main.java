import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ExpenseManager manager = new ExpenseManager();
        Budget budget = new Budget();

        int choice;

        System.out.println("==========================================");
        System.out.println("       PERSONAL EXPENSE TRACKER");
        System.out.println("==========================================");

        do {

            System.out.println("\n------------- MAIN MENU ----------------");
            System.out.println("1. Set Monthly Budget");
            System.out.println("2. Add Expense");
            System.out.println("3. Add Food Expense");
            System.out.println("4. Add Travel Expense");
            System.out.println("5. View All Expenses");
            System.out.println("6. View Total Expenses");
            System.out.println("7. Category-wise Expenses");
            System.out.println("8. View Remaining Budget");
            System.out.println("9. Delete Expense");
            System.out.println("10. Exit");
            System.out.println("-----------------------------------------");

            System.out.print("Enter your choice: ");

            try {

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        setBudget(scanner, budget);
                        break;

                    case 2:
                        addNormalExpense(scanner, manager);
                        break;

                    case 3:
                        addFoodExpense(scanner, manager);
                        break;

                    case 4:
                        addTravelExpense(scanner, manager);
                        break;

                    case 5:
                        manager.viewExpenses();
                        break;

                    case 6:
                        System.out.printf(
                                "\nTotal Expenses = ₹%.2f%n",
                                manager.calculateTotal()
                        );
                        break;

                    case 7:
                        manager.categoryWiseExpenses();
                        break;

                    case 8:
                        budget.displayBudget(manager.calculateTotal());
                        break;

                    case 9:
                        deleteExpense(scanner, manager);
                        break;

                    case 10:
                        System.out.println(
                                "\nThank you for using Personal Expense Tracker!"
                        );
                        break;

                    default:
                        System.out.println(
                                "\nInvalid choice! Please select 1-10."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nInvalid input! Please enter a number."
                );

                choice = 0;

            } catch (Exception e) {

                System.out.println(
                        "\nError: " + e.getMessage()
                );

                choice = 0;
            }

        } while (choice != 10);

        scanner.close();
    }

    // Set budget
    public static void setBudget(Scanner scanner, Budget budget) {

        try {

            System.out.print("\nEnter monthly budget: ₹");

            double amount =
                    Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                throw new InvalidExpenseException(
                        "Budget must be greater than zero."
                );
            }

            budget.setBudget(amount);

            System.out.println(
                    "Monthly budget set successfully!"
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid amount! Please enter a number."
            );

        } catch (InvalidExpenseException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // Add normal expense
    public static void addNormalExpense(
            Scanner scanner,
            ExpenseManager manager) {

        try {

            System.out.print("\nEnter expense name: ");
            String name = scanner.nextLine();

            System.out.print("Enter category: ");
            String category = scanner.nextLine();

            System.out.print("Enter amount: ₹");
            double amount =
                    Double.parseDouble(scanner.nextLine());

            System.out.print("Enter date (DD-MM-YYYY): ");
            String date = scanner.nextLine();

            if (name.isEmpty()) {
                throw new InvalidExpenseException(
                        "Expense name cannot be empty."
                );
            }

            if (amount <= 0) {
                throw new InvalidExpenseException(
                        "Amount must be greater than zero."
                );
            }

            Expense expense = new Expense(
                    manager.getNextId(),
                    name,
                    category,
                    amount,
                    date
            );

            manager.addExpense(expense);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid amount! Please enter a number."
            );

        } catch (InvalidExpenseException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // Add food expense
    public static void addFoodExpense(
            Scanner scanner,
            ExpenseManager manager) {

        try {

            System.out.print("\nEnter food expense name: ");
            String name = scanner.nextLine();

            System.out.print("Enter amount: ₹");
            double amount =
                    Double.parseDouble(scanner.nextLine());

            System.out.print("Enter date (DD-MM-YYYY): ");
            String date = scanner.nextLine();

            if (amount <= 0) {
                throw new InvalidExpenseException(
                        "Amount must be greater than zero."
                );
            }

            FoodExpense foodExpense =
                    new FoodExpense(
                            manager.getNextId(),
                            name,
                            amount,
                            date
                    );

            manager.addExpense(foodExpense);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid amount! Please enter a number."
            );

        } catch (InvalidExpenseException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // Add travel expense
    public static void addTravelExpense(
            Scanner scanner,
            ExpenseManager manager) {

        try {

            System.out.print("\nEnter travel expense name: ");
            String name = scanner.nextLine();

            System.out.print("Enter amount: ₹");
            double amount =
                    Double.parseDouble(scanner.nextLine());

            System.out.print("Enter date (DD-MM-YYYY): ");
            String date = scanner.nextLine();

            if (amount <= 0) {
                throw new InvalidExpenseException(
                        "Amount must be greater than zero."
                );
            }

            TravelExpense travelExpense =
                    new TravelExpense(
                            manager.getNextId(),
                            name,
                            amount,
                            date
                    );

            manager.addExpense(travelExpense);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid amount! Please enter a number."
            );

        } catch (InvalidExpenseException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // Delete expense
    public static void deleteExpense(
            Scanner scanner,
            ExpenseManager manager) {

        try {

            System.out.print("\nEnter expense ID to delete: ");

            int id =
                    Integer.parseInt(scanner.nextLine());

            manager.deleteExpense(id);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid ID! Please enter a number."
            );
        }
    }
}