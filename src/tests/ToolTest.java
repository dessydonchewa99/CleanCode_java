package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import toolsForSale.Pen;
import toolsForSale.PenBox;

public class ToolTest {
    @Test
    public void testRandomPen(){
        Pen result = new Pen();
        result = result.takeRandomPen();

        System.out.println(result.getType());
        System.out.println(result.getColor());

        Assertions.assertNotEquals(null, result);
    }
    @Test
    public void testCreateBox(){
        PenBox result = new PenBox();
        result.createBox();

        for(int i = 0; i < result.getBoxOfPens().size(); i++){
            System.out.println(result.getBoxOfPens().get(i).getType());
        }

        Assertions.assertNotEquals(null, result);
    }
    @Test
    public void testSortByType(){
        PenBox result = new PenBox();
        result.sortByType();

        for(int i = 0; i < result.getBoxOfPens().size(); i++){
            System.out.println(result.getBoxOfPens().get(i).getType());
        }

        Assertions.assertNotEquals(null, result);
    }
    @Test
    public void testOfferedPens(){
        PenBox result = new PenBox();
        result.showOfferedPens();

        Assertions.assertNotEquals(null, result);
    }
}
