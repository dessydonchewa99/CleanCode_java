package toolsForSale;
/**
 * Represents a ProtractorTool.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import exceptions.ToolMeasureException;

public class ProtractorTool extends GeometryTool {

    /**
     * Constructor with parameters for class ProtractorTool.
     * @param measure This is the measure of ProtractorTool.
     */
    public ProtractorTool(GeometryToolMeasure measure){
        super();
        validationMeasure(new ProtractorTool(measure));
    }

    /**
     * This method validates if the measure of ProtractorTool
     * is correct or not.
     * @param protractor Object of class ProtractorTool.
     */
    public void validationMeasure(ProtractorTool protractor){
        ToolMeasureException exception = new ToolMeasureException();
        exception.protractorValidation(protractor, "Invalid protractor measure");
    }
}

