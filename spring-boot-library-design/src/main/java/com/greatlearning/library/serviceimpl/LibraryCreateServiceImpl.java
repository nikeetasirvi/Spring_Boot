package com.greatlearning.library.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {

	@Autowired
	LibraryRepository createRepository;
	
	@Override
	public String addSingleLibrary(Library library) {
		createRepository.save(library);
		createRepository.flush();
		return "Library saved";
	}
	
	@Override
	public String addAllLibrary(List<Library> libraries) {
		createRepository.saveAll(libraries);
		createRepository.flush();
		return "All Libraries saved";
	}
	
	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		return createRepository.saveAndFlush(library);
	}
}
