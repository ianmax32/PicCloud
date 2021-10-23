package org.naitech.domain.dtos;

import org.naitech.domain.persistence.Albums;
import org.naitech.domain.persistence.Pictures;

import java.time.LocalDate;
import java.util.List;

public class AlbumsDto {
    private  String albumName;
    private String discription;
    private LocalDate dateCreated;
    private List<PicturesDto> picturesList;

    public AlbumsDto() {
    }

    public AlbumsDto(Albums albums) {
        this.albumName = albums.getAlbumName();
        this.discription = albums.getDiscription();
        this.dateCreated = albums.getDateCreated();
    }

    public AlbumsDto(String albumName, String discription, LocalDate dateCreated, List<PicturesDto> picturesList) {
        this.albumName = albumName;
        this.discription = discription;
        this.dateCreated = dateCreated;
        this.picturesList = picturesList;
    }

    public Albums buildAlbum(AlbumsDto albumsDto) {
        return new Albums(null,getAlbumName(),getDiscription(),getDateCreated());
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<PicturesDto> getPicturesList() {
        return picturesList;
    }

    public void setPicturesList(List<PicturesDto> picturesList) {
        this.picturesList = picturesList;
    }

    @Override
    public String toString() {
        return "AlbumsDto{" +
                "albumName='" + albumName + '\'' +
                ", discription='" + discription + '\'' +
                ", dateCreated=" + dateCreated +
                ", picturesList=" + picturesList +
                '}';
    }


}
