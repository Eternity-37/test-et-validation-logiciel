package exercice_3;

public class CalculImpot {
    public Double calculerImpot(Double revenu) throws ExceptionRevenuNegatif{
        if (revenu < 0.0) throw new ExceptionRevenuNegatif("negative number");
        double apayer;
        if (revenu <= 20000.0){
            apayer = revenu*0.1;
        }
        else if (revenu <= 100000.0){
            apayer = 2000.0 + (revenu-20000.0)*0.2;
        }
        else{
            apayer = 2000.0 + 16000.0 + (revenu-100000.0)*0.3;
        }
        return apayer;
    }
}
