package org.naitech.translators;

import org.naitech.domain.dtos.PersonDto;
import org.springframework.stereotype.Component;

import java.util.*;
import java.beans.PersistenceDelegate;

public interface UserTranslator {
    List<PersonDto> getAllUsers();
    PersonDto getUser(String email);
    PersonDto addUser(PersonDto personDto);
    void deleteUser(String email);
    PersonDto loginUser(String email, String password);
}
