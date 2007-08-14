package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;

public interface IReportItem {
	void executeRCommands(RInterface re);
	void visit(IReportRenderingVisitor v);
}
