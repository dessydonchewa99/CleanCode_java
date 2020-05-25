package toolsForSale;

import exceptions.ToolMeasureException;

public class TriangleTool extends GeometryTool {

    public TriangleTool() {
        super();
    }

    public void validationMeasure(TriangleTool triangle) {
        ToolMeasureException exception = new ToolMeasureException();
        exception.triangleValidation(triangle, "Invalid triangle measure");
    }
}

