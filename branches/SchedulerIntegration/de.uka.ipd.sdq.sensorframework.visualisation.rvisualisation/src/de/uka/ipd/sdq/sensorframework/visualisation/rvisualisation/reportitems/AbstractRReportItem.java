package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

/**Abstract class describing a R report item.
 * @author groenda
 */
public abstract class AbstractRReportItem implements IReportItem {
	/** The default description for R report items. */
	public static final String DEFAULT_DESCRIPTION = "No description available";
	/** Description of this item. */
	private final String description;
	
	/**Initializes a new report item with default description.
	 */
	public AbstractRReportItem() {
		this(DEFAULT_DESCRIPTION);
	}

	/**Initializes a new report item.
	 * @param description The description of the item.
	 */
	public AbstractRReportItem(final String description) {
		this.description = description;
	}

	/** {@inheritDoc}
	 */
	public String getDescription() {
		return description;
	}

	/**Used by the visitor to display the report item. 
	 * {@inheritDoc}
	 */
	public abstract void visit(IReportRenderingVisitor renderingVisitor);
	
}
