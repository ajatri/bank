package com.thbs.dhandhan.controller;


import com.thbs.dhandhan.controller.request.NomineeRequest;
import com.thbs.dhandhan.data.entity.Account;
import com.thbs.dhandhan.data.entity.Nominee;
import com.thbs.dhandhan.data.repo.NomineeRepo;
import com.thbs.dhandhan.data.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NomineeController {
    @Autowired
    NomineeService nomineeService;

    @Autowired
    NomineeRepo nomineeRepo;

    @GetMapping("/nominees")
    public List<Nominee> getNominees() {
        return nomineeService.getAllNominees();
    }

    @GetMapping("/nominees/{id}")
    public Nominee getNominee(@PathVariable("id") Integer id) {
        return nomineeService.getNominee(id);
    }

    @PostMapping("/nominees")
    public Integer addNominee(@RequestBody NomineeRequest nomineeRequest) {
        return nomineeService.createNominee(nomineeRequest);
    }

    @PutMapping("/nominees")
    public void updateNominee(@RequestBody Nominee nominee) {

        nomineeRepo.save(nominee);
    }

    @DeleteMapping("/nominees/{id}")
    public void deleteNominee(@PathVariable("id") Integer id) {

        nomineeRepo.deleteById(id);
    }


}
