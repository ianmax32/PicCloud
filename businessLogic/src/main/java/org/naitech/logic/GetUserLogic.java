package org.naitech.logic;

import org.naitech.domain.dtos.PersonDto;

public interface GetUserLogic {
    PersonDto getUser(String email);
    PersonDto loginUser(String email, String password);
}
