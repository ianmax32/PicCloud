package org.naitech.domain.dtos;

import org.naitech.domain.persistence.Albums;
import org.naitech.domain.persistence.Person;
import org.naitech.domain.persistence.Pictures;

import java.time.LocalDate;
import java.util.Arrays;

public class PicturesDto {
    private String picName;
    private byte[] picture;
    private PersonDto person;
    private AlbumsDto albums;
    private LocalDate dateuploaded;
    private String tag;
    private String location;
    private String capturedBy;

    public PicturesDto() {
    }

    public PicturesDto(Pictures pictures) {
        this.picName = pictures.getPicName();
        this.picture = pictures.getPicture();
        this.dateuploaded = pictures.getDateuploaded();
        if(null != pictures.getAlbums()){
            this.albums = new AlbumsDto(pictures.getAlbums());
        }

        if(null != pictures.getPerson()){
            this.person = new PersonDto(pictures.getPerson());
        }
    }

    public PicturesDto(String picName, byte[] picture, PersonDto person, AlbumsDto albums, LocalDate dateuploaded, String tag, String location, String capturedBy) {
        this.picName = picName;
        this.picture = picture;
        this.person = person;
        this.albums = albums;
        this.dateuploaded = dateuploaded;
        this.tag = tag;
        this.location = location;
        this.capturedBy = capturedBy;
    }

    public Pictures buildPicture(Person per, Albums albums){
        return new Pictures(null,getPicName(),getPicture(),getTag(),getLocation(),getCapturedBy(),per,albums,getDateuploaded());
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public AlbumsDto getAlbums() {
        return albums;
    }

    public void setAlbums(AlbumsDto albums) {
        this.albums = albums;
    }

    public LocalDate getDateuploaded() {
        return dateuploaded;
    }

    public void setDateuploaded(LocalDate dateuploaded) {
        this.dateuploaded = dateuploaded;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapturedBy() {
        return capturedBy;
    }

    public void setCapturedBy(String capturedBy) {
        this.capturedBy = capturedBy;
    }

    @Override
    public String toString() {
        return "PicturesDto{" +
                "picName='" + picName + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", person=" + person +
                ", albums=" + albums +
                ", dateuploaded=" + dateuploaded +
                ", tag='" + tag + '\'' +
                ", location='" + location + '\'' +
                ", capturedBy='" + capturedBy + '\'' +
                '}';
    }
}
