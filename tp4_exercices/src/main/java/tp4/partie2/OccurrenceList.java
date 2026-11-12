package tp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp4.partie1.ValueNotFoundException;
import tp4.partie2.Average;
import tp4.partie2.Occurrence;

public class OccurrenceList extends ArrayList<Integer> implements Occurrence {

    // Partie II : attribut de type Average
    private Average average;

    public OccurrenceList() {
        super();
    }

    public OccurrenceList(Integer[] t) {
        super(Arrays.asList(t));
    }

    // Partie II : constructeur avec Average
    public OccurrenceList(Average average, Integer[] t) {
        super(Arrays.asList(t));
        this.average = average;
    }

    @Override
    public Integer computeOccurrence(int i) {
        return Collections.frequency(this, i);
    }

    @Override
    public Boolean containsNOccurrences(int i, int occ) {
        return computeOccurrence(i) >= occ;
    }

    @Override
    public void removeAllOccurrences(int i) {
        boolean supprime = this.removeIf(e -> e.equals(i));
        if (!supprime) throw new ValueNotFoundException("Not found !");
    }

    @Override
    public void replaceAllOccurrences(int oldValue, int newValue) {
        boolean trouve = false;
        for (int j = 0; j < this.size(); j++) {
            if (this.get(j).equals(oldValue)) {
                trouve = true;
                this.set(j, newValue);
            }
        }
        if (!trouve) throw new ValueNotFoundException("Not found !");
    }

    @Override
    public List<Integer> subListWithoutOccurrences(int i) {
        List<Integer> newList = new ArrayList<>();
        boolean trouve = false;
        for (Integer e : this) {
            if (e.equals(i)) {
                trouve = true;
            } else {
                newList.add(e);
            }
        }
        if (!trouve) throw new ValueNotFoundException("Not found !");
        return newList;
    }

    // Partie II : moyenne de la sous-liste sans les occurrences de i
    public float avgWithoutOccurrence(int i) {
        List<Integer> sousListe = subListWithoutOccurrences(i);
        return average.compute(sousListe);
    }
}