package profile.ui;

import component_library.KFont;
import component_library.KFontSize;
import component_library.KHeading;
import profile.api.GetUsersEndpoint;

import javax.swing.*;
import java.awt.*;


public class LoginView extends JPanel {
    private LoginViewModel viewModel;

    public LoginView() {
        viewModel = new LoginViewModel();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));

        JLabel welcomeLabel = KHeading.buildHeading(
            "Welcome! Please select an account",
            KFont.PLAIN_HEADING,
            KFontSize.HEADING_MEDIUM
        );
        panel.add(welcomeLabel);

        for (GetUsersEndpoint.User user : viewModel.getUsers()) {
            JButton userProfileButton = new JButton();
            userProfileButton.setText("Name: %s | Sex: %s".formatted(user.name(), user.sex()));
            panel.add(userProfileButton);
        }

        this.add(panel);
    }

    public static void main(String[] args) {
        new LoginView();
    }
}
