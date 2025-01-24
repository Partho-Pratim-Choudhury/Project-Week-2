package com.expensetracker.my_expense_tracker.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("misc")
public class MiscHandler implements CategoryHandler{

    private Double miscExpense = 0.0;

    public void addExpense(double amount, Map<String, List<Double>> expenses) {
        expenses.get("misc").add(amount);
        miscExpense += amount;
    }

    public double getTotalExpense() {
        return miscExpense;
    }

    public String getCategoryName() {
        return "misc";
    }
}
