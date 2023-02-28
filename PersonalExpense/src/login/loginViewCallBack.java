package login;


import dto.Expense;

public interface loginViewCallBack {

    void monthlyLimitExceeded();

    void showMonthlyExpense(Expense expense);

}
