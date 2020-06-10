package toolsForSale;
/**
 * Represents a PenBox.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Arrays;

public class PenBox {
    public final static int SELL_SIZE_BOX = 100;
    public final static int INITIAL_CAPACITY = 20;

    private ArrayList<Pen> boxOfPens;

    /**
     * Default constructor for class PenBox.
     * It generates all combinations of Pen with
     * color enum type and type enum type.
     */
    public PenBox() {

        boxOfPens = new ArrayList<>();

        for(PenColors currentColor : PenColors.values()){
            for(PenTypes currentType : PenTypes.values()){

                Pen currentPen = new Pen();

                currentPen.setColor(currentColor);
                currentPen.setType(currentType);

                boxOfPens.add(currentPen);

            }
        }
    }

    /**
     * This method gets boxOfPens of class PenBox.
     * @return Pen ArrayList
     */
    public ArrayList<Pen> getBoxOfPens() {
        return boxOfPens;
    }

    /**
     * This method generates a box with fixed size
     * full of random generated Pens.
     */
    public void createBox() {
        boxOfPens = new ArrayList<>();
        int i = 0;
        while (i!=SELL_SIZE_BOX){
            Pen result = new Pen();
            result = result.takeRandomPen();
            boxOfPens.add(result);
            i++;
        }
    }
    /**
     * This method sorts all Pen types.
     */
    public void sortByType() {
        ArrayList<PenTypes> penTypesSorted = new ArrayList<PenTypes>(Arrays.asList(PenTypes.values()));

        for (int i = 0; i < boxOfPens.size() - 1; i++) {
            int min = i;

            for (int j = i + 1; j < boxOfPens.size(); j++) {
                if (penTypesSorted.indexOf(boxOfPens.get(j).getType()) <
                        penTypesSorted.indexOf(boxOfPens.get(min).getType())) {
                    min = j;
                }
            }

            if (min != i) {
                Pen temporary = boxOfPens.get(i);
                boxOfPens.set(i, boxOfPens.get(min));
                boxOfPens.set(min, temporary);

            }
        }
    }
    /**
     * This method shows all offered Pens.
     */
    public void showOfferedPens() {
        ArrayList<Pen> listOfPens = new ArrayList<>(INITIAL_CAPACITY);

        for(PenColors currentColor : PenColors.values()){
            for(PenTypes currentType : PenTypes.values()){
                Pen currentPen = new Pen(currentColor, currentType);
                System.out.println(currentPen.color);
                System.out.println(currentPen.type);
            }
        }
    }
}

