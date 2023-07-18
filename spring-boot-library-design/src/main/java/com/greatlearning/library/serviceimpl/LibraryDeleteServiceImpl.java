package com.greatlearning.library.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

	@Autowired
	LibraryRepository deleteRepository;
	
	@Override
	public String deleteOneLibrary(Library library) {
		deleteRepository.delete(library);
		return "Deleted library: " +library;
	}
	
	@Override
	public String pruneTable() {
		deleteRepository.deleteAll();
		return "prune completed";
	}
	
	@Override
	public String deleteAllThese(List<Library> libraries) {
		deleteRepository.deleteAll(libraries);
		return "Delete all completed";
	}
	
	@Override
	public String deleteAllInBatch() {
		deleteRepository.deleteAllInBatch();
		return "Deleted all in batch completed";
	}
	
	@Override
	public String deleteLibraryById(long id) {
		deleteRepository.deleteById(id);
		return "Library with this " +id+ " is deleted";
	}
	
	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		deleteRepository.deleteInBatch(libraries);
		return "Deleted all the libraries in list in batch mode";
	}
}
