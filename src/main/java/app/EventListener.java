package app;

// TO DO: can we make the event listener typed to avoid casting the payload as Object for increased type safety?
public interface EventListener {
    void update(EventType eventType, Object payload);
}
