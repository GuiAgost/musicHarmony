package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;

/*
 *  Classe para validar a string chord
 */

@Service
public class ValidationChordService {

    public boolean validation(String chord){
        // Não deve validar entre as letras H-Z, os números, letras minúsculas entre as letras a-z e o símbolo #
        if (chord.matches("[H-Z]") || chord.matches("[0-9]*") || chord.matches("[a-z]") ||
                chord.matches("#")) {
            return false;
        }
        //Valida somente as letras maiúsculas de A-G e pode incluir o #, exceto as notas E# e B#
        if(chord.matches("((?![EB]#))([A-G]#?$)")){
            return true;
        }
        return chord.length() < 2;
    }
}