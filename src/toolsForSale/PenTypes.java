package toolsForSale;
/**
 * Represents a PenTypes enum type.
 * @author Desislava Dontcheva
 * @version 1.0
 */
public enum PenTypes {

    /**
     * Possible Pen types.
     */
    VERY_THIN("VERY_THIN"),
    THIN("THIN"),
    MEDIUM("MEDIUM"),
    THICK("THICK"),
    VERY_THICK("VERY_THICK");

    private final String type;

    /**
     * Constructor with parameters for enum PenTypes.
     * @param type
     */
    PenTypes(String type){
        this.type = type == null ? "MEDIUM" : type;
    }

    /**
     * This method returns formatted string.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Pen type: %s%n", type);
    }
}
