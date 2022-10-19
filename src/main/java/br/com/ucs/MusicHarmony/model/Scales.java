package br.com.ucs.MusicHarmony.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Scales {

    private final LinkedList<String> scale;
    private final List<String> scaleDo;
    private final List<String> scaleRe;
    private final List<String> scaleMi;
    private final List<String> scaleFa;
    private final List<String> scaleSol;
    private final List<String> scaleLa;
    private final List<String> scaleSi;

    public Scales(){
        this.scale = new LinkedList<>(){{add("C");add("C#");add("D");add("D#");add("E");add("F");add("F#");add("G");add("G#");add("A");add("A#");add("B");}};
        this.scaleDo = new ArrayList<>(){{add("C");add("C#");add("D");add("Eb");add("E");add("F");add("F#");add("Gb");add("G");add("G#");add("A");add("Bb");add("B");}};
        this.scaleRe = new ArrayList<>(){{add("D");add("D#");add("E");add("F");add("F#");add("G");add("G#");add("Ab");add("A");add("A#");add("B");add("C");add("C#");}};
        this.scaleMi = new ArrayList<>(){{add("E");add("F");add("F#");add("G");add("G#");add("A");add("A#");add("Bb");add("B");add("C");add("C#");add("D");add("D#");}};
        this.scaleFa = new ArrayList<>(){{add("F");add("F#");add("G");add("Ab");add("A");add("A#");add("Bb");add("B");add("C");add("C#");add("D");add("Eb");add("E");}};
        this.scaleSol = new ArrayList<>(){{add("G");add("G#");add("A");add("Bb");add("B");add("C");add("C#");add("Db");add("D");add("D#");add("E");add("F");add("F#");}};
        this.scaleLa = new ArrayList<>(){{add("A");add("A#");add("B");add("C");add("C#");add("Db");add("D");add("Eb");add("E");add("F");add("F#");add("G");add("G#");}};
        this.scaleSi = new ArrayList<>(){{add("B");add("C");add("C#");add("D");add("D#");add("E");add("F");add("F#");add("Gb");add("G");add("G#");add("A");add("A#");}};
    }

    public LinkedList<String> getScale() {
        return scale;
    }

    public List<String> getScaleDo() {
        return scaleDo;
    }

    public List<String> getScaleRe() {
        return scaleRe;
    }

    public List<String> getScaleMi() {
        return scaleMi;
    }

    public List<String> getScaleFa() {
        return scaleFa;
    }

    public List<String> getScaleSol() {
        return scaleSol;
    }

    public List<String> getScaleLa() {
        return scaleLa;
    }

    public List<String> getScaleSi() {
        return scaleSi;
    }
}
