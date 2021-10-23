package org.naitech.logic.implementation;

import org.naitech.logic.MovePictureToAlbum;
import org.naitech.translators.PicturesTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovePictureToAlbumImpl implements MovePictureToAlbum {
    private PicturesTranslator picturesTranslator;

    @Autowired
    public MovePictureToAlbumImpl(PicturesTranslator picturesTranslator) {
        this.picturesTranslator = picturesTranslator;
    }

    @Override
    public void moveToAlbum(String albumName) {
        picturesTranslator.moveToAlbum(albumName);
    }
}

