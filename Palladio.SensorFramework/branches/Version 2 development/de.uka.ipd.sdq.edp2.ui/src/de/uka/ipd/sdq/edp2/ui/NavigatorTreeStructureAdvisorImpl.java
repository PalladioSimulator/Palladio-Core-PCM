/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import de.uka.ipd.sdq.edp2.models.Presentation.UI.util.UISwitch;

/**
 * @author groenda
 *
 */
public class NavigatorTreeStructureAdvisorImpl extends TreeStructureAdvisor {
	@Override
	public Object getParent(Object element) {
		return null;
	}
	
	@Override
	public Boolean hasChildren(Object element) {
		return super.hasChildren(element);
	}
}
