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
        int total = heures * 3600 + minutes * 60 + secondes + s;
        total = Math.floorMod(total, 86400);

        heures = total /3600;
        minutes = (total % 3600) / 60;
        secondes = total %60;
    }
}
