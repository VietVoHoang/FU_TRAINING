package com.gst.controller;

import com.gst.domain.User;
import com.gst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by truonghuuthanh on 4/10/17.
 */
@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

//    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody User user){
        User added = userService.register(user);
        if (added != null) {
            return new ResponseEntity("User registered successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("User registered unsuccessfully", HttpStatus.NOT_FOUND);
        }
    }

}
