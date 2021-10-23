package org.naitech.logic.implementation;

import org.naitech.logic.deletePicture;
import org.naitech.translators.PicturesTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePictureImpl implements deletePicture {
    private PicturesTranslator picturesTranslator;

    @Autowired
    public DeletePictureImpl(PicturesTranslator picturesTranslator) {
        this.picturesTranslator = picturesTranslator;
    }

    @Override
    public void deletePicture(String pic) {
        picturesTranslator.deletePicture(pic);
    }
}
