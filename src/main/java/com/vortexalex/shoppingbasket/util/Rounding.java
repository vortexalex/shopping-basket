package com.vortexalex.shoppingbasket.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rounding {

    public static BigDecimal round(BigDecimal in) {
        BigDecimal divided = in.divide(new BigDecimal("0.05"), 0, RoundingMode.UP);
        BigDecimal result = divided.multiply(new BigDecimal("0.05"));
        return result;
    }
}
