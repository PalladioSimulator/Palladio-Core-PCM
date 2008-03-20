package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import java.io.File;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;

/**Represents a report item containing a density plot graphic.
 * @author groenda (comments, refactoring)
 */
public class DensityPlotReportItem implements IReportItem {

	private String rDataVector[];
	private String description;
	private File temporaryGraphicsFile = null;
	private String xAxisLabel;
	private int graphicsWidth;
	private int graphicsHeight;
	private int graphicsTextSize;

	/**Constructs a new report item containing a plotted density graphic.
	 * The graphic is stored in a temporary file. This is accessible via the getFilename method.
	 * @param rDataVector Name of the r vector containing the data. 
	 * @param title Title of the plotted graphic.
	 * @param xAxisLabel label of the x axis.
	 * @param height height of the plotted graphic.
	 * @param width width of the plotted graphics.
	 * @param textSize the default pointsize of plotted text, interpreted at 72 dpi, so one point is approximately one pixel.
	 */
	public DensityPlotReportItem(String[] rDataVector, String title, String xAxisLabel, int height, int width, int textSize) {
		this.rDataVector = rDataVector;
		this.description = title;
		this.xAxisLabel = xAxisLabel;
		this.graphicsWidth = width;
		this.graphicsHeight = height;
		this.graphicsTextSize = textSize;
	}
	
	/**Constructs a new report item containing a plotted density graphic of the size 400px by 400px and 12 point text size.
	 * @param rDataVector Name of the r vector containing the data. 
	 * @param title Title of the plotted graphic.
	 * @param xAxisLabel label of the x axis.
	 */
	public DensityPlotReportItem(String[] rDataVector, String title, String xAxisLabel) {
		this (rDataVector, title, xAxisLabel, 400, 400, 12);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#visit(de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportRenderingVisitor)
	 */
	public void visit(IReportRenderingVisitor renderingVisitor) {
		renderingVisitor.visitPlotItem(this);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#generateData(de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection)
	 */
	public void generateData(RConnection rConnection) {
		String rCommand = "";
		try{
			temporaryGraphicsFile = File.createTempFile("pic", ".png");
			temporaryGraphicsFile.deleteOnExit();
		}catch(Exception e){
			RVisualisationPlugin.log(IStatus.ERROR, "Could not create tempory graphics file. Graphics title is: " + description + ". "+e.getClass().getCanonicalName());
		}
		rCommand = "png(\"" + temporaryGraphicsFile.getAbsolutePath().replace(File.separator, "\\\\") +
			"\",height=" + graphicsHeight + ",width=" + graphicsWidth + ",pointsize=" + graphicsTextSize +")\n";
		
		// draw content
		rCommand += "plot("+this.rDataVector[0]+",xlab=\"" + xAxisLabel + "\",main=\""+this.description+"\")\n";
		for(int i = 1; i<rDataVector.length; i++){
			rCommand += "lines("+this.rDataVector[i]+")\n";
		}
		
		rCommand += "graphics.off()\n";
		
		rConnection.execute(rCommand);
	}

	/**
	 * @return the filename of the file containing the graphic. <code>null</code> if there is no file.
	 */
	public String getFilename() {
		if(rDataVector.length == 0) 
			return null; 
		else 
			return temporaryGraphicsFile.getAbsolutePath();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#getDescription()
	 */
	public String getDescription() {
		return description;
	}

}
