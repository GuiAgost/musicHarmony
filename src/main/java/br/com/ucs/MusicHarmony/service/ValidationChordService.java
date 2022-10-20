package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationChordService {

    public boolean validation(String chordNote){

        if (chordNote.matches("[H-Z]") || chordNote.matches("[0-9]*") || chordNote.matches("[a-z]")) {
            System.out.println("Passou a validação das letras inválidas e numeros inválidos: " + chordNote.matches("[H-Z]"));
            return false;
        }
        if (chordNote.matches("((?![EB]#))^([A-G][#]?$)")) {
            System.out.println("Passou a validação das letras válidas: " + chordNote.matches("^[A-G][#]?$"));
            return true;
        }
        System.out.println("Tamanho: " + (chordNote.length() < 2));
        return chordNote.length() < 2;
    }
}