package org.naitech.translators.implementations;

import org.naitech.domain.dtos.PersonDto;
import org.naitech.domain.persistence.Person;
import org.naitech.repository.persistence.PersonRepository;
import org.naitech.translators.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonTranslatorImpl implements UserTranslator {
    private PersonRepository personRepository;

    @Autowired
    public PersonTranslatorImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDto> getAllUsers() {
        List<PersonDto> allusers = new ArrayList<>();
        try {
            for(Person person: personRepository.findAll()){
                allusers.add(new PersonDto(person));
            }
        }catch(Exception e){
            throw new RuntimeException("Error getting the users from the database",e);
        }
        return allusers;
    }

    @Override
    public PersonDto getUser(String email) {
        Person person;
        try {
            person = personRepository.getUserByEmail(email);
        }catch(Exception e){
            throw new RuntimeException("Error getting the user with email "+ email +" from the database",e);
        }
        return new PersonDto(person);
    }

    @Override
    public PersonDto addUser(PersonDto personDto) {
        Person person;
        try {
            person = personDto.buildPerson(personDto);
            personRepository.save(person);
        }catch(Exception e){
            throw new RuntimeException("Error creating new user",e);
        }
        return new PersonDto(person);
    }

    @Override
    public void deleteUser(String email) {
        Person person;
        try {
            personRepository.deleteUserByEmail(email);
        }catch(Exception e){
            throw new RuntimeException("Error deleting the user with email "+ email +" from the database",e);
        }
    }

    @Override
    public PersonDto loginUser(String email, String password) {
        Person user;
        try {
            user = personRepository.loginUser(email,password);
            System.out.println(user.toString());
        }catch(Exception e){
            throw new RuntimeException("Error logging in the user with email "+ email +" from the database",e);
        }
        return new PersonDto(user);
    }
}
