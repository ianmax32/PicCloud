package org.naitech.logic.implementation;

import org.naitech.domain.dtos.AlbumsDto;
import org.naitech.translators.AlbumsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAlbumByNameLogicImpl implements org.naitech.logic.GetAlbumByNameLogic {
    private AlbumsTranslator albumsTranslator;

    @Autowired
    public GetAlbumByNameLogicImpl(AlbumsTranslator albumsTranslator) {
        this.albumsTranslator = albumsTranslator;
    }

    @Override
    public AlbumsDto getAlbum(String name) {
        return albumsTranslator.getAlbum(name);
    }
}
