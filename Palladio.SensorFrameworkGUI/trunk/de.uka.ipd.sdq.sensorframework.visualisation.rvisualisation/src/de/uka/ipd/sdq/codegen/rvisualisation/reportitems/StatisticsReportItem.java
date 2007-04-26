package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import org.rosuda.JRI.REXP;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;

public class StatisticsReportItem implements IReportItem {

	private REXP x;
	private String rCommands;
	private String myDescription;

	public StatisticsReportItem(String rCommands, String description){
		this.rCommands = rCommands;
		this.myDescription = description;
	}
	
	public String getResult() {
		return "" + x.asDouble();
	}
	
	public String getDescription(){
		return myDescription;
	}
	
	public void visit(IReportRenderingVisitor v) {
		v.visitStatisticsItem(this);
	}

	public void executeRCommands(RInterface re) {
		re.execute(rCommands);
		x = re.getLastResult();
	}

}
