package com.greatlearning.library.service;

import java.util.List;

import com.greatlearning.library.entity.Library;

public interface LibraryDeleteService {

	String deleteOneLibrary(Library library);

	String pruneTable();

	String deleteAllThese(List<Library> libraries);

	String deleteAllInBatch();

	String deleteLibraryById(long id);

	String deleteAllTheseInBatch(List<Library> libraries);

}