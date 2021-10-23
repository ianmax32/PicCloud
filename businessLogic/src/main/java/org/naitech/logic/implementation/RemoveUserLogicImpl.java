package org.naitech.logic.implementation;

import org.naitech.logic.RemoveUserLogic;
import org.naitech.translators.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveUserLogicImpl implements RemoveUserLogic {
    private UserTranslator userTranslator;

    @Autowired
    public RemoveUserLogicImpl(UserTranslator userTranslator) {
        this.userTranslator = userTranslator;
    }

    @Override
    public void deleteUser(String email) {
        userTranslator.deleteUser(email);
    }
}
