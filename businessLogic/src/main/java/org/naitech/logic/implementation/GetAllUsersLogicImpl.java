package org.naitech.logic.implementation;

import org.naitech.domain.dtos.PersonDto;
import org.naitech.logic.GetAllUsersLogic;
import org.naitech.translators.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUsersLogicImpl implements GetAllUsersLogic {
    private UserTranslator userTranslator;

    @Autowired
    public GetAllUsersLogicImpl(UserTranslator userTranslator) {
        this.userTranslator = userTranslator;
    }

    @Override
    public List<PersonDto> getAllUsers() {
        return userTranslator.getAllUsers();
    }
}
