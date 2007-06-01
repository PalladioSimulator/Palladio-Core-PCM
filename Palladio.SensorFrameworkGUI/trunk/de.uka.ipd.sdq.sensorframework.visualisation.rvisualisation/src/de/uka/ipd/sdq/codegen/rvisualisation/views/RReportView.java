package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.text.html.HTMLDocument.HTMLReader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.PlotReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StatisticsReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.visitor.HTMLVisitor;
import de.uka.ipd.sdq.sensorfactory.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;

public class RReportView extends AbstractReportView
implements IVisualisation {

	public static final String RREPORTVIEW_ID = "de.uka.ipd.sdq.codegen.rvisualization.views.ReportView";
	private Browser browser;
	
	public RReportView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createReportControls(Composite parent) {
		browser = new Browser(parent, SWT.BORDER);
		setInput(Collections.EMPTY_LIST);
	}

	public void addInput(Collection c) {
		// TODO Auto-generated method stub
		
	}

	public void deleteInput(Collection c) {
		// TODO Auto-generated method stub
		
	}

	public void setInput(Collection c) {
		RInterface t = new RInterface();
		if (t.isEngineAvailable()){
			ArrayList<IReportItem> items = new ArrayList<IReportItem>();
			items.add(new StaticReportItem("R-Report", true));
		
			ArrayList<String> data = new ArrayList<String>();
			Iterator it = c.iterator();
			for(int i=0; i<c.size();i++){
				SensorAndMeasurements sm = (SensorAndMeasurements) it.next();
				String rCommand = getRVector(sm,i) + "\n";
				t.execute(rCommand);
				data.add("density(sensor"+i+")");

				items.add(new PlotReportItem(new String[]{"density(sensor"+i+")"},sm.getSensor().getSensorName()));

				rCommand = "length(sensor"+i+")\n";
				items.add(new StatisticsReportItem(rCommand, "Number of observations of Sensor "+sm.getSensor().getSensorName()));
				rCommand = "mean(sensor"+i+")\n";
				items.add(new StatisticsReportItem(rCommand, "Mean of Sensor "+sm.getSensor().getSensorName()));
				rCommand = "sd(sensor"+i+")\n";
				items.add(new StatisticsReportItem(rCommand, "Standard-Deviation of Sensor "+sm.getSensor().getSensorName()));
			} 
			items.add(1, new PlotReportItem(data.toArray(new String[0]),"Combined Plot"));
			HTMLVisitor visitor = new HTMLVisitor();
			for(IReportItem item : items) {
				System.out.println("Exec command");
				item.executeRCommands(t);
				System.out.println("Render");
				item.visit(visitor);
			}
			browser.setText(visitor.getHTML());
		} else {
			browser.setText("<html><body><h1>Error! R-Engine unavailable!</h1></body></html>");
		}
	}

	private String getRVector(SensorAndMeasurements sm, int i) {
		File temp;
		try {
			temp = File.createTempFile("data", ".txt");
			temp.deleteOnExit();
			FileWriter fw = new FileWriter(temp);
			System.out.println("Start");
			long timeM = System.nanoTime();
			StringBuffer result = new StringBuffer(); //"sensor"+i+"<-c(");
			for (Measurement time : sm.getMeasurements()){
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
				result.append(tsm.getTimeSpan());
				result.append(" ");
			}
			if (result.charAt(result.length()-1) == ',')
				result = result.delete(result.length()-1, result.length()-1);
			// result.append(")");
			fw.write(result.toString());
			fw.close();
			System.out.println("End "+(System.nanoTime()-timeM));
			return "sensor"+i+"<-scan(\""+temp.getAbsolutePath().replace(File.separator, "\\\\")+"\")";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
