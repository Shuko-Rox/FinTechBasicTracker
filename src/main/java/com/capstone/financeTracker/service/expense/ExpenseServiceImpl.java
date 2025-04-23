package com.capstone.financeTracker.service.expense;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capstone.financeTracker.dto.ExpenseDTO;
import com.capstone.financeTracker.entity.Expense;
import com.capstone.financeTracker.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    // Constructor for dependency injection (replaces @RequiredArgsConstructor)
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense postExpense(ExpenseDTO expenseDTO) {
        return saveOrUpdateExpense(new Expense(), expenseDTO);
    }

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO) {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, ExpenseDTO expenseDTO) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return saveOrUpdateExpense(optionalExpense.get(), expenseDTO);
        } else {
            throw new EntityNotFoundException("Expense is not present with id -> " + id);
        }
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            throw new EntityNotFoundException("Expense is not present with id -> " + id);
        }
    }
    
    
    @Override
    public void deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            expenseRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Expense is not present with id -> " + id);
        }
    }
    
}
