package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**Interface for all displayable report items.
 * @author groenda (comments)
 */
public interface IReportItem {
	/**Initializes the generation of data for the report item. 
	 * @param rConnection connection to the R engine used for the generation
	 */
	void generateData(RConnection rConnection);
	
	/**Used to render the report item.
	 * @param renderingVisitor Visitor used for rendering the content of each item.
	 */
	void visit(IReportRenderingVisitor renderingVisitor);
	
	/**
	 * @return description of the content of the report item.
	 */
	String getDescription();
}
