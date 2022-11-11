package br.com.ucs.MusicHarmony.service;

import br.com.ucs.MusicHarmony.service.TetradService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TetradServiceTest {

//    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
//    @Autowired
//    public TetradService tetrad;

    @Test
    public void ChordsMajorWithSeventhMajorCorrect() {
        TetradService tetrad = new TetradService();
        String chordC7M = "C7M";
        String chordD7M = "D7M";
        String chordE7M = "E7M";
        String chordF7M = "F7M";
        String chordG7M = "G7M";
        String chordA7M = "A7M";
        String chordB7M = "B7M";
        String chordInvalidate = "Acorde inválido";
        String chordInvalidate1 = "Acorde inválido";

        String resC7M = tetrad.chordTetrad(chordC7M);
        String resD7M = tetrad.chordTetrad(chordD7M);
        String resE7M = tetrad.chordTetrad(chordE7M);
        String resF7M = tetrad.chordTetrad(chordF7M);
        String resG7M = tetrad.chordTetrad(chordG7M);
        String resA7M= tetrad.chordTetrad(chordA7M);
        String resB7M = tetrad.chordTetrad(chordB7M);
        String resInvalidade = tetrad.chordTetrad(chordInvalidate);
        String resInvalidade1 = tetrad.chordTetrad(chordInvalidate1);

        assertEquals("C - E - G - B", resC7M);
        assertEquals("D - F# - A - C#", resD7M);
        assertEquals("E - G# - B - D#", resE7M);
        assertEquals("F - A - C - E", resF7M);
        assertEquals("G - B - D - F#", resG7M);
        assertEquals("A - C# - E - G#", resA7M);
        assertEquals("B - D# - F# - A#", resB7M);
        assertEquals("Acorde inválido", chordInvalidate);
        assertNotEquals("C1", resInvalidade1);
        assertNotEquals("", resInvalidade1);
    }


    @Test
    public void ChordsMajorWithSeventhMinorCorrect() {
        TetradService tetrad = new TetradService();
        String chordC7 = "C7";
        String chordD7 = "D7";
        String chordE7 = "E7";
        String chordF7 = "F7";
        String chordG7 = "G7";
        String chordA7 = "A7";
        String chordB7 = "B7";

        String resC7 = tetrad.chordTetrad(chordC7);
        String resD7 = tetrad.chordTetrad(chordD7);
        String resE7 = tetrad.chordTetrad(chordE7);
        String resF7 = tetrad.chordTetrad(chordF7);
        String resG7 = tetrad.chordTetrad(chordG7);
        String resA7= tetrad.chordTetrad(chordA7);
        String resB7 = tetrad.chordTetrad(chordB7);

        assertEquals("C - E - G - Bb", resC7);
        assertEquals("D - F# - A - C", resD7);
        assertEquals("E - G# - B - D", resE7);
        assertEquals("F - A - C - Eb", resF7);
        assertEquals("G - B - D - F", resG7);
        assertEquals("A - C# - E - G", resA7);
        assertEquals("B - D# - F# - A", resB7);
    }

    @Test
    public void ChordsMinorWithSeventhMinorCorrect() {
        TetradService tetrad = new TetradService();
        String chordCm7 = "Cm7";
        String chordDm7 = "Dm7";
        String chordEm7 = "Em7";
        String chordFm7 = "Fm7";
        String chordGm7 = "Gm7";
        String chordAm7 = "Am7";
        String chordBm7 = "Bm7";

        String resCm7 = tetrad.chordTetrad(chordCm7);
        String resDm7 = tetrad.chordTetrad(chordDm7);
        String resEm7 = tetrad.chordTetrad(chordEm7);
        String resFm7 = tetrad.chordTetrad(chordFm7);
        String resGm7 = tetrad.chordTetrad(chordGm7);
        String resAm7= tetrad.chordTetrad(chordAm7);
        String resBm7 = tetrad.chordTetrad(chordBm7);

        assertEquals("C - Eb - G - Bb", resCm7);
        assertEquals("D - F - A - C", resDm7);
        assertEquals("E - G - B - D", resEm7);
        assertEquals("F - Ab - C - Eb", resFm7);
        assertEquals("G - Bb - D - F", resGm7);
        assertEquals("A - C - E - G", resAm7);
        assertEquals("B - D - F# - A", resBm7);
    }

    @Test
    public void ChordsHalfDiminutiveWithSeventhMinorCorrect() {
        TetradService tetrad = new TetradService();
        String chordCHalfDim = "Cm7(b5)";
        String chordDHalfDim  = "Dm7(b5)";
        String chordEHalfDim  = "Em7(b5)";
        String chordFHalfDim  = "Fm7(b5)";
        String chordGHalfDim  = "Gm7(b5)";
        String chordAHalfDim  = "Am7(b5)";
        String chordBHalfDim  = "Bm7(b5)";

        String resCHalfDim  = tetrad.chordTetrad(chordCHalfDim);
        String resDHalfDim  = tetrad.chordTetrad(chordDHalfDim);
        String resEHalfDim  = tetrad.chordTetrad(chordEHalfDim);
        String resFHalfDim  = tetrad.chordTetrad(chordFHalfDim);
        String resGHalfDim  = tetrad.chordTetrad(chordGHalfDim);
        String resAHalfDim = tetrad.chordTetrad(chordAHalfDim);
        String resBHalfDim  = tetrad.chordTetrad(chordBHalfDim);

        assertEquals("C - Eb - Gb - Bb", resCHalfDim);
        assertEquals("D - F - A - B", resDHalfDim);
        assertEquals("E - G - Bb - D", resEHalfDim);
        assertEquals("F - Ab - B - Eb", resFHalfDim);
        assertEquals("G - Bb - Db - F", resGHalfDim);
        assertEquals("A - C - Eb - G", resAHalfDim);
        assertEquals("B - D - F - A", resBHalfDim);
    }

    @Test
    public void ChordsInvalidate() {
        TetradService tetrad = new TetradService();

        String chordInvalidate = "C";
        String chordInvalidate1 = "";

        String resInvalidade = tetrad.chordTetrad(chordInvalidate);
        String resInvalidade1 = tetrad.chordTetrad(chordInvalidate1);

        assertEquals("Acorde inválido", resInvalidade);
        assertEquals("Acorde inválido", resInvalidade1);
    }
}

// https://cursos.alura.com.br/forum/topico-diferenca-entre-assert-assertequals-e-assertequals-138335