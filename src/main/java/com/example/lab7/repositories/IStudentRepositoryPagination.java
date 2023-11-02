package com.example.lab7.repositories;

import com.example.lab7.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepositoryPagination extends PagingAndSortingRepository<Student, Long> {
	List<Student> findAllByOrderByAgeDescIeltsScoreAsc();
}
