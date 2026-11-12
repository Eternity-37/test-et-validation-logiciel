package tp1_exercice;

import exercice_3.BinString;
import org.junit.jupiter.api.*;
@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TestBinString {
    BinString binString;

    @BeforeAll
    public void setup() {binString = new BinString();}

    @Test
    public void testSumFunction() throws Exception{
        int expected = 0;
        Assertions.assertEquals(expected, binString.sum(""));
        expected = 100;
        Assertions.assertEquals(expected, binString.sum("d"));
        expected = 265;
        Assertions.assertEquals(expected, binString.sum("Add"));
    }

    @Test
    public void testBinariseFunction(){
        String expected = "100";
        Assertions.assertEquals(expected,binString.binarise(4));
        expected = "11111100";
        Assertions.assertEquals(expected,binString.binarise(252));
    }

    @Test
    public void testTotalConversion() {
        String expected = "1000001";
        Assertions.assertEquals(expected, binString.convert("A"));
    }
}
