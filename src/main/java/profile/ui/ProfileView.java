package profile.ui;

import component_library.KFont;
import component_library.KFontSize;
import component_library.KHeading;

import app.App;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JPanel {
    public ProfileView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        // TO DO: fetch user info from API
        JLabel label = KHeading.buildHeading(
            "Welcome user %d!".formatted(App.instance().getCurrentUserId()),
            KFont.PLAIN_HEADING,
            KFontSize.HEADING_MEDIUM
        );
        panel.add(label);
        this.add(panel);
    }
}
