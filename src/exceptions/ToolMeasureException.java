package exceptions;
/**
 * Represents a ToolMeasureException.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import toolsForSale.*;

import java.util.Scanner;

public class ToolMeasureException extends Exception {
    public ToolMeasureException(String message){
        super(message);
    }
    public ToolMeasureException(){
        this("WRONG MEASURE");
    }

    /**
     * This method validates the measure of tool of ProtractorTool class.
     * @param tool This is the tool of class ProtractorTool that should be validated.
     * @param message This is the message that user should see if the program throws exceptions.
     */
    public void protractorValidation(ProtractorTool tool, String message){
        if(tool.getToolMeasure() == GeometryToolMeasure.DEGREE || tool.getToolMeasure() == GeometryToolMeasure.RADIAN) {
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();

            if(input.equals("DEGREE")){
                tool.setToolMeasure(GeometryToolMeasure.DEGREE);
                break;
            }else if (input.equals("RADIAN")){
                tool.setToolMeasure(GeometryToolMeasure.RADIAN);
                break;
            }else {
                try {
                    throw new ToolMeasureException(message);
                } catch (ToolMeasureException e) {
                    System.err.println(message);
                }
            }

        }
    }

    /**
     * This method validates the measure of tool of RulerTool class.
     * @param tool This is the tool of class RulerTool that should be validated.
     * @param message This is the message that user should see if the program throws exceptions.
     */
    public void rulerValidation(RulerTool tool, String message){
        if(tool.getToolMeasure() == GeometryToolMeasure.CENTIMETER || tool.getToolMeasure() == GeometryToolMeasure.INCH){
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();

            if(input.equals("CENTIMETER")){
                tool.setToolMeasure(GeometryToolMeasure.CENTIMETER);
                break;
            }else if (input.equals("INCH")){
                tool.setToolMeasure(GeometryToolMeasure.INCH);
                break;
            }else {
                try {
                    throw new ToolMeasureException(message);
                } catch (ToolMeasureException e) {
                    System.err.println(message);
                }
            }

        }
    }

    /**
     * This method validates the measure of tool of TriangleTool class.
     * @param tool This is the tool of class TriangleTool that should be validated.
     * @param message This is the message that user should see if the program throws exceptions.
     */
    public void triangleValidation(TriangleTool tool, String message){
        if(tool.getToolMeasure() == GeometryToolMeasure.CENTIMETER || tool.getToolMeasure() == GeometryToolMeasure.INCH) {
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();

            if(input.equals("CENTIMETER")){
                tool.setToolMeasure(GeometryToolMeasure.CENTIMETER);
                break;
            }else if (input.equals("INCH")){
                tool.setToolMeasure(GeometryToolMeasure.INCH);
                break;
            }else {
                try {
                    throw new ToolMeasureException(message);
                } catch (ToolMeasureException e) {
                    System.err.println(message);
                }
            }

        }
    }

}

