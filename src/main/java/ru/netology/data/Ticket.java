package ru.netology.data;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    public Ticket(int id, int price, String departure, String arrival, int travelTime) {
        this.id = id;
        this.price = price;
        this.departureAirport = departure;
        this.arrivalAirport = arrival;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }


    public String getDepartureAirport() {
        return departureAirport;
    }


    public String getArrivalAirport() {
        return arrivalAirport;
    }


    public int getTravelTime() {
        return travelTime;
    }


    @Override
    public int compareTo(Ticket inputTicket) {
        if (this.getPrice() < inputTicket.getPrice()) {
            return -1;
        }
        if (this.getPrice() > inputTicket.getPrice()) {
            return 1;
        }
        return 0;
    }
}
