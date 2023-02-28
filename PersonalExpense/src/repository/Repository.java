package repository;

import dto.Expense;

import java.time.LocalDate;
import java.util.ArrayList;

public class Repository {

    public static Repository repository;

    private Expense expense;

    private Repository() {
    }

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public void initialDetails(String name, int salary, int fixedExpenses, float expensePercentage) {
        expense = new Expense(name, salary, fixedExpenses, expensePercentage, new ArrayList<>(), new ArrayList<>(), 0);
    }

    public boolean storeDailyExpenses(LocalDate now, float currDayExpense, String reason) {
        if ((expense.getTotalDailyExpenditures() + currDayExpense) > (expense.getSalary() - expense.getFixedExpense()) * (expense.getExpensePercentage() / 100))
            return false;
        ArrayList<Float> exp = expense.getDailyExpenditures();
        exp.add(currDayExpense);
        ArrayList<String> reasons = expense.getReason();
        reasons.add(reason);
        expense.setDailyExpenditures(exp);
        expense.setTotalDailyExpenditures(expense.getTotalDailyExpenditures() + currDayExpense);
        expense.setDate(now);
        return true;
    }

    public Expense getThisMonthExpenditures() {
        return expense;
    }

}

