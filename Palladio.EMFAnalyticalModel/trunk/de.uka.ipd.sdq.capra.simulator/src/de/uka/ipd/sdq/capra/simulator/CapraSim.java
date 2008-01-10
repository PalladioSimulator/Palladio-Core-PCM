package de.uka.ipd.sdq.capra.simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import scheduler.SystemConfiguration;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.core.CapraExpression;
import de.uka.ipd.sdq.capra.core.DemandAction;
import de.uka.ipd.sdq.capra.core.ProbabilisticPrefix;
import de.uka.ipd.sdq.capra.simulator.builder.SimulationModelCreator;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;
import de.uka.ipd.sdq.capra.simulator.tools.CapraTools;
import de.uka.ipd.sdq.capra.simulator.tools.RandomStreamProvider;
import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.tools.SchedulerTools;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class CapraSim {

	private static final String path = "D:/Diss/dev/runtime-EclipseApplication/SchedulerConfigurator/";

	public static volatile boolean done = false;

	private static Map<String, List<PDFInfo>> pdfTableMap = new Hashtable<String, List<PDFInfo>>();

	public static final boolean debug = false;

	public static void main(String[] args) {
		double simTime = Double.parseDouble(args[0]);
		String fileName = args[1];
		
		try {
			LoggingWrapper.activate();
			RandomStreamProvider.getTimeStream().resetNextSubstream();
			Map<String, ManagedPDF> pdfMap = loadPDFs(fileName);
			SchedulingFactory.setUsedSimulator(Simulator.getDefaultSimulator());

			CapraModel capraModel = (CapraModel) CapraTools.loadFromXMI(path + "messaging.simple.Arrival100Size500NonPersistent.capra");
//			CapraModel capraModel = (CapraModel) CapraTools.loadFromXMI(path + "scenario4.capra");
			SchedulerTools.loadFromXMI(path + "Library.scheduler");
//			SystemConfiguration systemConfiguration = (SystemConfiguration) SchedulerTools.loadFromXMI(path + "scenario.scheduler");
//			IDAOFactory factory = new FileDAOFactory(1, path + "scenario4/");
			SystemConfiguration systemConfiguration = (SystemConfiguration) SchedulerTools.loadFromXMI(path + "messaging.scheduler");
			IDAOFactory factory = new FileDAOFactory(1, path + "messaging/");
//			for(String name : pdfMap.keySet()){
//				System.out.println(name);
//				setArrivalTime(capraModel,pdfMap.get(name));
//				simulate(simTime, capraModel, systemConfiguration, factory, name);
//			}
			simulate(simTime, capraModel, systemConfiguration, factory, "Arrival 100 Size 500 NonPersistent");
//			simulate(simTime, capraModel, systemConfiguration, factory, "Windows Scenario 4c");
			factory.finalizeAndClose();
			String path = getPath(fileName);
			//store(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void store(String path) {
		for (String name : pdfTableMap.keySet()){
			store(pdfTableMap.get(name), path, name);
		}
	}

	private static void store(List<PDFInfo> table, String rootDir,
			String name) {
		Object[] oArray = table.toArray();
		Arrays.sort(oArray);
		storeTable(oArray,rootDir+name+".csv");
		storePDF(rootDir+name+".list", oArray);
	}

	private static void storeTable(Object[] table,
			String fileName) {
		try {
			File file = new File(fileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write(PDFInfo.getDescription());
			writer.write("\n");
			for(Object o : table){
				PDFInfo info = (PDFInfo)o;
				writer.write(info.getRow());
				writer.write("\n");
			}
			writer.flush();
			writer.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	private static void storePDF(String fileName, Object[] infoList) {
		try {
			File file = new File(fileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			for(Object o: infoList){
				PDFInfo info = (PDFInfo)o;
				writer.write("#" + info.name + ": " + info.pdf.toString());
				writer.write("\n");
			}
			
			writer.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}


	
	private static String getPath(String fileName) {
		int pos = fileName.lastIndexOf(File.separator);
		return fileName.substring(0,pos+1);
	}

	private static void setArrivalTime(CapraModel capraModel,
			ManagedPDF managedPDF) {
		CapraExpression expr = capraModel.getProcesses().get(0).getProcessvariable().getProcess();
		ProbabilisticPrefix pref = (ProbabilisticPrefix)expr;
		DemandAction dem = (DemandAction) pref.getAction();
		dem.getResourceUsage().setUsageTimeSpecification(managedPDF.toString());
	}

	private static void simulate(double simTime, CapraModel capraModel,
			SystemConfiguration systemConfiguration, IDAOFactory factory, String name) {
		SchedulingFactory.getUsedSimulator().init();
		long start = System.nanoTime();
		SimulationModel simModel = SimulationModelCreator.loadSimulation(capraModel, systemConfiguration, new SchedulingFactory());
		simModel.init();
		System.out.println("Initialisation took " + (System.nanoTime() - start)
				/ 1000000 + " ms");
		start = System.nanoTime();
		simModel.simulate(simTime);
		System.out.println("Simulation took " + (System.nanoTime() - start)
				/ 1000000 + " ms");

		if (!debug) {
			start = System.nanoTime();
			CapraExperimentManager expManager = new CapraExperimentManager(name  ,factory);
			simModel.storeData(expManager);
			Experiment experiment = expManager.getExperiment();
			ExperimentRun run = expManager.getRun();
			for (de.uka.ipd.sdq.sensorframework.entities.Sensor s : experiment.getSensors()){
				SensorAndMeasurements sam = run.getMeasurementsOfSensor(s);
				PDFInfo info = toPDFInfo(sam, "Sim " + s.getSensorName()+ " "+ name);
				//addToTable(info,s.getSensorName());
			}
			expManager.close();
			System.out.println("Saving took " + (System.nanoTime() - start)
					/ 1000000 + " ms");
		}
	}

	private static void addToTable(PDFInfo info, String sensorName) {
		List<PDFInfo> infoList = pdfTableMap.get(sensorName);
		if (infoList == null){
			infoList = new ArrayList<PDFInfo>();
			pdfTableMap.put(sensorName,infoList);
		}
		infoList.add(info);
	}

	private static void setRate(CapraModel capraModel, double rate) {
		CapraExpression expr = capraModel.getProcesses().get(0).getProcessvariable().getProcess();
		ProbabilisticPrefix pref = (ProbabilisticPrefix)expr;
		DemandAction dem = (DemandAction) pref.getAction();
		ManagedPDF arr = new ManagedPDF( dem.getResourceUsage().getUsageTime());
		IBoxedPDF pdf = arr.getBoxedPdfTimeDomain();
		pdf = (IBoxedPDF)pdf.stretchDomain(1.0 / rate);
		arr = new ManagedPDF(pdf);
		dem.getResourceUsage().setUsageTime(arr.getModelPdf());
	}
	
	public static Map<String, ManagedPDF> loadPDFs(String fileName) throws Exception {
		Map<String, ManagedPDF> pdfMap = new HashMap<String, ManagedPDF>();
		FileReader fileReader = new FileReader(new File(fileName));
		BufferedReader reader = new BufferedReader(fileReader);
		String line;
		while ((line = reader.readLine()) != null){
			if((line.length() > 0) && (line.charAt(0) != '#')){
				if (line.contains("DoublePDF")){
					int pos = line.indexOf(":");
					String name = line.substring(0, pos);
					line = line.substring(pos+1);
					ManagedPDF pdf = ManagedPDF.createFromString(line);
					pdfMap.put(name,pdf);
				}
			}
		}
		return pdfMap;
	}
	
	private static class PDFInfo implements Comparable<PDFInfo>{
		public double mean;
		public double q25;
		public double median;
		public double q75;
		public double q10;
		public double q90;
		public ManagedPDF pdf;
		public String name;
		
		public PDFInfo() {
			mean = 0;
			q10 = 0;
			q25 = 0;
			q75 = 0;
			q90 = 0;
			median = 0;
			pdf = null;
			name = null;
		}
		
		@Override
		public String toString() {
			return 
			  name + "\n" 
			+ pdf + "\n"
			+ "Average: " + mean +  "\n"
			+ "Q10: " + q10 + "\n"
			+ "Q25: " + q25 + "\n"
			+ "Median: " + median + "\n"
			+ "Q75: " + q75 + "\n"
			+ "Q90: " + q90 + "\n";
		}

		public String getRow() {
			String row = 
			  name + ";" 
			+ mean +  ";"
			+ q10 + ";"
			+ q25 + ";"
			+ median + ";"
			+ q75 + ";"
			+ q90;
			return row.replace(".", ",");
		}
		
		public static String getDescription(){
			return "Name; Average; Q10; Q25; Median; Q75; Q90";
		}
		
		@Override
		public int compareTo(PDFInfo info) {
			return this.name.compareTo(info.name);
		}
	}

	private static PDFInfo toPDFInfo(SensorAndMeasurements sam, String name) {
		IProbabilityFunctionFactory factory = IProbabilityFunctionFactory.eINSTANCE;
		IUnit unit = factory.createUnit("ms");
		
		List<Double> measurements = getMeasurements(sam);
		ISamplePDF sPDF = factory.createSamplePDFFromMeasurements(0.1, measurements, unit);
		PDFInfo info = new PDFInfo();
		try {
			info.mean = sPDF.getArithmeticMeanValue();
			info.q10 = (Double) sPDF.getPercentile(10);
			info.q25 = (Double) sPDF.getPercentile(25);
			info.median = (Double) sPDF.getPercentile(50);
			info.q75 = (Double) sPDF.getPercentile(75);
			info.q90 = (Double) sPDF.getPercentile(90);
			sPDF = sPDF.getFunctionWithNewDistance(1);
			info.pdf = new ManagedPDF(sPDF);
			info.name = name;
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
		}
		return info;
	}

	private static List<Double> getMeasurements(SensorAndMeasurements sam) {
		List<Double> result = new ArrayList<Double>();
		for(Measurement m: sam.getMeasurements()){
			TimeSpanMeasurement tsm = (TimeSpanMeasurement)m;
			result.add(tsm.getTimeSpan());
		}
		return result;
	}
}
