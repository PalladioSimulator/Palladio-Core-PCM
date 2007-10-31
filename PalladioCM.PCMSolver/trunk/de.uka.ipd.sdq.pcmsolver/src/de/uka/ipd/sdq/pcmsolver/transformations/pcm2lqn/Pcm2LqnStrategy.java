package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.exprsolver.ExpressionSolver;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.Pcm2RegExStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.TransformUsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.spa.expression.Expression;

public class Pcm2LqnStrategy implements SolverStrategy {

	private static Logger logger = Logger.getLogger(Pcm2LqnStrategy.class.getName());
	private static final String FILENAME_INPUT = "C:\\Temp\\test.xml";
	private static final String FILENAME_RESULT = "C:\\Temp\\test.out";
	private static final String FILENAME_LQN = "C:\\Temp\\test.lqn";;
	private LqnModelType lqnModel;
	
	private long overallDuration = 0;
	private ILaunchConfiguration config;
	
	public Pcm2LqnStrategy(ILaunchConfiguration configuration) {
		config = configuration;
//	    boolean success = (new File(FILENAME_RESULT)).delete();
//	    if (!success) {
//	        logger.debug("Deleted Old Output File.");
//	    } else {
//	    	logger.debug("Deleting Old Output File failed!");
//	    }
	}

	public Pcm2LqnStrategy() {
	}

	@Override
	public void loadTransformedModel(String fileName) {
	}

	@Override
	public void solve() {
		
		String solverProgram = "";
		try {
			solverProgram = config.getAttribute("solver", "LQNS");
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (solverProgram.equals("LQNS")) solverProgram = "lqns";
		else solverProgram = "lqsim";
		
		long timeBeforeCalc = System.nanoTime();
		try {
			Thread.sleep(2000);
			Process blah = Runtime.getRuntime().exec( solverProgram+" -o"+FILENAME_RESULT+" "+FILENAME_LQN );
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		long timeAfterCalc = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc-timeBeforeCalc);
		overallDuration += duration;
		logger.warn("Finished Running "+solverProgram+":\t\t"+ duration + " ms");
		logger.warn("Completed Analysis:\t\t"+ overallDuration + " ms overall");
		
		System.out.println();
//		printFileToConsole(FILENAME_INPUT);
		printFileToConsole(FILENAME_RESULT);
	}

	private void printFileToConsole(String filename) {
		FileInputStream fis = null;
		byte b[]= null;
		try {
			fis = new FileInputStream(filename);
			int x = 0;
			x = fis.available();
			b= new byte[x];
			fis.read(b);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String content = new String(b);
		logger.warn(content);
	}
	
	@Override
	public void storeTransformedModel(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transform(PCMInstance model) {
		long startTime = System.nanoTime();
		runDSolver(model);
		long timeAfterDSolve = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterDSolve-startTime);
		overallDuration += duration;
		logger.warn("Finished DSolver:\t\t"+ duration + " ms");
		

		long timeBeforeTransform = System.nanoTime();
		runPcm2Lqn(model);
		long timeAfterTransform = System.nanoTime();
		long duration2 = TimeUnit.NANOSECONDS.toMillis(timeAfterTransform-timeBeforeTransform);
		overallDuration += duration2;
		logger.warn("Finished PCM2LQN:\t\t"+ duration2 + " ms");
	}
	
	private void runPcm2Lqn(PCMInstance model) {
		UsageModel2Lqn u2l = new UsageModel2Lqn(model);
		lqnModel = (LqnModelType)u2l.doSwitch(model.getUsageModel());
		
		saveToXMIFile(lqnModel, FILENAME_INPUT);
		fixXMLFile(FILENAME_INPUT);
		runLqnTools();
		
	}
	
	private void runLqnTools() {
		try {
			Process blah = Runtime.getRuntime().exec( "lqn2xml -o"+FILENAME_LQN+" -Olqn "+FILENAME_INPUT );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void runDSolver(PCMInstance model) {
		
		// TODO: fix this:
		UsageModelVisitor visitor = new UsageModelVisitor(model);
		try {
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void saveToXMIFile(EObject modelToSave, String fileName) {
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(modelToSave);
		
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	private void fixXMLFile(String filename) {
		FileInputStream fis = null;
		byte b[]= null;
		try {
			fis = new FileInputStream(filename);
			int x = 0;
			x = fis.available();
			b= new byte[x];
			fis.read(b);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String content = new String(b);
		content = content.replaceAll("LqnModelType", "lqn-model");
		content = content.replaceAll("xmlns=\"file:/C:/Program%20Files/LQN%20Solvers/lqn-core.xsd\"", "xsi:noNamespaceSchemaLocation=\"file:///C:/Program Files/LQN Solvers/lqn.xsd\"");
		content = content.replaceAll("xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\"", "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");

		content = content.replaceAll("entryActivityGraph", "entry-activity-graph");
		content = content.replaceAll("thinkTime", "think-time");

		content = content.replaceAll("entryPhaseActivities", "entry-phase-activities");
		content = content.replaceAll("solverParams", "solver-params");
		content = content.replaceAll("synchCall", "synch-call");
		content = content.replaceAll("convVal", "conv_val");
		content = content.replaceAll("itLimit", "it_limit");
		content = content.replaceAll("printInt", "print_int");
		content = content.replaceAll("underrelaxCoeff", "underrelax_coeff");
		content = content.replaceAll("hostDemandMean", "host-demand-mean");
		content = content.replaceAll("callsMean", "calls-mean");
		content = content.replaceAll("replyActivity", "reply-activity");
		content = content.replaceAll("postOR", "post-OR");
		content = content.replaceAll("preOR", "pre-OR");
		content = content.replaceAll("taskActivities", "task-activities");
		content = content.replaceAll("boundToEntry", "bound-to-entry");
		content = content.replaceAll("replyEntry", "reply-entry");
		content = content.replaceAll("activityGraph", "activity-graph");
		content = content.replaceAll("speedFactor", "speed-factor");
		content = content.replaceAll("serviceTimeDistribution", "service-time-distribution");
		content = content.replaceAll("openArrivalRate", "open-arrival-rate");
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filename);
			fos.write(content.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
