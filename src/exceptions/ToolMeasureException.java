package exceptions;

import toolsForSale.*;

import java.util.Scanner;

public class ToolMeasureException extends Exception {
    public ToolMeasureException(String message){
        super(message);
    }
    public ToolMeasureException(){
        this("WRONG MEASURE");
    }

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

