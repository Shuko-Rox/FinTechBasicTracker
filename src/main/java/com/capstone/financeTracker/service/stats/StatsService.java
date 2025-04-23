package com.capstone.financeTracker.service.stats;

import com.capstone.financeTracker.dto.GraphDTO;
import com.capstone.financeTracker.dto.StatsDTO;

public interface StatsService {

	GraphDTO getChartData();
	
	StatsDTO getStats() ;
}
