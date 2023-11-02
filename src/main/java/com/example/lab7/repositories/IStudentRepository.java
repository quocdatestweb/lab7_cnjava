package com.example.lab7.repositories;

import com.example.lab7.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
	List<Student> findStudentsByAgeIsGreaterThanEqual(int x);

	@Query("SELECT s FROM Student s")
	List<Student> readAll();

	int countStudentsByIeltsScoreEquals(double ieltsScore);

	List<Student> findStudentsByNameContainingIgnoreCase(String word);

	@Query("SELECT s FROM Student s WHERE s.age >= ?1")
	List<Student> getAllStudentsByAgeGreaterThanX(int x);

	@Query("SELECT s FROM Student s WHERE s.ieltsScore = ?1")
	int countAllStudentsByIeltsScoreEqualsX(double x);

	@Query("SELECT s FROM Student s where UPPER(s.name) like UPPER(concat('%'," + "?1,'%'))")
	List<Student> getAllStudentsByNameContainingIgnoreCase(String word);





}
