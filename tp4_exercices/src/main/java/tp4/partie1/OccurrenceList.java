package tp4.partie1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccurrenceList extends ArrayList<Integer> implements Occurrence {
    private ArrayList<Integer> liste;

    public OccurrenceList() {super();}

    public OccurrenceList(Integer[] t){
        this.liste = new ArrayList<>(Arrays.asList(t));
    }

    @Override
    public Integer computeOccurrence(int i) {
        Integer occurrence = 0;
        for(Integer e : this.liste){
            if( e.equals(i)){
                occurrence++;
            }
        }
        return occurrence;
    }

    @Override
    public Boolean containsNOccurrences(int i, int occ) {
        Integer nboccurrence = computeOccurrence(i);
        return nboccurrence >= occ;
    }

    @Override
    public void removeAllOccurrences(int i) {
        boolean delete = this.liste.removeIf(e -> e.equals(i));
        if (!delete) throw new ValueNotFoundException("Not found !");
    }

    @Override
    public void replaceAllOccurrences(int oldValue, int newValue) {
        boolean trouve = false;
        for(int j=0; j<this.liste.size();j++){
            if(this.liste.get(j).equals(oldValue)){
                trouve = true;
                this.liste.set(j,newValue);
            }
        }
        if (!trouve) throw new ValueNotFoundException("Not found !");
    }

    @Override
    public List<Integer> subListWithoutOccurrences(int i) {
        ArrayList<Integer> newList = new ArrayList<>();
        boolean trouve = false;
        for(Integer e : this.liste){
            if(e.equals(i)){
                trouve = true;
            } else{
                newList.add(e);
            }
        }
        if (!trouve) throw new ValueNotFoundException("Not found !");
        return newList;
    }
}
