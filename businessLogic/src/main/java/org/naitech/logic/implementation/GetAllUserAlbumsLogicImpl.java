package org.naitech.logic.implementation;

import org.naitech.domain.dtos.AlbumsDto;
import org.naitech.logic.GetAllUserAlbumsLogic;
import org.naitech.translators.AlbumsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUserAlbumsLogicImpl implements GetAllUserAlbumsLogic {
    private AlbumsTranslator albumsTranslator;

    @Autowired
    public GetAllUserAlbumsLogicImpl(AlbumsTranslator albumsTranslator) {
        this.albumsTranslator = albumsTranslator;
    }

    @Override
    public List<AlbumsDto> getAllUserAlbums(String email) {
        return albumsTranslator.getAllUserAlbums(email);
    }
}
