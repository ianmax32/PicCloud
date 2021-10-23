package org.naitech.repository.persistence;

import org.naitech.domain.persistence.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlbumsRepository extends JpaRepository<Albums, Long> {
    @Query(value = "Select * from albums where Album_name=:name",nativeQuery = true)
    Albums findAlbumByName(@Param("name") String name);
}
