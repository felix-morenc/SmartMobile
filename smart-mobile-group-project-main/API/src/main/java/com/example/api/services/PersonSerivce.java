package com.example.api.services;

import com.example.api.entity.Person;
import com.example.api.interfaces.IPersonRepository;
import com.example.api.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonSerivce implements IPersonService {


    @Autowired
    IPersonRepository iPersonRepository;

    @Override
    public Person signIn(int ticketId) {

        String ticket = String.valueOf(ticketId);

        if(ticket.trim().isBlank()){
            return null;
        }
       else{
            return iPersonRepository.signIn(ticketId);
        }
    }
}
