package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.entity.Library;
import com.greatlearning.service.LibraryService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

	@Autowired	
	private LibraryService libraryService;
	
	@GetMapping
	public List<Library> fetchAllLibraries(){
		return this.libraryService.fetchAllLibraries();	
	}
	
	@GetMapping("/{id}")
	public Library fetchLibraryById(@PathVariable("id") long libraryId) {
		return this.libraryService.getLibraryById(libraryId);
	}
	
	@PostMapping
	public void saveLibraryById(@RequestBody Library library) {
		this.libraryService.addSingleLibrary(library);
	}
	
	@PutMapping("/{id}")
	public void updateLibraryById(@PathVariable("id") long libraryId, Library updatedLibrary) {
		this.libraryService.updateLibrary(libraryId, updatedLibrary);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLibraryById(@PathVariable("id") long libraryId) {
		this.libraryService.deleteLibraryById(libraryId);
	}
}
