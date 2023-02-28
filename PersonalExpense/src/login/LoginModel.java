package login;

import dto.Expense;
import repository.Repository;

import java.time.LocalDate;

public class LoginModel implements loginModelCallBack {
    private loginControllerCallBack controllerObj;

    public LoginModel(loginControllerCallBack controllerObj) {
        this.controllerObj = controllerObj;
    }

    public void storeInitialData(String name, int salary, int fixedExpenses, float expensePercentage) {
        Repository.getInstance().initialDetails(name, salary, fixedExpenses, expensePercentage);
    }

    public void storeDailyExpenses(LocalDate now, float currDayExpense, String reason) {
        boolean isWithinLimit = Repository.getInstance().storeDailyExpenses(now, currDayExpense, reason);
        if (!isWithinLimit)
            controllerObj.monthlyLimitExceeded();
    }

    public void getThisMonthExpenditures() {
        Expense expense = Repository.getInstance().getThisMonthExpenditures();
        controllerObj.showMonthlyExpense(expense);
    }

    public Expense getExpenses() {
        return Repository.getInstance().getThisMonthExpenditures();
    }
}

