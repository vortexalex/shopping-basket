package com.vortexalex.shoppingbasket.printing;

import com.vortexalex.shoppingbasket.Receipt;

import java.util.Optional;

public class ConsolePrintService implements PrintService {

    @Override
    public void print(Receipt receipt) {
        System.out.println("RECEIPT OUTPUT");
        receipt.getItems().forEach((k, v) -> System.out.println(k.getDescription() + ": " + v));
        System.out.println("Salex Taxes: " + receipt.getTaxes());
        System.out.println("Total: " + receipt.getTotal());
        System.out.println("-----------------");
    }
}
