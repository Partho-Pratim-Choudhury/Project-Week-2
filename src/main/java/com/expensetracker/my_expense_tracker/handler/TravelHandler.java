package com.expensetracker.my_expense_tracker.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("travel")
public class TravelHandler implements CategoryHandler{

    private Double travelExpense = 0.0;

    public void addExpense(double amount, Map<String, List<Double>> expenses) {
        expenses.get("travel").add(amount);
        travelExpense += amount;
    }

    public double getTotalExpense() {
        return travelExpense;
    }

    public String getCategoryName() {
        return "travel";
    }
}
