package tp3;

public class Numbers {
    public static boolean isOdd(int number){
        if (number < 0) number *=-1;
        return number%2 == 1;
    }
}
