package component_library;

import javax.swing.*;
import java.awt.*;


public class KHeading {
    private static JLabel buildHeading(String text, String fontName, int fontStyle, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        return label;
    }

    public static JLabel buildHeading(String text, KFont font, KFontSize fontSize) {
        return KHeading.buildHeading(text, font.getName(), font.getStyle(), fontSize.getSize());
    }
}
