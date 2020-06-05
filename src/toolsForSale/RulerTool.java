package toolsForSale;

import exceptions.ToolMeasureException;

public class RulerTool extends GeometryTool {

    public RulerTool(GeometryToolMeasure centimeter){
        super();
    }

    public void validationMeasure(RulerTool ruler){
        ToolMeasureException exception = new ToolMeasureException();
        exception.rulerValidation(ruler, "Invalid ruler measure");
    }
}

