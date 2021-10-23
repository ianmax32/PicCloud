package org.naitech.logic;

import org.naitech.domain.dtos.PersonDto;

import java.util.List;

public interface GetAllUsersLogic {
    List<PersonDto> getAllUsers();
}
