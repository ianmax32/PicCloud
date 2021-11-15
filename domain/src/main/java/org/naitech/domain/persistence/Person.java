package org.naitech.domain.persistence;


import javax.persistence.*;
import java.util.*;
import java.util.Objects;

@Table
@Entity(name = "Users")
public class Person {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String confirmpassword;
    private List<Pictures> userPictures;

    public Person() {
    }

    public Person(Long id, String name, String surname, String email, String password, String confirmpassword) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public Person(Long id, String name, String surname, String email, String password, String confirmpassword, List<Pictures> userPictures) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.userPictures = userPictures;
    }

    @Id
    @SequenceGenerator(name="User_GENERIC_SEQ",sequenceName = "PicCould_GENERIC_SEQPe",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_GENERIC_SEQ")
    @Column(name = "user_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "User_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "User_surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "User_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "User_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* @Column(name = "User_confirm_password")
    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }*/

    @OneToMany(targetEntity = Pictures.class,fetch = FetchType.LAZY, mappedBy = "person")
    public List<Pictures> getUserPictures() {
        return userPictures;
    }

    public void setUserPictures(List<Pictures> userPictures) {
        this.userPictures = userPictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(email, person.email) && Objects.equals(password, person.password) && Objects.equals(confirmpassword, person.confirmpassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, confirmpassword);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmpassword='" + confirmpassword + '\'' +
                '}';
    }
}
