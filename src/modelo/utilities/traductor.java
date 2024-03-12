package modelo.utilities;

import java.math.BigDecimal;
import java.math.BigInteger;

public class traductor {
    public traductor(){

    }
    public BigDecimal getDecimalValueFromBinary(String binaryString){
        // Convert binary string to BigDecimal
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal factor = BigDecimal.ONE;

        // Split the binary string into integer and fractional parts
        String[] parts = binaryString.split("\\.");

        // Convert integer part
        for (int i = parts[0].length() - 1; i >= 0; i--) {
            if (parts[0].charAt(i) == '1') {
                result = result.add(factor);
            }
            factor = factor.multiply(BigDecimal.valueOf(2));
        }

        // Convert fractional part
        if (parts.length > 1) {
            factor = BigDecimal.ONE.divide(BigDecimal.valueOf(2));
            for (int i = 0; i < parts[1].length(); i++) {
                if (parts[1].charAt(i) == '1') {
                    result = result.add(factor);
                }
                factor = factor.divide(BigDecimal.valueOf(2));
            }
        }

        return result;
    }
    public String getBinaryRepresentationFromDecimal(BigDecimal decimalValue) {
        // Scale is the number of digits to the right of the decimal point.
        int scale = decimalValue.scale();
        // Unscaled value is the value of the BigDecimal without the scale.
        BigInteger unscaledValue = decimalValue.unscaledValue();

        StringBuilder binaryRepresentation = new StringBuilder();

        // If the value is negative, add a '-' sign to the binary representation.
        if (decimalValue.signum() == -1) {
            binaryRepresentation.append("-");
        }

        // Convert the unscaled value to binary.
        String unscaledBinary = unscaledValue.toString(2);
        binaryRepresentation.append(unscaledBinary);


        return binaryRepresentation.toString();
    }
}