package com.jc;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    static boolean running = true;
    static ArrayList<PoolTable> tables = new ArrayList<>();

    public static void mainLoop() {
        while (running) {
            try {
                UserDisplay.displayTablesStatuses(tables);
            } catch (Exception e) {
                System.out.println("error");
            }
            running = false;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <=6; i++) {
            tables.add(new PoolTable(i));
            tables.get(i - 1).startDateTime = LocalDateTime.now();
        }

        mainLoop();
    }
}
