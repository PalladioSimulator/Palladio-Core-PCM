/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.decorator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;

import de.uka.ipd.sdq.pcmbench.PCMBenchActivator;

/**
 * @author Snowball
 * 
 */
public class DecoratorLightwightLabelProvider extends LabelProvider implements
		ILightweightLabelDecorator {

	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof IProject) {
			IProject p = (IProject) element;
			IProjectDescription description;
			try {
				if (p.isOpen()) {
					description = p.getDescription();
					String[] natures = description.getNatureIds();
					int i;
					for (i = 0; i < natures.length; i++) {
						if (natures[i].equals("de.uka.ipd.sdq.pcmbench.nature"))
							break;
					}
					if (i == natures.length)
						return;
				} else
					return;
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			decoration.addSuffix("  [Palladio Modelling Project]");
			decoration.addOverlay(PCMBenchActivator.imageDescriptorFromPlugin(
					PCMBenchActivator.PLUGIN_ID,
					"icons/palladio-logo-overlay.gif"));
		}
		return;
	}

}
