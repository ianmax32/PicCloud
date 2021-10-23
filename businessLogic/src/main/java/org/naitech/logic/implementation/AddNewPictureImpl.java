package org.naitech.logic.implementation;

import org.naitech.domain.dtos.PicturesDto;
import org.naitech.logic.AddNewPicture;
import org.naitech.translators.PicturesTranslator;
import org.naitech.translators.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddNewPictureImpl implements AddNewPicture {
    private PicturesTranslator userTranslator;

    @Autowired
    public AddNewPictureImpl(PicturesTranslator userTranslator) {
        this.userTranslator = userTranslator;
    }

    @Override
    public PicturesDto addPicture(PicturesDto picturesDto) {
        return userTranslator.addPicture(picturesDto);
    }
}
