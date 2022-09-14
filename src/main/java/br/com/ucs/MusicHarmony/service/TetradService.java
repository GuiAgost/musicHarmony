package br.com.ucs.MusicHarmony.service;

import br.com.ucs.MusicHarmony.model.Scales;
import org.springframework.stereotype.Service;

@Service
public class TetradService {

    public String chordTetrad(String chord) {
        String res;
        Scales scales = new Scales();

        switch (chord) {
            //=======================================================================TÉTRADE MAIOR COM SÉTIMA MAIOR===================================================================
            case "C7M", "Cmaj7" -> res = scales.getScaleDo().get(0) + " - " + scales.getScaleDo().get(4) + " - " + scales.getScaleDo().get(8) + " - " + scales.getScaleDo().get(12);
            case "D7M", "Dmaj7" -> res = scales.getScaleRe().get(0) + " - " + scales.getScaleRe().get(4) + " - " + scales.getScaleRe().get(8) + " - " + scales.getScaleRe().get(12);
            case "E7M", "Emaj7" -> res = scales.getScaleMi().get(0) + " - " + scales.getScaleMi().get(4) + " - " + scales.getScaleMi().get(8) + " - " + scales.getScaleMi().get(12);
            case "F7M", "Fmaj7" -> res = scales.getScaleFa().get(0) + " - " + scales.getScaleFa().get(4) + " - " + scales.getScaleFa().get(8) + " - " + scales.getScaleFa().get(12);
            case "G7M", "Gmaj7" -> res = scales.getScaleSol().get(0) + " - " + scales.getScaleSol().get(4) + " - " + scales.getScaleSol().get(8) + " - " + scales.getScaleSol().get(12);
            case "A7M", "Amaj7" -> res = scales.getScaleLa().get(0) + " - " + scales.getScaleLa().get(4) + " - " + scales.getScaleLa().get(8) + " - " + scales.getScaleLa().get(12);
            case "B7M", "Bmaj7" -> res = scales.getScaleSi().get(0) + " - " + scales.getScaleSi().get(4) + " - " + scales.getScaleSi().get(7) + " - " + scales.getScaleSi().get(12);

            //=======================================================================TÉTRADE MAIOR COM SÉTIMA MENOR==========================================================
            case "C7" -> res = scales.getScaleDo().get(0) + " - " + scales.getScaleDo().get(4) + " - " + scales.getScaleDo().get(8) + " - " + scales.getScaleDo().get(11);
            case "D7" -> res = scales.getScaleRe().get(0) + " - " + scales.getScaleRe().get(4) + " - " + scales.getScaleRe().get(8) + " - " + scales.getScaleRe().get(11);
            case "E7" -> res = scales.getScaleMi().get(0) + " - " + scales.getScaleMi().get(4) + " - " + scales.getScaleMi().get(8) + " - " + scales.getScaleMi().get(11);
            case "F7" -> res = scales.getScaleFa().get(0) + " - " + scales.getScaleFa().get(4) + " - " + scales.getScaleFa().get(8) + " - " + scales.getScaleFa().get(11);
            case "G7" -> res = scales.getScaleSol().get(0) + " - " + scales.getScaleSol().get(4) + " - " + scales.getScaleSol().get(8) + " - " + scales.getScaleSol().get(11);
            case "A7" -> res = scales.getScaleLa().get(0) + " - " + scales.getScaleLa().get(4) + " - " + scales.getScaleLa().get(8) + " - " + scales.getScaleLa().get(11);
            case "B7" -> res = scales.getScaleSi().get(0) + " - " + scales.getScaleSi().get(4) + " - " + scales.getScaleSi().get(7) + " - " + scales.getScaleSi().get(11);

            //======================================================================TÉTRADE MENOR COM SÉTIMA MENOR=============================================================
            case "Cm7" -> res = scales.getScaleDo().get(0) + " - " + scales.getScaleDo().get(3) + " - " + scales.getScaleDo().get(8) + " - " + scales.getScaleDo().get(11);
            case "Dm7" -> res = scales.getScaleRe().get(0) + " - " + scales.getScaleRe().get(3) + " - " + scales.getScaleRe().get(8) + " - " + scales.getScaleRe().get(11);
            case "Em7" -> res = scales.getScaleMi().get(0) + " - " + scales.getScaleMi().get(3) + " - " + scales.getScaleMi().get(8) + " - " + scales.getScaleMi().get(11);
            case "Fm7" -> res = scales.getScaleFa().get(0) + " - " + scales.getScaleFa().get(3) + " - " + scales.getScaleFa().get(8) + " - " + scales.getScaleFa().get(11);
            case "Gm7" -> res = scales.getScaleSol().get(0) + " - " + scales.getScaleSol().get(3) + " - " + scales.getScaleSol().get(8) + " - " + scales.getScaleSol().get(11);
            case "Am7" -> res = scales.getScaleLa().get(0) + " - " + scales.getScaleLa().get(3) + " - " + scales.getScaleLa().get(8) + " - " + scales.getScaleLa().get(11);
            case "Bm7" -> res = scales.getScaleSi().get(0) + " - " + scales.getScaleSi().get(3) + " - " + scales.getScaleSi().get(7) + " - " + scales.getScaleSi().get(11);

            //=====================================================================TÉTRADE MEIO DIMINUTA COM SÉTIMA MENOR=========================================================
            case "Cm7(b5)" -> res = scales.getScaleDo().get(0) + " - " + scales.getScaleDo().get(3) + " - " + scales.getScaleDo().get(7) + " - " + scales.getScaleDo().get(11);
            case "Dm7(b5)" -> res = scales.getScaleRe().get(0) + " - " + scales.getScaleRe().get(3) + " - " + scales.getScaleRe().get(8) + " - " + scales.getScaleRe().get(10);
            case "Em7(b5)" -> res = scales.getScaleMi().get(0) + " - " + scales.getScaleMi().get(3) + " - " + scales.getScaleMi().get(7) + " - " + scales.getScaleMi().get(11);
            case "Fm7(b5)" -> res = scales.getScaleFa().get(0) + " - " + scales.getScaleFa().get(3) + " - " + scales.getScaleFa().get(7) + " - " + scales.getScaleFa().get(11);
            case "Gm7(b5)" -> res = scales.getScaleSol().get(0) + " - " + scales.getScaleSol().get(3) + " - " + scales.getScaleSol().get(7) + " - " + scales.getScaleSol().get(11);
            case "Am7(b5)" -> res = scales.getScaleLa().get(0) + " - " + scales.getScaleLa().get(3) + " - " + scales.getScaleLa().get(7) + " - " + scales.getScaleLa().get(11);
            case "Bm7(b5)" -> res = scales.getScaleSi().get(0) + " - " + scales.getScaleSi().get(3) + " - " + scales.getScaleSi().get(6) + " - " + scales.getScaleSi().get(11);
            default -> res = "Acorde inválido";
        }
        return res;
    }
}