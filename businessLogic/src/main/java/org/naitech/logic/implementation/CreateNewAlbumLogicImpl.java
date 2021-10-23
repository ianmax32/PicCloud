package org.naitech.logic.implementation;

import org.naitech.domain.dtos.AlbumsDto;
import org.naitech.logic.CreateNewAlbumLogic;
import org.naitech.translators.AlbumsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateNewAlbumLogicImpl implements CreateNewAlbumLogic {
    private AlbumsTranslator albumsTranslator;

    @Autowired
    public CreateNewAlbumLogicImpl(AlbumsTranslator albumsTranslator) {
        this.albumsTranslator = albumsTranslator;
    }

    @Override
    public AlbumsDto addNewAlbum(AlbumsDto albumsDto) {
        return albumsTranslator.addNewAlbum(albumsDto);
    }
}
