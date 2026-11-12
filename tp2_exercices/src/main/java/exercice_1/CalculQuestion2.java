package exercice_1;

public class CalculQuestion2 implements Calcul{
    public double calculer(double ...args) throws ExceptionPasAssezArguments, ExceptionTropArguments{
        double x,y,z;
        if (args.length == 3){
            x = args[0];
            y = args[1];
            z = args[2];

            return Math.sqrt( y * (z-1)/Math.pow(x ,2)-1);
        }else if (args.length <3){
            throw new ExceptionPasAssezArguments("Pas assez d'arguments !");
        }
            else throw new ExceptionTropArguments("Trop d'arguments !");
        }
}
