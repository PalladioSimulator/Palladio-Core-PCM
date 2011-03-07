package de.uka.ipd.sdq.dsexplore.analysis;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.opt4j.core.Objective;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

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
	 * @param monitor
	 * @return
	 * @throws CoreException
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 * @throws AnalysisFailedException
	 */
	public abstract void analyse(IProgressMonitor monitor) throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException;

	 /**
	  * Saves the passed Run Configuration information so that we do not have to pass them as parameters all the time.
	  * For real analyses, you need to call setBlackboard before this so that the objectives can be determined from the usage model.
	  * For the {@link AnalysisProxy} it is ok to call this first, you then need to call setBlackboard before calling 
	  * {@link #analyse(IProgressMonitor)}, {@link #retrieveLastResultsForObjective(Objective)}, {@link #getObjectives()}, 
	  * or {@link #hasObjectivePerUsageScenario()}.  
	  * @param configuration
	 * @throws CoreException 
	  */
	public abstract void initialise(ILaunchConfiguration configuration) throws CoreException;

	/**
	 * This method can only be called after calling a
	 * {@link #analyse()}
	 * @param objective
	 * @return
	 * @throws CoreException
	 * @throws AnalysisFailedException
	 */
	public abstract IAnalysisResult retrieveLastResultsForObjective(Objective objective) throws CoreException, AnalysisFailedException;

	/**
	 * Returns a {@link String} that represents the quality attribute that this analysis determines.  
	 * This method can be called without initialization. 
	 * @return
	 * @throws CoreException
	 */
	public abstract String getQualityAttribute() throws CoreException;
	
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
	public abstract List<Objective> getObjectives() throws CoreException;
	
	/**
	 * Returns whether this analysis provides one objective per usage scenario. This method can be called before calling {@link #initialise(MDSDBlackboard, ILaunchConfiguration, ILaunch, IProgressMonitor)}.
	 * @throws CoreException 
	 */
	public abstract boolean hasObjectivePerUsageScenario() throws CoreException;

	public abstract void setBlackboard(MDSDBlackboard blackboard); 

}
