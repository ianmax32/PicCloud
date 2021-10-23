package org.naitech.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Table
@Entity(name = "Pictures")
public class Pictures {
    private Long id;
    private String picName;
    private String picture;
    private Person person;
    private Albums albums;
    private LocalDate dateuploaded;

    public Pictures() {
    }

    public Pictures(Long id, String picName, String picture, Person person, LocalDate dateuploaded) {
        this.id = id;
        this.picName = picName;
        this.picture = picture;
        this.person = person;
        this.dateuploaded = dateuploaded;
    }

    @Id
    @SequenceGenerator(name="Pic_GENERIC_SEQ",sequenceName = "PicCould_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Pic_GENERIC_SEQ")
    @Column(name = "Picture_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Picture_name")
    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    @Lob
    @Column(name = "Picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_email")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getDateuploaded() {
        return dateuploaded;
    }

    public void setDateuploaded(LocalDate dateuploaded) {
        this.dateuploaded = dateuploaded;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Album_name")
    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pictures pictures = (Pictures) o;
        return Objects.equals(id, pictures.id) && Objects.equals(picName, pictures.picName) && Objects.equals(picture, pictures.picture) && Objects.equals(person, pictures.person) && Objects.equals(dateuploaded, pictures.dateuploaded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picName, picture, person, dateuploaded);
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "id=" + id +
                ", picName='" + picName + '\'' +
                ", picture='" + picture + '\'' +
                ", person=" + person +
                ", dateuploaded=" + dateuploaded +
                '}';
    }
}
