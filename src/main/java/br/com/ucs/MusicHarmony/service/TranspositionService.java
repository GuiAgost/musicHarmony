package br.com.ucs.MusicHarmony.service;

import br.com.ucs.MusicHarmony.model.Scales;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import static java.lang.Math.abs;

/*
 * Classe para cálculo de transposição.
 */

@Service
public class TranspositionService {

    public String transposition(int semitone, String note){
        Scales scale = new Scales();
        int aux = 0;

        aux = getPositionNote(note, scale.getScale(), aux);
        int transposed = getTransposed(semitone, scale.getScale(), aux);

        // Retorna a nota transposta, conforme a posição da nota transposta calculada
        return scale.getScale().get(transposed);
    }

    // Retorna a posição da nota transposta
    private int getTransposed(int semitone, LinkedList<String> scale, int position) {
        int transposed;
        int sum = position + semitone;

        if (sum >= 0) {
            transposed = sum % scale.size();
        } else {
            transposed = abs(scale.size() + sum) % scale.size();
        }
        return transposed;
    }

    // Retorna a posição da nota informada
    private int getPositionNote(String note, LinkedList<String> scale, int aux) {
        for(int i = 0; i < scale.size(); i++){
            if(scale.get(i).equals(note)){
                aux = i;
            }
        }
        return aux;
    }
}