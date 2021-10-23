package org.naitech.logic;

import org.naitech.domain.dtos.AlbumsDto;

import java.util.List;

public interface GetAllUserAlbumsLogic {
    List<AlbumsDto> getAllUserAlbums(String email);
}
