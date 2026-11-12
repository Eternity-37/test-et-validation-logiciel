package tp3_exercices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.Month;

@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestStrings {
    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCaseTest(String input, String expected) {
        String actualValue = input.toUpperCase();
        Assertions.assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCaseTest(String input, String expected) {
        String actualValue = input.toLowerCase();
        Assertions.assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @EnumSource(Month.class) // passing all 12 months
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
        int monthNumber = month.getValue();
        Assertions.assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void sameMonths_Are30DaysLong(Month month) {
        final boolean isALeapYear = false;
        Assertions.assertEquals(30, month.length(isALeapYear));
    }

    @ParameterizedTest
    @EnumSource(
            value = Month.class,
            names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
            mode = EnumSource.Mode.EXCLUDE)
    void exceptionFourMonths_OtherAre31DaysLong(Month month) {
        final boolean isALeapYear = false;
        Assertions.assertEquals(31, month.length(isALeapYear));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void toUpperCase_ShouldGeneratedTheExpectedUpperCaseValueCSVFile(
            String input, String expected) {
        String actualValue = input.toUpperCase();
        Assertions.assertEquals(expected, actualValue);
    }
}
