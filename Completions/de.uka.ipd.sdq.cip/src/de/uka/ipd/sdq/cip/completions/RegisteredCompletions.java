package de.uka.ipd.sdq.cip.completions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.cip.CipPlugin;
import de.uka.ipd.sdq.cip.ConstantsContainer;

/**
 * @author Thomas Schuischel
 *
 */
public class RegisteredCompletions {
	
	/**
	 * Cache enumerated completions for performance
	 */
	private static Collection<RegisteredCompletion> cachedCompletions;
	
	public static RegisteredCompletion findCompletion(String ID) {
		if(cachedCompletions == null)
			getCompletions();
		
		for(RegisteredCompletion completion : cachedCompletions)
		{
			if(completion.getId().equals(ID)) 
				return completion;
		}
		
		return null;
	}
	
	public static Collection<RegisteredCompletion> getCompletions() {
		if(cachedCompletions != null)
			return cachedCompletions;
		
		List<RegisteredCompletion> found = new ArrayList<RegisteredCompletion>();
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		try {
			IConfigurationElement[] elements = reg.getConfigurationElementsFor(CipPlugin.PLUGIN_ID,ConstantsContainer.COMPLETION_EXTENSION_POINT_ID);
			for(int i = 0; i < elements.length; i++) {
				IConfigurationElement element = elements[i];
				if(element.getName().equals(ConstantsContainer.NODE_COMPLETION)){
					RegisteredCompletion rc = RegisteredCompletion.parseCompletion(element,element.getContributor().getName());
					if(rc != null)
						found.add(rc);
						
				}
			}
			cachedCompletions =  found;
		}
		catch (InvalidRegistryObjectException e) {
			//logger.logError(msg,e);
		}
		
		return cachedCompletions;
	}
	
	private static class RegisteredCompletionLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			RegisteredCompletion rc = (RegisteredCompletion) element;
			switch (columnIndex) {
			case 0:
				return rc.getName(); 
			case 1:
				return rc.getId();

			default:
				return "unkown " +  columnIndex;
			}
			
		}
		
	}
	
	public static IBaseLabelProvider getLabelProvider() {
		return new RegisteredCompletions.RegisteredCompletionLabelProvider();
	}
	
	
}
