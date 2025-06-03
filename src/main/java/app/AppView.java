package app;

import profile.ui.LoginView;
import profile.ui.ProfileView;

import javax.swing.*;
import java.awt.*;

public class AppView implements EventListener {
    private static AppView instance;
    private AppViewModel appViewModel;
    private final JFrame frame;

    private Component loginView;

    private AppView() {
        instance = this;
        appViewModel = new AppViewModel();

        // listen for login events
        App.eventManager().subscribe(EventType.LOGIN, this);

        // the entire window the app runs in
        frame = new JFrame();
        frame.setTitle("Delta App");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // render login screen on startup
        loginView = new LoginView();
        frame.add(loginView);

        frame.setVisible(true);
        // testing flash message
        AppView.getInstance().flashMessage("Message", "Title", JOptionPane.INFORMATION_MESSAGE);
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
    private void handleLogin() {
        frame.remove(loginView);
        // TO DO: store user id and pass to profile view
        // or, save the currently logged-in user in singleton instance of App class
        frame.add(new ProfileView(123));
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void update(EventType eventType) {
        if (eventType == EventType.LOGIN) handleLogin();
    }
}
