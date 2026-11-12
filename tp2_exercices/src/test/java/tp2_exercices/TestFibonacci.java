package tp2_exercices;

import exercice_2.Fibonacci;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFibonacci {
    Fibonacci f;

    @BeforeAll
    public void setF(){f =new Fibonacci();}

    @Test
    public void testfib0() throws Exception{
        int n = 0;
        int res = f.fibonacci(n);
        int attendu = 0;
        Assertions.assertEquals(attendu,res);
    }
    @Test
    public void testfib1() throws Exception{
        int n = 1;
        int res = f.fibonacci(n);
        int attendu = 1;
        Assertions.assertEquals(attendu,res);
    }
    @Test
    public void testfib2() throws Exception{
        int n = 2;
        int res = f.fibonacci(n);
        int attendu = 1;
        Assertions.assertEquals(attendu,res);
    }
    @Test
    public void testfib3() throws Exception{
        int n = 3;
        int res = f.fibonacci(n);
        int attendu = 2;
        Assertions.assertEquals(attendu,res);
    }
    @Test
    public void testfib4() throws Exception{
        int n = 4;
        int res = f.fibonacci(n);
        int attendu = 3;
        Assertions.assertEquals(attendu,res);
    }
    @Test
    public void testfib5() throws Exception{
        int n = 5;
        int res = f.fibonacci(n);
        int attendu = 5;
        Assertions.assertEquals(attendu,res);
    }
    @Test
    public void testfib46() throws Exception{
        int n = 46;
        int res = f.fibonacci(n);
        int attendu = 1836311903;
        Assertions.assertEquals(attendu,res);
    }

}
