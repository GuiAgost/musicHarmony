package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationChordService {

    public boolean validation(String chord){

        if (chord.matches("[H-Z]") || chord.matches("[0-9]*") || chord.matches("[a-z]")) {
            return false;
        }
        if (chord.matches("((?![EB]#))^([A-G][#]?$)")) {
            return true;
        }
        return chord.length() < 2;
    }
}

// ^ = Começa assim
// $ = Termina assim
// ? = Pode existir ou não
// ! = negação