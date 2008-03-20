package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;

/**Report item containing static text.
 * @author groenda
 */
public class StaticTextReportItem implements IReportItem {

	private String myText;
	private boolean isHeading;

	/**Initializes a new report item containing static text.
	 * @param text static text of this item.
	 * @param isHeading <code>true</code> if this text should be a heading.
	 */
	public StaticTextReportItem(String text, boolean isHeading){
		setText(text);
		this.isHeading = isHeading;
	}
	
	/**Constructs a report item without text that is not a heading.
	 * 
	 */
	public StaticTextReportItem() {
		this("",false);
	}
	
	/**
	 * @return the static text that is this report item.
	 */
	public String getText(){
		return myText;
	}
	
	public void setText(String newText){
		if (newText!=null)
			myText = newText;
	}
	
	/**
	 * @return <code>true</code> if the text is a heading.
	 */
	public boolean isHeading() {
		return isHeading;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#visit(de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportRenderingVisitor)
	 */
	public void visit(IReportRenderingVisitor renderingVisitor) {
		renderingVisitor.visitStaticItem(this);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#generateData(de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection)
	 */
	public void generateData(RConnection re) {
		// No implementation needed
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#getDescription()
	 */
	@Override
	public String getDescription() {
		return "Textual Description";
	}

}
