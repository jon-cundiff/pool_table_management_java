package com.jc;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


public class PoolTableTest {
    PoolTable poolTable;

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
}
