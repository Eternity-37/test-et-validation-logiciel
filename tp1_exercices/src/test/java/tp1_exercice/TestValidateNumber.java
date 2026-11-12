package tp1_exercice;

import exercice_1.PrimeNumber;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class TestValidateNumber {
    @Test
    public void testValidateNumber1() throws Exception{
        Boolean expected = true;
        Assertions.assertEquals(expected, PrimeNumber.validateNumber(5));
    }

    @Test
    public void testValidateNumber2() throws Exception{
        Boolean expected = false;
        Assertions.assertEquals(expected, PrimeNumber.validateNumber(4));
    }

    @Test
    public void testValidateNumber3(){
        Exception exc = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PrimeNumber.validateNumber(-1);
        });
        Assertions.assertEquals("negative number", exc.getMessage());
    }

    @Test
    public void testValidateNumber4(){
        Exception exc = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PrimeNumber.validateNumber(0);
        });
        Assertions.assertEquals("null number", exc.getMessage());
    }

    @Test
    public void testValidateNumber5() throws Exception{
        Boolean expected = false;
        Assertions.assertEquals(expected, PrimeNumber.validateNumber(1));
    }
}
