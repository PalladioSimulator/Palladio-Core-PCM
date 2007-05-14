package de.uka.ipd.sdq.sensorframework.visualisation.menu;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.actions.CompoundContributionItem;


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
			items.add(new ActionContributionItem(
					new OpenAction(configurationElement.getAttribute("displayName"),
							configurationElement.getAttribute("editorID"))));
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
