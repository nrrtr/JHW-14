package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.data.Ticket;

public class RepositoryTest {
    Repository repo = new Repository();
    Ticket ticket1 = new Ticket(10_000, "NSK", "DME", 270);
    Ticket ticket2 = new Ticket(10_000, "DME", "NSK", 270);
    Ticket ticket3 = new Ticket(9_500, "DME", "VKO", 60);
    Ticket ticket4 = new Ticket(9_500, "VKO", "DME", 60);


    @Test
    void shouldRemoveByIDFromRepoWithOnlyOneTicket() {
        repo.add(ticket1);
        repo.removeById(1);
        Ticket[] er = {};
        Ticket[] ar = repo.findAll();
        assertArrayEquals(er, ar);
    }

    @Test
    void shouldRemoveByIDFromRepoWithManyTickets() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.removeById(3);
        Ticket[] er = {ticket1, ticket2, ticket4};
        Ticket[] ar = repo.findAll();
        assertArrayEquals(er, ar);
    }

    @Test
    void shouldAddToEmptyRepo() {
        repo.add(ticket1);
        Ticket[] er = {ticket1};
        Ticket[] ar = repo.getTicketsStorage();
        assertArrayEquals(er, ar);
    }

    @Test
    void shouldAddToNotEmptyRepo() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);

        Ticket[] ar = {ticket1, ticket2, ticket3};
        Ticket[] er = repo.getTicketsStorage();
        assertArrayEquals(er, ar);
    }

    @Test
    void shouldFindAllInEmptyRepo() {
        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllInNotEmptyRepo() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}
