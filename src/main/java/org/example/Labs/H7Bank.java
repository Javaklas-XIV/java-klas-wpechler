package org.example.Labs;

import org.example.Manager.BankManager;

import java.util.List;
import java.util.Scanner;


public class H7Bank {
    static Scanner scanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {
        setup();
        System.out.println("...");
        input = scanner.nextLine();
    }

    public static void setup() {
        List.of(BankManager.addBank("ABN"),
                BankManager.addBank("Rabobank"),
                BankManager.addBank("SNS"),
                BankManager.addBank("DSB"))
            .forEach(x -> {
                x.createBankAccounts(10);
                System.out.println("Bank: " + x.getBankName());
            });
    }
}
