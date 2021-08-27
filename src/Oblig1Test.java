import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1Test {

    @org.junit.jupiter.api.Test
    void maks() {
        int [] a = {1,2,3,8,9,-5,88,3,542,5};
        int maks_a = Oblig1.maks(a);
        assertEquals(542, maks_a);

        int [] b = {-542,-1115,-95458,-856,-9966,-5456551};
        int maks_b = Oblig1.maks(b);
        assertEquals(-542,maks_b);

        int [] c = {-55,2,3,8,9,-5,88,3,5,5550};
        int maks_c = Oblig1.maks(c);
        assertEquals(5550, maks_c);
    }

    @org.junit.jupiter.api.Test
    void bytt() {
    }

    @org.junit.jupiter.api.Test
    void ombytninger() {
        int [] a = randPerm(5);
        int [] b = randPerm(5);
        int [] c = randPerm(5);
        int [] d = randPerm(5);
        int [] e = randPerm(5);
        int [] f = randPerm(5);
        int [] j = randPerm(5);
        int [] h = randPerm(5);
        int [] i = randPerm(5);
        int [] g = randPerm(5);
        int [] k = randPerm(5);
        int Omb_a = Oblig1.ombytninger(a); // ANTALL ombyttinger for tabellen a
        int Omb_b = Oblig1.ombytninger(b); // ANTALL ombyttinger for tabellen b
        int Omb_c = Oblig1.ombytninger(c); // ANTALL ombyttinger for tabellen c
        int Omb_d = Oblig1.ombytninger(d); // ANTALL ombyttinger for tabellen d
        int Omb_e = Oblig1.ombytninger(e); // ANTALL ombyttinger for tabellen e
        int Omb_f = Oblig1.ombytninger(f); // ANTALL ombyttinger for tabellen f
        int Omb_j = Oblig1.ombytninger(j); // ANTALL ombyttinger for tabellen j
        int Omb_h = Oblig1.ombytninger(h); // ANTALL ombyttinger for tabellen h
        int Omb_i = Oblig1.ombytninger(i); // ANTALL ombyttinger for tabellen i
        int Omb_g = Oblig1.ombytninger(g); // ANTALL ombyttinger for tabellen g
        int Omb_k = Oblig1.ombytninger(k); // ANTALL ombyttinger for tabellen k

        // gjennomOmb står for Gjennomsnittlig Ombytninger som er antall ombytninger metoden maks gjør i gjennomsnitt.
        double gjennomOmb = (double) (Omb_a +Omb_b +Omb_c +Omb_d +Omb_e +Omb_f +Omb_j +Omb_h +Omb_i +Omb_g + Omb_k) /11;
        System.out.println(gjennomOmb);
     }

    public static int[] randPerm(int n){
        Random r = new Random();
        int [] a = new int [n];
        Arrays.setAll(a, i-> i+1); // legger tallene 1, 2, .., n
        for (int k = n-1; k>0; k--){
            int i = r.nextInt(k+1); // en tilfelldig tall fra 0 til k
            Oblig1.bytt(a,k,i);
        }
        return a;
    }

    @Test
    void antallUlikeSortert() {

    }

    @Test
    void sjekkSortert() {
        int [] sortert = {1,5,9,122,445,895,965,986,2501,7892};  // Denne er en sortert tabell
        assertEquals(true, Oblig1.sjekkSortert(sortert));

        int [] ikkeSortert = {1,99,3,22,588,1,4,32,9,-58,62289};
        assertEquals(false, Oblig1.sjekkSortert(ikkeSortert));
        assertFalse(Oblig1.sjekkSortert(ikkeSortert));
    }
}