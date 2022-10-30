package br.com.ucs.MusicHarmony.dto;

import br.com.ucs.MusicHarmony.repository.ChordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotBlank;

public class RequestChord {

    @Autowired
    ChordRepository chordRepository;

    @NotBlank
    private Long id;

    public Long getId() {
        return id;
    }

    public String getChordName(String chordName) {
        return chordName;
    }
}
