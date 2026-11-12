package exercice_3;

public class ExceptionRevenuNegatif extends Exception {

    public ExceptionRevenuNegatif(String negativeNumber) {
        super(negativeNumber);
    }
}
