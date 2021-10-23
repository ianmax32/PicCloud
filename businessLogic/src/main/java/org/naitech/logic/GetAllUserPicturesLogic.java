package org.naitech.logic;

import org.naitech.domain.dtos.PicturesDto;

import java.util.List;

public interface GetAllUserPicturesLogic {
    List<PicturesDto> getAllUserPictures(String email);
}
