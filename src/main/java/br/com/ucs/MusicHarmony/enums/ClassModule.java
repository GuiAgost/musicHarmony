package br.com.ucs.MusicHarmony.enums;

public enum ClassModule {
    CONCEPT("aulas/moduloConceito"),
    TRIAD("aulas/moduloTriade"),
    TETRAD("aulas/moduloTetrade"),
    TRANSPOSITION("aulas/moduloTransposicao");

    private final String view;

    ClassModule(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
