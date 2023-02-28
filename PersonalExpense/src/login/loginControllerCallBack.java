package login;

import dto.Expense;

import java.time.LocalDate;

public interface loginControllerCallBack {
    void initialDetails(String name, int salary, int fixedExpenses, float expensePercentage);

    void storeDailyExpenses(LocalDate now, float currDayExpense, String reason);

    void getThisMonthExpenditures();

    void showMonthlyExpense(Expense expense);

    void monthlyLimitExceeded();
}
