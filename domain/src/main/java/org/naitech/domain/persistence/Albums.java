package org.naitech.domain.persistence;


import javax.persistence.*;
import java.util.*;
import java.time.LocalDate;

@Table
@Entity(name = "Albums")
public class Albums {
    private Long id;
    private  String albumName;
    private String discription;
    private LocalDate dateCreated;
    private List<Pictures> picturesList;

    public Albums() {
    }

    public Albums(Long id, String albumName, String discription, LocalDate dateCreated) {
        this.id = id;
        this.albumName = albumName;
        this.discription = discription;
        this.dateCreated = dateCreated;
    }

    @Id
    @SequenceGenerator(name="Alb_GENERIC_SEQ",sequenceName = "PicCould_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Alb_GENERIC_SEQ")
    @Column(name = "Album_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Album_name")
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Column(name = "Album_Description")
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Column(name = "Album_date_created")
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    @OneToMany(targetEntity = Pictures.class, fetch = FetchType.LAZY, mappedBy = "albums")
    public List<Pictures> getPicturesList() {
        return picturesList;
    }

    public void setPicturesList(List<Pictures> picturesList) {
        this.picturesList = picturesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albums albums = (Albums) o;
        return Objects.equals(id, albums.id) && Objects.equals(albumName, albums.albumName) && Objects.equals(discription, albums.discription) && Objects.equals(dateCreated, albums.dateCreated) && Objects.equals(picturesList, albums.picturesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumName, discription, dateCreated, picturesList);
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", discription='" + discription + '\'' +
                ", dateCreated=" + dateCreated +
                ", picturesList=" + picturesList +
                '}';
    }
}
