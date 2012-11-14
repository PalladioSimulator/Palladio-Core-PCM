package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;



import java.io.PrintStream;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public class CreateProtoComMetaDataFilesJob extends AbstractCreateMetaDataFilesJob implements IJob {

	public CreateProtoComMetaDataFilesJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
		super();
		
		this.configuration = configuration;
	}

	@Override
	protected void writePluginXmlContent(PrintStream out) {
		out.println("<?xml version='1.0'?>"); 			//$NON-NLS-1$
		out.println("<plugin>"); 						//$NON-NLS-1$
		out.println("   <extension"); 					//$NON-NLS-1$
		out.println("         point=\"de.uka.ipd.sdq.simucomframework.controller\">"); //$NON-NLS-1$
		out.println("      <actionDelegate");			 //$NON-NLS-1$
		out.println("            class=\"main.SimuComControl\""); //$NON-NLS-1$
		out.println("            id=\"de.uka.ipd.sdq.codegen.simucominstance.actionDelegate\">"); //$NON-NLS-1$
		out.println("      </actionDelegate>"); 		//$NON-NLS-1$
		out.println("   </extension>"); 				//$NON-NLS-1$
		out.println("</plugin>"); //$NON-NLS-1$
	}

	@Override
	protected void writeBuildPropertiesContent(PrintStream out) {
		out.println("output.. = bin/"); //$NON-NLS-1$
		out.println("source.. = src/"); //$NON-NLS-1$
		out.println("bin.includes = plugin.xml,\\"); //$NON-NLS-1$
		out.println("				META-INF/,\\"); //$NON-NLS-1$
		out.println("				."); //$NON-NLS-1$
	}

	private final static String[] BUNDLES = new String[] {
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
		 
		 "de.uka.ipd.sdq.prototype.framework",
		 "de.uka.ipd.sdq.resourcestrategies",
		 "org.junit4",
		 "de.uka.ipd.sdq.stoex",
		 "de.uka.ipd.sdq.stoex.analyser",
		 "de.uka.ipd.sdq.pcm.stochasticexpressions",
		 "de.uka.ipd.sdq.pcm",
		 "de.uka.ipd.sdq.sensorframework.storage",
		 "de.uka.ipd.sdq.probfunction.math",
		 "org.apache.commons.math"
	};
		
		
	@Override
	protected String[] getRequiredBundles() {
		return BUNDLES;
	}	
	
    @Override
    protected String getBundleActivator() {
        return "main.SimuComControl";
    }
	
}
