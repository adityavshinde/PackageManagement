package com.manage.product_management.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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

	private static final Logger logger = LogManager.getLogger(AdminController.class);

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
        logger.info("Getting all the admins in a list and sending to the frontend");
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
            logger.error("User does not exist");
//            return except.("User DoesNot exist");
             //return new ResponseEntity<String>("Wrong ID or Password", HttpStatus.NOT_FOUND);
            return ResponseEntity.badRequest().body(null);
        }
        logger.info("Valid user..." + user);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/login")
    public ResponseEntity<LoginTable> loginuserget(@RequestBody LoginTable user)
    {
//     	String email = user.getEmailId();
//        String pass = user.getPassword();
//        System.out.println("email"+ email+" "+pass);
        user = adminrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(user == null)
        {
            System.out.println("User does not exist");
            logger.error("User does not exist");
            //return except.("User DoesNot exist");
//            return ResponseEntity<String>("Wrong ID or Password", HttpStatus.NOT_FOUND);
            return null;
        }
        logger.info("New user registered..." + user);
        return ResponseEntity.ok().body(user);
    }




    @PostMapping("/register")
    public LoginTable registeruser(@RequestBody LoginTable user)
    {
	if(user==null)
	{
		logger.error("null input...");
	}
	logger.info("New user registered..." + user);
        //System.out.println(user.toString());
        adminrepo.save(user);
        //System.out.println(user.toString());
        return user;
    }


}
