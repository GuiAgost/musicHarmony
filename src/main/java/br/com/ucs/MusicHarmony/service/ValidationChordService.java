package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationChordService {

    public boolean validation(String chordNote){
        if (chordNote.matches("[0-9]*")) {
            return false;
        }
        if (!chordNote.matches("[A-G]*") || !chordNote.matches("[A#-G#]*")) {
            return false;
        }
        if (chordNote.length() == 2){
            return false;
        }
        return true;
    }
}
// Falta aceitar o símbolo '#'
// https://www.alura.com.br/artigos/verificar-se-e-letra-ou-numero-no-java#:~:text=Agora%20precisamos%20verificar%20se%20essa,equipara%20com%20o%20par%C3%A2metro%20passado.

