package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.TicketManager;

import static org.junit.jupiter.api.Assertions.*;


class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket first = new Ticket(1, 7000, "OMS", "DME", 205);
    private Ticket second = new Ticket(2, 10000, "OMS", "DME", 205);
    private Ticket third = new Ticket(3, 20000, "OMS", "LED", 205);

    @BeforeEach
    public void setUp() {
        repository = new TicketRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldFindAllTickets() {
        Ticket[] expected = new Ticket[]{first, second, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExist() {
        int idToFind = 3;

        Ticket expected = third;
        Ticket actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfNotExist() {
        int idToFind = 4;

        Ticket expected = null;
        Ticket actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfExist() {
        int idToRemove = 2;

        repository.removeById(idToRemove);

        Ticket[] expected = {first, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(4));
    }
}