package com.greatlearning.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.serviceimpl.LibraryCountServiceImpl;
import com.greatlearning.library.serviceimpl.LibraryCreateServiceImpl;
import com.greatlearning.library.serviceimpl.LibraryDeleteServiceImpl;
import com.greatlearning.library.serviceimpl.LibraryExistServiceImpl;
import com.greatlearning.library.serviceimpl.LibraryReadServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner{

	@Autowired
	LibraryReadServiceImpl libraryReadServiceImpl;
	
	@Autowired
	LibraryCreateServiceImpl libraryCreateServiceImpl;
	
	@Autowired
	LibraryCountServiceImpl libraryCountServiceImpl;
	
	@Autowired
	LibraryExistServiceImpl libraryExistServiceImpl;
	
	@Autowired
	LibraryDeleteServiceImpl libraryDeleteServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("hi nikeeta");
		System.out.println("hello ....testing dev tools");
	}

	@Override
	public void run(String... args) throws Exception {
		
		//general();
		//readServiceImplMethodsExecution();
		//createServiceImplMethodsExecution();
		//countServiceimplMethodsExecution();
		//existServiceImplMethodsExecution();
		//deleteServiceImplMethodsExecution();
	}

	public void deleteServiceImplMethodsExecution() {
		log.info("Delete one library -> {}", libraryDeleteServiceImpl.deleteOneLibrary(
				Library.builder().id(10l).name("C Library").commaSeparatedBooknames("xyz, abc, efg").build()));
		log.info("Prune Table -> {}", libraryDeleteServiceImpl.pruneTable());
		
		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(3l).name("Animal Library").commaSeparatedBooknames("").build());
		libraries.add(Library.builder().id(4l).name("Cloud Library").commaSeparatedBooknames("").build());
		log.info("Delete All these -> {}", libraryDeleteServiceImpl.deleteAllThese(libraries));
		
		log.info("Delete all in batch -> {}", libraryDeleteServiceImpl.deleteAllInBatch());
		
		log.info("Delete by id -> {}", libraryDeleteServiceImpl.deleteLibraryById(6l));
		
		List<Library> libraries1 = new ArrayList<Library>();
		libraries1.add(Library.builder().id(3l).name("Animal Library").commaSeparatedBooknames("").build());
		libraries1.add(Library.builder().id(4l).name("Cloud Library").commaSeparatedBooknames("").build());
		log.info("delete All These In Batch -> {}", libraryDeleteServiceImpl.deleteAllTheseInBatch(libraries1));
	}
	

	public void existServiceImplMethodsExecution() {
		log.info("Check if library exists by id -> {}", libraryExistServiceImpl.checkLibraryExistsById(1l));
		log.info("Check if library exists by Example -> {}", libraryExistServiceImpl.checkLibraryExistByExample("learn java, learn scala, learn AWS"));
	}
	
	

	public void countServiceimplMethodsExecution() {
		log.info("Count the number of libraries -> {}", libraryCountServiceImpl.countLibraries());
		log.info("Count the number of libraries with zero books -> {}", libraryCountServiceImpl.countLibrariesWithZeroBooks());
	}
	

	public void createServiceImplMethodsExecution() {
		log.info("Persist a single Library -> {}", libraryCreateServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("E Library").commaSeparatedBooknames("xyz,abc").build()));
		
		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(12l).name("F Library").commaSeparatedBooknames("abc,efg").build());
		libraries.add(Library.builder().id(13l).name("G Library").commaSeparatedBooknames("efg").build());
		log.info("Persist all Libraries -> {}", libraryCreateServiceImpl.addAllLibrary(libraries));
		
		log.info("Persist a Library with saveAndFlush combined -> {}",libraryCreateServiceImpl.addLibraryWithSaveAndFlush(
				Library.builder().id(14l).name("E-Commerce Library").commaSeparatedBooknames("Amazone,Flipkart").build()));
	}
	

	public void readServiceImplMethodsExecution() {
		log.info("Fetch all libraries -> {}", libraryReadServiceImpl.getAllLibrary());
		log.info("Fetch all libraries with no books -> {}",libraryReadServiceImpl.getAllLibrariesWithNoBooks());
		
//		Page<Library> page = libraryReadServiceImpl.getLibrariesPaged();
//		List<Library> libraries = page.get().collect(Collectors.toList());
//		log.info("Fetch Libraries in page format -> {}",libraries);
		log.info("Fetch Libraries in page format -> {}",libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));
		
		log.info("Fetch Libraries in custom page format -> {}",libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));
		log.info("Fetch Libraries with latest added order -> {}",libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());
		log.info("Fetch Libraries in custom sorted by id -> {}",libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.ASC));
		log.info("Fetch Libraries in custom sorted by name -> {}",libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));
		log.info("Fetch Libraries default paged, sorted and with these books -> {}",libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz, abc, efg").get().collect(Collectors.toList()));
		log.info("Fetch Libraries default paged and default sorted by name -> {}",libraryReadServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));
		log.info("Fetch Libraries custom paged and default sorted by name and with these books ->{}",libraryReadServiceImpl
				.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(1, 2, "xyz, abc, efg").get().collect(Collectors.toList()));
		log.info("Fetch libraries with default sorted by name -> {}",libraryReadServiceImpl.getSortedByNameAndWithTheseBooks("xyz, abc, efg"));
		
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		log.info("Fetch Libraries by ids -> {}",libraryReadServiceImpl.getLibrariesByIds(ids));
		
		
		long id = 1l;
		Optional<Library> optionalLibrary = libraryReadServiceImpl.getLibraryById(id);
		if(optionalLibrary.isPresent()) {
			log.info("Fetch Library by Id -> {}", optionalLibrary.get());
		} else {
			log.info("No matching library with id " +id+ " was found in the DB");
		}
		//log.info("Fetch Library by Id -> {}", libraryReadServiceImpl.getLibraryById(id).get());
		
		String books = "Life of tommy, Life of Brownie";
		Optional<Library> optionalSingleLibrary = libraryReadServiceImpl.getLibraryWithTheseBooks(books);
		if(optionalSingleLibrary.isPresent()) {
			log.info("Fetch Library with these books -> {}", optionalSingleLibrary.get());
		} else {
			log.info("No matching library with books " +books+ " was found in the DB");
		}
		// if more than one record will be there of this book then it will throw exception
	}
	

	public void general() {
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Designing microservices with spring boot");
		greatLearning.setCourseType("Information Technology");
//		greatLearning.setInstructorName("Nikeeta Sirvi");
		
		System.out.println("GreatLearning object: " +greatLearning);
		
		System.out.println("course name: " + greatLearning.getCourseName());
		System.out.println("course type: " + greatLearning.getCourseType());
		System.out.println("instructor name: " + greatLearning.getInstructorName());
		
//		GreatLearning greatLearning1 = new GreatLearning("Designing microservices with spring boot","Information Technology","Nikeeta Sirvi");
//		System.out.println("GreatLearning object using constructor: " +greatLearning1);
		
		//Design Pattern
		GreatLearning greatLearningTeleDesignPattern = new GreatLearning("Learn Creational Design Pattern","IT");
		System.out.println("greatLearningTeleDesignPattern: " +greatLearningTeleDesignPattern);
		
		GreatLearning greatLearningWithBuilderPattern = GreatLearning.builder().courseName("Learn Builder pattern")
				.courseType("IT").build();
		System.out.println("greatLearningWithBuilderPattern: " +greatLearningWithBuilderPattern);
		
		GreatLearning greatLearningWithBuilderPattern1 = GreatLearning.builder().courseName("Learn Builder pattern").build();
		System.out.println("greatLearningWithBuilderPattern1: " +greatLearningWithBuilderPattern1);
		
		GreatLearning greatLearningComplexObject = GreatLearning.builder().courseName("Complex object builder")
				.courseType("IT")
				.instructorName(FullName.builder().firstName("Nikeeta").lastName("Sirvi").build())
				.build();
		System.out.println("greatLearningComplexObject: " +greatLearningComplexObject);
		
		log.info("Great Learning complex object creation -> {}",greatLearningComplexObject);
	}
}
