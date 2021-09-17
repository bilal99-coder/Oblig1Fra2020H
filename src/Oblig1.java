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
    }//maks

    public static void bytt(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }//bytt

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



    /* // Oppgave 4
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
    public static void quicksort(int[] a, int left, int right){
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

    public static int partisjoner(int[] a, int begin, int end, int pivot_index){
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

    public static int par_OddeTallPartisjonering(int[] a, int begin, int end, int pivot_index){
        bytt(a, pivot_index, end-1);
        int right = 0;
        int left = end-2;

        while (left < right){
            // Finner foorste element fra venstre som er partall
            while (left <= right && a[left] % 2 != 0){
                ++left;
            }
            // Finner foorste element fra høyre som er  oddetall
            while(left <= right && a[right] % 2 == 0){
                --right;
            }
            if(left < right){
                bytt(a, left, right);
                ++left;
                --right;
            }
        }
        // bytt pivot element tilbake
        bytt(a,left, end-1);
        // rerturn new index of pivot element
        return left;
    }

    public static void quicksortEdited(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        //velger en pivot
        int pivot_index = par_OddeTallPartisjonering( a, left, right, left-1);
        int pivot = a[pivot_index];

        // Partisjonering
        // Sørg for at alle til høyre blir større enn eller lik pivot
        // og at alle til venstre er mindre enn pivot

        int new_pivot_index = partisjoner(a,left,right, pivot_index);

        // Gjenta for høyre subliste og venstre subliste
        quicksort(a, left, new_pivot_index-1);
        quicksort(a, new_pivot_index+1, right);
    }*/

    public static int sorter_2n(int []a ){
        int left_index = 0;
        int right_index = a.length-1;
        // velger en pivot
        int pivot_index =  (left_index + right_index)/2;
        int pivot = a[pivot_index];
        //swap pivot element back of the array
        bytt(a, pivot, a[right_index]);

        while(left_index < right_index-1){
            // skjekker for å finne den første partall fra venstre
            while(a[left_index] % 2 != 0){
                left_index++;
            }
            // skjekker for å finne den første elementet fra høyre som er oddetall
            while(a[right_index] % 2 == 0){
                right_index --;
            }
            if(left_index< right_index){
                bytt(a, left_index, right_index);
                ++left_index;
                --right_index;
            }
        }
        // Bytt pivot tilbake
        bytt(a,left_index,right_index);
        return left_index;
    }

    public static int partisjonerr(int [] a, int pivot_index, int left, int right){
        int left_index = left;
        int right_index = right-1;
        //int pivot = a[pivot_index];
        //Setter pivot bakerst
        bytt(a,pivot_index,right);
        while(left_index < right_index ){
            //finner den første elementet som er større enn vår pivot fra venstre
            while(left_index <= right_index && a[left_index] < a[right]  ){
                ++left_index;
            }
            //Nå starter fra høyre og finner den første elementet som er mindre enn vår pivot
            while( left_index <= right_index && a[right_index] > a[right]){
                --right_index; //left <= right && a[right] > a[end-1]
            }
            if (left_index < right_index){
                bytt(a, left_index, right_index);
                ++left_index;
                --right_index;
            }
        }
        //bytt pivot tilbake til sin riktig plass nå

        bytt(a,left_index, right);
        return left_index;
    }

    public static void aQuicksort(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int pivot_index = (left+right-1)/2;
        int partisjonering = partisjonerr(a,pivot_index,left,right);
        aQuicksort(a,left,partisjonering-1);
        aQuicksort(a,partisjonering+1, right);
    }




    public static void delsortering(int [] a){
        int pivot = sorter_2n(a);
        aQuicksort(a,0,pivot);
        aQuicksort(a,pivot+1,a.length-1);
    }

    //Oppgave 6
    public static void rotasjon(char [] a){
        int lengde = a.length;
        int siste_index = lengde-1;
        char siste_verdi = a[siste_index];
        for(int j = siste_index ; j >= 1; --j){
                a[j] = a[j-1];
        }
        a[0] = siste_verdi; // setter første verdi lik siste verdi
    }
    // versjon 2 av rotasjon metode
    public static void rotasjon2(char [] a){
        int lengde = a.length;
        int siste_index = lengde-1;
        char siste_verdi = a[siste_index];
        int teller = 0;
        char temp;
        //char old = a[0];
        //char _new = a[1];
        char old = a[0];
        char _new ;
        for(int j = 1; j <= siste_index; ++j){
           _new = old;
           old = a[j];
           a[j] = _new ;
        }
        a[0] = siste_verdi; // setter a[0] lik "siste_verdi"
    }
/*
    public static void rotasjon3(char [] a){
        int lengde = a.length;
        int siste_index = lengde-1;
        char siste_verdi = a[siste_index];
        char temp;
        for(int j =siste_index; j>0; --j){
            a[j] = a[j-1];
        }
        a[0] = siste_verdi; // setter a[0] lik "siste_verdi"
    }*/

    //Oppgave 6
    //Vi skal ta i bruk algoritmen i rotasjon2 metode
    public static void sirkel_rotasjon2(char [] a, int k){
        int lengde = a.length;
        int siste_index = lengde-1;
        char siste_verdi = a[siste_index];
        int teller = 0;
        char temp;
        // This is for exemp. my input array: {'A','B','C','D','E','F','G','H','I','J'};
        // I will group my array in n groups of the size |k|
        int antall_grupper = lengde/k;

            int spesial_index = siste_index-k; // in case lengde%k =1
            // byttet om første og siste blokk
            for (int j = 0; j < k ; j++) {
                bytt_char(a,j,siste_index-(k-j-1));
            }
            // output blir: H I J D E F G A B C
          // bytter om a[k] og a[spesial_index]
           bytt_char(a,k,spesial_index);
            //output blir nå: H I J G E F D A B C  k= 3 j= 3 siste_index=9
           /*                 0 1 2 3 4 5 6 7 8 9
           * H I J G E F D A B C
           *
           * */
           /*   // Trenger nå å rotere andre blokken
           for(int j =spesial_index-1; j>=k; --j){
               a[j] = a[j-2];
           }*/
           // Trenger nå å gjøre den tredje blokken til den andre blokken
           for(int j = k; j <spesial_index; ++j){
               bytt_char(a,j,siste_index+(k-j));
           }
           //Output blir: H I J C B A D F E G
           bytt_char(a,spesial_index-1,k);
          // H I J A B C D F E G
       }


    private static void bytt_char(char[] a, int j, int i) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void nySirkel_Rotasjon(char[] a, int k){
        if(k==0){
            return;
        }
        if(k>0){
            for(int j = 0; j<=k; k++){
                    bytt_char(a,j,j+k);
            }
        }
        else{

        }
    }

    public static void kompleks_bytting(char []a, int k){
        int x = 0, y=0;
        //tilfellet hvor k>0
        for(int i = 0 ; i<k+1; i++ ){
            char temp1 = a[x];
            char temp2 = a[y];

            a[x] = a[y];
            a[y] = temp1;
        }

    }
    public interface Pair<K, V> {
        public K getKey();
        public V getValue();
    }
public class char_indexPair{
        public char[]a;
        public int index;
        public char_indexPair(char[]a, int index){
            this.a = a;
            this.index = index;
            for (int i = 0; i < a.length ; i++) {
                return ;
            }
        }
}
 public static void char_indexPairing(char[]a, int k){
     for (int i = 0; i < a.length; i++) {

     }
    }
     //////////oppgave 6 på en ny måte
     public static int gcd(int a, int b){ //great common divisor. Dette er en funskjon som trenges for å vite antall
                                         // grupper eller blokker vi kommer å få når vi kommer til dele n elementer
                                        //av arrayet på grupper
         if(b==0){
             return a;
         }

        else return gcd(b,a%b);
     }

     public static int skjekkAntallSets(int n, int k){
        if(gcd(n,k) ==1){
            return n/k;
        }
        else return gcd(n,k);
     }

     public static void  sirkelRoterArrayTilVenstre(char[] a, int k){ //mot venstre
        // n er antall elemnter i arrayet
        // k er hvor mange posisjoner  vi vil  flytte arrayet sine elementer
         int d,j;
         char temp;
         int n = a.length;
         int gd = gcd(n,k);

         for (int i = 0; i < gd ; i++) { //outer loop - antall sets
             j = i;
             temp = a[i];

             while(1>0){ // kjører uendelig til at den "breaks"
                 d = (j+k) % n;
                 if(d == i){
                     break;
                 }
                 a[j] = a[d];
                 j = d;
             }
             a[j] = temp;
         }

     }
    public static void  sirkelRoterArrayTilHøyre(char[] a, int n, int k) { //mot høyre
        // n er antall elemnter i arrayet
        // k er hvor mange posisjoner  vi vil  flytte arrayet sine elementer
        int d, j;
        char temp, temp1;
        for (int i = 0; i < k ; i++) { //outer loop
             j = (n-k-i-1)%n;
             d = (j+k)%n;
             temp = a[d];
             while (0 < 1){                                 //alltid true betingelse
                  d = (j+k)%n;
                  if(j<0){                                  //her er stoppbetingelsen
                      break;
                  }

                  a[d] = a[j];
                  j = (j-k)%n;
             }
             a[(k-1+i)%k] = temp;

        }


    }

    public static void  sirkelRoterArrayTilHøyre1(char[] a, int k) { //mot høyre
        for (int i = 0; i < k; i++) {
            rotasjon(a);
        }
    }

    public static void rotasjon(char []a, int k){
        if(k>=0){
            sirkelRoterArrayTilHøyre1(a,k);
        }
        else{
            sirkelRoterArrayTilVenstre(a,Math.abs(k));
        }
    }
}
