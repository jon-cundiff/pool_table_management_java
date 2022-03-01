package com.jc;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

public class PoolTable {
    int tableNumber;
    LocalDateTime startDateTime;

    public PoolTable(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    boolean isOccupied() {
        return startDateTime != null;
    }

    int getTotalTimePlayed(LocalDateTime endDateTime) {
        Duration duration = Duration.between(startDateTime, endDateTime);
        return (int)duration.getSeconds() / 60 ;
    }
}
