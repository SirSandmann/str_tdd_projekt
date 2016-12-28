package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Customer;
import model.Event;
import model.Reservation;

public class Service {
    private static HashMap<String, Customer> customers = new HashMap<String, Customer>();
    private static HashMap<UUID, Event> events = new HashMap<UUID, Event>();
    private static HashMap<UUID, Reservation> reservations = new HashMap<UUID, Reservation>();

    public static void addCustomer(Customer c) throws CustomerSameNameException {
        if (!customers.containsKey(c.getName())) {
            customers.put(c.getName(), c);
        } else {
            throw new CustomerSameNameException();
        }
    }

    public static void addEvent(Event e) throws NotUniqueIdentifierException {
        if (!events.containsKey(e.getUuid())) {
            events.put(e.getUuid(), e);
        } else {
            throw new NotUniqueIdentifierException();
        }
    }

    public static void addReservation(Reservation r) throws NotUniqueIdentifierException {
        if (!reservations.containsKey(r.getUuid())) {
            for (Reservation it : reservations.values()) {
                if (r.getCustomerName().equals(it.getCustomerName()) && r.getEventUuid() == it.getEventUuid()) {
                    r.increaseSeats(it.getSeats());
                    reservations.remove(it.getUuid());
                }
            }
            reservations.put(r.getUuid(), r);
        } else {
            throw new NotUniqueIdentifierException();
        }
    }

    public static Integer getFreeSeats(UUID eventUuid) {
        Event e = events.get(eventUuid);
        Integer freeSeats = e.getSeats();

        for (Reservation r : reservations.values()) {
            if (r.getEventUuid() == eventUuid) {
                freeSeats -= r.getSeats();
            }
        }

        return freeSeats;
    }

    public static void reset() {
        resetReservations();
        resetEvents();
        resetCustomers();
    }

    private static void resetCustomers() {
        customers.clear();
    }

    private static void resetEvents() {
        events.clear();
    }

    private static void resetReservations() {
        reservations.clear();
    }

    public static HashMap<String, Customer> getCustomers() {
        return customers;
    }

    public static HashMap<UUID, Event> getEvents() {
        return events;
    }

    public static HashMap<UUID, Reservation> getReservations() {
        return reservations;
    }
}
