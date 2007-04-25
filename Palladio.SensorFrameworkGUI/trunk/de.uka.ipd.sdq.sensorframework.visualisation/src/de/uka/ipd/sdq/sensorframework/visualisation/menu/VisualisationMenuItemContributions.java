package de.uka.ipd.sdq.sensorframework.visualisation.menu;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.CompoundContributionItem;
import com.sun.jmx.mbeanserver.OpenConverter;

import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

class OpenAction extends Action {

	private String editorID;

	public OpenAction(String label, String editorID){
		super(label);
		this.editorID = editorID;
	}
	
	@Override
	public void run() {
		IWorkbenchPage page = SimuPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();

		try {
			page.openEditor(new ConfigEditorInput(),
					editorID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class VisualisationMenuItemContributions extends CompoundContributionItem {

	public VisualisationMenuItemContributions() {
		// TODO Auto-generated constructor stub
	}

	public VisualisationMenuItemContributions(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IContributionItem[] getContributionItems() {
		ArrayList<IContributionItem> items = new ArrayList<IContributionItem>();
		for(IConfigurationElement configurationElement : Platform.getExtensionRegistry().
				getConfigurationElementsFor("de.uka.ipd.sdq.sensorframework.visualisation")){
			items.add(new ActionContributionItem(
					new OpenAction(configurationElement.getAttribute("displayName"),
							configurationElement.getAttribute("editorID"))));
		}
		return items.toArray(new IContributionItem[]{});
	}
}
