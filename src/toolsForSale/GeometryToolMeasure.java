package toolsForSale;
/**
 * Represents a GeometryToolMeasure enum type.
 * @author Desislava Dontcheva
 * @version 1.0
 */
public enum GeometryToolMeasure {

    /**
     * Possible measure types of GeometryTool.
     */
    INCH("INCH"),
    CENTIMETER("CENTIMETER"),
    DEGREE("DEGREE"),
    RADIAN("RADIAN");

    private final String measure;

    /**
     * Constructor with parameters for enum GeometryToolMeasure.
     * @param measure
     */
    GeometryToolMeasure(String measure){
        this.measure = measure == null ? "INCH" : measure;
    }

    /**
     * This method returns formatted string.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Tool measure: %s%n", measure);
    }
}
