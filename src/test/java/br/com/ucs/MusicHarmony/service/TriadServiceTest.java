package br.com.ucs.MusicHarmony.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriadServiceTest {

    private final TriadService triad = new TriadService();

    @Test
    public void chordsBiggerCorrect() {
        String chordC = "C";
        String chordD = "D";
        String chordE = "E";
        String chordF = "F";
        String chordG = "G";
        String chordA = "A";
        String chordB = "B";

        String resC = triad.chordTriad(chordC);
        String resD = triad.chordTriad(chordD);
        String resE = triad.chordTriad(chordE);
        String resF = triad.chordTriad(chordF);
        String resG = triad.chordTriad(chordG);
        String resA = triad.chordTriad(chordA);
        String resB = triad.chordTriad(chordB);

        assertEquals("C - E - G", resC);
        assertEquals("D - F# - A", resD);
        assertEquals("E - G# - B", resE);
        assertEquals("F - A - C", resF);
        assertEquals("G - B - D", resG);
        assertEquals("A - C# - E", resA);
        assertEquals("B - D# - F#", resB);
    }

    @Test
    public void chordsMinorsCorrect() {
        String chordCm = "Cm";
        String chordDm = "Dm";
        String chordEm = "Em";
        String chordFm = "Fm";
        String chordGm = "Gm";
        String chordAm = "Am";
        String chordBm = "Bm";

        String resCm = triad.chordTriad(chordCm);
        String resDm = triad.chordTriad(chordDm);
        String resEm = triad.chordTriad(chordEm);
        String resFm = triad.chordTriad(chordFm);
        String resGm = triad.chordTriad(chordGm);
        String resAm = triad.chordTriad(chordAm);
        String resBm = triad.chordTriad(chordBm);

        assertEquals("C - Eb - G", resCm);
        assertEquals("D - F - A", resDm);
        assertEquals("E - G - B", resEm);
        assertEquals("F - Ab - C", resFm);
        assertEquals("G - Bb - D", resGm);
        assertEquals("A - C - E", resAm);
        assertEquals("B - D - Gb", resBm);
    }

    @Test
    public void chordsDiminutiveCorrect() {
        String chordCdim = "Cdim";
        String chordDdim = "Ddim";
        String chordEdim = "Edim";
        String chordFdim = "Fdim";
        String chordGdim = "Gdim";
        String chordAdim = "Adim";
        String chordBdim = "Bdim";

        String resCdim = triad.chordTriad(chordCdim);
        String resDdim = triad.chordTriad(chordDdim);
        String resEdim = triad.chordTriad(chordEdim);
        String resFdim = triad.chordTriad(chordFdim);
        String resGdim = triad.chordTriad(chordGdim);
        String resAdim = triad.chordTriad(chordAdim);
        String resBdim = triad.chordTriad(chordBdim);

        assertEquals("C - Eb - Gb", resCdim);
        assertEquals("D - F - Ab", resDdim);
        assertEquals("E - G - Bb", resEdim);
        assertEquals("F - Ab - B", resFdim);
        assertEquals("G - Bb - Db", resGdim);
        assertEquals("A - C - Eb", resAdim);
        assertEquals("B - D - F", resBdim);
    }

    @Test
    public void chordsAugmentedCorrect() {
        String chordCaug = "C(#5)";
        String chordDaug = "D(#5)";
        String chordEaug = "E(#5)";
        String chordFaug = "F(#5)";
        String chordGaug = "G(#5)";
        String chordAaug = "A(#5)";
        String chordBaug = "B(#5)";

        String resCdim = triad.chordTriad(chordCaug);
        String resDdim = triad.chordTriad(chordDaug);
        String resEdim = triad.chordTriad(chordEaug);
        String resFdim = triad.chordTriad(chordFaug);
        String resGdim = triad.chordTriad(chordGaug);
        String resAdim = triad.chordTriad(chordAaug);
        String resBdim = triad.chordTriad(chordBaug);

        assertEquals("C - E - G#", resCdim);
        assertEquals("D - F# - A#", resDdim);
        assertEquals("E - G# - C", resEdim);
        assertEquals("F - A# - C#", resFdim);
        assertEquals("G - B - D#", resGdim);
        assertEquals("A - C# - F", resAdim);
        assertEquals("B - D# - G", resBdim);
    }

    @Test
    public void chordsInvalidate() {
        String chordInvalidate = "Cm7";
        String chordInvalidate1 = "";

        String resInvalidade = triad.chordTriad(chordInvalidate);
        String resInvalidade1 = triad.chordTriad(chordInvalidate1);

        assertEquals("Acorde inválido", resInvalidade);
        assertEquals("Acorde inválido", resInvalidade1);
    }
}