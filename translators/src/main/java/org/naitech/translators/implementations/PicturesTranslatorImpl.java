package org.naitech.translators.implementations;

import org.naitech.domain.dtos.PicturesDto;
import org.naitech.domain.persistence.Albums;
import org.naitech.domain.persistence.Pictures;
import org.naitech.repository.persistence.AlbumsRepository;
import org.naitech.repository.persistence.PicturesRepository;
import org.naitech.translators.PicturesTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PicturesTranslatorImpl implements PicturesTranslator {
    private PicturesRepository picturesRepository;
    private AlbumsRepository albumsRepository;

    @Autowired
    public PicturesTranslatorImpl(PicturesRepository picturesRepository,AlbumsRepository albumsRepository) {
        this.picturesRepository = picturesRepository;
        this.albumsRepository = albumsRepository;
    }

    @Override
    public List<PicturesDto> getAllUserPictures(String email) {
        List<PicturesDto> userPictures = new ArrayList<>();
        try {
            for (Pictures pictures: picturesRepository.findAll()){
                userPictures.add(new PicturesDto(pictures));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get user pictures",e);
        }
        return userPictures;
    }

    @Override
    public PicturesDto getPicture(String pic) {
        Pictures pictures;
        try {
            pictures = picturesRepository.getPicByName(pic);
        }catch (Exception e){
            throw new RuntimeException("Cannot get picture with name "+pic,e);
        }
        return new PicturesDto(pictures);
    }

    @Override
    public void moveToAlbum(String albumName) {
        try {
            Albums albums = albumsRepository.findAlbumByName(albumName);
            picturesRepository.updateAlbum(albums);
        }catch (Exception e){
            throw new RuntimeException("Cannot move picture to album with name "+albumName,e);
        }
    }

    @Override
    public void deletePicture(String pic) {
        Pictures pictures;
        try {
           pictures = picturesRepository.getPicByName(pic);
            picturesRepository.delete(pictures);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete picture with name "+pic,e);
        }
    }

    @Override
    public PicturesDto addPicture(PicturesDto picturesDto) {
        Pictures pictures = picturesDto.buildPicture(picturesDto);
        try {
            pictures = picturesRepository.save(pictures);
            picturesRepository.delete(pictures);
        }catch (Exception e){
            throw new RuntimeException("Cannot add new picture to the db",e);
        }
        return new PicturesDto(pictures);
    }
}
