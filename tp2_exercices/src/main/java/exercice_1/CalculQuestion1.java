package exercice_1;

import static java.lang.Math.sqrt;

public class CalculQuestion1 implements Calcul{
    @Override
    public double calculer(double... x) throws ExceptionPasAssezArguments,ExceptionTropArguments{
        try {
            if (x.length == 1){
                return sqrt(1 / (Math.pow(x[0], 2) - 1));
            }
            else if (x.length ==0){
                throw new ExceptionPasAssezArguments("0 arguments !");
            }
            else throw new ExceptionTropArguments("Trop d'arguments !");
        }
        catch (ArithmeticException e){
            throw new ArithmeticException(e.getMessage());
        }
    }

}
