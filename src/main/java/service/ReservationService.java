package service;

import custom_exceptions.NotEnoughFreeSeatsException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Event;
import model.Reservation;

import java.util.HashMap;
import java.util.UUID;

public class ReservationService {
    private static HashMap<UUID, Reservation> reservations = new HashMap<UUID, Reservation>();
    public static void addReservation(Reservation r) throws NotUniqueIdentifierException, NotEnoughFreeSeatsException {
        if (!reservations.containsKey(r.getUuid())) {
            if(getFreeSeats(r.getEventUuid()) >= r.getSeats()) {
                for (Reservation it : reservations.values()) {
                    if (r.getCustomerName().equals(it.getCustomerName()) && r.getEventUuid() == it.getEventUuid()) {
                        r.increaseSeats(it.getSeats());
                        reservations.remove(it.getUuid());
                    }
                }
                reservations.put(r.getUuid(), r);
            } else {
                throw new NotEnoughFreeSeatsException();
            }
        } else {
            throw new NotUniqueIdentifierException();
        }
    }

    public static Reservation findReservation(String customerName, UUID eventUuid) {
        for (Reservation it : reservations.values()) {
            if (customerName.equals(it.getCustomerName()) && eventUuid == it.getEventUuid()) {
                return it;
            }
        }
        return null;
    }

    public static Integer getFreeSeats(UUID eventUuid) {
        Event e = EventService.getEvents().get(eventUuid);
        Integer freeSeats = e.getSeats();

        for (Reservation r : reservations.values()) {
            if (r.getEventUuid() == eventUuid) {
                freeSeats -= r.getSeats();
            }
        }

        return freeSeats;
    }

    public static void reset() {
        reservations.clear();
    }

    public static HashMap<UUID, Reservation> getReservations() {
        return reservations;
    }
}
