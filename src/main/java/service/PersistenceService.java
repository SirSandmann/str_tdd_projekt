package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import model.Customer;
import model.Event;
import model.Reservation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class PersistenceService {
    private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.CLOSE_CLOSEABLE.INDENT_OUTPUT);

    static void saveCustomers() {
        try {
            mapper.writeValue(new File("./customers.json"), CustomerService.getCustomers());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Customer> loadCustomers() {
        HashMap<String, Customer> customers = new HashMap<>();
        try {
            customers = mapper.readValue(new File("./customers.json"), TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, Customer.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    static void saveEvents() {
        try {
            mapper.writeValue(new File("./events.json"), EventService.getEvents());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<UUID, Event> loadEvents() {
        HashMap<UUID, Event> events = new HashMap<>();
        try {
            events = mapper.readValue(new File("./events.json"), TypeFactory.defaultInstance().constructMapType(HashMap.class, UUID.class, Event.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }

    static void saveReservations() {
        try {
            mapper.writeValue(new File("./reservations.json"), ReservationService.getReservations());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<UUID, Reservation> loadReservations() {
        HashMap<UUID, Reservation> reservations = new HashMap<>();
        try {
            reservations = mapper.readValue(new File("./reservations.json"), TypeFactory.defaultInstance().constructMapType(HashMap.class, UUID.class, Reservation.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
