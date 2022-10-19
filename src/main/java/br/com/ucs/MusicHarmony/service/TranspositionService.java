package br.com.ucs.MusicHarmony.service;

import br.com.ucs.MusicHarmony.model.Scales;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import static java.lang.Math.abs;

@Service
public class TranspositionService {

    public String transposition(int semitone, String note){
        Scales scale = new Scales();
        int aux = 0;

        aux = getPositionNote(note, scale.getScale(), aux);
        int transposed = getTransposed(semitone, scale.getScale(), aux);

        System.out.println(scale.getScale().get(transposed));
        return scale.getScale().get(transposed);
    }
    // https://en.wikipedia.org/wiki/Transposition_(music)

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

    private int getPositionNote(String note, LinkedList<String> scale, int aux) {
        for(int i = 0; i < scale.size(); i++){
            if(scale.get(i).equals(note)){
                aux = i;
            }
        }
        return aux;
    }
}

// https://scholar.google.com.br/scholar?hl=pt-BR&as_sdt=0%2C5&q=Teoria+de+Grupos+e+M%C3%BAsica%3A+Conex%C3%B5es&btnG=
