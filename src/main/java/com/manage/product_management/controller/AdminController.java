package com.manage.product_management.controller;

import com.manage.product_management.model.LoginTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.manage.product_management.repository.adminrepository;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {
    @Autowired
    private adminrepository adminrepo;
    //private ResourceNotFoundException except;

    @GetMapping("/index")
    public String welcome() {
        return "hello";
    }

    //get all admins
    @GetMapping("/showadmins")
    public List<LoginTable> getAllAdmins()
    {
        return adminrepo.findAll();
    }

    //admin login
    @PostMapping("/login")
    public ResponseEntity<LoginTable> loginuser(@RequestBody LoginTable user)
    {
        user = adminrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(user == null)
        {
            System.out.println("User does not exist");
//            return except.("User DoesNot exist");
             //return new ResponseEntity<String>("Wrong ID or Password", HttpStatus.NOT_FOUND);
            //return user;
        }
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/login")
    public ResponseEntity<LoginTable> loginuserget(@RequestBody LoginTable user)
    {
        user = adminrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(user == null)
        {
            System.out.println("User does not exist");
            //return except.("User DoesNot exist");
//            return ResponseEntity<String>("Wrong ID or Password", HttpStatus.NOT_FOUND);
            //return user;
        }
        return ResponseEntity.ok().body(user);
    }




    @PostMapping("/register")
    public LoginTable registeruser(@RequestBody LoginTable user)
    {

        System.out.println(user.toString());
        adminrepo.saveAndFlush(user);
        System.out.println(user.toString());
        return user;
    }


}
