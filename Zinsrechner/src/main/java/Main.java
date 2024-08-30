import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidInputException, InvalidLaufzeitException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte Anfangskapital eingeben (nur ganze, positive Zahlen): ");
        BigDecimal anfangskapital = scanner.nextBigDecimal();

        System.out.println("Bitte Laufzeit eingeben (nur ganze, positive Zahlen): ");
        int laufzeit = scanner.nextInt();

        System.out.println("Bitte Zinssatz eingeben (float mit zwei Dezimalstellen, [0;100]): ");
        BigDecimal zinssatz = scanner.nextBigDecimal();

        scanner.close();

        Zinsrechner sparbuch = new Zinsrechner(anfangskapital, laufzeit, zinssatz);
        sparbuch.zeigeAufschluesselung();
    }
}