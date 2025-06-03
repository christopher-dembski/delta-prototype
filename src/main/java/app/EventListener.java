package app;

public interface EventListener {
    void update(EventType eventType, Object payload);
}
