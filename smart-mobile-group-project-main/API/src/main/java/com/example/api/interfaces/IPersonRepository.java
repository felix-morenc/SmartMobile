package com.example.api.interfaces;

import com.example.api.entity.Person;

public interface IPersonRepository {
    Person signIn(int ticketId);
}
