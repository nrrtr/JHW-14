package ru.netology.comporator;

import ru.netology.data.Ticket;

import java.util.Comparator;

public class TicketByTravelTimeAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}