package com.greatlearning.security.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class YearlyFinancialReport {

	@Id
	private Integer id;
	
	private String year;
	
	private int netRevenue;
	
	private int materialCost;
	
	private int netProfit;
}
