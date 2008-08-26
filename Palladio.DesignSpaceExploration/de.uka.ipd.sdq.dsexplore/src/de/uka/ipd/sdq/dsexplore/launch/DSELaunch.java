package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sf.jclec.IIndividual;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.algorithms.FullSearchAlgorithm;
import de.uka.ipd.sdq.dsexplore.algorithms.HillClimbingAlgorithm;
import de.uka.ipd.sdq.dsexplore.algorithms.IAlgorithm;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.helper.DSEMessageBox;
import de.uka.ipd.sdq.dsexplore.helper.LoggerHelper;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * Launches multiple simulation runs. 
 * 
 * @author Anne
 *
 */
public class DSELaunch implements ILaunchConfigurationDelegate {
	
	/**
	 * A default to be overridden by the settings in the run dialog.
	 */
	private int maxIterations = Integer.MAX_VALUE;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	/**
	 * Test for starting multiple simulations.
	 * @param configuration
	 * @param mode
	 * @param launch
	 * @param monitor
	 */
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		//TODO use Workflow mechanism already provided by the codegen packages?
		/* Add jobs for simulation one by one --> no, too low level, need to start whole simulations. */
		
			//super.createRunCompositeJob(new SimuAttributesGetMethods(configuration), true, launch);
			//super.launch(configuration, mode, launch, monitor);
			LoggerHelper.initializeLogger(configuration);
			
			Long timestampMillis = System.currentTimeMillis();
		
			logger.debug("Starting...");
			logger.debug("Launch Configuration: "+configuration.getMemento());
			
			String maxIterationsString = configuration.getAttribute(DSEConstantsContainer.MAX_ITERATIONS, "");
			if (!maxIterationsString.equals("")){
				try{
				this.maxIterations = Integer.parseInt(maxIterationsString);
				} catch (Exception e){
					//ok, it was worth a try, so just keep the old value. 
				}
			} else {
				maxIterations = Integer.MAX_VALUE;
			}
			
			
			List<IAnalysisResult> allCandidates = null;
			
			try {
				
			//Get the initial PCM Instance
		    PCMInstance pcmInstance = new PCMInstance(configuration);
		    List<PCMInstance> instances = new ArrayList<PCMInstance>();
		    instances.add(pcmInstance);
		    
		    //initialise the algorithm and analysis
		    IAlgorithm algorithm = new HillClimbingAlgorithm();
		    //IAlgorithm algorithm = new FullSearchAlgorithm();
			IAnalysis analysisTool = new AnalysisProxy(configuration, mode, launch, monitor);
		    algorithm.initialise(instances, analysisTool);
		    
		    //analyse the initial PCMInstance
		    //IAnalysisResult result = analysisTool.retrieveLastResults(pcmInstance);
		    IAnalysisResult result = analysisTool.analyse(pcmInstance);
		    logger.info("The mean value of instance "+pcmInstance.getName()+": "+result.getMeanValue());
		    List<IAnalysisResult> currentPopulation = new ArrayList<IAnalysisResult>();
		    allCandidates = new ArrayList<IAnalysisResult>();
		    currentPopulation.add(result);
		    allCandidates.add(result);
		    
		    int noOfIterations = 0;
		    while(!algorithm.terminated() && noOfIterations <= this.maxIterations){
		    	currentPopulation = algorithm.iterate(currentPopulation);
		    	allCandidates.addAll(currentPopulation);
		    	noOfIterations++;
		    }
		    

		    
		    logger.info("Best candidate: "+currentPopulation.get(0).getPCMInstance().getName());
		    

				
			} catch (AnalysisFailedException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
				throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, e.getMessage(), e));
			} finally {
				//try to save the results as far as it got. 
				if (allCandidates != null){
				    long duration = System.currentTimeMillis() - timestampMillis;
				    Collections.sort(allCandidates);
			        try {
						DSEMessageBox
							.showMessage(
									"DSE results",
									"Here are the results, sorted by response time: \n\n"
											+ resultsToString(allCandidates)
											+ "\n You find the corresponding run configuration in your "
											+ "run dialog, they show you all details on the candidates.\n\n "
											+ "The search took "
											+ duration / 1000.0 + " seconds. "
											+ allCandidates.size() + " candidates were analysed.",
									MessageDialog.INFORMATION);
					} catch (AnalysisFailedException e) {
						e.printStackTrace();
					}
				}

			}
			
			//IIndividual individual = null;

			logger.debug("DSE launch done");

	}

	private static String resultsToString(List<IAnalysisResult> population) throws AnalysisFailedException {
		String string = "";
		int count = 1;
		for (Iterator<IAnalysisResult> iterator = population.iterator(); iterator
				.hasNext();) {
			IAnalysisResult analysisResult = iterator.next();
			string += count + ".: ";
			string += "\t" + analysisResult.getPCMInstance().getName();
			string += "\t"+ analysisResult.getMeanValue()+" time units.\n"; 
			count ++;
		}
		return string;
	}
	
}
