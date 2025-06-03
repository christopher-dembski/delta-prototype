package app;

// main class that runs the App and contains some global data
// that is useful to access everywhere throughout the app like the currently logged in user
public class App {
    private final EventManager eventManager = new EventManager();
    private static App instance;

    private int currentUserId;

    public static void main(String[] args) {
        // TO DO: database setup
        // render UI
       AppView.getInstance();
    }

    public EventManager eventManager() {
        return eventManager;
    }

    // singleton pattern: one instance of the app
    public static App instance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    // this is a common pattern I've seen, where some globally useful data is made available everywhere
    public int getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(int id) {
        currentUserId = id;
    }
}
