package com.example.demo.service;

import 	java.util.List;

import com.example.demo.model.Candidate;

public interface CandidateService {
	public Candidate registerCandidate(String username, String email, String password);
	public List<Candidate> getAllCandidate();
}
