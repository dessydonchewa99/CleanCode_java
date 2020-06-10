package toolsForSale;
/**
 * Represents a PenColors enum type.
 * @author Desislava Dontcheva
 * @version 1.0
 */
enum PenColors{

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
     * @param color
     */
    PenColors(String color){
        this.color = color == null ? "BLACK" : color;
    }

    /**
     * This method returns formatted string.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Pen color: %s%n", color);
    }
}
