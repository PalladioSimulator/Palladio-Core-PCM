package de.uka.ipd.sdq.sensorframework.visualisation.menu;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.actions.CompoundContributionItem;

import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;


/**
 * A compound contribution is a contribution item consisting of a dynamic list
 * of contribution items.
 */
public class VisualisationMenuItemContributions extends CompoundContributionItem {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	@Override
	public IContributionItem[] getContributionItems() {
		ArrayList<IContributionItem> items = new ArrayList<IContributionItem>();
		for(IConfigurationElement configurationElement : Platform.getExtensionRegistry().
				getConfigurationElementsFor("de.uka.ipd.sdq.sensorframework.visualisation")){
			String executableObject = configurationElement.getAttribute("acceptsData");
			try {
				Class<?> viewerAcceptsClass = Class.forName(executableObject);
				for (IAdapterFactory f : AdapterRegistry.singleton().getAllAvailableFactories(viewerAcceptsClass)) {
					String displayName = configurationElement.getAttribute("displayName");
					displayName = displayName.replace("{0}", f.getMetricLabel());
					items.add(new ActionContributionItem(
							new OpenAction(displayName,
								f.getAdapterFactoryID(),	
								configurationElement.getAttribute("editorID"))));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return items.toArray(new IContributionItem[]{});
	}

	public VisualisationMenuItemContributions() {
		// TODO Auto-generated constructor stub
	}
	
	public VisualisationMenuItemContributions(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
}
