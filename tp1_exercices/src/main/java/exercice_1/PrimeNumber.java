package exercice_1;

public class PrimeNumber {
    public static Boolean validateNumber(final Integer primeNumber) throws Exception{
        if (primeNumber < 0){
            throw new IllegalArgumentException("negative number");
        }
        if (primeNumber == 0){
            throw new IllegalArgumentException("null number");
        }
        if (primeNumber ==1){
            return false;
        }
        for (int i = 2; i <= (primeNumber / 2); i++) {
            if (primeNumber % i == 0) return false;
        }
        return true;
    }
}
