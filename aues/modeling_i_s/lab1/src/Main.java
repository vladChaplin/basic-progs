import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        AlgorithmMiddleOfProduct algo = new AlgorithmMiddleOfProduct("0.173123", "0.971573", 100, 3);
        algo.init();
    }

    private void initTest() {
        //0,943954094329
//        var z0 = new BigDecimal("0.971573");
        var z0 = new BigDecimal("0.183123");
        int index = 3;
        final var quantityIter = 100;
        final var templateIntZero = "0.";

        for(int i = 0; i < quantityIter; i++) {
            var zSquared = z0.pow(2);
            String numberStr = zSquared.toString();
            int startIndex = numberStr.indexOf(".") + 1 +index;
            int endIndex = numberStr.length() - index;
            String result = "";
            try {
                result = templateIntZero + zSquared.toString().substring(startIndex, endIndex);
            } catch (StringIndexOutOfBoundsException exp) {
                result = "0.0";
                System.out.println("Строка закончилась! ");
            }
            var resValue = new BigDecimal(result);


            System.out.printf("(%s)^2 = %s. Z%s = %s\n", z0, zSquared, i+1, resValue);
            z0 = resValue;

            if(result.equals("0.0")) break;
        }
    }
}