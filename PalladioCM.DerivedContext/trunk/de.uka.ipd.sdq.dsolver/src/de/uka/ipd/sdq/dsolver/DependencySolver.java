/**
 * 
 */
package de.uka.ipd.sdq.dsolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import de.uka.ipd.sdq.dsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;




/**
 * @author Koziolek
 *
 */
public class DependencySolver {

	private Properties config;
	private PCMInstance currentModel;
	private static Logger logger = 
		Logger.getLogger(DependencySolver.class.getName());

	public DependencySolver(Properties config){
		this.config = config;
		logger.debug("Loading PCM Instance");
		currentModel = new PCMInstance(config);
		
		long startTime = System.nanoTime();
		visitScenarioEMFSwitch();
		long endTime = System.nanoTime();

		long duration = TimeUnit.NANOSECONDS.toMillis(endTime-startTime);
		logger.debug("Finished Traversal, Duration: "+ duration + " ms");
		
		logger.debug("Saving PCM Instance");
		currentModel.saveToFiles("SolvedDSolverExample1");
	}

	private void visitScenarioEMFSwitch(){
		UsageModelVisitor visitor = new UsageModelVisitor(currentModel);
		try {
			UsageScenario us = (UsageScenario) currentModel.getUsageModel()
					.getUsageScenario_UsageModel().get(0);
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		configureLogger();
		DependencySolver dsolver = new DependencySolver(getConfig(args));
	}

	private static void configureLogger() {
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %c - %m%n");
		ConsoleAppender myAppender = new ConsoleAppender(myLayout);
		BasicConfigurator.configure(myAppender);
	}

	private static Properties getConfig(String[] args) {
		Properties configFromFile = new Properties();
		if (args.length != 1) {
			System.out.println("Usage: DependencySolver <configfile.xml>");
			System.exit(-1);
		} else {
			// read XML configuration file
			configFromFile = new Properties();
			try {
				FileInputStream fis = new FileInputStream(args[0]);
				configFromFile.loadFromXML(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return configFromFile;
	}

}
