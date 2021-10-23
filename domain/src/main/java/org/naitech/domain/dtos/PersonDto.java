package org.naitech.domain.dtos;

import org.naitech.domain.persistence.Person;
import org.naitech.domain.persistence.Pictures;

import java.util.List;

public class PersonDto {
    private String name;
    private String surname;
    private String email;
    private List<PicturesDto> userPictures;

    public PersonDto() {
    }

    public PersonDto(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.email = person.getEmail();

    }

    public PersonDto(String name, String surname, String email, List<PicturesDto> userPictures) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userPictures = userPictures;
    }

    public Person buildPerson(PersonDto personDto){
        return new Person(null,personDto.getName(), personDto.getSurname(), personDto.getEmail(),"password","password");
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
