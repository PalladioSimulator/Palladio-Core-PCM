/**
 * 
 */
package de.uka.ipd.sdq.featureinstance;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.edit.ui.action.ValidateAction.EclipseResourcesUtil;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;

import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;
import de.uka.ipd.sdq.featureconfig.Configuration;

class InstanceValidateAction extends ValidateAction {
	
	Configuration config;
	Shell shell;
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	/* starts the validation-process and processes the results*/
	public void run() {
		Diagnostician diagnostician = new Diagnostician();
		Diagnostic d = diagnostician.validate(config);
		ErrorDisplayDialog errord;

		switch (d.getSeverity()) {
		case Diagnostic.CANCEL: 
			String errorMsg = "The validation was cancelled:\n\n";
			for (Diagnostic currentD : d.getChildren()) {
				errorMsg = errorMsg + currentD.getMessage() + "\n";
			}
			errord = new ErrorDisplayDialog(shell,new Throwable(errorMsg));
			errord.open(); break;
		case Diagnostic.ERROR: 
			errorMsg = "The validation finished with errors:\n\n";
			for (Diagnostic currentD : d.getChildren()) {
				errorMsg = errorMsg + currentD.getMessage() + "\n";
			}
			errord = new ErrorDisplayDialog(shell,new Throwable(errorMsg));
			errord.open(); break;
		case Diagnostic.WARNING:
			errorMsg = "The validation finished with warnings:\n\n";
			for (Diagnostic currentD : d.getChildren()) {
				errorMsg = errorMsg + currentD.getMessage() + "\n";
			}
			errord = new ErrorDisplayDialog(shell,new Throwable(errorMsg));
			errord.open(); break;
		case Diagnostic.OK: 
			MessageDialog.openInformation(shell, "Validation success", "The validation completed successfully");
			break;
		case Diagnostic.INFO: 
			MessageDialog.openInformation(shell, "Validation", "The validation completed with informational messages");
			break;
		default:
			errorMsg = "The validation finished with an unknown status:\n\n";
		
		for (Diagnostic currentD : d.getChildren()) {
			errorMsg = errorMsg + currentD.getMessage() + "\n";
		}

//		EclipseResourcesUtil eclipseResourcesUtil = 
//			EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE ?
//					new EclipseResourcesUtil() :
//						null;
//
//					if (eclipseResourcesUtil != null)
//					{
//						Resource resource = domain.getResourceSet().getResources().get(0);
//						if (resource != null)
//						{
//							eclipseResourcesUtil.deleteMarkers(resource);
//							for (Diagnostic childDiagnostic : d.getChildren())
//							{
//								eclipseResourcesUtil.createMarkers(resource, childDiagnostic);
//							}
//						}
//					}

		errord = new ErrorDisplayDialog(shell,new Throwable(errorMsg));
		errord.open(); break;
		}
	}
	
	/**
	 * Setter for the Configuration object needed in the validation
	 * 
	 * @param config the Configuration object
	 */
	public void setConfiguration (Configuration config) {
		this.config = config;	
	}
	
	/**
	 * Setter for the Shell object needed for the validation-result dialogs
	 * 
	 * @param shell the Shell object
	 */
	public void setShell (Shell shell) {
		this.shell = shell;
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
	
	protected InstanceValidateAction myValidate;

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
		validateAction = null;
		myValidate = new InstanceValidateAction();
	}
	
	
	public void fillContextMenu(IMenuManager manager)
	{
		manager.appendToGroup("Validate", myValidate);
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
	
	/**
	 * Setter for the Configuration object needed in the validation
	 * 
	 * @param config the Configuration object
	 */
	public void setConfiguration(Configuration config) {
		if (myValidate instanceof InstanceValidateAction) {
			((InstanceValidateAction)myValidate).setConfiguration(config);
		}
	}
	
	/**
	 * Setter for the Shell object needed for the validation-result dialogs
	 * 
	 * @param shell the Shell object
	 */
	public void setShell (Shell shell) {
		if (myValidate instanceof InstanceValidateAction) {
			((InstanceValidateAction)myValidate).setShell(shell);
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
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			myValidate.updateSelection((IStructuredSelection)selection);
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
