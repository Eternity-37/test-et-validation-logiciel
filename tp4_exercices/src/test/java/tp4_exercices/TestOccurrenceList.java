package tp4_exercices;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tp4.partie1.OccurrenceList;
import tp4.partie1.ValueNotFoundException;

import java.util.Arrays;
import java.util.List;

@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestOccurrenceList {

    private OccurrenceList list;

    @BeforeEach
    void setUp() {
        list = new OccurrenceList(new Integer[]{1, 2, 3, 2, 3, 3});
    }

    @Test
    void constructeurSansParametre_ListeVide() {
        OccurrenceList vide = new OccurrenceList();
        Assertions.assertTrue(vide.isEmpty());
    }

    @RepeatedTest(3)
    void containsNOccurrences_AuMoinsNOccurrencesDeTrois(RepetitionInfo info) {
        Assertions.assertTrue(list.containsNOccurrences(3, 1));
        Assertions.assertTrue(list.containsNOccurrences(3, 2));
        Assertions.assertTrue(list.containsNOccurrences(3, 3));
    }

    @Test
    void containsNOccurrences_TropPeuDOccurrences() {
        Assertions.assertFalse(list.containsNOccurrences(3, 4));
        Assertions.assertFalse(list.containsNOccurrences(1, 2));
    }

    @Test
    void containsNOccurrences_ValeurAbsente() {
        Assertions.assertFalse(list.containsNOccurrences(9, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void computeOccurrence_ValeursPresentes(int i) {
        Assertions.assertEquals(i, list.computeOccurrence(i));
    }

    @Test
    void computeOccurrence_ValeurAbsente() {
        Assertions.assertEquals(0, list.computeOccurrence(9));
    }


    @Test
    void removeAllOccurrences_ValeurAbsente_LeveException() {
        Assertions.assertThrows(ValueNotFoundException.class,
                () -> list.removeAllOccurrences(9));
    }


    @Test
    void replaceAllOccurrences_ValeurAbsente_LeveException() {
        Assertions.assertThrows(ValueNotFoundException.class,
                () -> list.replaceAllOccurrences(9, 5));
    }

    @Test
    void subListWithoutOccurrences_RetourneLaSousListe() throws ValueNotFoundException {
        List<Integer> sousListe = list.subListWithoutOccurrences(3);
        Assertions.assertEquals(Arrays.asList(1, 2, 2), sousListe);
    }

    @Test
    void subListWithoutOccurrences_ValeurAbsente_LeveException() {
        Assertions.assertThrows(ValueNotFoundException.class,
                () -> list.subListWithoutOccurrences(9));
    }

    @Test
    public void testReplaceAllOccurrences() throws ValueNotFoundException{
        Integer[] t = {1, 3, 4, 4, 3, 3};
        OccurrenceList expected = new OccurrenceList();
        try{
            list.replaceAllOccurrences(2,4);
            Assertions.assertEquals(expected,list);
        }catch(ValueNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}
