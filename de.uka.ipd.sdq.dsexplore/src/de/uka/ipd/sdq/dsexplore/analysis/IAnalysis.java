package de.uka.ipd.sdq.dsexplore.analysis;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.opt4j.core.Criterion;
import org.opt4j.core.Objective;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.workflow.Blackboard;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Interface for analysis approaches that can be used within PerOpteryx. Can be used to start the analysis ({@link #analyse()}) and retrieve the last result.
 * Check the methods for detailed call instructions (the protocols are complicated). 
 * 
 * TODO: Refactor this (after having refactored DSEWorkflowConfiguration, see there) 
 * and use DSE configuration classes instead of Eclipse ones. 
 * 
 * Configuration and execution are now already separated a bit. 
 * However, the analyses need the blackboard before they can determine their objectives. 
 * Thus, now the AnalysisProxy and the other analyses have different protocols, which is bad. Refactor more. 
 *  
 *  Probably I need to reconsider the whole AnalysisProxy idea... 
 *  
 * @author martens
 *
 */

public interface IAnalysis {

	/**
	 * Analyses the current PCM instance from the blackboard. This method can only be called 
	 * after calling {@link #initialise(MDSDBlackboard, ILaunchConfiguration, ILaunch)}.
	 * 
	 * The PCM instance for this {@link PCMPhenotype} has to be copied to the Blackboard 
	 * into partition {@link LoadPCMModelsIntoBlackboardJob}.PCM_MODELS_PARTITION_ID before callings
	 * this. Otherwise, a wrong PCM model is analysed. 
	 * 
	 * The Analysis has to store the results for this {@link PCMPhenotype}, so that {@link #retrieveResultsFor(PCMPhenotype, Criterion)}
	 * can be called on it multiple times. The results should be stored in a memory-efficient way.
	 * 
	 * @param pheno TODO
	 * @param monitor
	 * @return
	 * @throws CoreException
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 * @throws AnalysisFailedException
	 */
	public abstract void analyse(PCMPhenotype pheno, IProgressMonitor monitor) throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException;

	 /**
	  * Saves the passed Run Configuration information so that we do not have to pass them as parameters all the time.
	  * For real analyses, you need to call setBlackboard before this so that the objectives can be determined from the usage model.
	  * For the {@link AnalysisProxy} it is ok to call this first, you then need to call setBlackboard before calling 
	  * {@link #analyse(PCMPhenotype, IProgressMonitor)}, {@link #retrieveLastResultsForObjective(Objective)}, {@link #getObjectives()}, 
	  * or {@link #hasObjectivePerUsageScenario()}.  
	  * @param configuration
	 * @throws CoreException 
	  */
	public abstract void initialise(DSEWorkflowConfiguration configuration) throws CoreException;

	/**
	 * This method can only be called after calling a
	 * {@link #analyse()} for this phenotype and the current PCM models
	 * of this candidate have to be in the {@link Blackboard} partition 
	 * {@link LoadPCMModelsIntoBlackboardJob}.PCM_MODELS_PARTITION_ID
	 * FIXME: Make this method independent of the blackboard state. Currently, the 
	 * SimuComAnalysis and the LQN analyses still require the current 
	 * PCM model to be on the blackboard.  
	 * 
	 * @param pheno TODO
	 * @param criterion
	 * @return
	 * @throws CoreException
	 * @throws AnalysisFailedException
	 */
	public abstract IAnalysisResult retrieveResultsFor(PCMPhenotype pheno, Criterion criterion) throws CoreException, AnalysisFailedException;

	/**
	 * Returns a {@link String} that represents the quality attribute that this analysis determines.  
	 * This method can be called without initialization. 
	 * @return
	 * @throws CoreException
	 */
	public abstract QualityAttribute getQualityAttribute() throws CoreException;
	
	/**
	 * Returns whether this analysis also provides statistics for the objectives. 
	 * This method can be called without initialization. 
	 * @return
	 * @throws CoreException
	 */
	public abstract boolean hasStatisticResults() throws CoreException;

	/**
	 * Can only be called after initialisation ({@link #initialise(MDSDBlackboard, ILaunchConfiguration, ILaunch, IProgressMonitor)}).
	 * @return
	 * @throws CoreException
	 */
	public abstract List<Criterion> getCriterions() throws CoreException;
	
	/**
	 * Returns whether this analysis provides one objective per usage scenario. This method can be called before calling {@link #initialise(MDSDBlackboard, ILaunchConfiguration, ILaunch, IProgressMonitor)}.
	 * @throws CoreException 
	 */
	public abstract boolean hasObjectivePerUsageScenario() throws CoreException;

	public abstract void setBlackboard(MDSDBlackboard blackboard); 

}
