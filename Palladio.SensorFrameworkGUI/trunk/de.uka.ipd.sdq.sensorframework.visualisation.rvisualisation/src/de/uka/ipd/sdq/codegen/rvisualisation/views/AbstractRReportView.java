package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.visitor.HTMLVisitor;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;

public abstract class AbstractRReportView extends AbstractReportView implements
		IVisualisation {

	private Browser browser;

	@Override
	protected void createReportControls(Composite parent) {
		browser = new Browser(parent, SWT.BORDER);
		setInput(Collections.EMPTY_LIST);
	}

	public void addInput(Collection c) {
		System.out.println("Add file was called.");
		
		
	}

	public void deleteInput(Collection c) {
		// TODO Auto-generated method stub
		
	}

	public void setInput(Collection c) {
		RInterface t = new RInterface();
		if (RInterface.isEngineAvailable()){
			ArrayList<IReportItem> items = prepareReportItems(c, t);
			
			
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
	
	protected String getRVector(SensorAndMeasurements sm, int i) {
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
			//TODO throw an error if result.length is 0? (Happened to Anne once, she doesn't know why)
			if (result.length() != 0 && result.charAt(result.length()-1) == ',')
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
	
	/** Template method for subclasses to implement. 
	 * Subclasses can create IReportItems from the given SensorAndMeasurements. They can use the 
	 * getRVector(SensorAndMeasurements, int) method to write files to a 
	 * temporary file and create an R command that reads in the sensor data.
	 * This command needs to be      
	 * @param c
	 * @param t
	 * @return
	 */
	abstract protected ArrayList<IReportItem> prepareReportItems(Collection<SensorAndMeasurements> c, RInterface t);

}
