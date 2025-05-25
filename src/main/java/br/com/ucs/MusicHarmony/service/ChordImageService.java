package br.com.ucs.MusicHarmony.service;

import br.com.ucs.MusicHarmony.model.ChordImage;
import br.com.ucs.MusicHarmony.repository.ChordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ChordImageService {

    @Autowired
    private ChordRepository chordRepository;

    // Itera a lista de imagem para fazer a conversão para Base64
    public List<String> findAllChordImagesBase64() {
        return chordRepository.findByImage().stream()
                .map(ChordImage::getImage)
                .map(image -> Base64.getMimeEncoder().encodeToString(image))
                .toList();
    }

    // Optional retorna string chord do banco de dados
    public Optional<String> findChordImageByName(String chordName) {
        Optional<ChordImage> chord = chordRepository.findByChordName(chordName);
        return chord.map(c -> Base64.getMimeEncoder().encodeToString(c.getImage()));
    }
}
