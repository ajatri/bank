package com.thbs.dhandhan.data.service;

import com.thbs.dhandhan.controller.request.NomineeRequest;
import com.thbs.dhandhan.data.entity.Account;
import com.thbs.dhandhan.data.entity.Nominee;
import com.thbs.dhandhan.data.repo.AccountRepo;
import com.thbs.dhandhan.data.repo.NomineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class NomineeService {
    @Autowired
    NomineeRepo nomineeRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    AccountService accountService;


    public ArrayList<Nominee> getAllNominees() {
        try {
            ArrayList<Nominee> nominee = new ArrayList<Nominee>();
            nomineeRepo.findAll().forEach(nominee::add);
            return nominee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Nominee getNominee(Integer id) {
        try {
            Optional<Nominee> nomineeOptional = nomineeRepo.findById(id);
            return nomineeOptional.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer createNominee(Nominee nominee) {
        try {
            Nominee insertedNominee = nomineeRepo.save(nominee);
            return insertedNominee.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer createNominee(NomineeRequest nomineeRequest) {
        try {
            Integer accountId = nomineeRequest.getAccountId();
            String name = nomineeRequest.getName();
            String govId = nomineeRequest.getGovId();
            String govIdType = nomineeRequest.getGovIdType();
            String phoneNumber = nomineeRequest.getPhoneNumber();
            Nominee nominee = new Nominee();
            nominee.setName(name);
            nominee.setGov_tid(govId);
            nominee.setGov_type(govIdType);
            nominee.setPhone(phoneNumber);
            Nominee insertedNominee = nomineeRepo.save(nominee);
            Integer nid = insertedNominee.getId();
            Nominee nominees = getNominee(nid);
            Account account = accountService.getAccount(accountId);
            account.setNominee(nominees);
            accountService.updateAccount(account);

            return insertedNominee.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public Integer updateNominee(Nominee nominee) {
        try {
            Nominee updatedNominee = nomineeRepo.save(nominee);
            return updatedNominee.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
