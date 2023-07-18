package com.greatlearning.library.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FullName {

	private String firstName;
	private String lastName;
	
}
