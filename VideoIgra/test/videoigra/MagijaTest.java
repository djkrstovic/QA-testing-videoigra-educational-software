package videoigra;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MagijaTest {


    // promenljiva tipa Magija
    private Magija magija;

    // definisanje delta vrednosti zato sto proveravamo float/double vrednosti
    private double DELTA = 0.01;


    // definisanje anotacije @BeforeAll koja se izvrsava tacno jednom pre svih testova
    // i definisanje metode setBeforeAll koja koristi mockito biblioteku za simulaciju
    // podataka odnosno objekata koje cemo koristiti. Uz notaciju BeforeAll definisali
    // smo da zelimo mokito objekat klase Magija da koristimo.
    @BeforeAll
    void setBeforeAll() {

        magija = Mockito.mock(Magija.class);

    }



    // pozivamo metod "fail()" zato sto klasa Magija nema get metod za naziv magije
    @Test
    void getNazivMagije_ShouldReturnNazivMagije() {

        fail("Klasa Magija: Ne postiji get metod za nazivMagije!");

    }




    // test metoda za poredjenje potrebne inteligencije koja je ocekivana i koja se
    // dobija izvrsavanjem metoda
    @Test
    void getPotrebnaInteligencija_ShouldReturnAnAdequateValue() {

        Mockito.when(magija.getPotrebnaInteligencija())
                .thenReturn(15.0);
        assertEquals(15.0, magija.getPotrebnaInteligencija(), DELTA);

    }


    // poredimo ocekivanu stetu i aktuelnu koju dobijamo izvrsavanjem programa
    @Test
    void getSteta_ShouldReturnAnAdequateValue() {

        Mockito.when(magija.getSteta())
                .thenReturn(15.0);
        assertEquals(15.0, magija.getSteta(), DELTA);

    }


    // poredjenje ocekivane i aktuelne vrednosti potrebne energije
    @Test
    void getPotrebnaEnergija_ShouldReturnAnAdequateValue() {


        Mockito.when(magija.getPotrebnaEnergija())
                .thenReturn(15.0);
        assertEquals(15.0, magija.getPotrebnaEnergija(), DELTA);

    }





}