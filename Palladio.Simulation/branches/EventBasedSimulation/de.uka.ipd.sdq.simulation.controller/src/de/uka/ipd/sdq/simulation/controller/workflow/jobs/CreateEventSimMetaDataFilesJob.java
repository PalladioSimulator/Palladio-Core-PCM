package de.uka.ipd.sdq.simulation.controller.workflow.jobs;

import java.io.PrintStream;

import org.eclipse.core.resources.IProject;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractCreateSimulationMetaDataFilesJob;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

/**
 * 
 * 
 * @author Philipp Merkle
 *
 */
public class CreateEventSimMetaDataFilesJob extends AbstractCreateSimulationMetaDataFilesJob {

    public CreateEventSimMetaDataFilesJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void writePluginXml(PrintStream out, IProject project) {
        out.println("<?xml version='1.0'?>"); 
        out.println("<plugin>");
//        out.println("   <extension"); //$NON-NLS-1$
//        out.println("         point=\"de.uka.ipd.sdq.simucomframework.controller\">"); //$NON-NLS-1$
//        out.println("      <actionDelegate");
//        out.println("            class=\"main.SimuComControl\"");
//        out.println("            id=\"de.uka.ipd.sdq.codegen.simucominstance.actionDelegate\">");
//        out.println("      </actionDelegate>");
//        out.println("   </extension>");
        out.println("</plugin>");
    }
    
    @Override
    public void writeBuildProperties(PrintStream out, IProject project) {
        out.println("output.. = bin/");
        out.println("source.. = src/");
        out.println("bin.includes = plugin.xml,\\");
        out.println("               META-INF/,\\");
        out.println("               .");
    }
    
    @Override
    public void writeManifestMf(PrintStream out, IProject project) {
        out.println("Manifest-Version: 1.0");
        out.println("Bundle-ManifestVersion: 2");
        out.println("Bundle-Name: EventSim Instance Plug-in");
        out.println("Bundle-SymbolicName: " + project.getName() + ";singleton:=true");
        out.println("Bundle-Version: 1.0.0");
        out.println("Bundle-Activator: main.Main");
        out.println("Require-Bundle: de.uka.ipd.sdq.simucomframework,");
        out.println(" de.uka.ipd.sdq.simucomframework.simucomstatus,");
        out.println(" de.uka.ipd.sdq.sensorframework,");
        out.println(" de.uka.ipd.sdq.simucomframework.variables,");
        out.println(" org.apache.log4j,");
        out.println(" org.eclipse.osgi,");
        out.println(" de.uka.ipd.sdq.scheduler,");
        out.println(" org.jscience,");
        out.println(" de.uka.ipd.sdq.probespec.framework,");
        out.println(" de.uka.ipd.sdq.pipesandfilters,");
        out.println(" de.uka.ipd.sdq.pipesandfilters.framework,");
        out.println(" de.uka.ipd.sdq.simulation,");
        out.println(" de.desmoj");
        out.println("Eclipse-LazyStart: true");
        out.println("Bundle-ClassPath: bin/,");
        out.println(" .");
        // out.println("Export-Package: main");
    }

}
