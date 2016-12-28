package model;

import java.util.UUID;

public class Reservation {
    private UUID uuid;
    private String customerName;
    private UUID eventUuid;
    private Integer seats;

    public Reservation() {
    }

    public Reservation(String customerName, UUID eventUuid, Integer seats) {
        this.setUuid(UUID.randomUUID());
        this.setCustomerUuid(customerName);
        this.setEventUuid(eventUuid);
        this.setSeats(seats);
    }

    public UUID getUuid() {
        return uuid;
    }

    private void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCustomerName() {
        return customerName;
    }

    private void setCustomerUuid(String customerName) {
        this.customerName = customerName;
    }

    public UUID getEventUuid() {
        return eventUuid;
    }

    private void setEventUuid(UUID eventUuid) {
        this.eventUuid = eventUuid;
    }

    public Integer getSeats() {
        return seats;
    }

    private void setSeats(Integer seats) {
        this.seats = seats;
    }

    public void increaseSeats(Integer value) {
        this.seats += value;
    }

    public void decreaseSeats(Integer value) {
        if (this.seats - value >= 0) {
            this.seats -= value;
        }
    }

    public boolean equals(Reservation r) {
        return (r.getUuid().equals(this.uuid) &&
                r.getSeats().equals(this.seats) &&
                r.getEventUuid().equals(this.eventUuid) &&
                r.getCustomerName().equals(this.customerName));
    }
}
