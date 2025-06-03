package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// Design Pattern (Observer): enables subscribing to and listening for events
public class EventManager {
    private final Map<EventType, Collection<EventListener>> listeners = new HashMap<>();

    public void subscribe(EventType eventType, EventListener listener) {
        if (!listeners.containsKey(eventType)) {
            listeners.put(eventType, new ArrayList<>());
        }
        listeners.get(eventType).add(listener);
    }

    public void notify(EventType eventType, Object value) {
        for (EventListener listener : listeners.get(eventType)) {
            // TO DO: add type to events to allow
            // calling listener.update with different params
            listener.update(eventType, value);
        }
    }
}
