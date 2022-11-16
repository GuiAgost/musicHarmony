package br.com.ucs.MusicHarmony.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranspositionServiceTest {

    private final TranspositionService transp = new TranspositionService();

    @Test
    public void transpositionSemitonePositivo() {
        String chordTransp = transp.transposition(2, "C");
        assertEquals("D", chordTransp);
    }

    @Test
    public void transpositionSemitoneNegative() {
        String chordTransp = transp.transposition(-2, "A");
        assertEquals("G", chordTransp);
    }

    @Test
    public void transpositionSemitoneOctaveUp() {
        String chordTransp = transp.transposition(9, "F");
        assertEquals("D", chordTransp);
    }

    @Test
    public void transpositionSemitoneOctaveBelow() {
        String chordTransp = transp.transposition(-10, "G");
        assertEquals("A", chordTransp);
    }

    @Test
        public void transpositionInvalidate() {
        ValidationChordService valid = new ValidationChordService();

        // Nesse caso retorna true
        boolean val11 = valid.validation("C#");
        assertTrue(val11);

//        boolean val1 = valid.validation("C1");
//        assertFalse(val1);
        assertFalse(valid.validation("C1"));

        boolean val2 = valid.validation("c");
        assertFalse(val2);

        boolean val3 = valid.validation("123");
        assertFalse(val3);

        boolean val4 = valid.validation("B#");
        assertFalse(val4);

        boolean val5 = valid.validation("E#");
        assertFalse(val5);

        boolean val6 = (valid.validation("CC"));
        assertFalse(val6);

        boolean val7 = valid.validation("H");
        assertFalse(val7);

        boolean val8 = valid.validation("#");
        assertFalse(val8);

        boolean val9 = valid.validation("#F");
        assertFalse(val9);

        boolean val10 = valid.validation("##");
        assertFalse(val10);
    }
}