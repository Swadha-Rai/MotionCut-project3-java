import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String category;
    private double amount;
    private String date;

    public Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
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

    @Override
    public String toString() {
        return "Date: " + date + ", Category: " + category + ", Amount: $" + amount;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Expense Tracker!");
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n1. Add Expense");
                System.out.println("2. View All Expenses");
                System.out.println("3. Generate Summary");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = Integer.parseInt(scanner.nextLine()); // Parse input as int

                switch (choice) {
                    case 1 -> addExpense();
                    case 2 -> viewExpenses();
                    case 3 -> generateSummary();
                    case 4 -> {
                        System.out.println("Thank you for using the Expense Tracker!");
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Please enter a valid option.");
            }
        }
    }

    private static void addExpense() {
        try {
            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("Enter category (e.g., Food, Travel): ");
            String category = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            expenses.add(new Expense(category, amount, date));
            System.out.println("Expense added successfully!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        System.out.println("\nYour Expenses:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private static void generateSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded to generate a summary.");
            return;
        }

        double total = 0;
        System.out.println("\nExpense Summary:");
        for (Expense expense : expenses) {
            total += expense.getAmount();
            System.out.println(expense);
        }
        System.out.println("Total Expenses: $" + total);
    }
}