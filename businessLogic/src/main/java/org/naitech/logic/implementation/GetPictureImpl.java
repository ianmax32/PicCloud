package org.naitech.logic.implementation;

import org.naitech.domain.dtos.PicturesDto;
import org.naitech.logic.GetPicture;
import org.naitech.translators.PicturesTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPictureImpl implements GetPicture {
    private PicturesTranslator picturesTranslator;

    @Autowired
    public GetPictureImpl(PicturesTranslator picturesTranslator) {
        this.picturesTranslator = picturesTranslator;
    }

    @Override
    public PicturesDto getPicture(String pic) {
        return picturesTranslator.getPicture(pic);
    }
}
