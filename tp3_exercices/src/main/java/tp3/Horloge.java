package tp3;

public class Horloge {
    private int heures;
    private int minutes;
    private int secondes;

    public Horloge(int heures, int minutes, int secondes) {
        this.heures = heures;
        this.minutes = minutes;
        this.secondes = secondes;
    }

    public int getHeures() {
        return heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSecondes() {
        return secondes;
    }

    public void addSecondes(int s){
        secondes += s;
        if (secondes >= 60){
            minutes = secondes%60;
            secondes = secondes - minutes*60;
        }
        if (minutes >= 60){
            heures = minutes%60;
            minutes = minutes - heures*60;
        }
    }
}
