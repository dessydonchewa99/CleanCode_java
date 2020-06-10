package toolsForSale;
/**
 * Represents a Pen.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import java.util.Random;

public class Pen {

    PenColors color;
    PenTypes type;

    /**
     * Default constructor for class Pen.
     */
    public Pen() {
        setColor(null);
        setType(null);
    }
    /**
     * Constructor with parameters for class Pen.
     * @param color This is enum type showing the color of the Pen.
     * @param type This is enum type showing the type of the Pen.
     */
    public Pen(PenColors color, PenTypes type) {
        setColor(color);
        setType(type);
    }
    /**
     * Copy constructor for class Pen.
     * @param pen Object of class Pen.
     */
    public Pen(Pen pen) {
        setColor(pen.color);
        setType(pen.type);
    }

    /**
     * This method sets color of class Pen.
     * @param color This is enum type showing the color of the Pen.
     */
    public void setColor(PenColors color) {
        this.color = color == null ? PenColors.BLACK : color;
    }
    /**
     * This method sets type of class Pen.
     * @param type This is enum type showing the type of the Pen.
     */
    public void setType(PenTypes type) {
        this.type = type == null ? PenTypes.THIN : type;
    }

    /**
     * This method gets color of class Pen.
     * @return PenColors This is enum type showing the color of the Pen.
     */
    public PenColors getColor() {
        return color;
    }
    /**
     * This method gets type of class Pen.
     * @return PenTypes This is enum type showing the type of the Pen.
     */
    public PenTypes getType() {
        return type;
    }

    /**
     * This method takes a Pen with random generated color and type.
     * @return Pen This is a new object of class Pen.
     */
    public Pen takeRandomPen() {
        PenColors[] allColors = PenColors.values();
        PenTypes[] allTypes = PenTypes.values();
        Random random = new Random();

        color = allColors[random.nextInt(allColors.length)];
        type = allTypes[random.nextInt(allTypes.length)];

        return new Pen(color, type);
    }
}

