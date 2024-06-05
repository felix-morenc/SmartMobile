package com.example.api.controller;

import com.example.api.entity.Person;
import com.example.api.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PersonController {

    @Autowired
    IPersonService iPersonService;

    @GetMapping("/user/sign/in/{ticketID}")
    public ResponseEntity<Object> signIn(@PathVariable("ticketID") int tickerID){
        Person user = this.iPersonService.signIn(tickerID);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
