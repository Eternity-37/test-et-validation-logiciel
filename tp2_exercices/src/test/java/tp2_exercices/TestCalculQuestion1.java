package tp2_exercices;

import exercice_1.CalculQuestion1;
import exercice_1.ExceptionPasAssezArguments;
import exercice_1.ExceptionTropArguments;
import org.junit.jupiter.api.*;

import exercice_1.Calcul;

@org.junit.jupiter.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCalculQuestion1 {
    private Calcul calcul;

    @BeforeAll
    public void initialisation(){this.calcul = new CalculQuestion1();}

    @Test
    public void testQ1() throws ExceptionPasAssezArguments, ExceptionTropArguments {
        double resultat = this.calcul.calculer(1);
        Assertions.assertTrue(Double.isInfinite(resultat));
    }
}

