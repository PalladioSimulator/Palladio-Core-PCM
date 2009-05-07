package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**Abstract class describing R report item which are generated.
 * @author groenda
 */
public abstract class AbstractGeneratedTextRReportItem 
		extends AbstractRReportItem {

	/**Initializes items of this class.
	 * @param description Description of the item represented by this object.
	 */
	public AbstractGeneratedTextRReportItem(final String description) {
		super(description);
	}
	
	/**Used to calculate the data in R. 
	 * {@inheritDoc}
	 */
	public abstract void generateData(RConnection re);

	/** {@inheritDoc}
	 */
	public abstract void visit(IReportRenderingVisitor renderingVisitor);

	/**
	 * @return The textual representation of this report item.
	 */
	public abstract String getText();
}
