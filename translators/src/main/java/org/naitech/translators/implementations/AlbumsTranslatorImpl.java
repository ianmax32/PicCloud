package org.naitech.translators.implementations;

import org.naitech.domain.dtos.AlbumsDto;
import org.naitech.domain.persistence.Albums;
import org.naitech.repository.persistence.AlbumsRepository;
import org.naitech.translators.AlbumsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumsTranslatorImpl implements AlbumsTranslator {
    private AlbumsRepository albumsRepository;

    @Autowired
    public AlbumsTranslatorImpl(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @Override
    public List<AlbumsDto> getAllUserAlbums(String email) {
        List<AlbumsDto> albumsDtoList= new ArrayList<>();
        try {
            for(Albums albums:albumsRepository.findAll()){
                albumsDtoList.add(new AlbumsDto(albums));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get the albums from the database",e);
        }
        return albumsDtoList;
    }

    @Override
    public void deleteAlbum(String name) {
        Albums albums;
        try {
            albums = albumsRepository.findAlbumByName(name);
            albumsRepository.delete(albums);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete the albums with name "+name+" from the database",e);
        }
    }

    @Override
    public AlbumsDto getAlbum(String name) {
        Albums albums;
        try {
            albums = albumsRepository.findAlbumByName(name);
        }catch (Exception e){
            throw new RuntimeException("Cannot get the albums with name "+name+" from the database",e);
        }
        return new AlbumsDto(albums);
    }

    @Override
    public AlbumsDto addNewAlbum(AlbumsDto albumsDto) {
        Albums albums = albumsDto.buildAlbum(albumsDto);
        try {
            albums = albumsRepository.save(albums);
        }catch (Exception e){
            throw new RuntimeException("Cannot create a new albumsto the database",e);
        }
        return albumsDto;
    }
}
