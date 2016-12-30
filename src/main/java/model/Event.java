package model;

import java.util.Date;
import java.util.UUID;

public class Event {
    private UUID uuid;
    private String title;
    private Date date;
    private double price;
    private int seats;
    private String email;

    public Event() {
    }

    public Event(String title, Date date, double price, int seats, String email) {
        this.setTitle(title);
        this.setDate(date);
        this.setPrice(price);
        this.setSeats(seats);
        this.setUuid(UUID.randomUUID());
        this.setEmail(email);
    }

    public UUID getUuid() {
        return this.uuid;
    }

    private void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return this.date;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public int getSeats() {
        return this.seats;
    }

    private void setSeats(int seats) {
        this.seats = seats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Event e) {
        return (e.getTitle().equals(this.title) &&
                e.getDate().equals(this.date) &&
                e.getPrice() == this.price &&
                e.getSeats() == this.seats &&
                e.getEmail().equals(this.email)&&
                e.getUuid().equals(this.uuid));
    }
}
