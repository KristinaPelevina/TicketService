package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private Ticket first = new Ticket(1, 10000, "OMS", "DME", 205);
    private Ticket second = new Ticket(2, 7000, "OMS", "DME", 205);
    private Ticket third = new Ticket(3, 20000, "OMS", "LED", 205);

    @BeforeEach
    public void setUp() {
        manager = new TicketManager(repository);
    }

    @Test
    public void shouldReturnEmptyIfNoTickets() {
        manager.ticketAdd(first);
        manager.ticketAdd(second);
        manager.ticketAdd(third);
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("OVB", "VVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTicketIfContains() {
        manager.ticketAdd(first);
        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = manager.findAll("OMS", "DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsIfContains() {
        manager.ticketAdd(first);
        manager.ticketAdd(second);
        manager.ticketAdd(third);
        Ticket[] expected = new Ticket[]{second, first};
        Ticket[] actual = manager.findAll("OMS", "DME");
        assertArrayEquals(expected, actual);
    }
}