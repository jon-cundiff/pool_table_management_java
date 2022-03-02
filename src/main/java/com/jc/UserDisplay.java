package com.jc;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDisplay {
    static Scanner sc;
    static DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("MM/dd - hh:mm a");

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
                Enter "q" to quit.""");
    }

    static void displayTableEntries(int tableIndex) {
        sc = new Scanner(System.in);
        ArrayList<TableEntry> entries = Main.tables.get(tableIndex).entries;
        if (entries.isEmpty()) {
            System.out.println("No entries");
        } else {
            for (TableEntry entry : entries) {
                System.out.println(entry.getEntry());
            }
        }
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }

    static void displayError(String message) {
        sc = new Scanner(System.in);
        System.out.println(message);
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }

    static String getCommand() {
        sc = new Scanner(System.in);
        return sc.nextLine();
    }

    static int getPoolTableNumber(String message) {
        sc = new Scanner(System.in);
        System.out.printf("%s (1-%s)\n", message, Main.tables.size());
        return sc.nextInt();
    }
}
