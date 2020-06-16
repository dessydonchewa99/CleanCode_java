package toolsForSale;
/**
 * Represents a TriangleTool.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import exceptions.ToolMeasureException;

public class TriangleTool extends GeometryTool {

    /**
     * Constructor with parameters for class TriangleTool.
     * @param measure This is the measure of TriangleTool.
     */
    public TriangleTool(GeometryToolMeasure measure) {
        super();
        validationMeasure(new TriangleTool(measure));
    }

    /**
     * This method validates if the measure of TriangleTool
     * is correct or not.
     * @param triangle Object of class TriangleTool.
     * @see ToolMeasureException#triangleValidation(TriangleTool, String) 
     */
    public void validationMeasure(TriangleTool triangle) {
        ToolMeasureException exception = new ToolMeasureException();
        exception.triangleValidation(triangle, "Invalid triangle measure");
    }
}

