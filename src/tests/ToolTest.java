package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import toolsForSale.*;

public class ToolTest {
    @Test
    public void testRandomPen(){
        Pen result = new Pen();
        result = result.takeRandomPen();

        boolean flag = result.getColor() != null && result.getType() != null;

        System.out.println(result.getType());
        System.out.println(result.getColor());

        Assertions.assertTrue(flag);
    }
    @Test
    public void testCreateBox(){
        PenBox result = new PenBox();
        result.createBox();

        boolean flag = false;

        for(int i = 0; i < result.getBoxOfPens().size(); i++){
            if (result.getBoxOfPens().get(i).getColor() != null && result.getBoxOfPens().get(i).getType() != null) {
                flag = true;
            } else{
                Assertions.assertTrue(flag);
            }
        }
    }
    @Test
    public void testSortByType(){
        PenBox result = new PenBox();
        result.sortByType();

        boolean flag = false;

        for(int i = 0; i < result.getBoxOfPens().size(); i++){
            if (result.getBoxOfPens().get(i).getColor() != null && result.getBoxOfPens().get(i).getType() != null) {
                flag = true;
            } else{
                Assertions.assertTrue(flag);
            }
        }
    }
    @Test
    public void testOfferedPens(){
        PenBox result = new PenBox();
        result.showOfferedPens();

        boolean flag = false;

        for(int i = 0; i < result.getBoxOfPens().size(); i++){
            if (result.getBoxOfPens().get(i).getColor() != null && result.getBoxOfPens().get(i).getType() != null) {
                flag = true;
            } else{
                Assertions.assertTrue(flag);
            }
        }
    }
}
