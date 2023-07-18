package com.greatlearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.serviceimpl.LibraryCreateServiceImpl;

@RestController
@RequestMapping("/createService")
public class LibraryCreateController {
	
	@Autowired
	LibraryCreateServiceImpl createService;
	
	@PostMapping("/addSingleLibrary")
	public String addSingleLibrary(Library library) {
		return createService.addSingleLibrary(library);
	}
	
	@PostMapping("/addAllLibrary")
	public String addAllLibrary(@RequestBody List<Library> library) {
		return createService.addAllLibrary(library);
	}
	
	@PostMapping("/addLibraryWithSaveAndFlush")
	public Library addLibraryWithSaveAndFlush(Library library) {
		return createService.addLibraryWithSaveAndFlush(library);
	}
}
