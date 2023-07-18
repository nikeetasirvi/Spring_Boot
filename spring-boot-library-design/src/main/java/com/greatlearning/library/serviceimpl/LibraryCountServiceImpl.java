package com.greatlearning.library.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {

	@Autowired
	LibraryRepository countRepository;
	
	@Override
	public long countLibraries() {
		return countRepository.count();
	}
	
	@Override
	public long countLibrariesWithZeroBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeparatedBooknames("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return countRepository.count(example);
	}
}
