package de.uka.ipd.sdq.simulation.controller.workflow.jobs;

import java.io.PrintStream;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractCreateMetaDataFilesJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

/**
 * 
 * 
 * @author Philipp Merkle
 *
 */
public class CreateEventSimMetaDataFilesJob extends AbstractCreateMetaDataFilesJob implements IJob {

    public CreateEventSimMetaDataFilesJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
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
        "de.uka.ipd.sdq.simulation"
   };


   @Override
   protected String[] getRequiredBundles() {
       return BUNDLES;
   }

    @Override
    protected String getBundleActivator() {
        return "main.Main";
    }
    
//    @Override
//    public void writeManifestMf(PrintStream out, IProject project) {
//        out.println("Manifest-Version: 1.0");
//        out.println("Bundle-ManifestVersion: 2");
//        out.println("Bundle-Name: EventSim Instance Plug-in");
//        out.println("Bundle-SymbolicName: " + project.getName() + ";singleton:=true");
//        out.println("Bundle-Version: 1.0.0");
//        out.println("Bundle-Activator: main.Main");
//        out.println("Require-Bundle: de.uka.ipd.sdq.simucomframework,");
//        out.println(" de.uka.ipd.sdq.simucomframework.simucomstatus,");
//        out.println(" de.uka.ipd.sdq.sensorframework,");
//        out.println(" de.uka.ipd.sdq.simucomframework.variables,");
//        out.println(" org.apache.log4j,");
//        out.println(" org.eclipse.osgi,");
//        out.println(" de.uka.ipd.sdq.scheduler,");
//        out.println(" org.jscience,");
//        out.println(" de.uka.ipd.sdq.probespec.framework,");
//        out.println(" de.uka.ipd.sdq.pipesandfilters,");
//        out.println(" de.uka.ipd.sdq.pipesandfilters.framework,");
//        out.println(" de.uka.ipd.sdq.simulation,");
//        out.println(" de.desmoj");
//        out.println("Eclipse-LazyStart: true");
//        out.println("Bundle-ClassPath: bin/,");
//        out.println(" .");
//        // out.println("Export-Package: main");
//    }

}
