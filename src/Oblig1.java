import java.util.ArrayList;
import java.util.Arrays;
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
        if (a.length == 0) {
            return 0;
        }
        boolean erSortertStigende = sjekkSortert(a);  // Skjekk om tabellen a er stigende sortert og returnerer true eller false

        if (erSortertStigende == false){             //  Tabellen må vaere sortert stigende
            throw new IllegalStateException("Tabellen er ikke sortert stigende!");
        }
        int antallUlike =  1;  // AntallUlike teller antall antall ulike verdier i tabellen a. Tabellen skal ha minst en unik verdi uansett
         for (int i = 1; i<a.length; ++i){
             if(a[i] != a[i-1]) {
                 antallUlike++;
             }
         }
         return antallUlike;
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

    /* Metoden på Oppgave 3 */
    public static int antallUlikeUsortert(int[] a){
        if (a.length == 0) {
            return 0;
        }
        int antallUlike =  1;
        boolean finnesFraFoor = false;
        for (int i =1; i< a.length; i++){
            for(int j = 0; j<i ; j++){
                if(a[i] == a[j]){
                    finnesFraFoor = true;
                }

            }
            if (finnesFraFoor == false){ // hvis den verdien a [i] ikke finnes fra før i del arrayet a[0:i] legger vi en ulik verdi til
                antallUlike++;
            }
            finnesFraFoor = false; // tilbakestille finnesFraFoor til sin opprinelig verdi etter hver iterasjon
        }

        return antallUlike;
        }



    // Oppgave 4
    public static void delSortering(int [] a){
        // skal implementere quicksort her også
        int n = a.length;
        int antallOddeTall = 0;
        int antallPartallTall = 0;
        // løpe gjennom tabellen og telle antall odde- og partall
        for (int i = 0; i < n ; ++i) {
            if(a[i] % 2 == 0){
                antallPartallTall++;
            }
            else
                antallOddeTall++;
        }
    }
    public void quicksort(int[]a, int left, int right){
        if(left >= right){
            return;
        }
        //velger en pivot
        int pivot_index = (left+right)/2;
        int pivot = a[pivot_index];

        // Partisjonering
        // Sørg for at alle til høyre blir større enn eller lik pivot
        // og at alle til venstre er mindre enn pivot

        int new_pivot_index = partisjoner(a,left,right, pivot_index);

        // Gjenta for høyre subliste og venstre subliste
        quicksort(a, left, new_pivot_index-1);
        quicksort(a, new_pivot_index+1, right);
    }
    public int byttPivotBakerst(int [] a, int begin, int end){
        int pivot = (begin + end)/2;
        int temp = a[end-1];
        a[end-1] = a[pivot];
        a[pivot] = temp;
        return pivot;

    }

    public int partisjoner (int []a, int begin, int end, int pivot_index){
        // First, move our pivot to the end of the array
        bytt(a,pivot_index,end-1);
        int left = begin;
        int right = end-2;

        // loop over the array and swap until left meets right
        while (left < right){
            // Find first element from the left larger than pivot
            while (left <= right && a[left] < a[end-1]){
                ++left;
            }
            // Find first element from the right smaller than pivot
            while(left <= right && a[right] > a[end-1]){
                --right;
            }

            //If left and right have not met, swap left and right
            if(left<right){
                bytt(a, left,right);
                ++left;
                --right;
            }
        }
        //Swap pivot element back
        bytt(a,left,end-1);

        // Rerurn new index of pivot element
        return left;
    }
}
