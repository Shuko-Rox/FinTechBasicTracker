package com.capstone.financeTracker.entity;

import java.time.LocalDate;

import com.capstone.financeTracker.dto.IncomeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private Integer amount;
	
	private LocalDate date;
	
	private String category;
	
	private String description;
	
	public IncomeDTO getIncomeDTO() {
		IncomeDTO incomeDTO = new IncomeDTO();
		
		incomeDTO.setId(id);
		incomeDTO.setTitle(title);
		incomeDTO.setAmount(amount);
		incomeDTO.setCategory(category);
		incomeDTO.setDescription(description);
		incomeDTO.setDate(date);
		
		return incomeDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
