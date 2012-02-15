package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import LqnCore.LqnModelType;

public class LqnXmlHandler {

	private static Logger logger = Logger.getLogger(LqnXmlHandler.class.getName());
	
	LqnModelType lqnModel;
	
	public LqnXmlHandler(LqnModelType anLqnModel) {
		lqnModel = anLqnModel;
	}

	public void saveModelToXMI(String fileName) {
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
		
		URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());
		
		//Resource resource = resourceSet.createResource(fileURI);
		XMIResource resource = (XMIResource) resourceSet.createResource(fileURI);
		resource.getContents().add(lqnModel);
		
		//resource.getDefaultSaveOptions().put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, true);
		
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		fixXMLFile(fileName);
		
	}
	
	/**
	 * Restores the corresponding Ecore model, previously serialized via
	 * {@link #saveModelToXMI(String)}.
	 * 
	 * @param fileName
	 * @return A representation of the model object 'LQN Model Type'; null if
	 *         the file don't exists or when there were problems reading the
	 *         file.
	 */
	public static LqnModelType loadModelFromXMI(String fileName) {
		// Revert the Ecore tag names
		revertXMLFile(fileName);
		
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());
		
		Resource resource = resourceSet.createResource(fileURI);
		
		LqnModelType lqnModel = null;
		try {
			resource.load(Collections.EMPTY_MAP);
			lqnModel = (LqnModelType) resource.getContents().get(0);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		// Can be null if there were problems retrieving the model
		return lqnModel;
	}

	/**
	 * Changes the XML-tag names to their original names. They had
	 * formerly been changed by the LQN-to-Ecore mapping.
	 * 
	 * @param filename
	 */
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
		
		//TODO: remove hard coded path to xsd file. 
		String content = new String(b);
		content = content.replaceAll("LqnModelType", "lqn-model");
		
//		String lqnDir = System.getenv("LQNDIR");
//		if (lqnDir != null && lqnDir !=""){
//			
//			lqnDir = lqnDir.replaceAll("\\\\", "/");
//			lqnDir = lqnDir.replaceAll(" ", "%20");
//			content = content.replaceAll("xmlns=\"file:/C:/Program%20Files/LQN%20Solvers/lqn-core.xsd\"", "xsi:noNamespaceSchemaLocation=\"file:///"+lqnDir+"lqn.xsd\"");
//		} else {
//			content = content.replaceAll("xmlns=\"file:/C:/Program%20Files/LQN%20Solvers/lqn-core.xsd\"", "xsi:noNamespaceSchemaLocation=\"file:///C:/Program Files/LQN Solvers/lqn.xsd\"");
//		}
		
		content = content.replaceAll("xmlns=\"file:/C:/Program%20Files/LQN%20Solvers/lqn-core.xsd\"", "xsi:noNamespaceSchemaLocation=\"file:/C:/Program Files/LQN Solvers/lqn.xsd\"");
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
		content = content.replaceAll("callOrder", "call-order");
		content = content.replaceAll("hostDemandMean", "host-demand-mean");
		content = content.replaceAll("hostDemandCvsq", "host-demand-cvsq");
		content = content.replaceAll("callsMean", "calls-mean");
		content = content.replaceAll("replyActivity", "reply-activity");
		content = content.replaceAll("postOR", "post-OR");
		content = content.replaceAll("postAND", "post-AND");
		content = content.replaceAll("preOR", "pre-OR");
		content = content.replaceAll("preAND", "pre-AND");
		content = content.replaceAll("taskActivities", "task-activities");
		content = content.replaceAll("boundToEntry", "bound-to-entry");
		content = content.replaceAll("replyEntry", "reply-entry");
		content = content.replaceAll("activityGraph", "activity-graph");
		content = content.replaceAll("speedFactor", "speed-factor");
		content = content.replaceAll("serviceTimeDistribution", "service-time-distribution");
		content = content.replaceAll("openArrivalRate", "open-arrival-rate");
		content = content.replaceAll("openWaitTime", "open-wait-time");
		content = content.replaceAll("binSize", "bin-size");
		content = content.replaceAll("midPoint", "mid-point");
		content = content.replaceAll("numberBins", "number-bins");
		content = content.replaceAll("stdDev", "std-dev");
		content = content.replaceAll("histogramBin", "histogram-bin");
		content = content.replaceAll("overflowBin", "overflow-bin");
		content = content.replaceAll("waitingVariance", "waiting-variance");
		content = content.replaceAll("phase1ProcWaiting", "phase1-procWaiting");
		content = content.replaceAll("phase1ServiceTime", "phase1-serviceTime");
		content = content.replaceAll("phase1ServiceTimeVariance", "phase1-serviceTime");
		content = content.replaceAll("resultJoinDelay", "result-join-delay");
		
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
	
	/**
	 * Revert the previously changed XML-tag names to their corresponding Ecore
	 * names. The renaming is required before the model can be restored from an
	 * XML file.
	 * 
	 * @param filename
	 */
	private static void revertXMLFile(String filename) {
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
		content = content.replaceAll("lqn-model", "LqnModelType");
		
//		String lqnDir = System.getenv("LQNDIR");
//		if (lqnDir != null && lqnDir !=""){
//			lqnDir = lqnDir.replaceAll("\\\\", "/");
//			//lqnDir = lqnDir.replaceAll(" ", "%20");
//			content = content.replaceAll("xsi:noNamespaceSchemaLocation=\"file:///C:/Program Files/LQN Solvers/lqn.xsd\"", "xmlns=\"file:///"+lqnDir+"lqn-core.xsd\"");
//		} else {
//			content = content.replaceAll("xsi:noNamespaceSchemaLocation=\"file:///C:/Program Files/LQN Solvers/lqn.xsd\"", "xmlns=\"file:///C:/Program%20Files/LQN%20Solvers/lqn-core.xsd\"");
//		}
		content = content.replaceAll("xsi:noNamespaceSchemaLocation=\"file:///C:/Program Files/LQN Solvers/lqn.xsd\"", "xmlns=\"file:/C:/Program%20Files/LQN%20Solvers/lqn-core.xsd\"");
		
		
		content = content.replaceAll("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\"");

		content = content.replaceAll("entry-activity-graph", "entryActivityGraph");
		content = content.replaceAll("think-time", "thinkTime");

		content = content.replaceAll("entry-phase-activities", "entryPhaseActivities");
		content = content.replaceAll("solver-params", "solverParams");
		content = content.replaceAll("synch-call", "synchCall");
		content = content.replaceAll("conv_val", "convVal");
		content = content.replaceAll("it_limit", "itLimit");
		content = content.replaceAll("print_int", "printInt");
		content = content.replaceAll("underrelax_coeff", "underrelaxCoeff");
		content = content.replaceAll("host-demand-mean", "hostDemandMean");
		content = content.replaceAll("host-demand-cvsq", "hostDemandCvsq");
		content = content.replaceAll("calls-mean", "callsMean");
		content = content.replaceAll("reply-activity", "replyActivity");
		content = content.replaceAll("post-OR", "postOR");
		content = content.replaceAll("pre-OR", "preOR");
		content = content.replaceAll("postAND", "post-AND");
		content = content.replaceAll("preAND", "pre-AND");
		
		content = content.replaceAll("task-activities", "taskActivities");
		content = content.replaceAll("bound-to-entry", "boundToEntry");
		content = content.replaceAll("reply-entry", "replyEntry");
		content = content.replaceAll("activity-graph", "activityGraph");
		content = content.replaceAll("speed-factor", "speedFactor");
		content = content.replaceAll("service-time-distribution", "serviceTimeDistribution");
		content = content.replaceAll("open-arrival-rate", "openArrivalRate");
		
		// the subsequent replacement rules are relevant only for result files
		content = content.replaceAll("result-general", "resultGeneral");
		content = content.replaceAll("result-join-delay", "resultJoinDelay");
		content = content.replaceAll("join-variance", "joinVariance");
		content = content.replaceAll("join-waiting", "joinWaiting");
		content = content.replaceAll("conv-val", "convVal");
		content = content.replaceAll("elapsed-time", "elapsedTime");
		content = content.replaceAll("solver-info", "solverInfo");
		content = content.replaceAll("result-task", "resultTask");
		content = content.replaceAll("phase1-utilization", "phase1Utilization");
		content = content.replaceAll("proc-utilization", "procUtilization");
		content = content.replaceAll("result-entry", "resultEntry");
		content = content.replaceAll("squared-coeff-variation", "squaredCoeffVariation");
		content = content.replaceAll("throughput-bound", "throughputBound");
		content = content.replaceAll("result-activity", "resultActivity");
		content = content.replaceAll("proc-waiting", "procWaiting");
		// As "service-time" is a prefix of "service-time-variance", a following "=" is needed
		content = content.replaceAll("service-time=", "serviceTime=");   
		content = content.replaceAll("service-time-variance", "serviceTimeVariance");
		content = content.replaceAll("result-call", "resultCall");
		content = content.replaceAll("result-processor", "resultProcessor");
		content = content.replaceAll("open-wait-time", "openWaitTime");
		content = content.replaceAll("bin-size", "binSize");
		content = content.replaceAll("mid-point", "midPoint");
		content = content.replaceAll("number-bins", "numberBins");
		content = content.replaceAll("std-dev", "stdDev");
		content = content.replaceAll("histogram-bin", "histogramBin");
		content = content.replaceAll("overflow-bin", "overflowBin");
		content = content.replaceAll("waiting-variance", "waitingVariance");
		content = content.replaceAll("phase1-procWaiting", "phase1ProcWaiting");
		content = content.replaceAll("phase1-serviceTime", "phase1ServiceTime");
		content = content.replaceAll("phase1-serviceTime", "phase1ServiceTimeVariance");
		
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
