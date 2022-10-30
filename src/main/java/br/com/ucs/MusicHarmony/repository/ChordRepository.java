package br.com.ucs.MusicHarmony.repository;

import br.com.ucs.MusicHarmony.model.ChordImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChordRepository extends JpaRepository<ChordImage, Long> {
    Optional<ChordImage> findByChordName(String chordName);

    @Query(value = "SELECT * FROM image", nativeQuery = true)
    List<ChordImage> findByImage();
}
