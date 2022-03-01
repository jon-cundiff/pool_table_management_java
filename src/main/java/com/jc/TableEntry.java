package com.jc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TableEntry {
    LocalDateTime checkOutDateTime;
    LocalDateTime checkInDateTime;
    int durationMins;
    BigDecimal cost;

    TableEntry(LocalDateTime checkOut, LocalDateTime checkIn, int duration, BigDecimal cost) {
        this.checkOutDateTime = checkOut;
        this.checkInDateTime = checkIn;
        this.durationMins = duration;
        this.cost = cost;
    }
}
