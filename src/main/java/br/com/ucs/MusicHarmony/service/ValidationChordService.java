package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;

/*
 *  Classe para validar a string chord
 */

@Service
public class ValidationChordService {

    public boolean validation(String chord){
        // Não deve validar entre as letras H-Z, os números e letras minúsculas entre as letras a-z
        if (chord.matches("[H-Z]") || chord.matches("[0-9]*") || chord.matches("[a-z]")) {
            return false;
        }
        return chord.length() < 2;
    }
}