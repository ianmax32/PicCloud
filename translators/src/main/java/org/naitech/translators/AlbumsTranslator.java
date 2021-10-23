package org.naitech.translators;

import org.naitech.domain.dtos.AlbumsDto;

import java.util.*;

public interface AlbumsTranslator {
    List<AlbumsDto> getAllUserAlbums(String email);
    void deleteAlbum(String name);
    AlbumsDto getAlbum(String name);
    AlbumsDto addNewAlbum(AlbumsDto albumsDto);
}
