package goals.ui;

import component_library.KFont;
import component_library.KFontSize;
import component_library.KHeading;

import javax.swing.*;

public class GoalsView extends JPanel {
    public GoalsView() {
        JPanel panel = new JPanel();
        JLabel heading = KHeading.buildHeading(
            "Goals",
            KFont.PLAIN_HEADING,
            KFontSize.HEADING_LARGE
        );
        panel.add(heading);
        this.add(panel);
    }
}
