package com.greatlearning.library.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryReadService;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {

	@Autowired
	LibraryRepository readRepository;

	@Override
	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeparatedBooknames("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return readRepository.findAll(example);
	}
	
	@Override
	public Page<Library> getLibrariesPaged() {
		Pageable pageable = PageRequest.of(0, 3);
		return readRepository.findAll(pageable);
	}
	
	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber,int numberOfRecordsOnPage) {
		Pageable pageable = PageRequest.of(pageNumber, numberOfRecordsOnPage);
		return readRepository.findAll(pageable);
	}
	
	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}
	
	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}
	
	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(example, pageable);
	}
	
	@Override
	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pageable);
	}
	
	@Override
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(int pageNumber,int numberOfRecordsOnPage,String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable pageable = PageRequest.of(pageNumber, numberOfRecordsOnPage, Sort.by("name"));
		return readRepository.findAll(example, pageable);
	}
	
	@Override
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBooknames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBooknames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findAll(example, Sort.by("name"));
	}
	
	@Override
	public List<Library> getLibrariesByIds(List<Long> ids) {
		return readRepository.findAllById(ids);
	}
	
	@Override
	public Optional<Library> getLibraryById(Long id) {
		return readRepository.findById(id);
	}
	
	@Override
	public Optional<Library> getLibraryWithTheseBooks(String commaSeparatedBooknames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBooknames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findOne(example);
	}
}
