package exercice_2;

public class IntegerOp {
    private int e;
    //private int two = 3;
    private int two = 2;
    public IntegerOp(int e){
        this.e = e;
    }
    public void twice(){
        // e *= (2 + 2 - 2 + 1);
        e *= 2;
    }
    public void half(){
        e /= two;
    }
    public int getE(){
        return e;
    }
}
