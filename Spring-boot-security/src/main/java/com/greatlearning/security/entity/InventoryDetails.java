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
public class InventoryDetails {

	@Id
	private Integer id;
	
	private String itemName;
	
	private int numberOfItemsAvailable;
	
	private int price;
}
