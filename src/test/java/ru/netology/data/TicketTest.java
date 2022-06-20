package ru.netology.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {
    Ticket ticket1 = new Ticket(1,10_000, "NSK", "DME", 270);
    Ticket ticket2 = new Ticket(2,10_000, "DME", "NSK", 270);
    Ticket ticket3 = new Ticket(3,9_500, "DME", "VKO", 60);
    Ticket ticket4 = new Ticket(4,9_500, "VKO", "DME", 60);

    @Test
    void shouldReturnTravelTime() {
        int ar = ticket1.getTravelTime();
        int er = 270;
        Assertions.assertEquals(er, ar);
    }

    @Test
    void shouldCompareToBiggerOne() {
        int ar = ticket3.compareTo(ticket1);
        int er = -1;
        Assertions.assertEquals(er, ar);
    }
    @Test
    void shouldCompareToLowerOne() {
        int ar = ticket1.compareTo(ticket3);
        int er = 1;
        Assertions.assertEquals(er, ar);
    }

    @Test
    void shouldCompareToEqualsOne() {
        int ar = ticket1.compareTo(ticket2);
        int er = 0;
        Assertions.assertEquals(er, ar);
    }
}
