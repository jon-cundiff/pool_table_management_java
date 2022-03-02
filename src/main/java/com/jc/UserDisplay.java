package com.jc;

import java.util.ArrayList;

public class UserDisplay {
    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void displayTablesStatuses(ArrayList<PoolTable> tables) {
        System.out.println("=========== Pool Tables ===========");
        for (PoolTable table : tables) {
            String statusString = String.format("%s: %s", table.tableNumber, table.getStatus());
            System.out.println(statusString);
        }
        System.out.println("===================================");
    }

    static void displayOptions() {
        System.out.println("""
                1. Check out a pool table
                2. Check in pool table
                3. Get pool table log
                Enter "q" to quit.
                """);
    }

    static void displayError(String message) {
        System.out.println(message);
        System.out.println("Press any key to continue...");
        Main.sc.nextLine();
    }

    static int getPoolTableNumber(String message, int limit) {
        System.out.printf("%s (1-%s)\n", message, limit);
        return Main.sc.nextInt();
    }
}