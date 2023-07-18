package com.greatlearning.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryReadService;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {

	@Autowired
	LibraryReadService readService;
	
	@GetMapping("/getAllLibraries")
	public List<Library> getAllLibraries() {
		return readService.getAllLibrary();
	}
	
	@GetMapping("/getAllLibrariesWithNoBooks")
	public List<Library> getAllLibrariesWithNoBooks() {
		return readService.getAllLibrariesWithNoBooks();
	}
	
	@GetMapping("/getLibrariesPaged")
	public Page<Library> getLibrariesPaged() {
		return readService.getLibrariesPaged();
	}
	
	@GetMapping("/getLibrariesCustomPaged")
	public Page<Library> getLibrariesCustomPaged(int pageNumber,int numberOfRecordsOnPage) {
		return readService.getLibrariesCustomPaged(pageNumber, numberOfRecordsOnPage);
	}
	
	@GetMapping("/getLibrariesWithLatestAddedOrder")
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readService.getLibrariesWithLatestAddedOrder();
	}
	
	@GetMapping("/getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readService.getLibrariesCustomSortedById(direction);
	}
	
	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readService.getLibrariesCustomSortedByName(direction);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		return readService.getLibrariesPagedAndSortedByNameAndWithTheseBooks(commaSeparatedBookNames);
	}
	
	@GetMapping("/getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks")
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(int pageNumber,int numberOfRecordsOnPage,String commaSeparatedBookNames) {
		return readService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(pageNumber, numberOfRecordsOnPage, commaSeparatedBookNames);
	}

	@GetMapping("/getSortedByNameAndWithTheseBooks")
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBooknames) {
		return readService.getSortedByNameAndWithTheseBooks(commaSeparatedBooknames);
	}
	
	@PostMapping("/getLibrariesByIds")
	public List<Library> getLibrariesByIds(@RequestBody List<Long> ids) {
		return readService.getLibrariesByIds(ids);
	}
	
	@GetMapping("/getLibrariesById")
	public Optional<Library> getLibrariesById(Long id) {
		return readService.getLibraryById(id);
	}
	
	@GetMapping("/getLibraryWithTheseBooks")
	public Optional<Library> getLibraryWithTheseBooks(String commaSeparatedBooknames) {
		return readService.getLibraryWithTheseBooks(commaSeparatedBooknames);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return readService.getLibrariesPagedAndSortedByName();
	}
}
