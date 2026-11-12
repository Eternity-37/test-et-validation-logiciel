package tp4_exercices;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import tp4.OccurrenceList;
import tp4.partie1.ValueNotFoundException;
import tp4.partie2.Average;

/**
 * Tests de avgWithoutOccurrence (TP4 - exercice 1, partie II).
 * Liste de départ : {1, 2, 3, 2, 3, 3}
 */
@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OccurrenceListTest {

    private OccurrenceList list;

    @BeforeEach
    void setUp() {
        // Classe anonyme qui implémente Average : moyenne arithmétique
        Average moyenne = new Average() {
            @Override
            public float compute(List<Integer> l) {
                float somme = 0;
                for (Integer e : l) {
                    somme += e;
                }
                return somme / l.size();
            }
        };
        list = new OccurrenceList(moyenne, new Integer[]{1, 2, 3, 2, 3, 3});
    }

    // 1 retiré -> [2, 3, 2, 3, 3] -> 13/5 = 2.6
    // 2 retiré -> [1, 3, 3, 3]    -> 10/4 = 2.5
    // 3 retiré -> [1, 2, 2]       -> 5/3  = 1.666...
    @ParameterizedTest(name = "moyenne sans {0} = {1}")
    @CsvSource({
            "1, 2.6",
            "2, 2.5",
            "3, 1.6666666"
    })
    void avgWithoutOccurrence_CalculeLaMoyenneDeLaSousListe(int i, float attendue) {
        Assertions.assertEquals(attendue, list.avgWithoutOccurrence(i), 0.0001f);
    }

    @Test
    void avgWithoutOccurrence_ValeurAbsente_LeveException() {
        Assertions.assertThrows(ValueNotFoundException.class,
                () -> list.avgWithoutOccurrence(9));
    }

    @Test
    void avgWithoutOccurrence_TransmetBienLaSousListeACompute() {
        // Autre classe anonyme : renvoie la taille de la liste reçue
        Average taille = new Average() {
            @Override
            public float compute(List<Integer> l) {
                return l.size();
            }
        };
        OccurrenceList l2 = new OccurrenceList(taille, new Integer[]{1, 2, 3, 2, 3, 3});
        // sans les 3 -> [1, 2, 2] -> 3 éléments
        Assertions.assertEquals(3f, l2.avgWithoutOccurrence(3));
    }

    @Test
    void avgWithoutOccurrence_NeModifiePasLaListe() {
        list.avgWithoutOccurrence(3);
        Assertions.assertEquals(6, list.size());
    }
}