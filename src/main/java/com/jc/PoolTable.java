package com.jc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PoolTable {
    int tableNumber;
    LocalDateTime startDateTime;
    BigDecimal rate = new BigDecimal(30);
    ArrayList<TableEntry> entries = new ArrayList<>();

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

    BigDecimal getTotalCost(int playTime) {
        var hours = new BigDecimal(playTime / 60.0);
        return rate.multiply(hours).setScale(2, RoundingMode.HALF_UP);
    }

    void checkOut() throws IllegalAccessException {
        if (startDateTime != null) {
            throw new IllegalAccessException("Table already checked out!");
        }
        startDateTime = LocalDateTime.now();
    }

    void checkIn() throws IllegalAccessException{
        if (startDateTime == null) {
            throw new IllegalAccessException("Table not checked out!");
        }

        LocalDateTime endDateTime = LocalDateTime.now();
        int playTime = getTotalTimePlayed(endDateTime);
        var newEntry = new TableEntry(startDateTime, endDateTime, playTime, getTotalCost(playTime));
        entries.add(newEntry);

        startDateTime = null;
    }

    String getStatus() {
        if (startDateTime == null) {
            return "Unoccupied";
        } else {
            return String.format("Occupied since %s", startDateTime.format(UserDisplay.dtFormat));
        }
    }
}
