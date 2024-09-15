import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorithmMiddleOfProduct {
    private List<BigDecimal> valuesZ;
    private int countIteration;
    private int halfDigit;

    public AlgorithmMiddleOfProduct(String valueZ1, String valueZ2, int countIteration, int halfDigit) {
        this.valuesZ = new ArrayList<>(Arrays.asList(new BigDecimal(valueZ1), new BigDecimal(valueZ2)));
        this.countIteration = countIteration;
        this.halfDigit = halfDigit;
    }

    public void init() {

        for(int i = 0; i < countIteration; i++) {
            var firstZ = valuesZ.get(i);
            var secondZ = valuesZ.get(i+1);
            var result = firstZ.multiply(secondZ);
            var newZ = discardResult(result.toString());
            valuesZ.add(newZ);
            System.out.printf("%s * %s = %s. Z%s = %s. \n", firstZ, secondZ, result, i+1, newZ);
        }
    }

    public BigDecimal discardResult(String value) {
        int startIndex = value.indexOf(".") + 1 +halfDigit;
        int endIndex = value.length() - halfDigit;
        final var templateIntZero = "0.";

        try {
            var result = templateIntZero + value.substring(startIndex, endIndex);
            return new BigDecimal(result);
        } catch (StringIndexOutOfBoundsException exp) {
            System.out.println("Строка закончилась! ");
            return null;
        }
    }
}
