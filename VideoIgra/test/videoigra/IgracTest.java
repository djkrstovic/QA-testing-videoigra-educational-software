package videoigra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class IgracTest {

    // definisanje delte
    private final double DELTA = 0.01;

    // definisanje promenljive napadac tipa Igrac
    private Igrac napadac;

    // definisanje promenljive meta tipa Igrac
    private Igrac meta;

    // kreiranje instance oruzje tipa klase Oruzje koriscenjem Mockito biblioteke
    private Oruzje oruzje = Mockito.mock(Oruzje.class);

    // kreiranje instance magija tipa klase Magija koriscenjem Mockito biblioteke
    private Magija magija = Mockito.mock(Magija.class);

    // kreiranje instance odeca tipa klase Odeca koriscenjem Mockito biblioteke
    private Odeca odeca = Mockito.mock(Odeca.class);



    // instance Liste(oruzje, magija, odeca), oruzja, odece, magije
    // pre izvrsavanja svakog testa
    // definisanje napadaca i mete
    @BeforeEach
    void startBefore() {
        ArrayList<Oruzje> oruzja = new ArrayList<>();

        ArrayList<Magija> magije = new ArrayList<>();

        ArrayList<Odeca> odece = new ArrayList<>();

        oruzja.add(oruzje);

        odece.add(odeca);

        magije.add(magija);



        // instanca napadac
        napadac = new Igrac("Napadac", 80, 80, 80, 80, Igrac.Stanje.AGRESIVNO, oruzja, odece, magije);


        // instanca meta
        meta= new Igrac("Meta", 90, 80, 90, 90, Igrac.Stanje.DEFANZIVNO, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    }



    // get i set metode neophodne za testiranje

    // testiranje get metode za naziv ako je igrac kreiran
    @Test
    void getNaziv_ShouldReturnNaziv_IfIgracIsCreated() {

        assertEquals("napadac", napadac.getNaziv());

    }


    // testiranje set metoda za postavljanje novog naziva napadaca
    @Test
    void setNaziv_ShouldSetNaziv() {

        napadac.setNaziv("Napadac1");
        String actual = napadac.getNaziv();
        assertEquals("Napadac1", actual);

    }


    // testiranje get metode za zdravlje ukoliko je igrac kreiran uz ocekivanu vrednost
    @Test
    void getZdravlje_ShouldReturnZdravlje_IfIgracIsCreated() {

        double actual = napadac.getZdravlje();
        assertEquals(80.0, actual, DELTA);

    }


    // testoranje set metode za zdravlje
    // treba da setuje novu vrednost za zdravlje
    @Test
    void setZdravlje_ShouldSetZdravlje() {

        napadac.setZdravlje(100.0);
        double actual = napadac.getZdravlje();
        assertEquals(100.0, actual,DELTA);

    }


    // testiranje get metode za energiju ukoliko je igrac kreiran
    @Test
    void getEnergija_ShouldReturnEnergija_IfIgracIsCreated() {

        double actual = napadac.getEnergija();

        assertEquals(80.0, actual, DELTA);

    }

    // testiranje set metode za postavljanje vrednosti energije igraca
    @Test
    void setEnergija_ShouldSetEnergija() {

        napadac.setEnergija(100.0);
        double actual = napadac.getEnergija();
        assertEquals(100.0, actual,DELTA);

    }


    // testiranje get metode za snagu koju igrac treba da ima ukoliko je kreiran
    @Test
    void getSnaga_ShouldReturnSnaga_IfIgracIsCreated() {

        int actual = napadac.getSnaga();
        assertEquals(80, actual);

    }



    // testiranje set metode za setovanje vrednosti snage
    @Test
    void setSnaga_ShouldSetSnaga() {

        napadac.setSnaga(100);
        int actual = napadac.getSnaga();
        assertEquals(100, actual);


    }


    // testiranje get metode za vrednost inteligencije ako je igrac kreiran
    @Test
    void getInteligencija_ShouldReturnInteligencija_IfIgracIsCreated() {

        int actual = napadac.getInteligencija();

        assertEquals(80, actual);

    }


    // testiranje set metode za vrednost inteligencija
    @Test
    void setInteligencija_ShouldSetInteligencija() {

        napadac.setInteligencija(100);
        int actual = napadac.getInteligencija();
        assertEquals(100, actual);

    }


    // testiranje get metode za vrednost stanja ako je igrac kreiran sa agresivnim stanjem
    @Test
    void getStanje_ShouldReturnStanjeAGRESINVO_IfIgracCreatedWithAgresivnoStanje() {

        assertEquals(Igrac.Stanje.AGRESIVNO, napadac.getStanje());

    }


    // testiranje get metode za vrednost stanja ukoliko je stanje defanzivno
    @Test
    void getStanje_ShouldReturnStanjeDEFAZIVNO() {

        napadac.setStanje(Igrac.Stanje.DEFANZIVNO);
        assertEquals(Igrac.Stanje.DEFANZIVNO, napadac.getStanje());

    }


    // testiranje get metode ukoliko je stanje pasivno
    @Test
    void getStanje_ShouldReturnStanjePASIVNO() {

        napadac.setStanje(Igrac.Stanje.PASIVNO);
        assertEquals(Igrac.Stanje.PASIVNO, napadac.getStanje());

    }


    // testiranje set metode stanja u vrednost PASIVNO
    @Test
    void setStanje_ShouldSetStanje() {

        napadac.setStanje(Igrac.Stanje.PASIVNO);
        assertEquals( Igrac.Stanje.PASIVNO, napadac.getStanje());

    }

    // testiranje get metode koja bi trebala da vrati listu oruzja
    // ako je igrac kreiran
    @Test
    void getOruzja_ShouldReturnAListOfOruzja_IfIgracIsCreated() {

        ArrayList<Oruzje> expected = new ArrayList<>();
        expected.add(oruzje);
        assertEquals(expected, napadac.getOruzja());

    }


    // testiranje set metode koja treba da setuje listu oruzja
    @Test
    void setOruzja_ShouldSetArrayListOfOruzja() {

        // kreiranje liste ocekivanih vrednosti oruzja
        ArrayList<Oruzje>  expected = new ArrayList<>();

        // dodavanje oruzja u ocekivanu vrednost
        expected.add(oruzje);

        // dodavanje instance uz pomoc Mockito
        expected.add(Mockito.mock(Oruzje.class));

        // setovanje ocekivane vrednosti oruzja napadacu
        napadac.setOruzja(expected);

        // poredjenje ocekivane i aktuelne vrednosti oruzja
        assertEquals(expected, napadac.getOruzja());

    }



    // testiranje get metode za odecu koja treba da vrati listu odece
    // ako je igrac kreiran
    @Test
    void getOdeca_ShouldReturnArrayListOfOdeca_IfIgracIsCreated() {

        ArrayList<Odeca> expected = new ArrayList<>();
        expected.add(odeca);
        assertEquals(expected, napadac.getOdeca());

    }


    // testiranje set metode za setovanje odece kroz kreiranje liste, dodavanje
    // dodavanje vrednosti u listu, kreiranje instance i dodavanje u istu, i na
    // i na kraju poredjenje
    @Test
    void setOdeca_ShouldSetArrayListOfOdeca() {

        ArrayList<Odeca> expected = new ArrayList<>();

        expected.add(odeca);

        expected.add(Mockito.mock(Odeca.class));

        napadac.setOdeca(expected);

        assertEquals(expected, napadac.getOdeca());

    }


    // testiranje getMagije metode treba da vrati listu magija ako igrac postoji
    // kroz kreiranje liste magija i poredjenje
    @Test
    void getMagije_ShouldReturnAListOfMagije_IfIgracCreated() {

        ArrayList<Magija> expected = new ArrayList<>();
        expected.add(magija);
        assertEquals(expected, napadac.getMagije());

    }

    // testiranje metode za setovanje magije, odnosno liste koja sadrzi magije
    @Test
    void setMagije_ShouldSetArrayListOfMagija() {

        ArrayList<Magija> expected = new ArrayList<>();

        expected.add(Mockito.mock(Magija.class));

        expected.add(magija);

        napadac.setMagije(expected);

        assertEquals(expected, napadac.getMagije());

    }


    // testiranje metode za ispis
    @Test
    void toString_ShouldReturnAnAdequateString_IfIgracIsCreated(){
        assertEquals("(Napadac, 80.0/80.0, STR:80, INT:80)", napadac.toString());
    }


    // testiranje metode za napad na igraca, odnosno metu, ukoliko je energija setovana na 20
    @Test
    void napadniIgraca_ShouldReturn0_IfNapadacEnergyIs20() {

        napadac.setEnergija(20.0);

        napadac.setSnaga(49);

        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(50.0);

        Mockito.when(napadac.getOruzja().get(0).getSteta())
                .thenReturn(50.0);

        double expected = 0;

        double actual = napadac.napadniIgraca(0, meta);

        assertEquals(expected, actual,DELTA);

    }


    // testiranje metode napadaniIgraca ukoliko npadac ima energiju manju od 20
    // u tom slucaju steta se setuje na vrednost  0
    @Test
    void  napadniIgraca_ShouldReturn0_IfNapadacHasEnergyLessThen20(){

        napadac.setEnergija(19.0);

        napadac.setSnaga(49);

        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(40.0);

        Mockito.when(napadac.getOruzja().get(0).getSteta()).
                thenReturn(40.0);

        double expected = 0;

        double actual = napadac.napadniIgraca(0, meta);

        assertEquals(expected, actual, DELTA);


    }




    // null pointer & index of bound
    @Test
    void napadniIgraca_ShouldThrowAnIllegalArgumentException_IfAtLeastOneOruzjeIsNull() {

        napadac.getOruzja().add(null);

        // hendlujemo izuzetke uz pomoc IllegalArgumentException jer nije logicno da program "pukne"
        assertThrows(IllegalArgumentException.class,()->{
            napadac.napadniIgraca(napadac.getOruzja().size()-1,meta);});

    }


    // null pointer & index of bound
    @Test
    void napadniIgraca_ShouldThrowAnIllegalArgumentException_IfIndexOfArrayListOruzjeDoesNotExist() {


        napadac.getOruzja().add(null);


        // hendlujemo izuzetke uz pomoc IllegalArgumentException jer nije logicno da program "pukne"
        assertThrows(IllegalArgumentException.class,()->{
            napadac.napadniIgraca(napadac.getOruzja().size(),meta);});

    }




    // testiranje metode napadniIgraca ukoliko igrac ima vise od 20 energije - potrosi 21 bod za energiju
    // Takodje odredjuje se steta koju ce oruzje napadaca naneti. Ukoliko napadac nema dovoljno snage da koristi
    // oruzje steta ce biti duplo manja (50%)

    // Slucaj kada je energija veca od 20 a snaga manja od potrebne u zavisnosti od stanja, odnosno da li
    // napadac ima jedno od ponudjenih stanja (defanzivno, pasivno, agresivno)

    // defanzivno stanje
    @Test
    void napadniIgraca_ShouldReturnStetaHalfStetaOruzja_IfNapadacEnergyIsGreaterThan20AndStrengthLessThanNeeded_WhenStanjeDefanzivno() {

        napadac.setEnergija(21.0);

        napadac.setSnaga(49);

        napadac.setStanje(Igrac.Stanje.DEFANZIVNO);


        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(100.0);


        Mockito.when(napadac.getOruzja().get(0).getSteta())
                .thenReturn(100.0);

        double expected = (napadac.getOruzja().get(0).getSteta() / 2 + (napadac.getSnaga() * 2)) * 0.8;

        double actual = napadac.napadniIgraca(0, meta);
       
    }
    
    // pasivno stanje
    @Test
    void napadniIgraca_ShouldReturnStetaHalfStetaOruzja_IfNapadacEnergyIsGreaterThan20AndStrengthLessThanNeeded_WhenStanjePasivno() {

        napadac.setEnergija(21.0);

        napadac.setSnaga(49);

        napadac.setStanje(Igrac.Stanje.PASIVNO);


        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(100.0);


        Mockito.when(napadac.getOruzja().get(0).getSteta())
                .thenReturn(100.0);


        double expected = (napadac.getOruzja().get(0).getSteta() / 2 + (napadac.getSnaga() * 2));

        double actual = napadac.napadniIgraca(0, meta);

        assertEquals(expected, actual, DELTA);
    }

    // agresivno stanje
    @Test
    void napadniIgraca_ShouldReturnStetaHalfStetaOruzja_IfNapadacEnergyIsGreaterThan20AndStrengthLessThanNeeded_WhenStanjeAgresivno() {

        napadac.setEnergija(21.0);

        napadac.setSnaga(49);

        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(100.0);


        Mockito.when(napadac.getOruzja().get(0).getSteta())
                .thenReturn(100.0);


        double expected = (napadac.getOruzja().get(0).getSteta() / 2 + (napadac.getSnaga() * 2))*1.2;

        double actual = napadac.napadniIgraca(0, meta);

        assertEquals(expected, actual, DELTA);
    }

    // Slucaj kada je energija veca od 20, snaga veca od potrebne snage pri nekom od stanja (defanzivno,pasivno,agresivno)

    // defanzivno stanje
    @Test
    void napadniIgraca_ShouldReturnSteta_IfNapadacEnergyIsGreaterThan20AndStrengthGreaterThanNeeded_WhenStanjeDefanzivno() {

        napadac.setEnergija(21.0);

        napadac.setStanje(Igrac.Stanje.DEFANZIVNO);


        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(60.0);


        Mockito.when(napadac.getOruzja().get(0).getSteta())
                .thenReturn(60.0);


        double expected = (napadac.getOruzja().get(0).getSteta()  + (napadac.getSnaga() * 2)) * 0.8;

        double actual = napadac.napadniIgraca(0, meta);

        assertEquals(expected, actual, DELTA);
    }

    // pasivno stanje
    @Test
    void napadniIgraca_ShouldReturnSteta_IfNapadacEnergyIsGreaterThan20AndStrengthGreaterThanNeeded_WhenStanjePasivno() {

        napadac.setEnergija(21.0);

        napadac.setStanje(Igrac.Stanje.PASIVNO);


        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(50.0);


        Mockito.when(napadac.getOruzja().get(0).getSteta())
                .thenReturn(50.0);


        double expected = (napadac.getOruzja().get(0).getSteta() / 2 + (napadac.getSnaga() * 2));

        double actual = napadac.napadniIgraca(0, meta);

        assertEquals(expected, actual, DELTA);

    }

    // agresivno stanje
    @Test
    void napadniIgraca_ShouldReturnSteta_IfNapadacEnergyIsGreaterThan20AndStrengthGreaterThanNeeded_WhenStanjeAgresivno() {

        napadac.setEnergija(21.0);

        napadac.setSnaga(50);

        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(40.0);


        Mockito.when(napadac.getOruzja().get(0).getSteta())
                .thenReturn(40.0);


        double expected = (napadac.getOruzja().get(0).getSteta()  + (napadac.getSnaga() * 2)) * 1.2;

        double actual = napadac.napadniIgraca(0, meta);

        assertEquals(expected, actual, DELTA);
    }

    // slucaj kada je energija veca od 20, a snaga jednaka potrebnoj snazi


    // pasivno stanje
    @Test
    void napadniIgraca_ShouldReturnStetaHalfStetaOruzja_IfNapadacEnergyIsGreaterThan20AndStrengthEqualWithNeeded_WhenStanjePasivno() {

        napadac.setEnergija(21.0);

        napadac.setSnaga(100);

        napadac.setStanje(Igrac.Stanje.PASIVNO);


        Mockito.when(napadac.getOruzja().get(0).getPotrebnaSnaga())
                .thenReturn(100.0);


        Mockito.when(napadac.getOruzja().get(0).getSteta())
                .thenReturn(100.0);


        double expected = (napadac.getOruzja().get(0).getSteta()  + (napadac.getSnaga() * 2));

        double actual = napadac.napadniIgraca(0, meta);

       assertEquals(expected, actual, DELTA);
    }

    // metoda odbraniSe

    // testiranje metode odbraniSe koja rteba da izbaci izuzetak ukoliko je bar jedna
    // vrednost oruzja setovana na null
    @Test
    void odbraniSe_ShouldThrowAnIllegalArgumentException_IfAtLeastOneOruzjeIsNull() {

        napadac.getOruzja().add(null);

        assertThrows(IllegalArgumentException.class,()->{

            napadac.odbraniSe(10);});

    }

    // ako je odeca setovana na null
    @Test
    void odbraniSe_ShouldThrowAnIllegallDolaznaStetaException_IfAtLeastOneOdecaIsNull() {

        napadac.getOdeca().add(null);

        assertThrows(IllegalArgumentException.class,()->{

            napadac.odbraniSe(10);});

    }



    // ako je dolaznaSteta manja od 0
    @Test
    void odbraniSe_ShouldThrowAnIllegalArgumentException_IfDolaznaStetaIsLessThan0() {

        assertThrows(IllegalArgumentException.class, () -> napadac.odbraniSe(-15));

    }

    // ako je dolaznaSteta minus jedan (-1)
    @Test
    void odbraniSe_ShouldThrowAnIllegalArgumentException_IfDolaznaStetaIsMinus1() {

        assertThrows(IllegalArgumentException.class, () -> napadac.odbraniSe(-1));



    }

    // IllegalArgumentException
    @Test
    void odbraniSe_ShouldThrowAnIllegalArgumentException_IfDolaznaStetaIs0() {

        assertThrows(IllegalArgumentException.class, () -> napadac.odbraniSe(0));

    }





    // u specifikaciji je navedeno da se ovom metodu moze proslediti 0 i zbog toga testiramo sledeci slucaj
    @Test
    void odbraniSe_ShouldReturnSteta_IfDolaznaStetaIs0AndEquipmentWeightLessThanMaxWeight_WhenStanjeAgresivno() {

        napadac.setSnaga(10);

        Mockito.when(napadac.getOdeca().get(0).getOdbrambenaVrednost())
                .thenReturn(10.0);


        Mockito.when(napadac.getOdeca().get(0).getTezina())
                .thenReturn(10.0);


        Mockito.when(napadac.getOruzja().get(0).getTezina())
                .thenReturn(10.0);


        double expected = 0;

        double actual = napadac.odbraniSe(0);

        assertEquals(expected, actual, DELTA);

    }



    // defanzivno stanje
    @Test
    void odbraniSe_ShouldReturnSteta_IfDolaznaStetaGreaterThan0AndEquipmentWeightGreaterThanMaxWeigh_WhenStanjeDefanzivno() {

        napadac.setSnaga(10);

        napadac.setStanje(Igrac.Stanje.DEFANZIVNO);

        Mockito.when(napadac.getOdeca().get(0).getOdbrambenaVrednost())
                .thenReturn(10.0);


        Mockito.when(napadac.getOdeca().get(0).getTezina())
                .thenReturn(10.0);


        Mockito.when(napadac.getOruzja().get(0).getTezina())
                .thenReturn(21.0);


        double expected = 20*1.5/ (0.9*napadac.getOdeca().get(0).getOdbrambenaVrednost() *0.25 );

        double actual = napadac.odbraniSe(20);


        assertEquals(expected, actual, DELTA);

    }



    // stanje pasivno
    // pozitivna dolazna steta, tezina opreme veca od max tezine
    @Test
    void odbraniSe_ShouldReturnSteta_IfDolaznaStetaGreaterThan0AndEquipmentWeightGreaterThanMaxWeight_WhenStanjePasivno() {

        napadac.setStanje(Igrac.Stanje.PASIVNO);

        napadac.setSnaga(10);

        Mockito.when(napadac.getOdeca().get(0).getOdbrambenaVrednost())
                .thenReturn(10.0);


        Mockito.when(napadac.getOdeca().get(0).getTezina())
                .thenReturn(10.0);


        Mockito.when(napadac.getOruzja().get(0).getTezina())
                .thenReturn(21.0);

        double expected = 20*1.5/ (0.9*napadac.getOdeca().get(0).getOdbrambenaVrednost() * 0.15);

        double actual = napadac.odbraniSe(20);

        assertEquals(expected, actual, DELTA);

    }



    // agresivno stanje
    @Test
    void odbraniSe_ShouldReturnSteta_IfDolaznaStetaGreaterThan0AndEquipmentWeightGreaterThanMaxWeight_WhenStanjeAgresivno() {

        napadac.setSnaga(10);

        Mockito.when(napadac.getOdeca().get(0).getOdbrambenaVrednost())
                .thenReturn(10.0);


        Mockito.when(napadac.getOdeca().get(0).getTezina())
                .thenReturn(10.0);


        Mockito.when(napadac.getOruzja().get(0).getTezina())
                .thenReturn(21.0);


        double expected = 20*1.5/(0.9*napadac.getOdeca().get(0).getOdbrambenaVrednost() * 0.08);

        double actual = napadac.odbraniSe(20);

        assertEquals(expected, actual, DELTA);

    }




    // Slucaj kada su pozitivna dolazna steta i tezina opreme manje od max tezine
    @Test
    void odbraniSe_ShouldReturnSteta_IfDolaznaStetaGreaterThan0AndEquipmentWeightLessThanMaxWeight_WhenStanjeDefanzivno() {

        napadac.setSnaga(10);

        napadac.setStanje(Igrac.Stanje.DEFANZIVNO);

        Mockito.when(napadac.getOdeca().get(0).getOdbrambenaVrednost())
                .thenReturn(10.0);


        Mockito.when(napadac.getOdeca().get(0).getTezina())
                .thenReturn(10.0);


        Mockito.when(napadac.getOruzja().get(0).getTezina())
                .thenReturn(10.0);


        double expected = 20/(napadac.getOdeca().get(0).getOdbrambenaVrednost() * 0.3);

        double actual = napadac.odbraniSe(20);

        assertEquals(expected, actual, DELTA);

    }



    // pasivno stanje
    @Test
    void odbraniSe_ShouldReturnSteta_IfDolaznaStetaGreaterThan0AndEquipmentWeightLessThanMaxWeight_WhenStanjePasivno() {

        napadac.setSnaga(10);

        napadac.setStanje(Igrac.Stanje.PASIVNO);

        Mockito.when(napadac.getOdeca().get(0).getOdbrambenaVrednost())
                .thenReturn(10.0);


        Mockito.when(napadac.getOdeca().get(0).getTezina())
                .thenReturn(10.0);


        Mockito.when(napadac.getOruzja().get(0).getTezina())
                .thenReturn(10.0);


        double expected = 20/(napadac.getOdeca().get(0).getOdbrambenaVrednost() * 0.2);

        double actual = napadac.odbraniSe(20);

        assertEquals(expected, actual, DELTA);

    }



    // agresivno stanje
    @Test
    void odbraniSe_ShouldReturnSteta_IfDolaznaStetaGreaterThan0AndEquipmentWeightLessThanMaxWeight_WhenStanjeAgresivno() {

        napadac.setSnaga(10);

        Mockito.when(napadac.getOdeca().get(0).getOdbrambenaVrednost())
                .thenReturn(10.0);


        Mockito.when(napadac.getOdeca().get(0).getTezina())
                .thenReturn(10.0);


        Mockito.when(napadac.getOruzja().get(0).getTezina())
                .thenReturn(10.0);


        double expected = 20/(napadac.getOdeca().get(0).getOdbrambenaVrednost() * 0.1);

        double actual = napadac.odbraniSe(20);

        assertEquals(expected, actual, DELTA);

    }


    // agreisvno stanje
    @Test
    void odbraniSe_ShouldReturnSteta_IfDolaznaStetaGreaterThan0AndMaxWeightEqualToEquipmentWeight_WhenStanjeAgresivno() {

        napadac.setSnaga(10);
        Mockito.when(napadac.getOdeca().get(0).getOdbrambenaVrednost())
                .thenReturn(10.0);


        Mockito.when(napadac.getOdeca().get(0).getTezina())
                .thenReturn(10.0);


        Mockito.when(napadac.getOruzja().get(0).getTezina())
                .thenReturn(20.0);


        double expected = 10/(napadac.getOdeca().get(0).getOdbrambenaVrednost() * 0.1);

        double actual = napadac.odbraniSe(10);

        assertEquals(expected, actual, DELTA);

    }



    // metoda upotrebiMagiju

    // ako inteligencija vise od megije
    @Test
    void upotrebiMagiju_ShouldReturnSteta_IfInteligencijaGreaterThanMagijaInteligencijaAndEnergyLessThanMagijaEnergy_WhenNapadacHasEnoughHealth() {

        napadac.setEnergija(10);

        napadac.setZdravlje(100.0);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaInteligencija())
                .thenReturn(10.0);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaEnergija())
                .thenReturn(50.0);


        Mockito.when(napadac.getMagije().get(0).getSteta())
                .thenReturn(10.0);


        double expected = napadac.getMagije().get(0).getSteta() * (napadac.getInteligencija() * 0.1 +
                (napadac.getInteligencija() - napadac.getMagije().get(0).getPotrebnaInteligencija()) +
                (napadac.getInteligencija() - meta.getInteligencija()));


        assertEquals(expected, napadac.upotrebiMagiju(0, meta), DELTA);

    }



    // inteligencija jednaka magiji
    @Test
    void upotrebiMagiju_ShouldReturnSteta_IfInteligencijaEqualToMagijaInteligencijaAndEnergyLessThanMagijaEnergy_WhenNapadacHasEnoughHealth() {

        napadac.setEnergija(10);

        napadac.setZdravlje(100.0);

        napadac.setInteligencija(100);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaInteligencija())
                .thenReturn(100.0);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaEnergija())
                .thenReturn(50.0);


        Mockito.when(napadac.getMagije().get(0).getSteta())
                .thenReturn(10.0);


        double expected = napadac.getMagije().get(0).getSteta() * (napadac.getInteligencija() * 0.1 +
                (napadac.getInteligencija() - napadac.getMagije().get(0).getPotrebnaInteligencija()) +
                (napadac.getInteligencija() - meta.getInteligencija()));


        assertEquals(expected, napadac.upotrebiMagiju(0, meta), DELTA);

    }


    // null pointer // exception IndexOutOfBound
    @Test
    void upotrebiMagiju_ShouldThrowAnIllegalArgumentException_IfAtLeastOneMagijaIsNull() {

        napadac.getMagije().add(null);

        napadac.setInteligencija(100);

        napadac.setEnergija(0);

        napadac.setZdravlje(100.0);

        assertThrows(IllegalArgumentException.class,
                ()-> napadac.upotrebiMagiju(napadac.getMagije().size()-1,meta));

    }



    // IllegalArgumentException izuzetak ako lista magija ne postoji
    @Test
    void upotrebiMagiju_ShouldThrowAnIllegalArgumentException_IfIndexOfListMagijeDoesNotExist() {

        napadac.getMagije().add(null);

        napadac.setInteligencija(100);

        napadac.setEnergija(0);

        napadac.setZdravlje(100.0);

        assertThrows(IllegalArgumentException.class,
                ()-> napadac.upotrebiMagiju(napadac.getMagije().size(),meta));

    }



    @Test
    void upotrebiMagiju_ShouldReturn0_IfInteligencijaGreaterThanMagijaInteligencijaAndEnergyLessThanMagijaEnergy_WhenNapadacDoesNotHaveEnoughHealth() {

        napadac.setEnergija(10);

        napadac.setZdravlje(10.0);

        napadac.setInteligencija(100);

        Mockito.when(napadac.getMagije().get(0).getPotrebnaInteligencija())
                .thenReturn(10.0);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaEnergija())
                .thenReturn(50.0);


        Mockito.when(napadac.getMagije().get(0).getSteta())
                .thenReturn(10.0);


        assertAll(
                () -> assertEquals(napadac.getZdravlje() - magija.getPotrebnaEnergija() + napadac.getEnergija(), napadac.getZdravlje(), 0.001,"zdravlje"),
                () -> assertEquals(0, napadac.getEnergija(), 0.001,"energija"),
                () -> assertEquals(0, napadac.upotrebiMagiju(0, meta), 0.001,"steta")
        );


    }




    @Test
    void upotrebiMagiju_ShouldReturnSteta_IfInteligencijaGreaterThanMagijaInteligencijaAndEnergyGreaterThanMagijaEnergy_WhenNapadacDoesNotHaveEnoughHealth() {

        double energijaNapadaca=100.0;

        double zdravljeNapadaca= 10.0;

        napadac.setEnergija(energijaNapadaca);

        napadac.setZdravlje(zdravljeNapadaca);

        napadac.setInteligencija(100);

        Mockito.when(napadac.getMagije().get(0).getPotrebnaInteligencija())
                .thenReturn(10.0);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaEnergija())
                .thenReturn(50.0);


        Mockito.when(napadac.getMagije().get(0).getSteta())
                .thenReturn(10.0);


        double expected = napadac.getMagije().get(0).getSteta() * (napadac.getInteligencija() * 0.1 +
                (napadac.getInteligencija() - napadac.getMagije().get(0).getPotrebnaInteligencija()) +
                (napadac.getInteligencija() - meta.getInteligencija()));


        assertAll(
                () -> assertEquals(zdravljeNapadaca, napadac.getZdravlje(), DELTA,"zdravlje"),
                () -> assertEquals(energijaNapadaca - magija.getPotrebnaEnergija(), napadac.getEnergija(),DELTA,"energija"),
                () -> assertEquals(expected, napadac.upotrebiMagiju(0, meta), DELTA)
        );

    }



    @Test
    void upotrebiMagiju_ShouldReturnSteta_IfInteligencijaLessThanMagijaInteligencijaAndEnergyLessThanMagijaEnergy_WhenNapadacHasEnoughHealth() {

        double energijaNapadaca = 10.0;

        double zdravljeNapadaca = 100.0;

        napadac.setEnergija(energijaNapadaca);

        napadac.setZdravlje(zdravljeNapadaca);

        napadac.setInteligencija(10);

        Mockito.when(napadac.getMagije().get(0).getPotrebnaInteligencija())
                .thenReturn(100.0);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaEnergija())
                .thenReturn(50.0);


        Mockito.when(napadac.getMagije().get(0).getSteta())
                .thenReturn(10.0);


        double expected = napadac.getMagije().get(0).getSteta() * (napadac.getInteligencija() * 0.1 +
                (napadac.getInteligencija() - napadac.getMagije().get(0).getPotrebnaInteligencija()) +
                (napadac.getInteligencija() - meta.getInteligencija()));


        double actual = napadac.upotrebiMagiju(0, meta);

        assertAll(
                () -> assertEquals((0.9 * zdravljeNapadaca) - magija.getPotrebnaEnergija() + 0, napadac.getZdravlje(), DELTA),
                () -> assertEquals(0, napadac.getEnergija(), DELTA),
                () -> assertEquals(expected, actual, DELTA)
        );

    }

    @Test
    void upotrebiMagiju_ShouldReturnSteta_IfInteligencijaLessThanMagijaInteligencijaAndEnergyEqualToMagijaEnergy_WhenNapadacHasEnoughHealth() {

        double energijaNapadaca = 50.0;

        double zdravljeNapadaca = 100.0;

        napadac.setEnergija(energijaNapadaca);

        napadac.setZdravlje(zdravljeNapadaca);

        napadac.setInteligencija(10);

        Mockito.when(napadac.getMagije().get(0).getPotrebnaInteligencija())
                .thenReturn(100.0);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaEnergija())
                .thenReturn(50.0);


        Mockito.when(napadac.getMagije().get(0).getSteta())
                .thenReturn(10.0);


        double expected = napadac.getMagije().get(0).getSteta() * (napadac.getInteligencija() * 0.1 +
                (napadac.getInteligencija() - napadac.getMagije().get(0).getPotrebnaInteligencija()) +
                (napadac.getInteligencija() - meta.getInteligencija()));


        double actual = napadac.upotrebiMagiju(0, meta);


        assertAll(
                () -> assertEquals((0.9 * zdravljeNapadaca) - magija.getPotrebnaEnergija() + 0, napadac.getZdravlje(), DELTA,"zdravlje"),
                () -> assertEquals(0, napadac.getEnergija(), DELTA,"energija"),
                () -> assertEquals(expected, actual, DELTA,"steta")
        );


    }


    @Test
    void upotrebiMagiju_ShouldReturn0_IfInteligencijaLessThanMagijaInteligencija_WhenNapadacDoesNotHaveEnoughHealth() {

        double energijaNapadaca = 10.0;

        double zdravljeNapadaca = 10.0;

        napadac.setEnergija(energijaNapadaca);

        napadac.setZdravlje(zdravljeNapadaca);

        napadac.setInteligencija(10);

        Mockito.when(napadac.getMagije().get(0).getPotrebnaInteligencija())
                .thenReturn(100.0);


        Mockito.when(napadac.getMagije().get(0).getPotrebnaEnergija())
                .thenReturn(50.0);


        Mockito.when(napadac.getMagije().get(0).getSteta())
                .thenReturn(10.0);



        double actual = napadac.upotrebiMagiju(0, meta);



        assertAll(
                () -> assertEquals((0.9 * zdravljeNapadaca) - magija.getPotrebnaEnergija() + 0, napadac.getZdravlje(), DELTA,"zdravlje"),
                () -> assertEquals(0, napadac.getEnergija(), DELTA, "energija"),
                () -> assertEquals(0, actual, DELTA,"steta")
        );

    }




    //  parametri za metodu odmoriSe
    private static Stream<Arguments> parametri() {

        return Stream.of(

                Arguments.of(75,0,75),

                Arguments.of(76,0,76),

                Arguments.of(100,0,100),

                Arguments.of(91,0,91),

                Arguments.of(0,50,50),

                Arguments.of(35,50,85),

                Arguments.of(48,50,98),

                Arguments.of(50,50,100),

                Arguments.of(51,49,100),

                Arguments.of(60,40,100),

                Arguments.of(2,50,52)

        );
    }




    // parametrizovani test
    @ParameterizedTest
    @MethodSource(value = "parametri")
    public void odmoriSe_ShouldReturnAdequateValue(double energija, double oporavak, double novaEnergija) {


        napadac.setEnergija(energija);

        double actual = napadac.odmoriSe();


        assertAll(
                () -> assertEquals(oporavak, actual, DELTA, "Oporavak."),
                () -> assertEquals(novaEnergija, napadac.getEnergija(), DELTA, "Nova energija!")
        );


    }

}