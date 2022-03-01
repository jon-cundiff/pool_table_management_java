package com.jc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


public class PoolTableTest {
    PoolTable poolTable;
    LocalDateTime startDateTime = LocalDateTime.of(2021, 12, 1, 18, 0);

    @BeforeEach
    void init() {
        poolTable = new PoolTable(1);
    }

    @Test
    @DisplayName("Pool table knows if occupied")
    void testPoolTableOccupied() {
        assertFalse(poolTable.isOccupied());
        poolTable.startDateTime = LocalDateTime.now();
        assertTrue(poolTable.isOccupied());
    }

    @Test
    @DisplayName("Pool table can calculate play time properly")
    void testPlayTimeCalculation() {
        poolTable.startDateTime = startDateTime;
        LocalDateTime endDateTime = LocalDateTime.of(2021, 12, 1, 18, 30);
        assertEquals(30, poolTable.getTotalTimePlayed(endDateTime));
    }

    @Test
    @DisplayName("Pool table can calculate cost properly")
    void testPlayTimeCost() {
        int playTime = 30;
        BigDecimal cost = poolTable.getTotalCost(playTime);
        assertEquals(new BigDecimal("15.00"), cost);
    }

    @Test
    @DisplayName("Pool table can be checked out")
    void testCheckOut() {
        assertDoesNotThrow(() -> poolTable.checkOut());
        assertNotNull(poolTable.startDateTime);
    }

    @Test
    @DisplayName("Pool cannot be checked out while checked out")
    void testDuplicateCheckOut() {
        poolTable.startDateTime = startDateTime;
        assertThrows(IllegalAccessException.class, () -> poolTable.checkOut());
    }
}
