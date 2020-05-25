package toolsForSale;

public class GeometryTool {
    private GeometryToolMeasure toolMeasure;

    public GeometryTool(){
        setToolMeasure(null);
    }
    public GeometryTool(GeometryToolMeasure toolMeasure){
        setToolMeasure(toolMeasure);
    }
    public GeometryTool(GeometryTool geometryTool){
        setToolMeasure(geometryTool.toolMeasure);
    }
    public final void setToolMeasure(GeometryToolMeasure toolMeasure) {
        this.toolMeasure = toolMeasure == null ? GeometryToolMeasure.INCH : toolMeasure;
    }
    public final GeometryToolMeasure getToolMeasure() {
        return toolMeasure;
    }
}
