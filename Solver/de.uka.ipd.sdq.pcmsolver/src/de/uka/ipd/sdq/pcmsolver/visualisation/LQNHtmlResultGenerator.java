package de.uka.ipd.sdq.pcmsolver.visualisation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import LqnCore.ActivityDefType;
import LqnCore.LqnModelType;
import LqnCore.OutputResultType;
import LqnCore.ProcessorType;
import LqnCore.TaskType;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.LqnXmlHandler;

public class LQNHtmlResultGenerator {
	private LqnModelType lqnResultModel;
	private StringBuilder htmlText = new StringBuilder("");

	public LQNHtmlResultGenerator(String fileName) {
		LqnModelType loadedModel = LqnXmlHandler.loadModelFromXMI(fileName);
		this.lqnResultModel = loadedModel;
		if (this.lqnResultModel != null){
			generateHtml();	
		} else {
			generateErrorMsg(fileName);
		}
	}

	private void generateErrorMsg(String fileName) {
		appendHtmlHeader();
		htmlText.append("<h2>LQN Results</h2>");
		htmlText.append("Error retrieving results from: "+fileName+"<br>");
		htmlText.append("Check console output for error messages.");
		htmlText.append("</body></html>");
	}

	/**
	 * Retrieves the contents of an InputStream as a String.
	 * 
	 * @param is
	 *            the InputStream
	 * @return the resulting String
	 * @throws IOException
	 */
	private String getInputStreamContents(final InputStream is)
			throws IOException {
		if (is != null) {
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is,
						"UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}
	
	
	/**
	 * Generates HTML code from the LQN result file
	 */
	private void generateHtml() {
	
		appendHtmlHeader();		
		
		htmlText.append("<h2>LQN Results</h2>");
		htmlText.append(lqnResultModel.getName());

		htmlText.append("<table border=\"0\" style=\"margin-top: 1mm; border: 1px solid black;\">");
		htmlText.append("<thead><tr>");
		htmlText.append("<th class=\"SortString\" onselectstart=\"return false;\">Processor</th>");
		htmlText.append("<th class=\"SortString\" onselectstart=\"return false;\">Utilization</th>");
		htmlText.append("<th class=\"SortString\" onselectstart=\"return false;\">Util / #Cores</th>");
		htmlText.append("</tr></thead><tbody>");

		DecimalFormat format = new DecimalFormat("0.000000",
				DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		
		EList<ProcessorType> procList = lqnResultModel.getProcessor();
		for (ProcessorType pt : procList){
			EList<OutputResultType> outputResults = pt.getResultProcessor();
			
			if (outputResults.size() > 0){
				OutputResultType singleResult = outputResults.get(0);
				htmlText.append("<tr>");

				String procName = pt.getName();
				htmlText.append("<td>"+procName+"</td>");
				String util = (String)singleResult.getUtilization();
				double utilDouble = convertStringToDouble(util);
				htmlText.append("<td>"+format.format(utilDouble)+"</td>");

				String multiplicity = pt.getMultiplicity().toString();
				int multInt = Integer.parseInt(multiplicity);
				if (multInt != 0){
					double utilPerCore = utilDouble / multInt;
					htmlText.append("<td>"+format.format(utilPerCore)+"</td>");
				} else {
					htmlText.append("<td>n/a</td>");
				}
				
				htmlText.append("</tr>");
			}
		}
		htmlText.append("</tbody></table>");
		htmlText.append("<br>");
		
		
		htmlText.append("<table border=\"0\" style=\"margin-top: 1mm; border: 1px solid black;\">");
		htmlText.append("<thead><tr>");
		htmlText.append("<th class=\"SortString\" onselectstart=\"return false;\">UsageScenario</th>");
		htmlText.append("<th class=\"SortString\" onselectstart=\"return false;\">ServiceTime*</th>");
		htmlText.append("<th class=\"SortString\" onselectstart=\"return false;\">Throughput</th>");
		htmlText.append("</tr></thead><tbody>");
		for (ProcessorType pt : procList){
			String name = pt.getName();
			
			if (name.contains("UsageScenario") && !name.contains("Loop")){
				htmlText.append("<tr>");
				TaskType tt = pt.getTask().get(0);

				String entryName = tt.getEntry().get(0).getName();
				htmlText.append("<td>"+entryName+"</td>");

				double serviceTime = getResponseTimeOfSubActivities(tt);
				htmlText.append("<td>"+format.format(serviceTime)+"</td>");
				
				String throughput = (String)tt.getResultTask().get(0).getThroughput();
				double tpDouble = convertStringToDouble(throughput);
				htmlText.append("<td>"+format.format(tpDouble)+"</td>");
				
				htmlText.append("</tr>");
			}
		}
		htmlText.append("</tbody></table>");
		htmlText.append("* Does not yet support Branches in UsageScenarios");
		
		htmlText.append("</body></html>");
	}

	private void appendHtmlHeader() {
		// Retrieve CSS and JavaScript source code for later use in HTML page:
		String cssCode = "";
		String jsCode = "";
		try {
			cssCode = getInputStreamContents(this.getClass()
					.getResourceAsStream("/jsComponents.css"));
			jsCode = getInputStreamContents(this.getClass()
					.getResourceAsStream("/jsComponents.js"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// create HTML page header
		htmlText = new StringBuilder(
				"<html><head>"
						+ "<title>LQN Results</title>"
						+ "<script type=\"text/javascript\">"
						+ jsCode
						+ "</script>"
						+ "<style type=\"text/css\">"
						+ cssCode
						+ "		body { font-family: Lucida Grande, Arial, Tahoma, Verdana; font-size: 12px; }"
						+ "		td, th { font-size: 11px; }"
						+ "		th { background-color: c0c0c0; margin: 1px; padding: 3px 5px 3px 5px; border: 1px solid black; }"
						+ "		td { background-color: dfdfdf; margin: 1px; padding: 3px 5px 3px 5px; }"
						+ "</style>" + "</head><body>");
	}

	private double convertStringToDouble(String toConvert){
		double ret = Double.NaN;

		toConvert = toConvert.replaceAll("e", "E");
		toConvert = toConvert.replaceAll("\\+", "");
		DecimalFormat format = new DecimalFormat("0.0E000",
				DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		try {
			ret = format.parse(toConvert).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}
	
	private double getResponseTimeOfSubActivities(TaskType task) {
		// We add all result service times of the usage scenario to compute
		// the response time
		// TODO: check whether this works correctly if the usage scenario
		// contains branches
		double time = 0;

		EList<ActivityDefType> activities = task.getTaskActivities()
				.getActivity();
		for (ActivityDefType activity : activities) {
			EList<OutputResultType> results = activity.getResultActivity();

			for (OutputResultType outputResultType : results) {
				double serviceTime = convertStringToDouble((String) outputResultType
						.getServiceTime());

				time += serviceTime;
			}

		}
		return time;
	}
	
	

	public void display() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				if (page != null) {
					try {
						page.openEditor(new LQNResultEditorInput(htmlText.toString()),
								"de.uka.ipd.sdq.pcmsolver.LQNResultEditor");
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
	}
	
}
