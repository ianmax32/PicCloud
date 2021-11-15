package org.naitech.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

@Table
@Entity(name = "Pictures")
public class Pictures {
    private Long id;
    private String picName;
    private byte[] picture;
    private String tag;
    private String location;
    private String capturedBy;
    private Person person;
    private Albums albums;
    private LocalDate dateuploaded;

    public Pictures() {
    }

    public Pictures(Long id, String picName, byte[] picture, String tag, String location, String capturedBy, LocalDate dateuploaded) {
        this.id = id;
        this.picName = picName;
        this.picture = picture;
        this.tag = tag;
        this.location = location;
        this.capturedBy = capturedBy;
        this.dateuploaded = dateuploaded;
    }

    public Pictures(Long id, String picName, byte[] picture, String tag, String location, String capturedBy, Person person, Albums albums, LocalDate dateuploaded) {
        this.id = id;
        this.picName = picName;
        this.picture = picture;
        this.tag = tag;
        this.location = location;
        this.capturedBy = capturedBy;
        this.person = person;
        this.albums = albums;
        this.dateuploaded = dateuploaded;
    }

    @Id
    @SequenceGenerator(name="Pic_GENERIC_SEQ",sequenceName = "PicCould_GENERIC_SEQP",allocationSize = 1)
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
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "Tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Column(name = "Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "CapturedBy")
    public String getCapturedBy() {
        return capturedBy;
    }

    public void setCapturedBy(String capturedBy) {
        this.capturedBy = capturedBy;
    }

    @ManyToOne(cascade = CascadeType.ALL)
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
        return Objects.equals(id, pictures.id) && Objects.equals(picName, pictures.picName) && Arrays.equals(picture, pictures.picture) && Objects.equals(tag, pictures.tag) && Objects.equals(location, pictures.location) && Objects.equals(capturedBy, pictures.capturedBy) && Objects.equals(person, pictures.person) && Objects.equals(albums, pictures.albums) && Objects.equals(dateuploaded, pictures.dateuploaded);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, picName, tag, location, capturedBy, person, albums, dateuploaded);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "id=" + id +
                ", picName='" + picName + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", tag='" + tag + '\'' +
                ", location='" + location + '\'' +
                ", capturedBy='" + capturedBy + '\'' +
                ", person=" + person +
                ", albums=" + albums +
                ", dateuploaded=" + dateuploaded +
                '}';
    }
}
