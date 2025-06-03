package app;

import profile.ui.LoginView;

import javax.swing.*;

public class AppView {
    private static AppView instance;
    private AppViewModel appViewModel;

    private AppView() {
        appViewModel = new AppViewModel();

        // the entire window the app runs in
        JFrame frame = new JFrame();
        frame.setTitle("Delta App");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // render login screen on startup
        LoginView loginView = new LoginView();
        frame.add(loginView);

        frame.setVisible(true);
    }

    public static AppView getInstance() {
        if (instance == null) {
            instance = new AppView();
        }
        return instance;
    }
}
