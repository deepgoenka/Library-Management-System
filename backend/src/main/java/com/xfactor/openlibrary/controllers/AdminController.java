package com.xfactor.openlibrary.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.domain.Admin;
import com.xfactor.openlibrary.repository.AdminRepository;

@RestController
@RequestMapping("admins")
public class AdminController {
    // ArrayList <Admin> aadmin = new ArrayList<>();

    private AdminRepository adminRepository;
    
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/saveAdmin")
    public Admin saveAdmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return admin;
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping("/getAdminById/{id}")
    public Admin findById (@PathVariable Long id) {
        Optional<Admin> optionalOfAdmin = adminRepository.findById(id);
        if (optionalOfAdmin.isPresent()){
            return optionalOfAdmin.get();
        }
        return null;
    }

    @GetMapping("/getAdminByName/{name}")
    public List<Admin> findByName (@PathVariable String name) {
        List<Admin> listOfAdminByName = adminRepository.findByName(name);
        return listOfAdminByName;
    }

    @GetMapping("/getAdminByUsername/{username}")
    public List<Admin> findByUsername (@PathVariable String username) {
        List<Admin> listOfAdminByUsername = adminRepository.findByUsername(username);
        return listOfAdminByUsername;
    }

    @GetMapping("/getAdminByPassword/{password}")
    public List<Admin> findByPassword (@PathVariable String password) {
        List<Admin> listOfAdminByPassword = adminRepository.findByPassword(password);
        return listOfAdminByPassword;
    }

    @PutMapping("/updateAdmin")
    public Admin updatedAdmin (@RequestBody Admin admin) {
        if (admin.getId() != null) {
            Admin updatedAdmin = adminRepository.save(admin);
            return updatedAdmin;
        }
        return null;
    }

    @DeleteMapping("deleteAdmin/{id}")
    public void deleteAdmin (@PathVariable Long id) {
        adminRepository.deleteById(id);
    }

}
