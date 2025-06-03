package app;

import goals.ui.GoalsView;
import profile.ui.LoginView;
import profile.ui.ProfileView;

import javax.swing.*;
import java.awt.*;

// Views define the UI of the App
// they should not contain any business logic, and are just about rendering the UI
public class AppView implements EventListener {
    // this component is the main UI window for the App
    // containing the header bar to switch between tabs

    // singleton design patter (one instance of app)
    private static AppView instance;
    // the corresponding View Model would be responsible for handling front end logic not directly related to the UI
    // for example, calling the API and fetching data, etc.
    // we could also not have a view model layer and just put the data fetching logic in the views themselves
    // this concept is used on Android development
    // and is a common front-end pattern https://developer.android.com/topic/libraries/architecture/viewmodel
    private AppViewModel appViewModel;

    // a frame is the overall window for the UI
    private final JFrame frame;

    // components for the header allowing you to switch between tabs
    private JTabbedPane header;
    private Component loginView;
    private Component profileView;
    private Component goalsView;


    private AppView() {
        instance = this;
        appViewModel = new AppViewModel();

        // listen for login events
        App.instance().eventManager().subscribe(EventType.LOGIN, this);

        // the entire window the app runs in
        frame = new JFrame();
        frame.setTitle("Delta App");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // render login screen on startup
        loginView = new LoginView();
        frame.add(loginView);

        // we want to see the app...
        frame.setVisible(true);
        // testing flash message
        AppView.getInstance().flashMessage("Testing a flash message.", "Flash", JOptionPane.INFORMATION_MESSAGE);
    }

    // Design Pattern (Singleton): one instance of the app
    public static AppView getInstance() {
        if (instance == null) {
            instance = new AppView();
        }
        return instance;
    }

    // TO DO: define enum for message type wrapping JOptionPane.INFORMATION_MESSAGE
    // TO DO: decide whether to move out to separate class
    // Pro: separates flash message logic
    // Con: requires exposing frame publicly to the FlashMessage class
    public void flashMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(frame, message, title, type);
    }

    // TO DO: should probably handle this logic in the view model instead
    private void handleLogin(int id) {
        // navigation is a bit different for the login screen vs. the rest of the application,
        // since we don't want to be able to click on tabs or show anything else until the user is logged in

        // note: there is a known bug where if you hit the login button to change profile while
        // already logged in, multiple of the same tabs are rendered
        // not fixing since just a prototype
        // basically, changing profile is currently treated the same as login
        App.instance().setCurrentUserId(id);
        // create a menu with tabs
        frame.remove(loginView);
        header = new JTabbedPane();
        header.addTab("Change profile", loginView);
        profileView = new ProfileView();
        header.addTab("Settings", profileView);
        goalsView = new GoalsView();
        header.addTab("Goals", goalsView);
        // view the goals tab after login
        header.setSelectedComponent(goalsView);
        frame.add(header);
        // redraw the updated UI
        frame.revalidate();
        frame.repaint();
    }

    // TO DO: this method should probably be in the View Model
    @Override
    public void update(EventType eventType, Object payload) {
        if (eventType == EventType.LOGIN) handleLogin((int) payload);
    }
}
