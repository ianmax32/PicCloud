package org.naitech.logic;

import org.naitech.domain.dtos.AlbumsDto;

public interface GetAlbumByNameLogic {
    AlbumsDto getAlbum(String name);
}
