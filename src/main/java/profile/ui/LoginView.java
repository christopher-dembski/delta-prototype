package profile.ui;

import app.App;
import app.EventType;
import component_library.KFont;
import component_library.KFontSize;
import component_library.KHeading;
import profile.api.GetUsersEndpoint;

import javax.swing.*;
import java.awt.*;


public class LoginView extends JPanel {
    // this view is for the login screen
    // it displays a button for each user profile to select

    private LoginViewModel viewModel;

    public LoginView() {
        // the view model handles the logic for the view
        // it fetches the list of users
        // so this view can only be concerned with the UI
        // single responsibility
        // ensures this view class doesn't get too bloated
        viewModel = new LoginViewModel();

        // overall container containing other components
        JPanel panel = new JPanel();
        // 0 rows means as many rows as needed
        // each time a component is added, a new row is generated
        panel.setLayout(new GridLayout(0,1));

        // we use our KHeading library component so that if we ever wanted to change for example
        // the style of our app, we would ust need to change the value of KFont.PLAIN_HEADING for example
        // this is kind of using the factory pattern
        JLabel welcomeLabel = KHeading.buildHeading(
            "Welcome! Please select an account",
            KFont.PLAIN_HEADING,
            KFontSize.HEADING_MEDIUM
        );
        panel.add(welcomeLabel);

        // loop over each user and create a button to login as that user
        for (GetUsersEndpoint.User user : viewModel.getUsers()) {
            JButton userProfileButton = getLoginButton(user);
            panel.add(userProfileButton);
        }

        this.add(panel);
    }

    // helper method to build a login button for a given user
    private static JButton getLoginButton(GetUsersEndpoint.User user) {
        JButton userProfileButton = new JButton();
        userProfileButton.setText("Name: %s".formatted(user.name()));
        // the lambda function provided to the action
        // Lambda functions https://www.geeksforgeeks.org/lambda-expressions-java-8/
        // note: we might want to make this async to not block the user from interacting with the UI
        // while the data is loading? this gets tricky if the user then clicks somewhere else while
        // waiting for data to load, and we have two async functions happening at the same time
        // probably not an issue with our small app
        userProfileButton.addActionListener((arg) -> {
            App.instance().eventManager().notify(EventType.LOGIN, user.id());
        });
        return userProfileButton;
    }
}
