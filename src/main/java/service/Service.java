package service;

import java.util.HashMap;
import java.util.UUID;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Customer;
import model.Event;

public class Service {
    private static HashMap<String, Customer> customers = new HashMap<String, Customer>();
    private static HashMap<UUID, Event> events = new HashMap<UUID, Event>();

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

    public static void reset() {
        resetEvents();
        resetCustomers();
    }

    private static void resetCustomers() {
        customers.clear();
    }

    private static void resetEvents() {
        events.clear();
    }

    public static HashMap<String, Customer> getCustomers() {
        return customers;
    }

    public static HashMap<UUID, Event> getEvents() {
        return events;
    }
}
