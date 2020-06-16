package toolsForSale;
/**
 * Represents a RulerTool.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import exceptions.ToolMeasureException;

public class RulerTool extends GeometryTool {

    /**
     * Constructor with parameters for class RulerTool.
     * @param measure This is the measure of RulerTool.
     */
    public RulerTool(GeometryToolMeasure measure){
        super();
        validationMeasure(new RulerTool(measure));
    }

    /**
     * This method validates if the measure of RulerTool
     * is correct or not.
     * @param ruler Object of class RulerTool.
     * @see ToolMeasureException#rulerValidation(RulerTool, String) 
     */
    public void validationMeasure(RulerTool ruler){
        ToolMeasureException exception = new ToolMeasureException();
        exception.rulerValidation(ruler, "Invalid ruler measure");
    }
}

