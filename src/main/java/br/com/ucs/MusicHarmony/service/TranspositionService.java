package br.com.ucs.MusicHarmony.service;

import java.util.LinkedList;

public class TranspositionService {

    public String transposition(int semitone, String note){
        final LinkedList<String> scale = new LinkedList<String>(){{add("C");add("C#");add("D");add("D#");add("E");add("F");add("F#");add("G");add("G#");add("A");add("A#");add("B");}};

//        if (note.matches("[0-9]*")) {
//
//        }
        int transposed;
        int aux = 0;

        for(int i = 0; i < scale.size(); i++){
            if(scale.get(i).equals(note)){
                aux = i;
            }
        }
        int sum = aux + semitone;

        if (sum >= 0) {
            transposed = sum % scale.size();
        } else {
            transposed = Math.abs(scale.size() + sum) % scale.size();
        }

        System.out.println(scale.get(transposed));
        return scale.get(transposed);
    }
}

// https://scholar.google.com.br/scholar?hl=pt-BR&as_sdt=0%2C5&q=Teoria+de+Grupos+e+M%C3%BAsica%3A+Conex%C3%B5es&btnG=
