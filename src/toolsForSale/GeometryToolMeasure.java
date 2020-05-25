package toolsForSale;

public enum GeometryToolMeasure {
    INCH("INCH"),
    CENTIMETER("CENTIMETER"),
    DEGREE("DEGREE"),
    RADIAN("RADIAN");

    private final String measure;

    GeometryToolMeasure(String measure){
        this.measure = measure == null ? "INCH" : measure;
    }
    @Override
    public String toString() {
        return String.format("Pen color: %s%n", measure);
    }
}
