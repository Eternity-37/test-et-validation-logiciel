package tp2_exercices;

import exercice_1.Calcul;
import exercice_1.CalculQuestion2;
import exercice_1.ExceptionPasAssezArguments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@org.junit.jupiter.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCalculQuestion2 {

    /*
    00,Y,Z,X
    01,Y<0,Z<1,X<-1
    02,Y=0,Z=1,X<-1
    03,Y>0,Z>1,X<-1
    04,Y>0,Z=1,X=-1
    05,Y=0,Z<1,X=-1
    06,Y<0,Z>1,X=-1
    07,Y<0,Z=1,X=1
    08,Y=0,Z>1,X=1
    09,Y>0,Z<1,X=1
    10,Y>0,Z<1,X>1
    11,Y=0,Z>1,X>1
    12,Y<0,Z=1,X>1
    13,Y<0,Z=1,-1<X<1
    14,Y=0,Z>1,-1<X<1
    15,Y>0,Z<1,-1<X<1
     */
    private Calcul calcul;
    private double x;
    private double y;
    private double z;

    @BeforeAll
    public void initialisation(){this.calcul = new CalculQuestion2();}
    /*
    Chaque test correspond au numéro de test calculé avec la méthode
    AllPairs pour réduire le nombre de test à faire
     */
    @Test
    public void test1() throws ExceptionPasAssezArguments {
        double resultat = this.calcul.calculer(0,-1,0);
        Assertions.assertTrue(Double.isInfinite(resultat));
    }

    @Test
    public void test2() throws ExceptionPasAssezArguments {
        double resultat = this.calcul.calculer(0,0,1);
        Assertions.assertTrue(Double.isInfinite(resultat));
    }
}
