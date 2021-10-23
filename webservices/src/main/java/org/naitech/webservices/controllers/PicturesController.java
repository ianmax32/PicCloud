package org.naitech.webservices.controllers;

import org.naitech.domain.dtos.PersonDto;
import org.naitech.domain.dtos.PicturesDto;
import org.naitech.logic.AddNewPicture;
import org.naitech.logic.GetPicture;
import org.naitech.logic.MovePictureToAlbum;
import org.naitech.logic.deletePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/pictures")
public class PicturesController {
    private AddNewPicture addNewPicture;
    private org.naitech.logic.deletePicture deletePicture;
    private GetPicture getPicture;
    private MovePictureToAlbum movePictureToAlbum;

    @Autowired
    public PicturesController(AddNewPicture addNewPicture, org.naitech.logic.deletePicture deletePicture, GetPicture getPicture, MovePictureToAlbum movePictureToAlbum) {
        this.addNewPicture = addNewPicture;
        this.deletePicture = deletePicture;
        this.getPicture = getPicture;
        this.movePictureToAlbum = movePictureToAlbum;
    }

    @PutMapping("/add")
    public ResponseEntity<PicturesDto> addnewpic(@RequestBody PicturesDto picturesDto){
        PicturesDto picturesDto1 = addNewPicture.addPicture(picturesDto);
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
