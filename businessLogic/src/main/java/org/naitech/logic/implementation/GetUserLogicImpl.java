package org.naitech.logic.implementation;

import org.naitech.domain.dtos.PersonDto;
import org.naitech.logic.GetUserLogic;
import org.naitech.translators.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserLogicImpl implements GetUserLogic {
    private UserTranslator userTranslator;

    @Autowired
    public GetUserLogicImpl(UserTranslator userTranslator) {
        this.userTranslator = userTranslator;
    }

    @Override
    public PersonDto getUser(String email) {
        return userTranslator.getUser(email);
    }
}
