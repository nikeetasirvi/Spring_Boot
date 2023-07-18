package com.greatlearning.library.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {

	@Autowired
	LibraryRepository existRepository;
	
	@Override
	public boolean checkLibraryExistsById(long id) {
		return existRepository.existsById(id);
	}
	
	@Override
	public boolean checkLibraryExistByExample(String commaSeparatedBookNames) {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeparatedBooknames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return existRepository.exists(example);
	}
}
