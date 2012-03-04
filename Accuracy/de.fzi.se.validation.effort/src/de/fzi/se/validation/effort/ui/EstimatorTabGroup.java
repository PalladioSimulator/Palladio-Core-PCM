/**
 *
 */
package de.fzi.se.validation.effort.ui;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.fzi.se.validation.effort.workflow.EstimatorConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;

/**Tab group of the launch configuration for validation effort estimation.
 *
 * @author groenda
 *
 */
public class EstimatorTabGroup extends AbstractLaunchConfigurationTabGroup {
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(EstimatorTabGroup.class);

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog, java.lang.String)
	 */
	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab commonTab = new DebugEnabledCommonTab();
		ArrayList<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();
		tabs.add(new EstimatorConfigurationTab());
		// add tabs of extensions for effort estimation
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EstimatorConstantsContainer.EXTENSION_POINT_ID);
		if (point == null) {
			return;
		}
		IExtension[] extensions = point.getExtensions();
		for (IExtension extension : extensions) {
			IConfigurationElement[] configElements = extension.getConfigurationElements();
			assert(configElements.length == 1);
			try {
				String configurationTabAttribute = configElements[0].getAttribute(EstimatorConstantsContainer.EXTENSION_POINT_ATTRIBUTE_CONFIGURATION_TAB);
				if(!configurationTabAttribute.isEmpty()) { // the attribute is optional; empty means no new tab
					tabs.add((ILaunchConfigurationTab) configElements[0].createExecutableExtension(EstimatorConstantsContainer.EXTENSION_POINT_ATTRIBUTE_CONFIGURATION_TAB));
				}
			} catch (CoreException e) {
				logger.error("Could not create estimator for registered validation effort estimator.", e);
			}
		}
		tabs.add(commonTab);
		setTabs(tabs.toArray(new ILaunchConfigurationTab[] {}));
	}

}
