import java.math.BigDecimal;
import java.math.RoundingMode;

public class Zinsrechner {

    private BigDecimal anfangskapital;
    private int laufzeit;
    private BigDecimal zinssatz;

    public Zinsrechner(BigDecimal anfangskapital, int laufzeit, BigDecimal zinssatz) throws InvalidInputException, InvalidLaufzeitException {
        validateInput(anfangskapital, laufzeit, zinssatz);
        validateLaufzeit(laufzeit);
        this.anfangskapital = anfangskapital;
        this.laufzeit = laufzeit;
        this.zinssatz = zinssatz;
    }

    private void validateInput(BigDecimal anfangskapital, int laufzeit, BigDecimal zinssatz) throws InvalidInputException {
        if (anfangskapital.compareTo(BigDecimal.ZERO) <= 0 ||
                laufzeit <= 0 ||
                zinssatz.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidInputException("Ungültige Eingabeparameter");
        }
    }

    private void validateLaufzeit(int laufzeit) throws InvalidLaufzeitException {
        if (laufzeit <= 0) {
            throw new InvalidLaufzeitException("Ungültige Laufzeit");
        }
    }

    public BigDecimal berechneEndkapital() {
        if (anfangskapital.compareTo(BigDecimal.ZERO) < 0 || laufzeit < 0 || zinssatz.compareTo(BigDecimal.ZERO) < 0 || zinssatz.compareTo(BigDecimal.valueOf(100)) > 0 || anfangskapital.stripTrailingZeros().scale() > 0) {
            try {
                throw new InvalidInputException("Ungültige Eingabeparameter");
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }
        }else{
            BigDecimal zinssatzAlsProzentsatz = zinssatz.divide(new BigDecimal(100));
            BigDecimal endkapital = anfangskapital.multiply(zinssatzAlsProzentsatz.add(BigDecimal.ONE).pow(laufzeit));
            return endkapital.setScale(2, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal berechneZinsen() {
        return berechneEndkapital().subtract(anfangskapital).setScale(2, RoundingMode.HALF_UP);
    }

    public void zeigeAufschluesselung() {
        System.out.println("Endkapital (Sparsumme): " + berechneEndkapital() + " EUR");
        System.out.println("Einlage: " + anfangskapital + " EUR");
        System.out.println("Zinsen: " + berechneZinsen() + " EUR");
    }
}