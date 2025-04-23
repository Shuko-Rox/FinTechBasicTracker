package com.capstone.financeTracker.service.income;

import java.util.List;

import com.capstone.financeTracker.dto.IncomeDTO;
import com.capstone.financeTracker.entity.Income;

public interface IncomeService {
	
	Income postIncome(IncomeDTO incomeDTO);
	
	List<IncomeDTO> getAllIncome();
	
	Income updateIncome(Long id, IncomeDTO incomeDTO);
	
	IncomeDTO getIncomeById(Long id);
	
	void deleteIncome(Long id);

}
