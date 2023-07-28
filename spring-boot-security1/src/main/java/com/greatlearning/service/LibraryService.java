package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Library;

public interface LibraryService {

	public String addSingleLibrary(Library library);
	
	String addAllLibraries(List<Library> libraries);
	
	Library addLibraryWithSaveAndFlush(Library library);
	
	Library updateLibrary(long id, Library updatedLibrary);
	
	Library getLibraryById(long libraryId);
	
	void deleteLibraryById(long id);
	
	List<Library> fetchAllLibraries();
	
}
