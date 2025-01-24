package com.expensetracker.my_expense_tracker.service;

import com.expensetracker.my_expense_tracker.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    private Map<String, List<Double>> expenses = new HashMap<>();
    private Map<String, Double> categoryExpenseMap = new HashMap<>();
    private Double totalExpense = 0.0;

    @Autowired
    private Map<String, CategoryHandler> categoryHandlerMap;

    public ExpenseService() {
        expenses.put("food", new ArrayList<>());
        expenses.put("travel", new ArrayList<>());
        expenses.put("entertainment", new ArrayList<>());
        expenses.put("misc", new ArrayList<>());
    }

    public void addExpense(String category, Double amount) {
            CategoryHandler handler = categoryHandlerMap.get(category);
            if(handler != null) {
                handler.addExpense(amount, expenses);
                categoryExpenseMap.put(category, handler.getTotalExpense());
                totalExpense += amount;
            } else {
                System.out.println("Invalid Category Provided !");
            }
    }

    public void getSummary() {
        System.out.println("Summary : ");
        System.out.print("Food : " + (categoryExpenseMap.get("food") != null ? categoryExpenseMap.get("food") : 0.0) + " ");
        System.out.print("Travel : " + (categoryExpenseMap.get("travel") != null ? categoryExpenseMap.get("travel") : 0.0) + " ");
        System.out.print("Entertainment : " + (categoryExpenseMap.get("entertainment") != null ? categoryExpenseMap.get("entertainment") : 0.0) + " ");
        System.out.print("Miscellaneous : " + (categoryExpenseMap.get("misc") != null ? categoryExpenseMap.get("misc") : 0.0) + "\n");
    }

    public void getTotal() {
        System.out.println("Total Expenses : " + totalExpense);
    }

}
