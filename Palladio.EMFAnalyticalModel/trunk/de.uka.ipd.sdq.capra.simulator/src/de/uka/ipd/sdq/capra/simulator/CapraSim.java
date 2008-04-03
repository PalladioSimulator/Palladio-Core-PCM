package de.uka.ipd.sdq.capra.simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import scheduler.SystemConfiguration;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.ExperimentSeries;
import de.uka.ipd.sdq.capra.simulator.builder.SimulationModelCreator;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;
import de.uka.ipd.sdq.capra.simulator.tools.CapraTools;
import de.uka.ipd.sdq.pdftools.PDFInfo;
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

public class CapraSim extends AbstractSim {

	private static List<PDFInfo> table = new ArrayList<PDFInfo>();
	private static ExperimentSeries experimentSeries;
	
	public static void main(String[] args) {
		initialize(args);

		experimentSeries = (ExperimentSeries) CapraTools.loadFromXMI(experiment_file);
		factory = new FileDAOFactory(experimentSeries.getOutputDirectory());

		try {
			SchedulingFactory.setUsedSimulator(Simulator.getDefaultSimulator());

			CapraModel capraModel = (CapraModel) CapraTools
					.loadFromXMI(experimentSeries.getCapraFile());
			SchedulerTools.loadFromXMI(experimentSeries.getSchedulerLibraryFile());
			SystemConfiguration systemConfiguration = (SystemConfiguration) SchedulerTools
					.loadFromXMI(experimentSeries.getSystemConfigurationFile());

			for(de.uka.ipd.sdq.capra.experiment.Experiment exp : experimentSeries.getExperiment()){
				simulate(capraModel, systemConfiguration, exp);
				if (debug) break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

	}


	private static void simulate(CapraModel capraModel,
			SystemConfiguration systemConfiguration, de.uka.ipd.sdq.capra.experiment.Experiment exp) {

		SchedulingFactory.getUsedSimulator().init();

		long start = System.nanoTime();
		SimulationModel simModel = SimulationModelCreator.loadSimulation(
				capraModel, systemConfiguration, exp, new SchedulingFactory());
		simModel.init();
		System.out.println("Initialisation took " + (System.nanoTime() - start)
				/ 1000000 + " ms");
		start = System.nanoTime();
		simModel.simulate(duration);
		System.out.println("Simulation took " + (System.nanoTime() - start)
				/ 1000000 + " ms");

		if (!debug) {
			start = System.nanoTime();
			CapraExperimentManager expManager = new CapraExperimentManager(
					exp.getName(), factory);
			
			simModel.storeData(expManager);
			
			createSummary(exp.getName(), expManager);
			
			expManager.close();
			
			System.out.println("Saving took " + (System.nanoTime() - start)
					/ 1000000 + " ms");
		}
	}

	private static void createSummary(String name,
			CapraExperimentManager expManager) {
		if (experimentSeries.getSummaryFile() != null) {
			Experiment experiment = expManager.getExperiment();
			ExperimentRun run = expManager.getRun();
			for (de.uka.ipd.sdq.sensorframework.entities.Sensor s : experiment
					.getSensors()) {
				try {
				SensorAndMeasurements sam = run.getMeasurementsOfSensor(s);
				PDFInfo info = toPDFInfo(sam, s.getSensorName() + " "
						+ name);
				table.add(info);
				} catch (IllegalArgumentException e){
					LoggingWrapper.log(e.getMessage());
				}
			}
			storeTable(table, experimentSeries.getSummaryFile());
		}
	}

	private static void storeTable(List<PDFInfo> table, String fileName) {
		try {
			File file = new File(fileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write(PDFInfo.getDescription());
			writer.write("\n");
			for (PDFInfo info : table) {
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

	private static PDFInfo toPDFInfo(SensorAndMeasurements sam, String name) {
		IProbabilityFunctionFactory factory = IProbabilityFunctionFactory.eINSTANCE;
		IUnit unit = factory.createUnit("ms");

		List<Double> measurements = getMeasurements(sam);
		ISamplePDF sPDF = factory.createSamplePDFFromMeasurements(0.1,
				measurements, unit);
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
		for (Measurement m : sam.getMeasurements()) {
			TimeSpanMeasurement tsm = (TimeSpanMeasurement) m;
			result.add(tsm.getTimeSpan());
		}
		return result;
	}
}
