package toolsForSale;

public enum PenTypes {
    VERY_THIN("VERY_THIN"),
    THIN("THIN"),
    MEDIUM("MEDIUM"),
    THICK("THICK"),
    VERY_THICK("VERY_THICK");

    private final String type;

    PenTypes(String type){
        this.type = type == null ? "MEDIUM" : type;
    }
    @Override
    public String toString() {
        return String.format("Pen type: %s%n", type);
    }
}
