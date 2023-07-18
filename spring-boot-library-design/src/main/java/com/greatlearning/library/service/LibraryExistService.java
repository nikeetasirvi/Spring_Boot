package com.greatlearning.library.service;

public interface LibraryExistService {

	boolean checkLibraryExistsById(long id);

	boolean checkLibraryExistByExample(String commaSeparatedBookNames);

}