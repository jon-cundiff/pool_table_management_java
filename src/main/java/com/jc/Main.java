package com.jc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean running = true;
    static ArrayList<PoolTable> tables = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void mainLoop() {
        while (running) {
            UserDisplay.clearScreen();
            UserDisplay.displayTablesStatuses(tables);
            UserDisplay.displayOptions();
            String userInput = sc.nextLine();
            try {
                if (userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("q")) {
                    break;
                }
                switch (userInput) {
                    case "1" -> {
                        int tableIndex = UserDisplay.getPoolTableNumber(
                                "Which table number would you like to check out?",
                                tables.size());
                        tables.get(tableIndex - 1).checkOut();
                    }
                    case "2" -> {
                        System.out.println(2);
                    }
                    case "3" -> {
                        System.out.println(3);
                    }
                    case "q", "quit" -> running = false;
                    default -> throw new Exception("Invalid Input");
                }

            }  catch (IndexOutOfBoundsException e) {
                UserDisplay.displayError("Invalid Selection");
            }  catch (Exception e) {
                System.out.println(e.getClass());
                UserDisplay.displayError(e.getMessage());
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        for (int i = 1; i <=6; i++) {
            tables.add(new PoolTable(i));
        }

        mainLoop();
    }
}
