package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Library;
import com.greatlearning.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public String addSingleLibrary(Library library) {
		libraryRepository.save(library);
		return "Library Saved";
	}

	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		return "Added all libraries";
	}

	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		return libraryRepository.saveAndFlush(library);
	}

	@Override
	public Library updateLibrary(long id, Library updatedLibrary) {
		Library existingLibrary = this.libraryRepository.findById(id).get();
		existingLibrary.setName(updatedLibrary.getName());
		existingLibrary.setBooks(updatedLibrary.getBooks());
		return this.libraryRepository.save(existingLibrary);
	}

	@Override
	public Library getLibraryById(long id) {
		return this.libraryRepository.findById(id).get();
	}

	@Override
	public void deleteLibraryById(long id) {
		libraryRepository.deleteById(id);
	}

	@Override
	public List<Library> fetchAllLibraries() {
		return libraryRepository.findAll();
	}

}
