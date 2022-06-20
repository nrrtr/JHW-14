package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Ticket;
import ru.netology.repository.Repository;

public class ManagerTest {
    Ticket ticket1 = new Ticket(1,10_000, "NSK", "DME", 270);
    Ticket ticket2 = new Ticket(2,10_000, "DME", "NSK", 270);
    Ticket ticket3 = new Ticket(3,9_500, "DME", "VKO", 60);
    Ticket ticket4 = new Ticket(4,9_500, "VKO", "DME", 60);
    Ticket ticket5 = new Ticket(5,9_000, "SVO", "LED", 75);
    Ticket ticket6 = new Ticket(6,9_001, "NSK", "DME", 270);
    Ticket ticket7 = new Ticket(7,9_000, "NSK", "DME", 270);
    Repository repository = new Repository();
    Manager mng = new Manager(repository);

    @BeforeEach
    void setUp() {
        mng.save(ticket1);
        mng.save(ticket2);
        mng.save(ticket3);
        mng.save(ticket4);
        mng.save(ticket5);
        mng.save(ticket6);
        mng.save(ticket7);
    }

    @Test
    void shouldReturnResultWithOneTicket() {
        Ticket[] er = {ticket4};
        Ticket[] ar = mng.findAll("VKO", "DME");
        assertArrayEquals(er, ar);
    }

    @Test
    void shouldReturnSortedResultWithManyTickets() {
        Ticket[] er = {ticket7, ticket6, ticket1};
        Ticket[] ar = mng.findAll("NSK", "DME");
        assertArrayEquals(er, ar);
    }

    @Test
    void shouldReturnEmptyResultWithWrongSearchFirstParameter() {
        Ticket[] er = {};
        Ticket[] ar = mng.findAll("FROM", "DME");
        assertArrayEquals(er, ar);
    }

    @Test
    void shouldReturnEmptyResultWithWrongSearchSecondParameter() {
        Ticket[] er = {};
        Ticket[] ar = mng.findAll("NSK", "TO");
        assertArrayEquals(er, ar);
    }
    @Test
    void shouldReturnEmptyResultWithWrongSearchBothParameters() {
        Ticket[] er = {};
        Ticket[] ar = mng.findAll("FROM", "TO");
        assertArrayEquals(er, ar);
    }
}
