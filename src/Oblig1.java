import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Oblig1 {
    // Bilal Sahli   s339603
    public static int maks (int []a ){
        int n = a.length; // Tabellens størrelse
        if (n == 0){
            throw new NoSuchElementException("Input tabellen er tom!");
        }
        for (int i = 0; i < a.length -1; ++i){
            if (a[i] > a[i+1]){
                bytt(a,i,i+1);
            }
        }
        return a[n-1]; // Største verdien ligger nå bakerst i tabellen
    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int ombytninger(int [] a){
        int antallOmbytninger = 0;
        int n = a.length; // Tabellens størrelse
        if (n == 0){
            throw new NoSuchElementException("Input tabellen er tom!");
        }
        for (int i = 0; i < a.length -1; ++i){
            if (a[i] > a[i+1]){
                bytt(a,i,i+1);
            }
            antallOmbytninger++;
        }
        return antallOmbytninger;
    }

    /* Teoristiske spørsmaal:
    * Naar blir det flest ombytninger?
        * Svar: Det er flest ombytninger når tabellen er sortert synkende, dvs. sortert fra stoorste til minste tall.
    * Naar blir det faerrest?
        * Svar: Det er faerrest ombytninger når tabellen er sortert stigende, dvs. sortert fra minste til største tall.
    * Hvor mange blir det i gjennomsnitt?
        * Svar: Etter å ha testet metoden  public static int ombytninger(int [] a) i Oblig1Test har vi fått at i
        * gjennomsnitt blir det fire ombytninger.
    * */

    public static int antallUlikeSortert(int [] a){
        boolean erSortertStigende = sjekkSortert(a);  // Skjekk om tabellen a er stigende sortert
        if (erSortertStigende == false){             //  Tabellen må vaere sortert stigende
            throw new IllegalStateException("Tabellen er ikke sortert stigende!");
        }

        /* Denne er en tabell som vi skal lagre på kun de unike verdier som finnes på tabbelen a
         Jeg velger å bruke ArrayList nå fordi den har en variabel stoorrelse som vi kan fylle på etterhvert */

        ArrayList <Integer> unikeVerdier = new ArrayList<Integer>();
        // Vi adder første elementet i tabbelen a inn i hjelpe-tabellen unikeVerider for å initialisere den.
        unikeVerdier.add(0, a[0]);

        // For hver tall i tabellen a går jeg gjennom unikeVerdier tabellen og skjekker om det finnes fra før, hvis ikke
        // så legger jeg den til unikeVerdier tabellen
        // Når vi er ferdig så hav vi en tabell -unikeVerider- som har på seg alle og kun de unike verider i tabellen a
        for (int k = 1; k<a.length; ++k) {
            for (int j = 0; j< unikeVerdier.size(); ++j){
                if (a[k] != unikeVerdier.get(j) ){
                    unikeVerdier.add(a[k]);
                }
            }
        }
        int antallUlikeVerdier = unikeVerdier.size(); // Hjelpeverdi som lagrer antall elementer i ulikeVerdier tabellen.
        return antallUlikeVerdier;
    }

    // metode som skjekker om en tabell er sortert stigende
    public static boolean sjekkSortert(int [] a){
        boolean sortertStigende = true;
        for (int i = 0; i < a.length -1; ++i){
            if(a[i] > a[i+1]) {
                sortertStigende = false;
            }
        }
        return sortertStigende;
    }
}
