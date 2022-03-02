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

    String getEntry() {
        return String.format("""
                ===============================
                  Start    - %s
                  End      - %s
                  Duration - %s mins
                  Cost     - $%s
                ===============================""",
                checkOutDateTime.format(UserDisplay.dtFormat),
                checkInDateTime.format(UserDisplay.dtFormat),
                durationMins,
                cost
                );
    }
}
