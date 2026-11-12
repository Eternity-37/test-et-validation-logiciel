package exercice_4;

public class DivisionByZero {
    public static void main(String[] args){
        if (args.length != 0) {// throw new ArithmeticException("nb arguments nul!");
            int i = 10 / args.length;
            System.out.println("i = " + i);
        }
    }
}
