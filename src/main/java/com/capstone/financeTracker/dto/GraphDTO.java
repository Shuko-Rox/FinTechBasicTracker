package com.capstone.financeTracker.dto;

import java.util.List;

import com.capstone.financeTracker.entity.Expense;
import com.capstone.financeTracker.entity.Income;

public class GraphDTO {
	
	private List<Expense> expenseList;
	
	private List<Income> incomeList;

	public List<Expense> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<Expense> expenseList) {
		this.expenseList = expenseList;
	}

	public List<Income> getIncomeList() {
		return incomeList;
	}

	public void setIncomeList(List<Income> incomeList) {
		this.incomeList = incomeList;
	}

}
