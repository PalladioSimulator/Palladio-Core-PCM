package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import java.io.File;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;

public class PlotReportItem implements IReportItem {

	private String dataCommand[];
	private String title;
	File temp = null;

	public PlotReportItem(String[] dataCommand, String title) {
		this.dataCommand = dataCommand;
		this.title = title;
	}
	
	public void visit(IReportRenderingVisitor v) {
		v.visitPlotItem(this);
	}

	public static final int bmpSize = 400;
	
	public void executeRCommands(RInterface re) {
		String rCommand = "";
		try{
			temp = File.createTempFile("pic", ".bmp");
			temp.deleteOnExit();
			rCommand = "bmp(\""+temp.getAbsolutePath().replace(File.separator, "\\\\")+"\",height="+bmpSize+",width="+bmpSize+")\n";
			rCommand += "plot("+this.dataCommand[0]+",xlab=\"Response Time\",main=\""+this.title+"\")\n";
			for(int i = 1; i<dataCommand.length; i++){
				rCommand += "lines("+this.dataCommand[i]+")\n";
			}
			rCommand += "graphics.off()\n";
		}catch(Exception e){
			RVisualisationPlugin.log(IStatus.ERROR, "Could not create temp file. "+e.getClass().getCanonicalName());
		}
		RVisualisationPlugin.log(IStatus.INFO,
				"PlotReportItem::executeRCommands(RInterface re), rCommand=" + rCommand);

		re.execute(rCommand);
	}

	public String getFilename() {
		if(dataCommand.length==0) 
			return null; 
		else 
			return temp.getAbsolutePath();
	}

}
