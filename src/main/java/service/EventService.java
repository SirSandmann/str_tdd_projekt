package service;

import custom_exceptions.NotUniqueIdentifierException;
import model.Event;

import java.util.HashMap;
import java.util.UUID;

public class EventService {
    private static HashMap<UUID, Event> events = new HashMap<UUID, Event>();

    public static void addEvent(Event e) throws NotUniqueIdentifierException {
        if (!events.containsKey(e.getUuid())) {
            events.put(e.getUuid(), e);
        } else {
            throw new NotUniqueIdentifierException();
        }
        PersistenceService.saveEvents();
    }

    public static void reset() {
        events.clear();
    }

    public static HashMap<UUID, Event> getEvents() {
        return events;
    }
}
