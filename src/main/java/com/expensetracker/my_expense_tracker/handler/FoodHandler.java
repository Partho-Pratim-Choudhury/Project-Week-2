package com.expensetracker.my_expense_tracker.handler;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("food")
public class FoodHandler implements CategoryHandler {

    private Double foodExpense = 0.0;

    public void addExpense(double amount, Map<String, List<Double>> expenses) {
        expenses.get("food").add(amount);
        foodExpense += amount;
    }

    public double getTotalExpense() {
        return foodExpense;
    }

    public String getCategoryName() {
        return "food";
    }
}
