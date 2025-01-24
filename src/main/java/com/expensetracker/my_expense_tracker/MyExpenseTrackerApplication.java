package com.expensetracker.my_expense_tracker;

import com.expensetracker.my_expense_tracker.handler.CategoryHandler;
import com.expensetracker.my_expense_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class MyExpenseTrackerApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MyExpenseTrackerApplication.class);
		ExpenseService expenseService = context.getBean(ExpenseService.class);

		boolean optionsToDisplay = true;

		while(optionsToDisplay) {

			System.out.println("\nSelect an option : ");
			System.out.println("Options : 1) Add Expense 2) View Summary 3) View Total 4) Exit");

			int opt = new Scanner(System.in).nextInt();

			switch (opt) {
				case 1 : {
					System.out.println("Enter Category and Amount : ");

					System.out.println("Enter Category : a) Food b) Travel c) Entertainment d) Misc");
					String category = new Scanner(System.in).nextLine().toLowerCase();

					System.out.println("Enter Amount : ");
					Double amount = new Scanner(System.in).nextDouble();

					expenseService.addExpense(category, amount);
					break;
				}

				case 2 : {
					expenseService.getSummary();
					break;
				}

				case 3 : {
					expenseService.getTotal();
					break;
				}

				case 4 : {
					System.out.println("Exiting");
					optionsToDisplay = false;
					break;
				}

				default : {
					System.out.println("Wrong option chosen!");
					break;
				}
			}
		}
	}
}
