package videoigra;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

// @TestInstance izvrsava sve test metode u istoj instanci
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OdecaTest {
    // definisemo promenljivu tipa Odeca
    private Odeca odeca;
    // definisanje delta vrednosti zato sto proveravamo float/double vrednosti
    private double DELTA = 0.01;


    // definisanje anotacije @BeforeAll koja se izvrsava tacno jednom pre svih testova
    // i definisanje metode setBeforeAll koja koristi mockito biblioteku za simulaciju
    // podataka odnosno objekata koje cemo koristiti. Uz notaciju BeforeAll definisali
    // smo da zelimo mokito objekat klase Odeca da koristimo.
    @BeforeAll
    void setBeforeAll() {
        odeca = Mockito.mock(Odeca.class);
    }

    // test metoda koja proverava ocekivanu i "stvarnu" vrednost koja se dobija
    // izvrsavanjem metode u programu
    @Test
    void getTezina_ShouldReturnAnAdequateValue() {
        Mockito.when(odeca.getTezina())
                .thenReturn(15.0);
        assertEquals(15.0, odeca.getTezina(), DELTA);
    }

    // test metoda kojom proveravamo odbrambenu vrednost koja je ocekivana
    // sa vrednoscu koja se dobija izvrsavanjem metode
    @Test
    void getOdbrambenaVrednost_ShouldReturnAnAdequateValue() {
        Mockito.when(odeca.getOdbrambenaVrednost())
                .thenReturn(15.0);
        assertEquals(15.0, odeca.getOdbrambenaVrednost(), DELTA);
    }


}