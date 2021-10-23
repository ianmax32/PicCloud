package org.naitech.domain.dtos;

import org.naitech.domain.persistence.Albums;
import org.naitech.domain.persistence.Person;
import org.naitech.domain.persistence.Pictures;

import java.time.LocalDate;

public class PicturesDto {
    private String picName;
    private String picture;
    private PersonDto person;
    private AlbumsDto albums;
    private LocalDate dateuploaded;

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

    public PicturesDto(String picName, String picture, PersonDto person, AlbumsDto albums, LocalDate dateuploaded) {
        this.picName = picName;
        this.picture = picture;
        this.person = person;
        this.albums = albums;
        this.dateuploaded = dateuploaded;
    }

    public Pictures buildPicture(PicturesDto picturesDto){
        return new Pictures(null,getPicName(),getPicture(),picturesDto.getPerson().buildPerson(picturesDto.getPerson()),getDateuploaded());
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
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

    @Override
    public String toString() {
        return "PicturesDto{" +
                "picName='" + picName + '\'' +
                ", picture='" + picture + '\'' +
                ", person=" + person +
                ", albums=" + albums +
                ", dateuploaded=" + dateuploaded +
                '}';
    }
}
