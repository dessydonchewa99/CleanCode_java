package toolsForSale;

import java.util.Random;

public class Pen {
    PenColors color;
    PenTypes type;

    public Pen() {
        setColor(null);
        setType(null);
    }
    public Pen(PenColors color, PenTypes type) {
        setColor(color);
        setType(type);
    }
    public Pen(Pen pen) {
        setColor(pen.color);
        setType(pen.type);
    }

    public void setColor(PenColors color) {
        this.color = color == null ? PenColors.BLACK : color;
    }
    public void setType(PenTypes type) {
        this.type = type == null ? PenTypes.THIN : type;
    }

    public PenColors getColor() {
        return color;
    }

    public PenTypes getType() {
        return type;
    }

    public Pen takeRandomPen() {
        PenColors[] allColors = PenColors.values();
        PenTypes[] allTypes = PenTypes.values();
        Random random = new Random();

        color = allColors[random.nextInt(allColors.length)];
        type = allTypes[random.nextInt(allTypes.length)];

        return new Pen(color, type);
    }
}

