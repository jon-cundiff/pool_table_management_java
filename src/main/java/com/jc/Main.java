package com.jc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean running = true;
    static ArrayList<PoolTable> tables = new ArrayList<>();

    public static void mainLoop() {
        Scanner sc = new Scanner(System.in);
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
                    case "1" -> System.out.println(1);
                    case "2" -> System.out.println(2);
                    case "3" -> System.out.println(3);
                    case "q", "quit" -> running = false;
                    default -> throw new Exception("Invalid Input");
                }

            }  catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        for (int i = 1; i <=6; i++) {
            tables.add(new PoolTable(i));
            tables.get(i - 1).startDateTime = LocalDateTime.now();
        }

        mainLoop();
    }
}
