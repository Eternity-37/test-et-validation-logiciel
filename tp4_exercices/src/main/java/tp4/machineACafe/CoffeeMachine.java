package tp4.machineACafe;

import java.util.ArrayList;

public class CoffeeMachine {
    public enum etats {
        zero, un, deux, trois;
    }
    public static final int prix = 30; // prix d'un café

    public static int one_coffee(ArrayList<Integer> pieces, etats initial) throws Exception {
        int piece = 0; // somme des pièces mises dans la machine
        etats e = initial;
        int resteDu = 0;
        do {
            switch (e) {
                case zero:
                    piece = pieces.remove(0);
                    if (piece == 10) {
                        e = etats.un;
                    }
                    if (piece == 20) {
                        e = etats.deux;
                    }
                    break;
                case un:
                    if (pieces.isEmpty()) {
                        throw new Exception("Pas assez d'argent !");
                    }
                    piece = pieces.remove(0);
                    if (piece == 10) {
                        e = etats.deux;
                        break;
                    }
                    if (piece == 20) {
                        e = etats.trois;
                    }
                    break;
                case deux:
                    if (pieces.isEmpty()) {
                        throw new Exception("Pas assez d'argent !");
                    }
                    piece = pieces.remove(0);
                    if ((piece == 10) || (piece == 20)) {
                        e = etats.trois;
                    }
                    if (piece == 20) {
                        resteDu = 10;
                    }
                    break;
                case trois:
                    System.out.println("Servir cafe.");
                    e = etats.zero;
            }
        } while (e != etats.zero);
        return resteDu;
    }

    public static int coffee(ArrayList<Integer> monnaie) throws Exception {
        try {
            return one_coffee(monnaie, etats.zero);
        } catch (Exception e) {
            throw new Exception("Pas assez d'argent !");
        }
    }
}

