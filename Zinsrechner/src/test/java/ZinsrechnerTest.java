import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ZinsrechnerTest {

    @Test
    void calculateFinalCapital_validInputOne() throws InvalidInputException, InvalidLaufzeitException {
        // Gültige Eingaben
        BigDecimal anfangskapital = new BigDecimal("1000.00");
        int laufzeit = 5;
        BigDecimal zinssatz = new BigDecimal("5.0");

        Zinsrechner zinsrechner = new Zinsrechner(anfangskapital, laufzeit, zinssatz);

        BigDecimal actual = zinsrechner.berechneEndkapital();
        BigDecimal expected = new BigDecimal("1276.28"); // Der erwartete Endbetrag für die gegebenen Eingaben

        assertEquals(expected, actual);
    }
    @Test
    void calculateFinalCapital_validInputTwo() throws InvalidInputException, InvalidLaufzeitException {
        // Gültige Eingaben
        BigDecimal anfangskapital = new BigDecimal("3000.00");
        int laufzeit = 2;
        BigDecimal zinssatz = new BigDecimal("3.44");

        Zinsrechner zinsrechner = new Zinsrechner(anfangskapital, laufzeit, zinssatz);

        BigDecimal actual = zinsrechner.berechneEndkapital();
        BigDecimal expected = new BigDecimal("3209.95"); // Der erwartete Endbetrag für die gegebenen Eingaben

        assertEquals(expected, actual);
    }
    @Test
    void calculateFinalCapital_validInputThree() throws InvalidInputException, InvalidLaufzeitException {
        // Gültige Eingaben
        BigDecimal anfangskapital = new BigDecimal("192847615524.00");
        int laufzeit = 11;
        BigDecimal zinssatz = new BigDecimal("0.11");

        Zinsrechner zinsrechner = new Zinsrechner(anfangskapital, laufzeit, zinssatz);

        BigDecimal actual = zinsrechner.berechneEndkapital();
        BigDecimal expected = new BigDecimal("195193948126.20"); // Der erwartete Endbetrag für die gegebenen Eingaben

        assertEquals(expected, actual);
    }
    @Test
    void calculateFinalCapital_validInputFour() throws InvalidInputException, InvalidLaufzeitException {
        // Gültige Eingaben
        BigDecimal anfangskapital = new BigDecimal("73289981.00");
        int laufzeit = 5;
        BigDecimal zinssatz = new BigDecimal("0.01");

        Zinsrechner zinsrechner = new Zinsrechner(anfangskapital, laufzeit, zinssatz);

        BigDecimal actual = zinsrechner.berechneEndkapital();
        BigDecimal expected = new BigDecimal("73326633.32"); // Der erwartete Endbetrag für die gegebenen Eingaben

        assertEquals(expected, actual);
    }
    @Test
    void calculateFinalCapital_validInputFive() throws InvalidInputException, InvalidLaufzeitException {
        // Gültige Eingaben
        BigDecimal anfangskapital = new BigDecimal("1.00");
        int laufzeit = 1;
        BigDecimal zinssatz = new BigDecimal("99.99");

        Zinsrechner zinsrechner = new Zinsrechner(anfangskapital, laufzeit, zinssatz);

        BigDecimal actual = zinsrechner.berechneEndkapital();
        BigDecimal expected = new BigDecimal("2.00"); // Der erwartete Endbetrag für die gegebenen Eingaben

        assertEquals(expected, actual);
    }
    @Test
    void calculateFinalCapital_negativeRuntime() throws InvalidInputException, InvalidLaufzeitException {
        // Ungültige Laufzeit (negative Zahl)
        BigDecimal anfangskapital = new BigDecimal("1000.00");
        int laufzeit = -5;
        BigDecimal zinssatz = new BigDecimal("5.0");

        Zinsrechner zinsrechner = new Zinsrechner(anfangskapital, laufzeit, zinssatz);

        assertThrows(InvalidLaufzeitException.class, zinsrechner::berechneEndkapital);
    }
    @Test
    void calculateFinalCapital_negativeInitialAmount() throws InvalidInputException, InvalidLaufzeitException {
        // Ungültiges Anfangskapital (negative Zahl)
        BigDecimal anfangskapital = new BigDecimal("-1000.00");
        int laufzeit = 5;
        BigDecimal zinssatz = new BigDecimal("5.0");

        Zinsrechner zinsrechner = new Zinsrechner(anfangskapital, laufzeit, zinssatz);

        assertThrows(InvalidInputException.class, zinsrechner::berechneEndkapital);
    }
    @Test
    void calculateFinalCapital_invalidInterestRate() throws InvalidInputException, InvalidLaufzeitException {
        // Ungültiger Zinssatz (negativ)
        BigDecimal anfangskapital = new BigDecimal("1000.00");
        int laufzeit = 5;
        BigDecimal zinssatz = new BigDecimal("-5.0");

        Zinsrechner zinsrechner = new Zinsrechner(anfangskapital, laufzeit, zinssatz);

        assertThrows(InvalidInputException.class, zinsrechner::berechneEndkapital);
    }
}