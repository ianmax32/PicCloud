package org.naitech.webservices.controllers;

import org.naitech.domain.dtos.AlbumsDto;
import org.naitech.logic.CreateNewAlbumLogic;
import org.naitech.logic.DeleteAlbumLogic;
import org.naitech.logic.GetAlbumByNameLogic;
import org.naitech.logic.GetAllUserAlbumsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/albums")
public class AlbumsController {
    private CreateNewAlbumLogic createNewAlbumLogic;
    private DeleteAlbumLogic deleteAlbumLogic;
    private GetAlbumByNameLogic getAlbumByNameLogic;
    private GetAllUserAlbumsLogic getAllUserAlbumsLogic;

    @Autowired
    public AlbumsController(CreateNewAlbumLogic createNewAlbumLogic, DeleteAlbumLogic deleteAlbumLogic, GetAlbumByNameLogic getAlbumByNameLogic, GetAllUserAlbumsLogic getAllUserAlbumsLogic) {
        this.createNewAlbumLogic = createNewAlbumLogic;
        this.deleteAlbumLogic = deleteAlbumLogic;
        this.getAlbumByNameLogic = getAlbumByNameLogic;
        this.getAllUserAlbumsLogic = getAllUserAlbumsLogic;
    }

    @PutMapping("/add")
    public ResponseEntity<AlbumsDto> addnewAlbum(@RequestBody AlbumsDto picturesDto){
        picturesDto.setDateCreated(LocalDate.now());
        AlbumsDto picturesDto1 = createNewAlbumLogic.addNewAlbum(picturesDto);
        return new ResponseEntity<>(picturesDto1, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteAlbum(String name){
        deleteAlbumLogic.deleteAlbum(name);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @GetMapping("/album")
    public ResponseEntity<AlbumsDto> getAlbumByName(@RequestParam String name){
        AlbumsDto personDto = getAlbumByNameLogic.getAlbum(name);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<Boolean> moveToAlbum(@RequestParam String album){
        getAllUserAlbumsLogic.getAllUserAlbums(album);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
