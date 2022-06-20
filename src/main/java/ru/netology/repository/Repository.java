package ru.netology.repository;

import ru.netology.data.Ticket;

public class Repository {
    private Ticket[] ticketsStorage = new Ticket[0];

    public Repository() {

    }

    public Ticket[] getTicketsStorage() {
        return ticketsStorage;
    }

    public void setTicketStorage(Ticket[] ticketsStorage) {
        this.ticketsStorage = ticketsStorage;
    }

    public void add(Ticket inputTicket) {
        Ticket[] tmp = new Ticket[ticketsStorage.length + 1];
        for (int i = 0; i < ticketsStorage.length; i++) {
            tmp[i] = ticketsStorage[i];
        }
        tmp[tmp.length - 1] = inputTicket;
        setTicketStorage(tmp);
    }

    public Ticket[] findAll(){
        return ticketsStorage;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[ticketsStorage.length - 1];
        int tempIndex = 0;
        for (int i = 0; i < ticketsStorage.length; i++) {
            if (ticketsStorage[i].getId() != id) {
                tmp[tempIndex] = ticketsStorage[i];
                tempIndex++;
            }
        }
        setTicketStorage(tmp);
    }
}
