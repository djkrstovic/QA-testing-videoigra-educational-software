package videoigra;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

// @TestInstance izvrsava sve test metode u istoj instanci
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OruzjeTest {
    // promenljiva tipa oruzje
    private Oruzje oruzje;
    // definisanje delta vrednosti zato sto proveravamo float/double vrednosti
    private double DELTA = 0.01;


    // definisanje anotacije @BeforeAll koja se izvrsava tacno jednom pre svih testova
    // i definisanje metode setBeforeAll koja koristi mockito biblioteku za simulaciju
    // podataka odnosno objekata koje cemo koristiti. Uz notaciju BeforeAll definisali
    // smo da zelimo mokito objekat klase oruzje da koristimo.
    @BeforeAll
    void setBeforeAll() {

        oruzje = Mockito.mock(Oruzje.class);

    }

    // test koji proverava ocekivanu i dobijenu stetu
    @Test
    void getSteta_ShouldReturnAnAdequateStetaValue() {

        Mockito.when(oruzje.getSteta())
                .thenReturn(15.0);
        assertEquals(15.0, oruzje.getSteta(), DELTA);

    }

    // test koji proverava ocekivanu i dobijenu tezinu
    @Test
    void getTezina_ShouldReturnAnAdequateTezinaValue() {

        Mockito.when(oruzje.getTezina())
                .thenReturn(15.0);
        assertEquals(15.0, oruzje.getTezina(), DELTA);

    }

    // test koji proverava ocekivanu i dobijenu snagu
    @Test
    void getPotrebnaSnaga_ShouldReturnAnAdequatePotrebnaSnagaValue() {

        Mockito.when(oruzje.getPotrebnaSnaga())
                .thenReturn(15.0);
        assertEquals(15.0, oruzje.getPotrebnaSnaga(), DELTA);

    }
}