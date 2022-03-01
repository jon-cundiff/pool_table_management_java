package com.jc;

import java.time.LocalDateTime;

public class PoolTable {
    int tableNumber;
    LocalDateTime startDateTime;

    public PoolTable(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    boolean isOccupied() {
        return startDateTime != null;
    }


}
