package com.vortexalex.shoppingbasket.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundingTest {

    private Rounding rounding = new Rounding();

    @Test
    public void test() {
        BigDecimal toBeRounded = new BigDecimal("1.499");
        assertEquals(new BigDecimal("1.50"), rounding.round(toBeRounded));
    }

    @Test
    public void test2() {
        BigDecimal toBeRounded = new BigDecimal("2.375");
        assertEquals(new BigDecimal("2.40"), rounding.round(toBeRounded));
    }

    @Test
    public void test3() {
        BigDecimal toBeRounded = new BigDecimal("2.3003");
        assertEquals(new BigDecimal("2.35"), rounding.round(toBeRounded));
    }

}
