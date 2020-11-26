package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	@Query("from Student where address= :address")
	List<Student> findByAddress(@Param("address") String address);

}
