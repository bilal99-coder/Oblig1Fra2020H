Bilal Sahli: s339603

Oppgave 1: 
Jeg bruker en static funskjon som tar et array som parameter og returnerer det største verdien i arrayet. 
Funskjonen skjekker først om tabellen er tom. 
Hvis ikke så looper funksjonen over alle verdiene. 
Konseptet er å få den største verdien bakerst på arrayet,ved å sammenligne hver verdien med verdien i indeksen foran
og bytter mellom de hvis den som er foran er større enn den som er etter.
Vi bruker metoden bytt til å bytte om to gitte verdier i et gitt array A, men bytt tar indeksene til de verdiene som argument. 

Teoretiske spørsmål er besvart på en kommentar i  Oblig1.java. 
Jeg har laget en egen metode som heter ombytninger som tar et array som parameter, og teller antall ombytninger som 
skjer i gjennomsnitt. Testen ga at det er 4 ombyttninger i gjennomsnitt. 
Tilhørende testen er:
@org.junit.jupiter.api.Test
void ombytninger()

Alle Tester ligger på Oblig1Test.java 


Oppgave2:
Metoden skal telleantall ulike verdier i en sortert tabell. 
Metoden aksepterer tomme tabeller og returnerer i dette tilfellet 0.
Metoden skjekker om tabbelen er sortert stigende og hvis den ikke er sortert
så kaster den exception. Metoden kaller funksjonen sjekkSortert som returnerer true eller false for å skjekke om tabellen
er riktig sortert. 
Siden input tabellen skal være sortert stigende så holder det med å loope gjennom tabellen og sammenligne mellom hver verdi 
i arrayet og verdien foran. Hvis de ikke er like (to sammenlignete verdiene) så øker antallUlike variablen med 1. 
Etter at vi har loopet over hele arrayet så returnerer metoden variaben antallUlike; som er lik antall ulike verdier i arrayet.

@Test
void antallUlikeSortert() --> er tilhørende testen. 

Oppgave3: 
Metoden i oppgaven 3 skal telle antall ulike verdier i et gitt usortert tabell. 
Et tom tabell er ikke regnet som Exception.Hvis den er tom så returneres det 0. 
Jeg bruker to loops, en ytre og en indre. 
Metoden looper gjennom hver eneste element i arrayet og så lopper over alle verdiene før den elementet, Hvis vi ikke 
finner en element som er lik verdien så oppdatere vi boolean finnesFraFoor lik false og øker vi antallUlike variablen med 1. 
Hvis verdien finnes fra før så setter vi finnesFraFoor lik true, og da gjør vi ingenting og vi går videre til neste elementet, 
og skjekker igjen med alle elementene foran til at vi har loopet over alle veridene i arrayet. 
Når vi er ferdig så returnerer vi variablen antallUlike.
Tilhørende test er:  @Test
void antallUlikeSortert() 

Oppgave4: 
metoden public static void delsortering(int[]a).
Den skal dele tabellen a i to sorterte deler.Venstre delen skal inneholde kunne odde tallene sortert stigende
og høyre delen skal ha partallene sortert stigende.
Det er to hjelpe metoder som delsortering kaller. 
-> sorter_2n(int [] a) som tar arrayet og deler den paa to deler: venstre delen har alle odde tallene og hooyre delen har
alle partallene. Metoden bruker quicksort algoritmen for å kunne skille mellom partallene og oddetallene. Metoden 
sorterer ikke arrayet stigende men bare deler den på to deler.
sorter_2n(int [] a) returner en pivot som er indeksen hvor partall delen startet altsaa grenser mellom partallene og oddetallene.
Etter at vi har naa visst hvor vaart pivot ligger Så kaller vi aQuicksort(int []a, pivot) som sorterer venste delen av 
arrayet som har alle oddetall. Deretter kaller vi aQuicksort(pivot+1,a.length-1) som sorterer hooyre delen altsaa partallene. 
Etter dette så har vi et output array som har to deler: En venstre del med kun odde tall sortert stigende. 
En hooyre del som har partall sortert stigende. 
aQuicksort er en rekursiv  metode som bruker metoden partisjonerr(int [] a, int pivot_index, int left, int right) som en 
del av arrayet begrenset mellom [left, right]

Oppgave5:
public static void rotasjon(char [] a) er en metode som tar inn et array. Den lagrer først elementet på en variabel 
og så looper over arrayet. Den starter fra siste indeksen og bytter hver element med den verdien foran den. Metoden roterer 
arrayet en posisjon mot hooyre. 

Jeg lagde også en annen metode void rotasjon2 som gjør det samme som void rotasjon.
Void rotasjon2 tar inn et array og roterer den også en posisjon mot hoore men algoritmen er litt forskjellig enn den i forrige metoden.
Metoden bruker to hjelpe variabler old og _new, old lagrer verdien til den første elementen av to valgte elementer. 
Den oppdateres hver gang vi  inkrementerer med 1. Den andre elementen av to valgte elementer blir lik _new som er lik old som 
er verdien til elementet foran. osv ...


Oppgave6: 
I oppgaven 6 så har jeg tatt den vanskelige veien, Jeg har sett på arrayet som en en mengde av sets eller grupper av tall. 
Så når vi flytter arrayet med k posisjoner så bytter de gruppene posisjonen også. Jeg har observert hvordan de gruppene 
oppfører seg i forhold til en gitt parameter k. Etter flere og flere forsøk for finne den riktige algoritmen så har jeg kommet 
til en blind vei og da måtte jeg skjekke på internett. Det viste seg at det jeg prøvde å gjøre var en allerede etablert algoritme
som heter juggling algoritme. Etter å ha sett på den så visste jeg hvor jeg har bugg-en og så metoden min fungerte på riktig måten. 
Den algortimen roterer arrayet mot venstre k posisjoner, den kan brukes for å rotere mot hooyre også men jeg valgte å bruke 
metoden fra oppgaven 5, og kalle den k ganger ved hjelp av en for lookke. 
Tilhoorende testen er:
@Test
void testRotasjon()