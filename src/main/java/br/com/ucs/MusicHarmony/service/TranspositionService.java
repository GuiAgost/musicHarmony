package br.com.ucs.MusicHarmony.service;

import java.util.InputMismatchException;
import java.util.LinkedList;

import static java.lang.Math.abs;

public class TranspositionService {

    public String transposition(int semitone, String note){
        final LinkedList<String> escala = new LinkedList<String>(){{add("C");add("C#");add("D");add("D#");add("E");add("F");add("F#");add("G");add("G#");add("A");add("A#");add("B");}};

        String transposto;
        // REGEX: A, B, C, D, E, F, G e #

        int i = 0;
        int aux = 0;

        while (i < escala.size()) {
            if (escala.get(i).equals(note)) {
                aux = i; // Pega a nota informada pelo usuário
            }
            i++;
        }
        transposto = escala.get(abs(abs(aux + (semitone)) - i)); // Pega o elemento transposto
        System.out.println("Nota transposta: " + transposto); // Informa a nota tranposta
        return transposto;
    }
}
