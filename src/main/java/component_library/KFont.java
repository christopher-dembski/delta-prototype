package component_library;

import java.awt.*;

public enum KFont {
    PLAIN_HEADING("Serif");

    private final String name;

    KFont(String hexValue) {
        this.name = hexValue;
    }

    public String getName() {
        return name;
    }

    public int getStyle() {
        switch (this) {
            case PLAIN_HEADING -> {
                return Font.BOLD;
            }
            default -> {
                return Font.PLAIN;
            }
        }
    }
}
