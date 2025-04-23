package com.capstone.financeTracker.dto;

import com.capstone.financeTracker.entity.Expense;
import com.capstone.financeTracker.entity.Income;

public class StatsDTO {

	private Double income;
	
	private Double expense;
	
	private Income latestIncome;
	
	private Expense latestExpense;
	
	private Double balance;
	
	private Double minIncome;
	
	private Double maxIncome;
	
	private Double minExpense;
	
	private Double maxExpense;
	
	

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getMinIncome() {
		return minIncome;
	}

	public void setMinIncome(Double minIncome) {
		this.minIncome = minIncome;
	}

	public Double getMaxIncome() {
		return maxIncome;
	}

	public void setMaxIncome(Double maxIncome) {
		this.maxIncome = maxIncome;
	}

	public Double getMinExpense() {
		return minExpense;
	}

	public void setMinExpense(Double minExpense) {
		this.minExpense = minExpense;
	}

	public Double getMaxExpense() {
		return maxExpense;
	}

	public void setMaxExpense(Double maxExpense) {
		this.maxExpense = maxExpense;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public Income getLatestIncome() {
		return latestIncome;
	}

	public void setLatestIncome(Income latestIncome) {
		this.latestIncome = latestIncome;
	}

	public Expense getLatestExpense() {
		return latestExpense;
	}

	public void setLatestExpense(Expense latestExpense) {
		this.latestExpense = latestExpense;
	}
	
	
	
}
