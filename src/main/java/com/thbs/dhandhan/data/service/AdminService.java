package com.thbs.dhandhan.data.service;

import com.thbs.dhandhan.controller.request.CustomerApproveRequest;
import com.thbs.dhandhan.data.entity.Admin;
import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.repo.AdminRepo;
import com.thbs.dhandhan.utils.CustomerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;

    public ArrayList<Admin> getAllAdmins() {
        try {
            ArrayList<Admin> admins = new ArrayList<Admin>();
            adminRepo.findAll().forEach(admins::add);
            return admins;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Admin getAdmin(Integer id) {
        try {
            Optional<Admin> adminOptional = adminRepo.findById(id);
            return adminOptional.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Admin updateAdmin(Admin admin){

        try {
            Admin updatedAdmin = adminRepo.save(admin);
            return updatedAdmin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer createAdmin(Admin admin) {
        try {
            Admin insertedAdmin = adminRepo.save(admin);
            return insertedAdmin.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Boolean approveCustomer(CustomerApproveRequest customerApproveRequest) {
        try {
            Integer adminId = customerApproveRequest.getAdminId();
            Integer customerId = customerApproveRequest.getCustomerId();
            System.out.println(adminId);
            System.out.println(customerId);
            Admin admin = getAdmin(adminId);
            Customer customer = customerService.getCustomer(customerId);

            if (admin == null || customer == null) {
                return false;
            }

            if (!customer.getAdmin().getId().equals(admin.getId())) {
                return false;
            }

            accountService.createAccount(customerId);
            customer.setStatus(CustomerStatus.CREATED);
            customerService.updateCustomer(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }





    public Boolean blockCustomer(CustomerApproveRequest customerApproveRequest) {
        try {
            Integer adminId = customerApproveRequest.getAdminId();
            Integer customerId = customerApproveRequest.getCustomerId();
            Admin admin = getAdmin(adminId);
            Customer customer = customerService.getCustomer(customerId);

            if (admin == null || customer == null) {
                return false;
            }

            if (!customer.getAdmin().getId().equals(admin.getId())) {
                return false;
            }

            accountService.createAccount(customerId);
            customer.setStatus(CustomerStatus.BLOCKED);
            customerService.updateCustomer(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}


// Register - done
// login - done
//random and approve and account -done
// getBalance - done
// transaction and Statement - done
// error handling (op) - done
// Response wrapping
// JWT/Cookies/Sessions - authorization





