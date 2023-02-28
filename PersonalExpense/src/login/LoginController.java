package login;

import dto.Expense;

import java.time.LocalDate;

public class LoginController implements loginControllerCallBack {
    private loginViewCallBack viewObj;
    private loginModelCallBack modelObj;

    public LoginController(loginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj = new LoginModel(this);
    }

    public void storeInitialData(String name, int salary, int fixedExpenses, float expensePercentage) {
        modelObj.storeInitialData(name, salary, fixedExpenses, expensePercentage);
    }

    @Override
    public void initialDetails(String name, int salary, int fixedExpenses, float expensePercentage) {
        modelObj.storeInitialData(name, salary, fixedExpenses, expensePercentage);
    }

    public void storeDailyExpenses(LocalDate now, float currDayExpense, String reason) {
        modelObj.storeDailyExpenses(now, currDayExpense, reason);
    }

    public void monthlyLimitExceeded() {
        viewObj.monthlyLimitExceeded();
    }

    public void getThisMonthExpenditures() {
        modelObj.getThisMonthExpenditures();
    }


    public void showMonthlyExpense(Expense expense) {
        viewObj.showMonthlyExpense(expense);
    }

    public Expense getExpenses() {
        return modelObj.getExpenses();
    }
}
