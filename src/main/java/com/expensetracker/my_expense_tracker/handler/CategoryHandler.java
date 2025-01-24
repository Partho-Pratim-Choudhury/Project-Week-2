package com.expensetracker.my_expense_tracker.handler;

import java.util.List;
import java.util.Map;

public interface CategoryHandler {

    void addExpense(double amount, Map<String, List<Double>> expenses);

    double getTotalExpense();

    String getCategoryName();
}
