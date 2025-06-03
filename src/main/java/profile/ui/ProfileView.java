package profile.ui;

import component_library.KFont;
import component_library.KFontSize;
import component_library.KHeading;

import app.App;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JPanel {
    // this view renders the User settings page
    // they can view and edit their name etc.

    public ProfileView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        // TO DO: fetch info for current user (using the current user id) from the API
        // this would let us display the name, age. etc.
        JLabel label = KHeading.buildHeading(
            "Welcome user %d!".formatted(App.instance().getCurrentUserId()),
            KFont.PLAIN_HEADING,
            KFontSize.HEADING_MEDIUM
        );
        panel.add(label);
        this.add(panel);
    }
}
