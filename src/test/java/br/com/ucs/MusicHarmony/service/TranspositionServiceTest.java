package br.com.ucs.MusicHarmony.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranspositionServiceTest {

    @Test
    public void transpositionSemitonePositivo() {
        TranspositionService transp = new TranspositionService();
        String chordTransp = transp.transposition(2, "C");

        assertEquals("D", chordTransp);
    }

    @Test
    public void transpositionSemitoneNegative() {
        TranspositionService transp = new TranspositionService();
        String chordTransp = transp.transposition(-2, "A");

        assertEquals("G", chordTransp);
    }

    @Test
    public void transpositionSemitoneOctaveUp() {
        TranspositionService transp = new TranspositionService();
        String chordTransp = transp.transposition(9, "F");

        assertEquals("D", chordTransp);
    }

    @Test
    public void transpositionSemitoneOctaveBelow() {
        TranspositionService transp = new TranspositionService();
        String chordTransp = transp.transposition(-10, "G");

        assertEquals("A", chordTransp);
    }
}