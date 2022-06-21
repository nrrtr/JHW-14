package ru.netology.manager;

import ru.netology.data.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {
    private Repository repo = new Repository();

    public Manager(Repository repository) {
        this.repo = repository;
    }

    public Repository getRepo() {
        return repo;
    }

    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    public void save(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] tickets = repo.findAll();
        Ticket[] result = new Ticket[0];

        for (int i = 0; i < tickets.length; i++) {
            if ((tickets[i].getDepartureAirport().equals(from)) && (tickets[i].getArrivalAirport().equals(to))) {
                Ticket[] tmp = new Ticket[result.length + 1];
                //System.arraycopy(result,0,tmp,0,result.length);
                for(int j = 0; j < result.length; j++) {
                    tmp[j] = result[j];
                }
                tmp[tmp.length - 1] = tickets[i];
                result = tmp;
            }
        }
        if (result.length != 0){
            Arrays.sort(result);
        }
        return result;
    }
}
