package com.thbs.dhandhan.data.service;

import com.thbs.dhandhan.data.entity.Account;
import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.entity.Transaction;
import com.thbs.dhandhan.data.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.thbs.dhandhan.data.service.CustomerService.getRandomNumber;

@Service
public class AccountService {
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    CustomerService customerService;

    public ArrayList<Account> getAllAccounts() {
        try {
            ArrayList<Account> accounts = new ArrayList<Account>();
            accountRepo.findAll().forEach(accounts::add);
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account getAccount(Integer id) {
        try {
            Optional<Account> accountOptional = accountRepo.findById(id);
            return accountOptional.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer createAccount(Integer cid) {

        try {
            Calendar currentUtilCalendar = Calendar.getInstance();
            Date currentDate = Calendar.getInstance().getTime();
            Customer customer = customerService.getCustomer(cid);
            String accountNumber = getRandomNumber(9);
            Account account = new Account();
            account.setNumber(accountNumber);
            account.setCustomer(customer);
            account.setBalance(0.0f);
            account.setO_date(currentDate);
            account.setNominee(null);
            Account insertedAccount = accountRepo.save(account);
            return insertedAccount.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Float getBalance(Integer customerId) {

        try {
            Account account = getAccount(customerId);
            return account.getBalance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



    public void updateAccount(Account accountNid) {

        try {
            accountRepo.save(accountNid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
