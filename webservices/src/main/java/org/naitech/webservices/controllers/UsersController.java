package org.naitech.webservices.controllers;

import org.naitech.domain.dtos.PersonDto;
import org.naitech.logic.CreateNewUser;
import org.naitech.logic.GetAllUsersLogic;
import org.naitech.logic.GetUserLogic;
import org.naitech.logic.RemoveUserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private CreateNewUser createNewUser;
    private GetAllUsersLogic getAllUsers;
    private GetUserLogic getUser;
    private RemoveUserLogic removeUser;

    @Autowired
    public UsersController(CreateNewUser createNewUser, GetAllUsersLogic getAllUsers, GetUserLogic getUser, RemoveUserLogic removeUser) {
        this.createNewUser = createNewUser;
        this.getAllUsers = getAllUsers;
        this.getUser = getUser;
        this.removeUser = removeUser;
    }

    @PutMapping("/create")
    public ResponseEntity<PersonDto> createUser(@RequestBody PersonDto personDto){
        PersonDto personDto1 = createNewUser.addUser(personDto);
        return new ResponseEntity<>(personDto1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDto>> getUsers(){
        List<PersonDto> allusers = getAllUsers.getAllUsers();
        return new ResponseEntity<>(allusers, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<PersonDto> getUser(@RequestParam("email") String email){
        PersonDto personDto = getUser.getUser(email);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteUser(@RequestParam("email") String email){
        removeUser.deleteUser(email);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
