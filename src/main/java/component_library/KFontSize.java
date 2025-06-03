package component_library;

public enum KFontSize {
    HEADING_SMALL(14),
    HEADING_MEDIUM(18),
    HEADING_LARGE(25);

    private final int size;

    KFontSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
