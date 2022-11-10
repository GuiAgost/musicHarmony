package br.com.ucs.MusicHarmony.service;

import br.com.ucs.MusicHarmony.model.Scales;
import org.springframework.stereotype.Service;

/*
 *  Classe para retornar as 3 notas que forma o acorde de tríade
 */

@Service
public class TriadService {

    public String chordTriad(String chord){
        String res;
        Scales scales = new Scales();

        switch (chord) {
            //===============================================TRÍADE MAIOR===============================================================
            case "C" -> res = scales.getScaleDo().get(0) + " - " + scales.getScaleDo().get(4) + " - " + scales.getScaleDo().get(8);
            case "D" -> res = scales.getScaleRe().get(0) + " - " + scales.getScaleRe().get(4) + " - " + scales.getScaleRe().get(8);
            case "E" -> res = scales.getScaleMi().get(0) + " - " + scales.getScaleMi().get(4) + " - " + scales.getScaleMi().get(8);
            case "F" -> res = scales.getScaleFa().get(0) + " - " + scales.getScaleFa().get(4) + " - " + scales.getScaleFa().get(8);
            case "G" -> res = scales.getScaleSol().get(0) + " - " + scales.getScaleSol().get(4) + " - " + scales.getScaleSol().get(8);
            case "A" -> res = scales.getScaleLa().get(0) + " - " + scales.getScaleLa().get(4) + " - " + scales.getScaleLa().get(8);
            case "B" -> res = scales.getScaleSi().get(0) + " - " + scales.getScaleSi().get(4) + " - " + scales.getScaleSi().get(7);

            //===============================================TRÍADE MENOR===============================================================
            case "Cm" -> res = scales.getScaleDo().get(0) + " - " + scales.getScaleDo().get(3) + " - " + scales.getScaleDo().get(8);
            case "Dm" -> res = scales.getScaleRe().get(0) + " - " + scales.getScaleRe().get(3) + " - " + scales.getScaleRe().get(8);
            case "Em" -> res = scales.getScaleMi().get(0) + " - " + scales.getScaleMi().get(3) + " - " + scales.getScaleMi().get(8);
            case "Fm" -> res = scales.getScaleFa().get(0) + " - " + scales.getScaleFa().get(3) + " - " + scales.getScaleFa().get(8);
            case "Gm" -> res = scales.getScaleSol().get(0) + " - " + scales.getScaleSol().get(3) + " - " + scales.getScaleSol().get(8);
            case "Am" -> res = scales.getScaleLa().get(0) + " - " + scales.getScaleLa().get(3) + " - " + scales.getScaleLa().get(8);
            case "Bm" -> res = scales.getScaleSi().get(0) + " - " + scales.getScaleSi().get(3) + " - " + scales.getScaleSi().get(8);

            //==============================================TRÍADE DIMINUTO=============================================================
            case "Cdim" -> res = scales.getScaleDo().get(0) + " - " + scales.getScaleDo().get(3) + " - " + scales.getScaleDo().get(7);
            case "Ddim" -> res = scales.getScaleRe().get(0) + " - " + scales.getScaleRe().get(3) + " - " + scales.getScaleRe().get(7);
            case "Edim" -> res = scales.getScaleMi().get(0) + " - " + scales.getScaleMi().get(3) + " - " + scales.getScaleMi().get(7);
            case "Fdim" -> res = scales.getScaleFa().get(0) + " - " + scales.getScaleFa().get(3) + " - " + scales.getScaleFa().get(7);
            case "Gdim" -> res = scales.getScaleSol().get(0) + " - " + scales.getScaleSol().get(3) + " - " + scales.getScaleSol().get(7);
            case "Adim" -> res = scales.getScaleLa().get(0) + " - " + scales.getScaleLa().get(3) + " - " + scales.getScaleLa().get(7);
            case "Bdim" -> res = scales.getScaleSi().get(0) + " - " + scales.getScaleSi().get(3) + " - " + scales.getScaleSi().get(6);

            //=============================================TRÍADE AUMENTADO=============================================================
            case "C(#5)" -> res = scales.getScaleDo().get(0) + " - " + scales.getScaleDo().get(4) + " - " + scales.getScaleDo().get(9);
            case "D(#5)" -> res = scales.getScaleRe().get(0) + " - " + scales.getScaleRe().get(4) + " - " + scales.getScaleRe().get(9);
            case "E(#5)" -> res = scales.getScaleMi().get(0) + " - " + scales.getScaleMi().get(4) + " - " + scales.getScaleMi().get(9);
            case "F(#5)" -> res = scales.getScaleFa().get(0) + " - " + scales.getScaleFa().get(5) + " - " + scales.getScaleFa().get(9);
            case "G(#5)" -> res = scales.getScaleSol().get(0) + " - " + scales.getScaleSol().get(4) + " - " + scales.getScaleSol().get(9);
            case "A(#5)" -> res = scales.getScaleLa().get(0) + " - " + scales.getScaleLa().get(4) + " - " + scales.getScaleLa().get(9);
            case "B(#5)" -> res = scales.getScaleSi().get(0) + " - " + scales.getScaleSi().get(4) + " - " + scales.getScaleSi().get(9);
            default -> res = "Acorde inválido";
        }
        return res;
    }
}