package tp3_exercices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tp3.Numbers;

@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestNumbers {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void TestIsOdd(int number) {
        Assertions.assertTrue(Numbers.isOdd(number));
    }


}
