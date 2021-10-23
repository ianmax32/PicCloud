package org.naitech.translators;

import org.naitech.domain.dtos.PersonDto;
import org.naitech.domain.dtos.PicturesDto;

import java.util.List;

public interface PicturesTranslator {
    List<PicturesDto> getAllUserPictures(String email);
    PicturesDto getPicture(String pic);
    void moveToAlbum(String albumName);
    void deletePicture(String pic);
    PicturesDto addPicture(PicturesDto picturesDto);
}
