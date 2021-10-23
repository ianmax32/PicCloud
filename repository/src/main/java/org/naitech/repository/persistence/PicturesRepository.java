package org.naitech.repository.persistence;

import org.naitech.domain.persistence.Albums;
import org.naitech.domain.persistence.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PicturesRepository extends JpaRepository<Pictures,Long> {
    @Query(value = "Select * from Pictures where Picture_name=:name",nativeQuery = true)
    Pictures getPicByName(@Param("name") String pic);

    @Modifying
    @Transactional
    @Query(value = "Update Pictures(Album_name) set values(':album')",nativeQuery = true)
    void updateAlbum(@Param("album") Albums albums);

}
