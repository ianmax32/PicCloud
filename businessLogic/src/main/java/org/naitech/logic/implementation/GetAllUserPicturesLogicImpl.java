package org.naitech.logic.implementation;

import org.naitech.domain.dtos.PicturesDto;
import org.naitech.logic.GetAllUserPicturesLogic;
import org.naitech.translators.PicturesTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUserPicturesLogicImpl implements GetAllUserPicturesLogic {
    private PicturesTranslator picturesTranslator;

    @Autowired
    public GetAllUserPicturesLogicImpl(PicturesTranslator picturesTranslator) {
        this.picturesTranslator = picturesTranslator;
    }

    @Override
    public List<PicturesDto> getAllUserPictures(String email) {
        return picturesTranslator.getAllUserPictures(email);
    }
}
