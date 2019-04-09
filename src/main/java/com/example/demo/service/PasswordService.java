package com.example.demo.service;

import com.example.demo.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface PasswordService {
    public boolean confirmPass(Candidate candidate, String pass);
    public void addAcount(Candidate candidate);
    public Candidate getCandidateByEmail(String email);
    public Optional<Candidate> getCandidateById(long id);
    public List<Candidate> getAll();
}
