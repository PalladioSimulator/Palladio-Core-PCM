package de.uka.ipd.sdq.ByCounter.execution;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.lowagie.text.pdf.DefaultFontMapper;

import de.uka.ipd.sdq.ByCounter.instrumentation.AdditionalOpcodeInformation;
import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;
import de.uka.ipd.sdq.ByCounter.utils.ResultWriter;

/**
 * Class used to collect statistics about an instrumented method.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.1
 */
public class CountingResultCollector {
	
	private static CountingResultCollector instance = null;
	
	/**
	 * Public singleton accessor. Use this to get a reference 
	 * to the singleton instance.
	 * @return The singleton instance of ResultCollector.
	 */
	public synchronized static CountingResultCollector getInstance() {
		if (instance == null) {
			instance = new CountingResultCollector();
		}
		return instance;
	}
	
	private Logger log;
	
	// hold a list of results
	private ArrayList<CountingResult> results;
	
	private CountingResultCollector() {
		log = Logger.getLogger(this.getClass().getCanonicalName());
		results = new ArrayList<CountingResult>();
	}
	
	/**
	 * Clear all results in the ResultCollectors list.
	 *
	 */
	public synchronized void clearResults() {
		results.clear();
	}
	
	public synchronized JFreeChart createAndSaveChart(
		long datasetTimestampForSavingChart,
		DefaultCategoryDataset dataset,
		boolean savePNGchart,
		boolean savePDFchart,
		int chartXsize,
		int chartYsize,
		String qualifyingMethodName,
		String pathForChartSaving
		)
	{
		JFreeChart chart = ChartFactory.createBarChart(
				"Bytecode and method counts for method "+qualifyingMethodName, // chart title
				"Bytecode instructions", // domain axis label
				"Counts", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				false, // include legend
				true, // tooltips?
				false // URLs?
				);
		chart.setBackgroundPaint(Color.white);
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
//		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//		rangeAxis.setUpperMargin(0.15);
		CategoryItemRenderer renderer = plot.getRenderer();
		//renderer.setLabelGenerator(new LabelGenerator(50.0));
		renderer.setBaseItemLabelFont(new Font("Serif", Font.PLAIN, 20));
		renderer.setBaseItemLabelsVisible(true);

		File file = new File(pathForChartSaving+
				File.separator+"Counts."+
				qualifyingMethodName+
				"."+
				datasetTimestampForSavingChart+
				".pdf");
		if(!file.exists()){
			log.debug("Creating path "+pathForChartSaving);
			new File(pathForChartSaving).mkdirs();
			
		}else{
			log.warn("Overwriting "+file);
		}
			
		if(savePDFchart){
			try {
				ResultWriter.saveChartAsPDF(
						file, 
						chart, 
						chartXsize, 
						chartYsize, 
						new DefaultFontMapper());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(savePNGchart){
			try {
				ChartUtilities.saveChartAsPNG(file, chart, chartXsize, chartYsize);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return chart;
	}

	/**
	 * Get all results the ResultCollector holds.
	 * This does not clear the ResultCollectors list. You have to explicitly
	 * call <code>clearResults()</code> if that is your intention.
	 * @return A <code>Result</code> list.
	 */
	public synchronized List<CountingResult> getResults() {
		return results;
	}

	/**
	 * Get all results the ResultCollector holds.
	 * This does not clear the ResultCollectors list. You have to explicitly
	 * call <code>clearResults()</code> if that is your intention.
	 * @return A Result array.
	 */
	public synchronized CountingResult[] getResultsAsArray() {
		return results.toArray(new CountingResult[results.size()]);
	}

	/**
	 * Return an appropriate number of tabs to follow the given string.
	 * This is for log formatting purposes only.
	 * @param opcStr String after which the tabs shall follow
	 * @param maxNumTabs maximum number of tabs to return.
	 * @return A string containing a fitting number of tabs.
	 */
	private synchronized String getTabs(String opcStr, int maxNumTabs) {
		StringBuilder tabs = new StringBuilder();
		for(int i = maxNumTabs; i > 0; i--) {
			if(opcStr.length() < 8*i) {
				tabs.append("\t");
			} else {
				break;
			}
		}
		return tabs.toString();
	}

	/**
	 * Print a log message that reports the result, listing all counts and
	 * data that was collected.
	 * @param r Result to report.
	 * @return TODO
	 */
	public synchronized DefaultCategoryDataset logResult(CountingResult r) {
		log.info("Logging results...");
		
		long time = r.getTime(); 
		String qualifyingMethodName = r.getQualifyingMethodName(); 

		StringBuffer opcodes_texSB = new StringBuffer(); 	//for LaTeX tables
		StringBuffer opnames_texSB = new StringBuffer();	//for LaTeX tables
		StringBuffer opcounts_texSB = new StringBuffer();	//for LaTeX tables
		StringBuffer instrnames_texSB = new StringBuffer();	//for LaTeX tables
		StringBuffer instrcounts_texSB = new StringBuffer();//for LaTeX tables

		HashMap<Integer, Long> opcodeCounts = r.getOpcodeCounts();
		HashMap<String, Long> methodCallCounts = r.getMethodCallCounts();
		
		long[] newArrayCounts 	= r.getNewArrayCounts();
		int[] newArrayDims 		= r.getNewArrayDim();
		String[] newArrayTypes 	= r.getNewArrayTypes();

		if(time<0) {
			log.error("Wrong timestamp: "+time);
			return null;
		}
		if(qualifyingMethodName==null || qualifyingMethodName.equals("")) {
			log.error("Qualifying method name is null or empty");
			return null;
		}
		if(opcodeCounts == null) {
			log.error("Opcode counts hashmap is null... returning");
			return null;
		}
		if(methodCallCounts == null) {
			log.error("Method counts hashmap is null... returning");
			return null;
		}
		
		// make sure DisplayOpcodes does not interfer the output
		ASMOpcodesMapper dop = ASMOpcodesMapper.getInstance();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		long totalCountOfAllOpcodes = 0; //you need longs for that...
		long totalCountOfAllMethods = 0; //you need longs for that...
		
		
		String 	tabs;					// tabulators (for logging)
		String 	currentOpcodeString;	// opcode as string
		long 	currentOpcodeCount;		// opcode count
		long 	currentMethodCount = 0;	// method count
		

		log.info("\n================ ResultCollector ================");
		log.info("qualifyingMethodName: " + qualifyingMethodName);
		log.info("Opcodes, methods and their counts:");
		
		//TODO FIXME TESTME
		List<Integer> listOpcodes = new ArrayList<Integer>(opcodeCounts.keySet());
		Collections.sort(listOpcodes);
		
		for(int currentOpcode : listOpcodes) {
			currentOpcodeString = dop.getOpcodeString(currentOpcode);
			currentOpcodeCount 	= opcodeCounts.get(currentOpcode).intValue();
			tabs 				= getTabs(currentOpcodeString + ":", 2);
			dataset.addValue(currentOpcodeCount, qualifyingMethodName+": instructions", currentOpcodeString);
			log.info(currentOpcodeString + ": "+tabs+currentOpcodeCount);
			if(totalCountOfAllOpcodes +currentOpcodeCount<totalCountOfAllOpcodes){
				log.error("OVERFLOW while adding opcode counts");
			}else{
				totalCountOfAllOpcodes += currentOpcodeCount;
			}
			opcodes_texSB.append(currentOpcode+" & ");
			opnames_texSB.append(currentOpcodeString+" & ");
			opcounts_texSB.append(currentOpcodeCount+" & ");
		}
		opcodes_texSB.append("total \\\\");
		opnames_texSB.append("total \\\\");
		opcounts_texSB.append(totalCountOfAllOpcodes+" \\\\");
		
		
		for(String currentMethodSignature : methodCallCounts.keySet()) {
			currentMethodCount = methodCallCounts.get(currentMethodSignature);
			tabs = getTabs(currentMethodSignature + ":", 9);
			dataset.addValue(currentMethodCount, qualifyingMethodName+": methods", currentMethodSignature);
			log.info(currentMethodSignature + ": " + tabs + currentMethodCount);
			if(totalCountOfAllMethods + currentMethodCount<totalCountOfAllMethods){
				log.error("OVERFLOW while adding instruction counts");
			}else{
				totalCountOfAllMethods += currentMethodCount;
			}
			instrnames_texSB.append(currentMethodSignature+" & ");
			instrcounts_texSB.append(currentMethodCount+" & ");
		}
		instrnames_texSB.append("total \\\\");
		instrcounts_texSB.append(totalCountOfAllMethods+" \\\\");

		if(newArrayCounts != null 
				&& newArrayDims != null 
				&& newArrayTypes != null) {
			for(int i = 0; i < newArrayCounts.length; i++) {
				log.info("new array of type '" + newArrayTypes[i] + "'" 
						+ (newArrayDims[i] > 0 ? ", dim " + newArrayDims[i] : "")
						+ ": " + newArrayCounts[i]);
			}
		}
		log.info(totalCountOfAllOpcodes + " opcodes of "+opcodeCounts.size() + " different types were counted.\n");
		log.info(totalCountOfAllMethods + " methods of "+methodCallCounts.size() + " different types were counted.\n");
		System.out.println("====================================================");
		createAndSaveChart(time, dataset, true, true, 1200, 900, qualifyingMethodName, "charts");
		System.out.println("\n");
//		System.out.println("\\begin{table}[b]");
		
		System.out.println(opcodes_texSB.toString());//intentionally non-logger output
		System.out.println(opnames_texSB.toString());
		System.out.println(opcounts_texSB.toString());
		System.out.println(instrnames_texSB.toString());
		System.out.println(instrcounts_texSB.toString());
		
//		List<Integer> methodCounts = methodCallCounts.values();
//		int manualSum
//		for (Iterator<Integer> iterator = methodCounts.iterator(); iterator.hasNext();) {
//			Integer integer = iterator.next();
//			
//		}
		return dataset;
	}

	/**
	 * Call this to report the instruction and method call counts.
	 * @param time Time at which the method was invoced
	 * @param qualifyingMethodName Fully qualified method name.
	 * @param opcodeCounts An array of integers where each bytecode instruction is 
	 *        the index for which the value represents the number of calls to a 
	 *        specific instruction.
	 * @param methodCallCounts An array of integers where each element represents 
	 *        the number of times, the method was called.
	 *        The index is the same as for calledMethods.
	 * @param calledMethods An array of strings where each element is a 
	 *        method signature.
	 *        The index is the same as for methodCallCounts.
	 * @param newArrayCounts The counts for the specific *newarray call.
	 *        The index is the same as for newArrayTypeOrDim and newArrayDesc.
	 * @param newArrayTypeOrDim Depending on the type of the specific *newarray 
	 *        call, this is either a type integer or the dimension for the array.
	 *        The index is the same as for newArrayCounts and newArrayDesc.
	 * @param newArrayDescr For array consisting of object types, this is the 
	 *        type descriptor.
	 *        The index is the same as for newArrayCounts and newArrayTypeOrDim.
	 */
	@SuppressWarnings("boxing")
	public synchronized void protocolCount(
			long time, 
			String qualifyingMethodName, 
			long[] opcodeCounts, 
			long[] methodCallCounts,
			String[] calledMethods,
			long[] newArrayCounts,
			int[] newArrayTypeOrDim,
			String[] newArrayDescr) {
		log.info("Reporting counts...");
		HashMap<Integer, Long> filteredCounts = new HashMap<Integer, Long>();

		// remove all 0 counts
		for(int opcode = 0; opcode < opcodeCounts.length; opcode++) {
			if(opcodeCounts[opcode] != 0) {
				filteredCounts.put(opcode, opcodeCounts[opcode]);
			}
		}
		
		assert methodCallCounts.length == calledMethods.length;
		// create a HashMap for the method signatures and their counts
		HashMap<String, Long> methodCounts = new HashMap<String, Long>();
		for(int i = 0; i < methodCallCounts.length; i++) {
			methodCounts.put(calledMethods[i], methodCallCounts[i]);
		}
		
		int[] newArrayDim = null;
		String[] newArrayType = null;
		if(newArrayCounts != null && newArrayTypeOrDim != null && newArrayDescr != null) {
			// process information for the *newarray counts
			newArrayType = new String[newArrayCounts.length];
			newArrayDim = new int[newArrayCounts.length];
			
			for(int i = 0; i < newArrayCounts.length; i++) {
				// check whether the type is coded into the integer
				if(newArrayDescr[i] == AdditionalOpcodeInformation.NO_INFORMATION_STRING) {
					String str = null;
					// convert the type to a readable string
					switch(newArrayTypeOrDim[i]) {
					case 4:
						str = "boolean";
						break;
					case 5:
						str = "char";
						break;
					case 6:
						str = "float";
						break;
					case 7:
						str = "double";
						break;
					case 8:
						str = "byte";
						break;
					case 9:
						str = "short";
						break;
					case 10:
						str = "int";
						break;
					case 11:
						str = "long";
						break;
					default:
						log.error("Unknown object type id: " + newArrayTypeOrDim[i]);
						break;
					}
					newArrayType[i] = str;
					// no dimension information here
					newArrayDim[i] = AdditionalOpcodeInformation.NO_INFORMATION_INT;
				} else {
					// Type is there as descriptor - just copy it
					newArrayType[i] = newArrayDescr[i];
					// copy the dimension information
					newArrayDim[i] = newArrayTypeOrDim[i];
				}
			}
		}
		
		this.results.add(new CountingResult(
				time, 
				qualifyingMethodName, 
				filteredCounts, 
				methodCounts,
				newArrayCounts,
				newArrayDim,
				newArrayType));
	}

}
