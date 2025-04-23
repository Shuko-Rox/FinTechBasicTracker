package com.capstone.financeTracker.service.income;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capstone.financeTracker.dto.IncomeDTO;
import com.capstone.financeTracker.entity.Income;
import com.capstone.financeTracker.repository.IncomeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    // Manual constructor for dependency injection
    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public Income postIncome(IncomeDTO incomeDTO) {
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }

    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription()); // Fixed from setCategory

        return incomeRepository.save(income);
    }

    @Override
    public List<IncomeDTO> getAllIncome() {
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Income updateIncome(Long id, IncomeDTO incomeDTO) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()) {
            return saveOrUpdateIncome(optionalIncome.get(), incomeDTO);
        } else {
            throw new EntityNotFoundException("There is no income for id -> " + id);
        }
    }
    
    
    @Override
    public IncomeDTO getIncomeById(Long id) {
    	Optional<Income> optionalIncome = incomeRepository.findById(id);
    	if(optionalIncome.isPresent()) {
    		return optionalIncome.get().getIncomeDTO();
    	}else {
    		throw new EntityNotFoundException("There is no income for id -> " + id);
    	}
    }
    
    
    @Override
    public void deleteIncome(Long id) {
    	Optional<Income> optionalIncome = incomeRepository.findById(id);
    	if(optionalIncome.isPresent()) {
    		incomeRepository.deleteById(id);
    	}else {
    		throw new EntityNotFoundException("There is no income for id -> " + id);
    	}
    }
}
