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

    public void protractorValidation(ProtractorTool protractorTool, String message){
        if(protractorTool.getToolMeasure() == GeometryToolMeasure.DEGREE ||
                protractorTool.getToolMeasure() == GeometryToolMeasure.RADIAN) return;

        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();

            if(input.equals("DEGREE")){
                protractorTool.setToolMeasure(GeometryToolMeasure.DEGREE);
                break;
            }else if (input.equals("RADIAN")){
                protractorTool.setToolMeasure(GeometryToolMeasure.RADIAN);
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

    public void rulerValidation(RulerTool rulerTool, String message){
        if(rulerTool.getToolMeasure() == GeometryToolMeasure.CENTIMETER ||
                rulerTool.getToolMeasure() == GeometryToolMeasure.INCH) return;

        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();

            if(input.equals("CENTIMETER")){
                rulerTool.setToolMeasure(GeometryToolMeasure.CENTIMETER);
                break;
            }else if (input.equals("INCH")){
                rulerTool.setToolMeasure(GeometryToolMeasure.INCH);
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

    public void triangleValidation(TriangleTool triangleTool, String message){
        if(triangleTool.getToolMeasure() == GeometryToolMeasure.CENTIMETER ||
                triangleTool.getToolMeasure() == GeometryToolMeasure.INCH) return;

        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();

            if(input.equals("CENTIMETER")){
                triangleTool.setToolMeasure(GeometryToolMeasure.CENTIMETER);
                break;
            }else if (input.equals("INCH")){
                triangleTool.setToolMeasure(GeometryToolMeasure.INCH);
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

