package tp2_exercices;

import exercice_3.CalculImpot;
import exercice_3.ExceptionRevenuNegatif;
import org.junit.jupiter.api.*;

@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCalculImpot {
    CalculImpot calculImpot;

    @BeforeAll
    public void setCalculImpot(){calculImpot= new CalculImpot();}

    @Timeout(value = 10)
    @Test
    public void testCalculImpot1() throws ExceptionRevenuNegatif {
        double res = calculImpot.calculerImpot(20000.0);
        double attendu = 2000.0;
        Assertions.assertEquals(attendu,res);
    }
    @Timeout(value = 10)
    @Test
    public void testCalculImpot2() throws ExceptionRevenuNegatif {
        double res = calculImpot.calculerImpot(100000.0);
        double attendu = 18000.0;
        Assertions.assertEquals(attendu,res);
    }
    @Timeout(value = 10)
    @Test
    public void testCalculImpot3() throws ExceptionRevenuNegatif {
        double res = calculImpot.calculerImpot(200000.0);
        double attendu = 48000.0;
        Assertions.assertEquals(attendu,res);
    }
    @Timeout(value = 10)
    @Test
    public void testCalculImpot4() throws ExceptionRevenuNegatif {
        double res = calculImpot.calculerImpot(0.0);
        double attendu = 0.0;
        Assertions.assertEquals(attendu,res);
    }
    @Timeout(value = 10)
    @Test
    public void testCalculMoins1000() throws ExceptionRevenuNegatif {
        Exception exc = Assertions.assertThrows(ExceptionRevenuNegatif.class, () -> {
            calculImpot.calculerImpot(-1000.0);
        });
        Assertions.assertEquals("negative number", exc.getMessage());
    }
}
