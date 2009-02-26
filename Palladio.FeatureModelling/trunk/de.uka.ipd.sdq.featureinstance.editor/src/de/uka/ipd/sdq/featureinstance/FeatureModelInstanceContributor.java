/**
 * 
 */
package de.uka.ipd.sdq.featureinstance;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorPart;

import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;

class InstanceValidateAction extends ValidateAction {
	
	FeatureDiagram diagram;
	Configuration config;
	
	@Override
	public void run() {
			Diagnostician diagnostician = new Diagnostician();
			Diagnostic d = diagnostician.validate(config);
			switch (d.getSeverity()) {
			case Diagnostic.CANCEL: System.out.println("Validation cancelled"); break;
			case Diagnostic.ERROR: System.out.println("Validation error"); break;
			case Diagnostic.WARNING: System.out.println("Validation warning"); break;
			case Diagnostic.OK: System.out.println("Validation OK"); break;
			case Diagnostic.INFO: System.out.println("Validation INFO"); break;
			default: System.out.println("Validation sth else");
			}
			for (Diagnostic child : d.getChildren()) {
				System.out.println(child.getMessage());
			}
			System.out.println(d.getMessage());
			d = diagnostician.validate(diagram);
			switch (d.getSeverity()) {
			case Diagnostic.CANCEL: System.out.println("Validation cancelled"); break;
			case Diagnostic.ERROR: System.out.println("Validation error"); break;
			case Diagnostic.WARNING: System.out.println("Validation warning"); break;
			case Diagnostic.OK: System.out.println("Validation OK"); break;
			case Diagnostic.INFO: System.out.println("Validation INFO"); break;
			default: System.out.println("Validation sth else");
			}
			for (Diagnostic child : d.getChildren()) {
				System.out.println(child.getMessage());
			}
			System.out.println(d.getMessage());
	}
	
	public void setConfiguration (Configuration config, FeatureDiagram diagram) {
		this.config = config;
		this.diagram = diagram;		
	}

}
/**
 * @author Grischa Liebel
 *
 */
public class FeatureModelInstanceContributor extends
		EditingDomainActionBarContributor implements ISelectionChangedListener {

	/**
	 * This keeps track of the active editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IEditorPart activeEditorPart;

	/**
	 * This keeps track of the current selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionProvider selectionProvider;

	/**
	 * This creates an instance of the contributor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureModelInstanceContributor() {
		super(ADDITIONS_LAST_STYLE);
		validateAction = new InstanceValidateAction();
	}
	
	
	
	/**
	 * This adds to the menu bar a menu and some separators for editor additions,
	 * as well as the sub-menus for object creation items.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);

		IMenuManager submenuManager = new MenuManager("FeatureModelInstance", "de.uka.ipd.sdq.FeatureInstanceMenuID");
		menuManager.insertAfter("additions", submenuManager);
		submenuManager.add(new Separator("additions"));
		submenuManager.add(new Separator("additions-end"));

		addGlobalActions(submenuManager);
	}
	
	public void setConfiguration(Configuration config, FeatureDiagram diagram) {
		if (validateAction instanceof InstanceValidateAction) {
			((InstanceValidateAction)validateAction).setConfiguration(config, diagram);
		}
	}

	/**
	 * When the active editor changes, this remembers the change and registers with it as a selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		activeEditorPart = part;

		// Switch to the new selection provider.
		//
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			selectionProvider = null;
		}
		else {
			selectionProvider = part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (selectionProvider.getSelection() != null) {
				selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
			}
		}
	}

	public void selectionChanged(SelectionChangedEvent event) {
		System.out.println(event.getSource().getClass());
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			validateAction.updateSelection((IStructuredSelection)selection);
		}
	}

	/**
	 * This inserts global actions before the "additions-end" separator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void addGlobalActions(IMenuManager menuManager) {
		menuManager.insertAfter("additions-end", new Separator("ui-actions"));

		super.addGlobalActions(menuManager);
	}

	/**
	 * This ensures that a delete action will clean up all references to deleted objects.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean removeAllReferencesOnDelete() {
		return true;
	}

}
