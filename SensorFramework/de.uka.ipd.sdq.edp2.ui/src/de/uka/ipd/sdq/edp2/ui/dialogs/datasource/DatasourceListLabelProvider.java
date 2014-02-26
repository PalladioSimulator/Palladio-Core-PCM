/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui.dialogs.datasource;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.ui.dialogs.DialogsImages;

public class DatasourceListLabelProvider extends LabelProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof Repository) {
		    Repository repository = (Repository) element;
			return repository.toString() + " [" + repository.getUuid()+ "]";
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof Repository)
			return DialogsImages.imageRegistry.get(DialogsImages.TREEROOT);
		return super.getImage(element);
	}
	
	public static String dataSetRepresentation(Repository repository){
		return repository.toString() + " [" + repository.getUuid()+ "]";
	}
}
