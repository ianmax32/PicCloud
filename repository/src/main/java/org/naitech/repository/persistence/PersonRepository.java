package org.naitech.repository.persistence;

import org.naitech.domain.dtos.PersonDto;
import org.naitech.domain.persistence.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends JpaRepository<Person,Long> {
    @Modifying
    @Transactional
    @Query(value = "delete from Users where User_email=:email", nativeQuery = true)
    void deleteUserByEmail(@Param("email") String email);

    @Query(value = "select * from Users where User_email=:email", nativeQuery = true)
    Person getUserByEmail(String email);

    @Query(value = "select * from Users where User_email=:email and user_password=:password", nativeQuery = true)
    Person loginUser(@Param("email") String email,@Param("password") String password);
}
