package tp2_exercices;

import exercice_5.SommeArgent;
import org.junit.jupiter.api.*;

@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSommeArgent {
    SommeArgent sum, sum1;
    int i;

    @BeforeAll
    public void setSommeArgent(){
        sum = new SommeArgent(3,"US");
        sum1 = new SommeArgent(7, "CHF");
        i = 1;
    }

    @BeforeEach
    public void beforeI(){
        i += 1;
        System.out.println(i + " Avant execution d'une méthode de test");
    }

    @Test
    public void testSommeArgent1(){

    }

    @AfterAll
    public void

    @AfterEach
    public void afterI(){
        System.out.println(i + " Après execution d'une méthode de test");
    }
}
