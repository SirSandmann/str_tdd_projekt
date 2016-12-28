package service;

import java.util.ArrayList;
import java.util.HashMap;

import custom_exceptions.CustomerSameNameException;
import model.Customer;
import model.Event;

public class Service {
    private static HashMap<String, Customer> customers = new HashMap<String, Customer>();
    private static ArrayList<Event> events = new ArrayList<Event>();

    public static void addCustomer(Customer c) throws CustomerSameNameException {
        if (!customers.containsKey(c.getName())) {
            customers.put(c.getName(), c);
        } else {
            throw new CustomerSameNameException();
        }
    }

    public static void addEvent(Event e){
        events.add(e);
    }

    public static void reset() {
        resetEvents();
        resetCustomers();
    }

    private static void resetCustomers(){
        customers.clear();
    }

    private static void resetEvents(){
        events.clear();
    }

    public static HashMap<String, Customer> getCustomers() {
        return customers;
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }
}
