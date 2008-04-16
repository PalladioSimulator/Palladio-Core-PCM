package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**Report item containing static text.
 * @author groenda
 */
public class StaticTextReportItem extends AbstractRReportItem {

	/** The static text represented by this report item. */
	private String myText;
	/** Determines if this static text represents a heading. */
	private boolean isHeading;

	/**Initializes a new report item containing static text.
	 * @param text The static text of this item.
	 * @param isHeading <code>true</code> if this static text is a heading.
	 */
	public StaticTextReportItem(final String text, final boolean isHeading) {
		super("Static text");
		
		setText(text);
		this.isHeading = isHeading;
	}
	
	/**Constructs a report item without text that is not a heading.
	 * 
	 */
	public StaticTextReportItem() {
		this("", false);
	}
	
	/**
	 * @return The static text that is represented by this report item.
	 */
	public String getText() {
		return myText;
	}
	
	/**Set the static text of this report item.
	 * @param newText The new static text to set.
	 */
	public void setText(final String newText) {
		if (newText != null) {
			myText = newText;
		}
	}
	
	/**Checks if the static text is a heading.
	 * @return <code>true</code> if the text is a heading.
	 */
	public boolean isHeading() {
		return isHeading;
	}
	
	/** {@inheritDoc}
	 */
	public void visit(final IReportRenderingVisitor renderingVisitor) {
		renderingVisitor.visitStaticTextReportItem(this);
	}

	/** {@inheritDoc}
	 */
	public void generateData(final RConnection re) {
		// No implementation needed
	}
}
