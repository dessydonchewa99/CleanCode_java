package toolsForSale;

import java.util.ArrayList;
import java.util.Arrays;

public class PenBox {
    public final static int SELL_SIZE_BOX = 100;
    public final static int INITIAL_CAPACITY = 20;

    private ArrayList<Pen> boxOfPens;

    public PenBox() {
        for(PenColors currentColor : PenColors.values()){
            for(PenTypes currentType : PenTypes.values()){
                Pen currentPen = new Pen(currentColor, currentType);
                boxOfPens.add(currentPen);

            }
        }
    }

    public void createBox() {
        for (int i = 0; i < SELL_SIZE_BOX; i++){
            Pen current = new Pen();
            boxOfPens.set(i, current.takeRandomPen());
        }
    }

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

    public void showOfferedPens() {
        ArrayList<Pen> listOfPens = new ArrayList<>(INITIAL_CAPACITY);

        for(PenColors currentColor : PenColors.values()){
            for(PenTypes currentType : PenTypes.values()){
                Pen currentPen = new Pen(currentColor, currentType);
                System.out.println(currentPen);
            }
        }
    }
}

