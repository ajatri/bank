package com.thbs.dhandhan.data.service;

import com.thbs.dhandhan.controller.request.TransactionRequest;
import com.thbs.dhandhan.data.entity.Account;
import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.entity.Transaction;
import com.thbs.dhandhan.data.repo.AccountRepo;
import com.thbs.dhandhan.data.repo.TransactionRepo;
import com.thbs.dhandhan.utils.TransactionStatus;
import com.thbs.dhandhan.utils.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    private CustomerService customerService;

    public ArrayList<Transaction> getAllTransactions() {
        try {
            ArrayList<Transaction> transaction = new ArrayList<Transaction>();
            transactionRepo.findAll().forEach(transaction::add);
            return transaction;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Transaction getTransaction(Integer id) {
        try {
            Optional<Transaction> transactionOptional = transactionRepo.findById(id);
            return transactionOptional.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Transaction> statement(Integer customerId) {
        try {
            Customer customer = customerService.getCustomer(customerId);
            List<Transaction> transactions = new ArrayList<>();
            for (Account account : customer.getAccounts()) {
                transactions.addAll(account.getTransaction());
            }
            return transactions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Boolean transact(TransactionRequest transactionRequest) {
        try {
            Float oldBalance;
            Float newBalance;
            Integer accountId = transactionRequest.getAccountId();
            Account account = accountService.getAccount(accountId);
            Transaction transaction = new Transaction();
            transaction.setAccount(account);
            Float amount = transactionRequest.getAmount();
            Calendar currentUtilCalendar = Calendar.getInstance();
            Date currentDate = Calendar.getInstance().getTime();
            String toAccount = transactionRequest.getToAccountId();
            switch (transactionRequest.getType()) {
                case DEBIT:
                    oldBalance = account.getBalance();
                    if (amount > oldBalance) {
                        transaction.setAmount(amount);
                        transaction.setTransactionsStatus(TransactionStatus.FAILED);
                        transaction.setTransactionsType(TransactionType.DEBIT);

                    } else {
                        newBalance = oldBalance - amount;
                        account.setBalance(newBalance);
                        accountRepo.save(account);

                        transaction.setAmount(amount);
                        transaction.setTransactionsStatus(TransactionStatus.DONE);
                        transaction.setTransactionsType(TransactionType.DEBIT);

                    }
                    transaction.setTransactionsDate(currentDate);
                    transaction.setToAccount(null);
                    transactionRepo.save(transaction);
    //
                    break;
                case CREDIT:
                    oldBalance = account.getBalance();
                    newBalance = oldBalance + amount;
                    account.setBalance(newBalance);
                    accountRepo.save(account);
                    transaction.setAmount(amount);
                    transaction.setTransactionsStatus(TransactionStatus.DONE);
                    transaction.setTransactionsType(TransactionType.CREDIT);
                    transaction.setTransactionsDate(currentDate);
                    transaction.setToAccount(null);
                    transactionRepo.save(transaction);
                    break;
                case TRANSFER:
                    oldBalance = account.getBalance();
                    if(!toAccount.equals(null)) {
                        if (amount > oldBalance) {
                            transaction.setAmount(amount);
                            transaction.setTransactionsStatus(TransactionStatus.FAILED);
                            transaction.setTransactionsType(TransactionType.TRANSFER);
                            transaction.setToAccount(toAccount);

                        } else {
                            newBalance = oldBalance - amount;
                            account.setBalance(newBalance);
                            transaction.setAmount(amount);
                            transaction.setTransactionsStatus(TransactionStatus.DONE);
                            transaction.setTransactionsType(TransactionType.TRANSFER);
                            transaction.setToAccount(toAccount);

                        }
                        transaction.setTransactionsDate(currentDate);
                        transactionRepo.save(transaction);
                    }
                    else
                    {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

if(transaction.getTransactionsStatus().equals(TransactionStatus.FAILED))
{
    return false;
}
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}


