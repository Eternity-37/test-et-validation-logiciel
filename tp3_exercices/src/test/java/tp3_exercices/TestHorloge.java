package tp3_exercices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tp3.Horloge;

@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TestHorloge{

    @ParameterizedTest(name = "{0}:{1}:{2} + {3}s = {4}:{5}:{6}")
    @CsvFileSource(resources = "/horloge_positif.csv", numLinesToSkip = 1)
    void addSecondes_Positif(int h, int m, int s, int ajout,
                             int hAttendues, int mAttendues, int sAttendues) {
        Horloge horloge = new Horloge(h, m, s);
        horloge.addSecondes(ajout);
        Assertions.assertEquals(hAttendues, horloge.getHeures());
        Assertions.assertEquals(mAttendues, horloge.getMinutes());
        Assertions.assertEquals(sAttendues, horloge.getSecondes());
    }

    @ParameterizedTest(name = "{0}:{1}:{2} + ({3})s = {4}:{5}:{6}")
    @CsvFileSource(resources = "/horloge_negatif.csv", numLinesToSkip = 1)
    void addSecondes_Negatif(int h, int m, int s, int ajout,
                             int hAttendues, int mAttendues, int sAttendues) {
        Horloge horloge = new Horloge(h, m, s);
        horloge.addSecondes(ajout);
        Assertions.assertEquals(hAttendues, horloge.getHeures());
        Assertions.assertEquals(mAttendues, horloge.getMinutes());
        Assertions.assertEquals(sAttendues, horloge.getSecondes());
    }

    @ParameterizedTest(name = "10:00:00 + {0}s + {1}s = {2}:{3}:{4}")
    @CsvFileSource(resources = "/horloge_successifs.csv", numLinesToSkip = 1)
    void addSecondes_AppelsSuccessifs(int ajout1, int ajout2,
                                      int hAttendues, int mAttendues, int sAttendues) {
        Horloge horloge = new Horloge(10, 0, 0);
        horloge.addSecondes(ajout1);
        horloge.addSecondes(ajout2);
        Assertions.assertEquals(hAttendues, horloge.getHeures());
        Assertions.assertEquals(mAttendues, horloge.getMinutes());
        Assertions.assertEquals(sAttendues, horloge.getSecondes());
    }
}