package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.PrintStream;

import org.eclipse.core.resources.IProject;

import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public class CreateSimuComMetaDataFilesJob extends AbstractCreateSimulationMetaDataFilesJob {

    public CreateSimuComMetaDataFilesJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void writePluginXml(PrintStream out, IProject project) {
        out.println("<?xml version='1.0'?>"); //$NON-NLS-1$
        out.println("<plugin>"); //$NON-NLS-1$
        out.println("   <extension"); //$NON-NLS-1$
        out.println("         point=\"de.uka.ipd.sdq.simucomframework.controller\">"); //$NON-NLS-1$
        out.println("      <actionDelegate"); //$NON-NLS-1$
        out.println("            class=\"main.SimuComControl\""); //$NON-NLS-1$
        out.println("            id=\"de.uka.ipd.sdq.codegen.simucominstance.actionDelegate\">"); //$NON-NLS-1$
        out.println("      </actionDelegate>"); //$NON-NLS-1$
        out.println("   </extension>"); //$NON-NLS-1$
        out.println("</plugin>"); //$NON-NLS-1$
    }
    
    @Override
    public void writeBuildProperties(PrintStream out, IProject project) {
        out.println("output.. = bin/"); //$NON-NLS-1$
        out.println("source.. = src/"); //$NON-NLS-1$
        out.println("bin.includes = plugin.xml,\\"); //$NON-NLS-1$
        out.println("               META-INF/,\\"); //$NON-NLS-1$
        out.println("               ."); //$NON-NLS-1$
    }
    
    @Override
    public void writeManifestMf(PrintStream out, IProject project) {
        out.println("Manifest-Version: 1.0"); //$NON-NLS-1$
        out.println("Bundle-ManifestVersion: 2"); //$NON-NLS-1$
        out.println("Bundle-Name: SimuCom Instance Plug-in"); //$NON-NLS-1$
        out.println("Bundle-SymbolicName: " + project.getName() + ";singleton:=true"); //$NON-NLS-1$
        out.println("Bundle-Version: 1.0.0"); //$NON-NLS-1$
        out.println("Bundle-Activator: main.SimuComControl");
        out.println("Require-Bundle: de.uka.ipd.sdq.simulation.abstractsimengine,");
        out.println(" de.uka.ipd.sdq.simucomframework,"); //$NON-NLS-1$
        out.println(" de.uka.ipd.sdq.simucomframework.simucomstatus,"); //$NON-NLS-1$
        out.println(" de.uka.ipd.sdq.sensorframework,"); //$NON-NLS-1$
        out.println(" de.uka.ipd.sdq.simucomframework.variables,"); //$NON-NLS-1$
        out.println(" org.apache.log4j,"); //$NON-NLS-1$
        out.println(" org.eclipse.osgi,"); //$NON-NLS-1$
        out.println(" de.uka.ipd.sdq.scheduler,"); //$NON-NLS-1$
        out.println(" org.jscience,"); //$NON-NLS-1$
        out.println(" de.uka.ipd.sdq.probespec.framework,"); //$NON-NLS-1$
        out.println(" de.uka.ipd.sdq.pipesandfilters,"); //$NON-NLS-1$
        out.println(" de.uka.ipd.sdq.pipesandfilters.framework,"); //$NON-NLS-1$
        out.println(" de.uka.ipd.sdq.probfunction.math"); //$NON-NLS-1$
        out.println("Eclipse-LazyStart: true"); //$NON-NLS-1$
        out.println("Bundle-ClassPath: bin/,");
        out.println(" .");
        // out.println("Export-Package: main");
    }

}
