package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;

public class StaticReportItem implements IReportItem {

	private String myText;
	private boolean isHeading;

	public StaticReportItem(String text, boolean isHeading){
		this.myText = text;
		this.isHeading = isHeading;
	}
	
	public String getText(){
		return myText;
	}
	
	public boolean isHeading() {
		return isHeading;
	}
	
	public void visit(IReportRenderingVisitor v) {
		v.visitStaticItem(this);
	}

	public void executeRCommands(RInterface re) {
	}

}
