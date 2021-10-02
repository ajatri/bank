package com.thbs.dhandhan.data.service;

import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.repo.CustomerRepo;
import com.thbs.dhandhan.utils.CustomerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AccountService accountService;

    public static String generateRandomPassword() {
        try {
            // ASCII range – alphanumeric (0-9, a-z, A-Z)
            final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder();

            // each iteration of the loop randomly chooses a character from the given
            // ASCII range and appends it to the `StringBuilder` instance

            for (int i = 0; i < 10; i++) {
                int randomIndex = random.nextInt(chars.length());
                sb.append(chars.charAt(randomIndex));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getRandomNumber(int len) {
        try {
            // It will generate 6 digit random Number.
            // from 0 to 999999
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            if (len == 4)
                return String.format("%04d", number);
            else {
                return String.format("%09d", number);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Customer> getAllCustomers() {
        try {
            ArrayList<Customer> customers = new ArrayList<Customer>();
            customerRepo.findAll().forEach(customers::add);
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer getCustomer(Integer id) {
        try {
            Optional<Customer> customerOptional = customerRepo.findById(id);
            return customerOptional.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer getCustomerByUsernamePassword() {
        return null;
    }

    public Integer createCustomer(Customer customer) {
        try {
            customer.setAdmin(adminService.getAllAdmins().get(0));
            Customer insertedCustomer = customerRepo.save(customer);
            System.out.println(customer);
            return insertedCustomer.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer registerCustomer(Customer customer) {
        try {
            System.out.println(customer);
            String customerId = getRandomNumber(4);
            customer.setCustomerId(customerId);
            String password = generateRandomPassword();
            customer.setPassword(password);
            customer.setAdmin(adminService.getAllAdmins().get(0));
            Customer insertedCustomer = customerRepo.save(customer);


            return insertedCustomer.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean loginCustomer(String customerId, String password) {
        try {
            Customer customer = customerRepo.findByCustomerId(customerId);

            if (customer != null
                    && (customer.getCustomerId().equals(customerId))
                    && (customer.getPassword().equals(password)
                    && (customer.getStatus().equals(CustomerStatus.CREATED)))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Customer updateCustomer(Customer customer) {

        try {
            customer.setAdmin(adminService.getAllAdmins().get(0));

            Customer updatedCustomer = customerRepo.save(customer);
            return updatedCustomer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}



