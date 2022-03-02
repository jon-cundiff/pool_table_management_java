package com.jc;

import java.util.ArrayList;

public class Main {
    static boolean running = true;
    static ArrayList<PoolTable> tables = new ArrayList<>();

    public static void mainLoop() {
        while (running) {
            UserDisplay.clearScreen();
            UserDisplay.displayTablesStatuses(tables);
            UserDisplay.displayOptions();
            String userInput = UserDisplay.getCommand();
            try {
                if (userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("q")) {
                    break;
                }
                switch (userInput) {
                    case "1" -> {
                        int tableIndex = UserDisplay.getPoolTableNumber(
                                "Which table number would you like to check out?");
                        tables.get(tableIndex - 1).checkOut();
                    }
                    case "2" -> {
                        int tableIndex = UserDisplay.getPoolTableNumber(
                                "Which table number is getting checked in?");
                        tables.get(tableIndex - 1).checkIn();
                    }
                    case "3" -> System.out.println(3);
                    case "q", "quit" -> running = false;
                    default -> throw new Exception("Invalid Input");
                }

            }  catch (IndexOutOfBoundsException e) {
                UserDisplay.displayError("Invalid Selection");
            }  catch (Exception e) {
                UserDisplay.displayError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <=6; i++) {
            tables.add(new PoolTable(i));
        }

        mainLoop();
    }
}
