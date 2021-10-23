package org.naitech.logic.implementation;

import org.naitech.logic.DeleteAlbumLogic;
import org.naitech.translators.AlbumsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteAlbumLogicImpl implements DeleteAlbumLogic {
    private AlbumsTranslator albumsTranslator;

    @Autowired
    public DeleteAlbumLogicImpl(AlbumsTranslator albumsTranslator) {
        this.albumsTranslator = albumsTranslator;
    }

    @Override
    public void deleteAlbum(String name) {
        albumsTranslator.deleteAlbum(name);
    }
}
