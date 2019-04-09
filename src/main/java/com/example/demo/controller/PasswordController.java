package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.example.demo.model.Candidate;
import com.example.demo.service.CandidateService;
import com.example.demo.service.PasswordService;
import com.example.demo.service.impl.PasswordServiceImpl;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {


    @Autowired
    private PasswordService passwordService;

    //Th&ecirc;m Staff v&agrave;o b&#x1ea3;ng Account

    @PostMapping("/addstaff")
    public String addStaff(@RequestBody Candidate candidate) {
        passwordService.addAcount(candidate);
        return "Ok";
    }

    @RequestMapping(value = "/getaccount", method = RequestMethod.GET)
    public Optional<Candidate> getaccount(@RequestParam(value = "id") long id) {

        return passwordService.getCandidateById(id);
    }

    // Trả về danh sách các Candidate ở trong bảng Candidate
    @RequestMapping(value="/getallcandidate", method = RequestMethod.GET)
    public byte[] getallCandidate(){
        List<Candidate> allCandidates = passwordService.getAll();
        try {
            return (new JSONArray(allCandidates)).toString().getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "".getBytes();
        }
    }

    @RequestMapping(value = "/getString",method = RequestMethod.GET)
    public List<Candidate> getString()
    {

        List<Candidate> list = new ArrayList<>();
        list = passwordService.getAll();
        return list;
    }

}
