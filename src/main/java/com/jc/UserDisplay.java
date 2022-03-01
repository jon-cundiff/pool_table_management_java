package com.jc;

import java.util.ArrayList;

public class UserDisplay {
    static void displayTablesStatuses(ArrayList<PoolTable> tables) {
        System.out.println("=========== Pool Tables ===========");
        for (PoolTable table : tables) {
            String statusString = String.format("%s: %s", table.tableNumber, table.getStatus());
            System.out.println(statusString);
        }
        System.out.println("===================================");
    }
}
