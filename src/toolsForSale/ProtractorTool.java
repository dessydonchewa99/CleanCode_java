package toolsForSale;

import exceptions.ToolMeasureException;

public class ProtractorTool extends GeometryTool {

    public ProtractorTool(){
        super();
    }

    public void validationMeasure(ProtractorTool protractor){
        ToolMeasureException exception = new ToolMeasureException();
        exception.protractorValidation(protractor, "Invalid protractor measure");
    }
}

