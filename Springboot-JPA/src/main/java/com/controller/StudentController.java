package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.repository.StudentRepo;

@RestController
@RequestMapping("/api/")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("/students")
	public List<Student> getAllStudent()
	{
		return studentRepo.findAll();
	}
	
	@GetMapping("/students/id/{id}")
	public Optional<Student> getStudentById(@PathVariable int id)
	{
		return studentRepo.findById(id);
	}
	
	@GetMapping("/students/name/{name}")
	public List<Student> getStudentByName(@PathVariable String name)
	{
		return studentRepo.findByName(name);
	}
	
	@GetMapping("/students/address/{address}")
	public List<Student> getStudentByAddress(@PathVariable String address)
	{
		return studentRepo.findByAddress(address);
	}

	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student)
	{
		return studentRepo.save(student);
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		studentRepo.deleteById(id);
		return "Data Deleted With ID : "+id;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student)
	{
		return studentRepo.save(student);
	}
	
}
