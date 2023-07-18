package com.greatlearning.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;

public interface LibraryReadService {

	List<Library> getAllLibrary();

	List<Library> getAllLibrariesWithNoBooks();

	Page<Library> getLibrariesPaged();

	Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnPage);

	List<Library> getLibrariesWithLatestAddedOrder();

	List<Library> getLibrariesCustomSortedById(Direction direction);

	List<Library> getLibrariesCustomSortedByName(Direction direction);

	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames);

	Page<Library> getLibrariesPagedAndSortedByName();

	Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(int pageNumber,
			int numberOfRecordsOnPage, String commaSeparatedBookNames);

	List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBooknames);

	List<Library> getLibrariesByIds(List<Long> ids);

	Optional<Library> getLibraryById(Long id);

	Optional<Library> getLibraryWithTheseBooks(String commaSeparatedBooknames);

}