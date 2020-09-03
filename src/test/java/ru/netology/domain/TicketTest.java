package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private Ticket first = new Ticket(1, 10000, "OMS", "DME", 205);
    private Ticket second = new Ticket(2, 7000, "OMS", "OVB", 205);
    private Ticket third = new Ticket(3, 20000, "OMS", "LED", 205);

    @Test
    public void shouldSortTicketsByPrice() {
        Ticket[] expected = new Ticket[]{second, first, third};
        Ticket[] actual = new Ticket[]{first, second, third};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
}