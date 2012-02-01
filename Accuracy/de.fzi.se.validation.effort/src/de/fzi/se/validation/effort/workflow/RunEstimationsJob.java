/**
 *
 */
package de.fzi.se.validation.effort.workflow;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.fzi.se.validation.effort.IEstimator;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.PreparePCMBlackboardPartionJob;

/**Runs the effort estimation for each criterion registered for the {@code estimation.xsd} extension.
 *
 * @author groenda
 *
 */
public class RunEstimationsJob extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard>
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(RunEstimationsJob.class);

	/** Name of this job. */
	public static final String NAME = "Run validation effort estimations job";

	/** List of available estimators. */
	private final ArrayList<IEstimator> estimators;

	public RunEstimationsJob(EstimatorConfiguration configuration, ILaunchConfiguration launchConfiguration) {
		super();
		estimators = new ArrayList<IEstimator>();

		// Prepare Blackboard and Partition(s)
		this.add(new PreparePCMBlackboardPartionJob());
		this.add(new LoadPCMModelForValidationJob(configuration));

		// lookup extensions for effort estimation
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EstimatorConstantsContainer.EXTENSION_POINT_ID);
		if (point == null) {
			return;
		}
		IExtension[] extensions = point.getExtensions();
		for (IExtension extension : extensions) {
			IConfigurationElement[] configElements = extension.getConfigurationElements();
			IEstimator estimator;
			assert(configElements.length == 1);
			try {
				estimator = (IEstimator) configElements[0].createExecutableExtension(EstimatorConstantsContainer.EXTENSION_POINT_ATTRIBUTE_ESTIMATOR);
				estimator.setConfiguration(configuration);
				estimator.buildAndSetCustomConfiguration(launchConfiguration);
				estimators.add(estimator);
			} catch (CoreException e) {
				logger.error("Could not create estimator for registered validation effort estimator.", e);
			}
		}
		// add job for each extension
		for (IEstimator estimator : estimators) {
			this.add(estimator);
		}
		// show results
		this.add(new ShowEstimationJob(configuration, estimators));
	}

	@Override
	public String getName() {
		return RunEstimationsJob.NAME;
	}
}
