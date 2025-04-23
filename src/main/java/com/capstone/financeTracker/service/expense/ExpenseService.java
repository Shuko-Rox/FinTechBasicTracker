package com.capstone.financeTracker.service.expense;

import java.util.List;

import com.capstone.financeTracker.dto.ExpenseDTO;
import com.capstone.financeTracker.entity.Expense;

public interface ExpenseService {
	
	Expense postExpense(ExpenseDTO expenseDTO );
	
	List<Expense> getAllExpenses();
	
	Expense getExpenseById(Long id);
	
	Expense updateExpense(Long id, ExpenseDTO expenseDTO);
	
	void deleteExpense(Long id);

}
