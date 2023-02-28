package login;


import dto.Expense;

import java.time.LocalDate;

public interface loginModelCallBack {
    void storeInitialData(String name, int salary, int fixedExpenses, float expensePercentage);

    void storeDailyExpenses(LocalDate now, float currDayExpense, String reason);

    void getThisMonthExpenditures();

    Expense getExpenses();
}

