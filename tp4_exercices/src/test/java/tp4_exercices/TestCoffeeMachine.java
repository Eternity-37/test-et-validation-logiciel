package tp4_exercices;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tp4.machineACafe.CoffeeMachine;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCoffeeMachine {
    private static final String MESSAGE = "Pas assez d'argent !";
    private static final String CAFE = "Servir cafe.";

    private ByteArrayOutputStream sortie;
    private PrintStream ancienneSortie;
    private ArrayList<Integer> monnaie,monnaie1;

    @BeforeAll
    public void setList(){
        monnaie = new ArrayList<>();
        monnaie.add(10);
        monnaie.add(20);
        monnaie1 = new ArrayList<>();
        monnaie1.add(20);
        monnaie1.add(20);
    }

    // On capture System.out pour vérifier si un café est servi
    @BeforeEach
    void capturerSortie() {
        ancienneSortie = System.out;
        sortie = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sortie));
    }

    @AfterEach
    void restaurerSortie() {
        System.setOut(ancienneSortie);
    }

    // Construit une liste mutable à partir de "10 20 10" ("" ou null -> liste vide)
    private static ArrayList<Integer> liste(String pieces) {
        ArrayList<Integer> l = new ArrayList<>();
        if (pieces != null && !pieces.trim().isEmpty()) {
            for (String p : pieces.trim().split("\\s+")) {
                l.add(Integer.parseInt(p));
            }
        }
        return l;
    }

    // Nombre de fois où "Servir cafe." a été affiché
    private int nbCafesServis() {
        String texte = sortie.toString();
        int count = 0;
        int index = texte.indexOf(CAFE);
        while (index != -1) {
            count++;
            index = texte.indexOf(CAFE, index + 1);
        }
        return count;
    }

    // ---------------------------------------------------------------
    // coffee() : chemins valides et monnaie rendue
    // ---------------------------------------------------------------
    @ParameterizedTest(name = "pièces [{0}] -> rendu {1}")
    @CsvSource({
            "'10 10 10', 0",   // 0 -> 1 -> 2 -> 3
            "'10 20',    0",   // 0 -> 1 -> 3
            "'20 10',    0",   // 0 -> 2 -> 3
            "'10 10 20', 10",  // 0 -> 1 -> 2 -> 3, 40 c payés
            "'20 20',    10"   // 0 -> 2 -> 3, 40 c payés
    })
    void coffee_ServiUnCafeEtRendLaMonnaie(String pieces, int renduAttendu) throws Exception {
        int rendu = CoffeeMachine.coffee(liste(pieces));
        Assertions.assertEquals(renduAttendu, rendu);
        Assertions.assertEquals(1, nbCafesServis());
    }

    @Test
    void coffee_NePrendQueLesPiecesNecessaires() throws Exception {
        // 3 pièces suffisent (10+10+10) : les 2 suivantes restent dans la liste
        ArrayList<Integer> pieces = liste("10 10 10 10 20");
        CoffeeMachine.coffee(pieces);
        Assertions.assertEquals(2, pieces.size());
    }

    // ---------------------------------------------------------------
    // coffee() : argent insuffisant
    // ---------------------------------------------------------------
    @ParameterizedTest(name = "pièces [{0}] -> exception")
    @CsvSource({
            "''",       // aucune pièce
            "'10'",     // 10 c
            "'20'",     // 20 c
            "'10 10'"   // 20 c
    })
    void coffee_ArgentInsuffisant_LeveException(String pieces) {
        Exception e = Assertions.assertThrows(Exception.class,
                () -> CoffeeMachine.coffee(liste(pieces)));
        Assertions.assertEquals(MESSAGE, e.getMessage());
    }

    @Test
    void coffee_ArgentInsuffisant_NeServirPasDeCafe() {
        Assertions.assertThrows(Exception.class, () -> CoffeeMachine.coffee(liste("10 10")));
        Assertions.assertEquals(0, nbCafesServis());
    }

    // ---------------------------------------------------------------
    // one_coffee() : on part de chaque état de l'automate
    // ---------------------------------------------------------------
    @ParameterizedTest(name = "depuis {0} avec [{1}] -> rendu {2}")
    @CsvSource({
            "trois, '',      0",   // déjà 30 c : le café est servi directement
            "un,    '20',    0",
            "un,    '10 10', 0",
            "deux,  '10',    0",
            "deux,  '20',    10",
            "zero,  '10 10 10', 0"
    })
    void oneCoffee_DepuisUnEtat(CoffeeMachine.etats initial, String pieces, int renduAttendu) throws Exception {
        int rendu = CoffeeMachine.one_coffee(liste(pieces), initial);
        Assertions.assertEquals(renduAttendu, rendu);
        Assertions.assertEquals(1, nbCafesServis());
    }

    @ParameterizedTest(name = "depuis {0} avec [{1}] -> exception")
    @CsvSource({
            "un,   '10'",
            "un,   ''",
            "deux, ''"
    })
    void oneCoffee_ArgentInsuffisant_LeveException(CoffeeMachine.etats initial, String pieces) {
        Exception e = Assertions.assertThrows(Exception.class,
                () -> CoffeeMachine.one_coffee(liste(pieces), initial));
        Assertions.assertEquals(MESSAGE, e.getMessage());
    }

    // Dans l'état zéro, one_coffee ne teste pas si la liste est vide
    // (contrairement aux états un et deux) : on obtient une exception technique.
    @Test
    void oneCoffee_EtatZeroListeVide_LeveIndexOutOfBounds() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> CoffeeMachine.one_coffee(liste(""), CoffeeMachine.etats.zero));
    }

    @Test
    public void test20_20() throws Exception {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int result = CoffeeMachine.coffee(monnaie1);
        Assertions.assertEquals(10,result);
        assertEquals("Servir cafe.",outContent.toString().trim());
        System.setOut(originalOut);
    }

}
