package com.jc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;

public class PoolTable {
    int tableNumber;
    LocalDateTime startDateTime;
    BigDecimal rate = new BigDecimal(30);

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

    void checkOut() {
        startDateTime = LocalDateTime.now();
    }
}