package org.naitech.domain.dtos;

import org.naitech.domain.persistence.Person;
import org.naitech.domain.persistence.Pictures;

import java.util.List;

public class PersonDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<PicturesDto> userPictures;

    public PersonDto() {
    }

    public PersonDto(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.email = person.getEmail();
        this.password = person.getPassword();
    }

    public PersonDto(String name, String surname, String email,String password, List<PicturesDto> userPictures) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userPictures = userPictures;
    }

    public Person buildPerson(PersonDto personDto){
        return new Person(null,personDto.getName(), personDto.getSurname(), personDto.getEmail(), personDto.getPassword(), personDto.getPassword());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PicturesDto> getUserPictures() {
        return userPictures;
    }

    public void setUserPictures(List<PicturesDto> userPictures) {
        this.userPictures = userPictures;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", userPictures=" + userPictures +
                '}';
    }
}
