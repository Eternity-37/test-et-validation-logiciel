package exercice_2;

import static java.lang.Long.MAX_VALUE;

public class Fibonacci {
    public int fibonacci(int n){
        if(n<0) throw new IllegalArgumentException("n inférieur à 0");
        boolean calculOK = true;
        int u0 = 0;
        int u1 = 1;
        if(n == 0){
            return u0;
        }
        for (int i=0; i<=n-2; i++){
            if (u1 < MAX_VALUE -u0){
                int u3 = u0 +u1;
                u0 = u1;
                u1 = u3;
            }else{
                calculOK = false;
            }
            if (!calculOK){
                return u1;
            }

        }
        return u1;
    }
}
