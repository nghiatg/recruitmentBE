package com.example.demo.service.impl;

import com.example.demo.model.Candidate;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private CandidateRepository candidateRepo;

    @Override
    public boolean confirmPass(Candidate candidate, String pass) {
        if(candidate.getPassword().equals(pass)){
            return true;
        }
        return false;
    }

    @Override
    public void addAcount(Candidate candidate) {
        List<Candidate> allCandidates= candidateRepo.findAll();
        Candidate candidate1 = new Candidate();
        candidate1.setEmail(candidate.getEmail());
        candidate1.setTenUngVien(candidate.getTenUngVien());
        candidate1.setPassword(candidate.getPassword());
        candidate1.setUngVienId(allCandidates.get(allCandidates.size() - 1).getUngVienId() + 1);
        try {
            candidateRepo.save(candidate1);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Candidate> getCandidateByEmail(String email) {
        return candidateRepo.findByEmail(email);
//        return null;
    }

    @Override
    public Optional<Candidate> getCandidateById(long id) {
        int i=(int)id;
        return candidateRepo.findById(i);
    }

    @Override
    public List<Candidate> getAll() {
        return candidateRepo.findAll();
    }
}
