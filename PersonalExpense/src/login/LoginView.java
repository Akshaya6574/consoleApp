package login;

import dto.Expense;

import java.time.LocalDate;
import java.util.Scanner;


public class LoginView implements loginViewCallBack {
    private Scanner scanner = new Scanner(System.in);
    private loginControllerCallBack controllerObj;
    private boolean canContinue = true;

    public LoginView() {
        controllerObj = new LoginController(this);
    }

    static public void main(String[] args) {
        LoginView LoginView = new LoginView();
        LoginView.getInitializeDetails();
    }

    private void getInitializeDetails() {
        System.out.println("Welcome");
        System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println("Enter your this month salary");
        int salary = scanner.nextInt();
        System.out.println("Enter your monthly fixed expenses");
        int fixedExpenses = scanner.nextInt();
        System.out.println("Enter maximum expenditure percentage for monthly expenses limit");
        float expensePercentage = scanner.nextFloat();
        controllerObj.initialDetails(name, salary, fixedExpenses, expensePercentage);
        getDailyExpenditure();
    }

    private void getDailyExpenditure() {
        if (!canContinue) {
            System.out.println("INSUFFICIENT BALANCE ");
        } else {
            outer:
            while (canContinue) {
                System.out.println("1.ENTER TODAY EXPENSE\t2.DISPLAY EXPENDITURE\t3.EXIT");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Enter today spending (amount)");
                        float currDayExpense = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("Enter reason");
                        String reason = scanner.nextLine();
                        controllerObj.storeDailyExpenses(LocalDate.now(), currDayExpense, reason);
                        break;
                    }
                    case 2: {
                        controllerObj.getThisMonthExpenditures();
                        break;
                    }
                    case 3: {
                        System.out.println("EXIT");
                        break outer;
                    }

                }
            }
        }
    }

    public void monthlyLimitExceeded() {
        System.out.println(" WARNING ----> LIMIT EXCEEDED ");
    }

    public void showMonthlyExpense(Expense expense) {
        System.out.println("________________________________________");
        System.out.println("Date - " + expense.getDate());
        System.out.println("Name - " + expense.getName());
        System.out.println("This month salary - " + expense.getSalary());
        System.out.println("Fixed Expenditure - " + expense.getFixedExpense());
        System.out.println("Remaining money in salary after fixed expenditure - " + (expense.getSalary() - expense.getFixedExpense()));
        System.out.println("This month daily expense limit percentage - " + expense.getExpensePercentage());
        System.out.println("Daily expense limit amount - " + ((expense.getSalary() - expense.getFixedExpense()) * (expense.getExpensePercentage() / 100)));
        for (int i = 0; i < expense.getDailyExpenditures().size(); i++)
            System.out.println("Expense - " + expense.getDailyExpenditures().get(i) + "\tReason - " + expense.getReason().get(i));
        System.out.println("Total daily expenditures - " + expense.getTotalDailyExpenditures());
        System.out.println("Total expenditures  - " + (expense.getFixedExpense() + expense.getTotalDailyExpenditures()));
        System.out.println("Remaining amount for savings - " + (expense.getSalary() - (expense.getFixedExpense() + expense.getTotalDailyExpenditures())));
    }
}
