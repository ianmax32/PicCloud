package org.naitech.webservices.controllers;

import org.naitech.domain.dtos.AlbumsDto;
import org.naitech.domain.dtos.PersonDto;
import org.naitech.domain.dtos.PicturesDto;
import org.naitech.domain.persistence.Person;
import org.naitech.logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users/pictures")
public class PicturesController {
    private AddNewPicture addNewPicture;
    private org.naitech.logic.deletePicture deletePicture;
    private GetPicture getPicture;
    private MovePictureToAlbum movePictureToAlbum;
    private GetUserLogic getUserLogic;
    private GetAlbumByNameLogic getAlbumByNameLogic;


    @Autowired
    public PicturesController(AddNewPicture addNewPicture, org.naitech.logic.deletePicture deletePicture, GetPicture getPicture, MovePictureToAlbum movePictureToAlbum, GetUserLogic getUserLogic, GetAlbumByNameLogic getAlbumByNameLogic) {
        this.addNewPicture = addNewPicture;
        this.deletePicture = deletePicture;
        this.getPicture = getPicture;
        this.movePictureToAlbum = movePictureToAlbum;
        this.getUserLogic = getUserLogic;
        this.getAlbumByNameLogic = getAlbumByNameLogic;
    }

    @PutMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PicturesDto> addnewpic(@RequestParam("ImageName") String imageName
                                                ,@RequestParam(value = "file", required = false) MultipartFile file,
                                                 @RequestParam("tag") String tag,
                                                 @RequestParam("location") String location,
                                                 @RequestParam("capturedBy") String capturedBy,
                                                 @RequestParam("email") String email) throws IOException {

        PersonDto per = getUserLogic.getUser(email);
        AlbumsDto albumsDto = getAlbumByNameLogic.getAlbum("default");

        List<PicturesDto> picturesDtoList = new ArrayList<>();

        PicturesDto picturesDto1 = new PicturesDto();
        byte[] imagename = file.getBytes();
        picturesDto1.setPicture(imagename);
        picturesDto1.setPicName(imageName);
        picturesDto1.setPerson(per);
        picturesDto1.setAlbums(albumsDto);
        picturesDto1.setCapturedBy(capturedBy);
        picturesDto1.setLocation(location);
        picturesDto1.setTag(tag);
        picturesDto1.setDateuploaded(LocalDate.now());
        System.out.println(picturesDto1.toString());

        picturesDtoList.add(picturesDto1);
        albumsDto.setPicturesList(picturesDtoList);

        addNewPicture.addPicture(picturesDto1);
        return new ResponseEntity<>(picturesDto1, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deletePic(String pic){
        deletePicture.deletePicture(pic);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @GetMapping("/picture")
    public ResponseEntity<PicturesDto> getPic(@RequestParam String pic){
        PicturesDto personDto = getPicture.getPicture(pic);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<Boolean> moveToAlbum(@RequestParam String album){
        movePictureToAlbum.moveToAlbum(album);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
