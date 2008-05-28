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
		
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(lqnModel);
		
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		fixXMLFile(fileName);
		
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
