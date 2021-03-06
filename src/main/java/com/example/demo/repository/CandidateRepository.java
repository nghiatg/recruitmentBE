package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	public List<Candidate> findAll();
	public List<Candidate> findByEmail(String email);

}
