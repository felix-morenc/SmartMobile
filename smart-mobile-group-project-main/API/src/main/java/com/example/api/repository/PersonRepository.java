package com.example.api.repository;

import com.example.api.entity.Person;
import com.example.api.interfaces.IPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {

    private List<Person> users;

    public PersonRepository() {
        this.users = new ArrayList<>();
        createUsers();
    }

    private void createUsers(){
        Person admin = new Person(1,4520,0);
        Person liveEventUser = new Person(2,3531,1);
        Person atHomeUser = new Person(3,1282,2);

        this.users.add(admin);
        this.users.add(liveEventUser);
        this.users.add(atHomeUser);
    }

    @Override
    public Person signIn(int ticketId) {
        for (Person p:users
             ) {
            if(p.getTicketID()==ticketId){
                return p;
            }
        }

        return null;
    }
}
