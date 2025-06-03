package app;

import goals.ui.GoalsView;
import profile.ui.LoginView;
import profile.ui.ProfileView;

import javax.swing.*;
import java.awt.*;

public class AppView implements EventListener {
    private static AppView instance;
    private AppViewModel appViewModel;
    private final JFrame frame;

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
    // Con: requires exposing frame publicly
    public void flashMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(frame, message, title, type);
    }

    // TO DO: should we be handling this logic in the viewModel?
    private void handleLogin(int id) {
        // navigation is a bit different for the login screen vs. the rest of the application,
        // since we don't want to be able to click on tabs or show anything else until the user is logged in

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

    @Override
    public void update(EventType eventType, Object payload) {
        if (eventType == EventType.LOGIN) handleLogin((int) payload);
    }
}
