package br.com.ucs.MusicHarmony.repository;

import br.com.ucs.MusicHarmony.model.ChordImage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ChordRepository extends JpaRepository<ChordImage, Long> {
    Optional<ChordImage> findByChordName(String chordName);
}
