package tp1_exercice;

import exercice_4.DivisionByZero;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDivisionByZero {
    @Test
    void testMainDivisionByZero1() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DivisionByZero.main(new String[]{"5"});

        assertEquals("i = 10", outContent.toString().trim());
        System.setOut(originalOut);
    }

    @Test
    void testMainDivisionByZero2() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DivisionByZero.main(new String[]{"5", "8", "4"});

        assertEquals("i = 3", outContent.toString().trim());
        System.setOut(originalOut);
    }

}
