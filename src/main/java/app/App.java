package app;

public class App {
    private static final EventManager EVENT_MANAGER = new EventManager();

    public static void main(String[] args) {
        // TO DO: database setup
       AppView.getInstance();
    }

    public static EventManager eventManager() {
        return EVENT_MANAGER;
    }
}
