package com.thbs.dhandhan.data.service;

import com.thbs.dhandhan.data.entity.Account;
import com.thbs.dhandhan.data.entity.SavingAccount;
import com.thbs.dhandhan.data.repo.SavingAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SavingAccountService {
    @Autowired
    SavingAccountRepo savingAccountRepo;


    public ArrayList<SavingAccount> getAllSavingAccounts() {
        try {
            ArrayList<SavingAccount> savingAccounts = new ArrayList<SavingAccount>();
            savingAccountRepo.findAll().forEach(savingAccounts::add);
            return savingAccounts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SavingAccount getSavingAccount(Integer id) {
        try {
            Optional<SavingAccount> savingAccountOptional = savingAccountRepo.findById(id);
            return savingAccountOptional.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer createSavingAccount(SavingAccount savingAccount) {
        try {
            Account insertedSavingAccount = savingAccountRepo.save(savingAccount);
            return insertedSavingAccount.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer updateSavingAccount(SavingAccount savingAccount) {
        try {
            SavingAccount updatedSavingAccount = savingAccountRepo.save(savingAccount);
            return updatedSavingAccount.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void deleteSavingAccount(Integer id) {
        try {
            savingAccountRepo.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
