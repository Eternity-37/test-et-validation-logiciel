package tp1_exercice;

import exercice_2.IntegerOp;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class TestIntegerOp {
    @Test
    public void testIntegerOp() throws Exception{
        IntegerOp expected = new IntegerOp(2);
        Assertions.assertNotEquals(0,expected.getE());
        Assertions.assertEquals(2, expected.getE());
    }

    @Test
    public void testTwice(){
        IntegerOp expected = new IntegerOp(1);
        expected.twice();
        Assertions.assertEquals(2, expected.getE());
    }

    @Test
    public void testTwice_0(){
        IntegerOp expected = new IntegerOp(0);
        expected.twice();
        Assertions.assertEquals(0, expected.getE());
    }

    @Test
    public void testHalf(){
        IntegerOp expected = new IntegerOp(3);
        expected.half();
        Assertions.assertEquals(1, expected.getE());
    }

}
