package org.naitech.logic.implementation;

import org.naitech.domain.dtos.PersonDto;
import org.naitech.logic.CreateNewUser;
import org.naitech.translators.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateNewUserImpl implements CreateNewUser {
    private UserTranslator userTranslator;

    @Autowired
    public CreateNewUserImpl(UserTranslator userTranslator) {
        this.userTranslator = userTranslator;
    }

    @Override
    public PersonDto addUser(PersonDto personDto) {
        return userTranslator.addUser(personDto);
    }
}
