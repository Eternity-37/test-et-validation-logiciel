package tp4.partie2;

import tp4.partie1.ValueNotFoundException;

import java.util.List;

public interface Occurrence {
    Integer computeOccurrence(int i);
    Boolean containsNOccurrences(int i, int occ);
    void removeAllOccurrences(int i) throws ValueNotFoundException;
    void replaceAllOccurrences(int oldValue, int newValue) throws ValueNotFoundException;
    List<Integer> subListWithoutOccurrences(int i) throws ValueNotFoundException;
}
