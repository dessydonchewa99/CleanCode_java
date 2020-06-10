package toolsForSale;
/**
 * Represents a PenColors enum type.
 * @author Desislava Dontcheva
 * @version 1.0
 */
public enum PenColors{

    /**
     * Possible Pen colors.
     */
    BLACK("BLACK"),
    RED("RED"),
    BLUE("BLUE"),
    GREEN("GREEN");

    private final String color;

    /**
     * Constructor with parameters for enum PenColors.
     * @param color This is the color of a Pen.
     */
    PenColors(String color){
        this.color = color == null ? "BLACK" : color;
    }

    /**
     * This method returns formatted string.
     * @return String This is a formatted string result.
     */
    @Override
    public String toString() {
        return String.format("Pen color: %s%n", color);
    }
}
