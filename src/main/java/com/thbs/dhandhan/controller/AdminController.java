package com.thbs.dhandhan.controller;

import com.thbs.dhandhan.controller.request.CustomerApproveRequest;
import com.thbs.dhandhan.data.entity.Admin;
import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.repo.AdminRepo;
import com.thbs.dhandhan.data.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    AdminRepo adminRepo;

    @GetMapping("/admins")
    public List<Admin> getAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{id}")
    public Admin getAdmin(@PathVariable("id") Integer id) {
        return adminService.getAdmin(id);
    }

    @PostMapping("/admins")
    public Integer addAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @DeleteMapping("/admins")
    public void deleteAdmin(@RequestBody Integer id) {
        adminRepo.deleteById(id);
    }


    @PostMapping("/admins/approve")
    public Boolean approveCustomers(@RequestBody CustomerApproveRequest customerApproveRequest) {
        return adminService.approveCustomer(customerApproveRequest);
    }

    @PutMapping("/admins")
    public Admin updateAdmins(@RequestBody Admin admin) {
        return    adminService.updateAdmin(admin);
       }

    @PostMapping("/admins/block")
    public Boolean blockCustomers(@RequestBody CustomerApproveRequest customerApproveRequest) {
        return adminService.blockCustomer(customerApproveRequest);
    }
}
