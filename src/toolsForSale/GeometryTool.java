package toolsForSale;
/**
 * Represents a GeometryTool.
 * @author Desislava Dontcheva
 * @version 1.0
 */
public class GeometryTool {

    private GeometryToolMeasure toolMeasure;

    /**
     * Default constructor for class GeometryTool.
     */
    public GeometryTool(){
        setToolMeasure(null);
    }
    /**
     * Constructor with parameters for class GeometryTool.
     * @param toolMeasure This is enum type tool measure of the GeometryTool.
     */
    public GeometryTool(GeometryToolMeasure toolMeasure){
        setToolMeasure(toolMeasure);
    }
    /**
     * Copy constructor for class GeometryTool.
     * @param geometryTool Object of class GeometryTool.
     */
    public GeometryTool(GeometryTool geometryTool){
        setToolMeasure(geometryTool.toolMeasure);
    }

    /**
     * This method sets toolMeasure of class GeometryTool.
     * @param toolMeasure This is enum type tool measure of the GeometryTool.
     */
    public final void setToolMeasure(GeometryToolMeasure toolMeasure) {
        this.toolMeasure = toolMeasure == null ? GeometryToolMeasure.INCH : toolMeasure;
    }

    /**
     * This method gets toolMeasure of class GeometryTool.
     * @return GeometryToolMeasure enum type
     */
    public final GeometryToolMeasure getToolMeasure() {
        return toolMeasure;
    }
}
