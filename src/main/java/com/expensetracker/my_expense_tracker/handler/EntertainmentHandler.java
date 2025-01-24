package com.expensetracker.my_expense_tracker.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("entertainment")
public class EntertainmentHandler implements CategoryHandler{

    private Double entertainmentExpense = 0.0;

    public void addExpense(double amount, Map<String, List<Double>> expenses) {
        expenses.get("entertainment").add(amount);
        entertainmentExpense += amount;
    }

    public double getTotalExpense() {
        return entertainmentExpense;
    }

    public String getCategoryName() {
        return "entertainment";
    }
}
