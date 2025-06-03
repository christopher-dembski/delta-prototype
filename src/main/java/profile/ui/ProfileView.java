package profile.ui;

import component_library.KFont;
import component_library.KFontSize;
import component_library.KHeading;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JPanel {
    public ProfileView(int userId) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        // TO DO: fetch user info form API
        JLabel label = KHeading.buildHeading(
            "Welcome user %d!".formatted(userId),
            KFont.PLAIN_HEADING,
            KFontSize.HEADING_MEDIUM
        );
        panel.add(label);
        this.add(panel);
    }
}
