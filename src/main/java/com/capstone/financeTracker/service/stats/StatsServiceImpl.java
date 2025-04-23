package com.capstone.financeTracker.service.stats;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.capstone.financeTracker.repository.IncomeRepository;
import com.capstone.financeTracker.dto.GraphDTO;
import com.capstone.financeTracker.dto.StatsDTO;
import com.capstone.financeTracker.entity.Expense;
import com.capstone.financeTracker.entity.Income;
import com.capstone.financeTracker.repository.ExpenseRepository;

@Service
public class StatsServiceImpl implements StatsService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    // Manual constructor for dependency injection
    public StatsServiceImpl(IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }
    
    
    public GraphDTO getChartData() {
    	LocalDate endDate = LocalDate.now();
    	//LocalDate startDate = endDate.minusDays(27);
    	LocalDate startDate= LocalDate.of(2000, 1, 1);
    	
    	GraphDTO graphDTO = new GraphDTO();
    	graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate, endDate));
    	graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));
    	
    	
    	return graphDTO;
    	
    }
    
    
    public StatsDTO getStats() {
    	
    	Double totalIncome = incomeRepository.sumAllAmounts();
    	Double totalExpense = expenseRepository.sumAllAmounts();
    	 
    	Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
    	Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();
    	
    	StatsDTO statsDTO = new StatsDTO();
    	statsDTO.setExpense(totalExpense);
    	statsDTO.setIncome(totalIncome);
    	
    	
    	if(optionalIncome.isPresent()) {
    		statsDTO.setLatestIncome(optionalIncome.get());
    	}
    	
    	if(optionalExpense.isPresent()) {
    		statsDTO.setLatestExpense(optionalExpense.get());
    	}
    	
    	statsDTO.setBalance(totalIncome-totalExpense);
    	
    	List<Income> incomeList = incomeRepository.findAll();
    	List<Expense> expenseList = expenseRepository.findAll();
    	
    	OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
    	OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();
    	
    	OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
    	OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();
    	
    	statsDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : null);
    	statsDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);
    	
    	statsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);
    	statsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);
    	
    	return statsDTO;
    	
    }
    
    

}
