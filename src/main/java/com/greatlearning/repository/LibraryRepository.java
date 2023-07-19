package com.greatlearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long> {

}
