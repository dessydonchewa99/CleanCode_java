package toolsForSale;

enum PenColors{

    BLACK("BLACK"),
    RED("RED"),
    BLUE("BLUE"),
    GREEN("GREEN");

    private final String color;

    PenColors(String color){
        this.color = color == null ? "BLACK" : color;
    }
    @Override
    public String toString() {
        return String.format("Pen color: %s%n", color);
    }
}
