package edu.kit.ipd.sdq.simcomp.controller.workflow.jobs;

import java.io.PrintStream;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractCreateMetaDataFilesJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

/**
 * This job creates the meta data files for the simulation code plugin project.
 * 
 * This class is based on {@link CreateEventSimMetaDataFilesJob}. Some code has
 * been reused.
 * 
 * @author Christoph Föhrdes
 */
public class CreateSimulationComponentMetaDataFilesJob extends AbstractCreateMetaDataFilesJob implements IJob {

	public CreateSimulationComponentMetaDataFilesJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	protected void writePluginXmlContent(PrintStream out) {
		out.println("<?xml version='1.0'?>");
		out.println("<plugin>");
		out.println("   <extension"); //$NON-NLS-1$
		out.println("         point=\"de.uka.ipd.sdq.simucomframework.controller\">"); //$NON-NLS-1$
		out.println("      <actionDelegate");
		out.println("            class=\"main.Main\"");
		out.println("            id=\"de.uka.ipd.sdq.codegen.simucominstance.actionDelegate\">");
		out.println("      </actionDelegate>");
		out.println("   </extension>");
		out.println("</plugin>");
	}

	@Override
	protected void writeBuildPropertiesContent(PrintStream out) {
		out.println("output.. = bin/");
		out.println("source.. = src/");
		out.println("bin.includes = plugin.xml,\\");
		out.println("               META-INF/,\\");
		out.println("               model/,\\");
		out.println("               .");
	}

	private final static String[] BUNDLES = new String[] {
		"de.uka.ipd.sdq.simulation", 
		"de.uka.ipd.sdq.simulation.abstractsimengine", 
		"de.uka.ipd.sdq.simucomframework", 
		"de.uka.ipd.sdq.simucomframework.simucomstatus", 
		"de.uka.ipd.sdq.sensorframework", 
		"de.uka.ipd.sdq.simucomframework.variables", 
		"org.apache.log4j", 
		"org.eclipse.osgi", 
		"de.uka.ipd.sdq.scheduler", 
		"org.jscience", 
		"de.uka.ipd.sdq.probespec.framework", 
		"de.uka.ipd.sdq.pipesandfilters", 
		"de.uka.ipd.sdq.pipesandfilters.framework", 
		"de.uka.ipd.sdq.reliability.core", 
		"de.fzi.se.accuracy", 
		"de.uka.ipd.sdq.probfunction.math", 
		"edu.kit.ipd.sdq.simcomp.middleware"
	};

	@Override
	protected String[] getRequiredBundles() {
		return BUNDLES;
	}

	@Override
	protected String getBundleActivator() {
		return "main.Main";
	}

}
