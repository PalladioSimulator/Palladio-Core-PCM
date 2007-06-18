/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandActionDelegate;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.GenericCategoryItemProvider;

/**
 * @author Snowball
 * This class is OBSOLETE and only left for demonstration purposes.
 */
public class ChildAddMenuProvider extends CommonActionProvider {

	private Collection createChildActions;
	private Collection createSiblingActions;
	private IWorkbenchWindow workbenchWindow;

	/**
	 * 
	 */
	public ChildAddMenuProvider() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
	 */
	@Override
	public void init(ICommonActionExtensionSite aSite) {
		// TODO Auto-generated method stub
		super.init(aSite);
		ICommonViewerSite viewSite = aSite.getViewSite();
		if (viewSite instanceof ICommonViewerWorkbenchSite)
		{
			ICommonViewerWorkbenchSite workbench = (ICommonViewerWorkbenchSite)viewSite;
			workbenchWindow = workbench.getWorkbenchWindow();
//			seffAction = new OpenSEFFDiagramAction(
//					workbenchWindow.getActivePage(), workbench.getSelectionProvider());
//			seffAction.init(workbenchWindow);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);

		// Query the new selection for appropriate new child/sibling descriptors
		//
		final TransactionalEditingDomain domain = null; 
//			TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

		Collection newChildDescriptors = null;
		Collection newSiblingDescriptors = null;

		ISelection selection = this.getContext().getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1) {
			Object object = ((IStructuredSelection)selection).getFirstElement();

			newChildDescriptors = domain.getNewChildDescriptors(object, null);
			newSiblingDescriptors = domain.getNewChildDescriptors(null, object);

			if (object instanceof ResourceDemandingSEFF)
			{
				// menu.add(seffAction);
			}
		}

		// Generate actions for selection; populate and redraw the menus.
		//
		// createChildActions = generateCreateChildActions(newChildDescriptors, selection);
		createChildActions = new ArrayList();
		if (newChildDescriptors != null) {
			for (Iterator i = newChildDescriptors.iterator(); i.hasNext(); ) {
				createChildActions.add(new CreateChildAction(workbenchWindow.getActivePage().getActivePart(), selection, i.next())
				{

					/* (non-Javadoc)
					 * @see org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction#configureAction(org.eclipse.jface.viewers.ISelection)
					 */
					@Override
					public void configureAction(ISelection selection) {
						  editingDomain = domain; 
					      // convert the selection to a collection of the selected objects
					      IStructuredSelection sselection = (IStructuredSelection) selection;
					      Collection collection = new ArrayList(sselection.size());
					      for (Iterator i = sselection.iterator(); i.hasNext(); )
					      {
					    	  Object selectedObject = i.next();
					    	  if (selectedObject instanceof GenericCategoryItemProvider)
					    		  selectedObject = ((GenericCategoryItemProvider)selectedObject).getParent(selectedObject);
					    	  collection.add(selectedObject);
					      }

					      // if we found an editing domain, create command
					      if (editingDomain != null)
					      {
					        command = createActionCommand(editingDomain, collection);
					        setEnabled(command.canExecute());
					      }

					      // give up if we couldn't create the command; otherwise, use a
					      // CommandActionDelegate to set the action's text, tooltip, icon,
					      // etc. or just use the default icon
					      if (command == null || command == UnexecutableCommand.INSTANCE)
					      {
					        disable();
					      }
					      else if (!(command instanceof CommandActionDelegate))
					      {
					        if (getDefaultImageDescriptor() != null)
					        {
					          setImageDescriptor(getDefaultImageDescriptor());
					        }
					      }
					      else
					      {
					        CommandActionDelegate commandActionDelegate =
					          (CommandActionDelegate) command;

					        ImageDescriptor imageDescriptor =
					          objectToImageDescriptor(commandActionDelegate.getImage());
					        if (imageDescriptor != null)
					        {
					          setImageDescriptor(imageDescriptor);
					        }
					        else if (getDefaultImageDescriptor() != null)
					        {
					          setImageDescriptor(getDefaultImageDescriptor());
					        }

					        if (commandActionDelegate.getText() != null)
					        {
					          setText(commandActionDelegate.getText());
					        }
					        
					        if (commandActionDelegate.getDescription() != null)
					        {
					          setDescription(commandActionDelegate.getDescription());
					        }

					        if (commandActionDelegate.getToolTipText() != null)
					        {
					          setToolTipText(commandActionDelegate.getToolTipText());
					        }
					      }
					}
				});
			}
		}
		
		// Generate actions for selection; populate and redraw the menus.
		//
		// createChildActions = generateCreateChildActions(newChildDescriptors, selection);
		if (newSiblingDescriptors != null && ((IStructuredSelection)selection).getFirstElement() instanceof EObject)
		{
			createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);
		}
		else
			createSiblingActions = Collections.EMPTY_SET;
		
		MenuManager childSubmenu = new MenuManager("Child");
		if (childSubmenu != null) {
			populateManager(childSubmenu, createChildActions, null);
			childSubmenu.update(true);
		}
		MenuManager siblingSubmenu = new MenuManager("Sibling");
		if (siblingSubmenu != null) {
			populateManager(siblingSubmenu, createSiblingActions, null);
			siblingSubmenu.update(true);
		}
		
//		OpenRepositoryAction ora = new OpenRepositoryAction();
//		ora.init(workbenchWindow);
//
//		menu.add(ora);
//		menu.insertBefore(ICommonMenuConstants.GROUP_EDIT, 
//				childSubmenu);
//		menu.insertBefore(ICommonMenuConstants.GROUP_EDIT, 
//				siblingSubmenu);
	}

	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>,
	 * and returns the collection of these actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection generateCreateChildActions(Collection descriptors, ISelection selection) {
		Collection actions = new ArrayList();
		if (descriptors != null) {
			for (Iterator i = descriptors.iterator(); i.hasNext(); ) {
				actions.add(new CreateChildAction(workbenchWindow.getActivePage().getActivePart(), selection, i.next()));
			}
		}
		return actions;
	}

	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each object in <code>descriptors</code>,
	 * and returns the collection of these actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection generateCreateSiblingActions(Collection descriptors, ISelection selection) {
		Collection actions = new ArrayList();
		if (descriptors != null) {
			for (Iterator i = descriptors.iterator(); i.hasNext(); ) {
				actions.add(new CreateSiblingAction(workbenchWindow.getActivePage().getActivePart(), selection, i.next()));
			}
		}
		return actions;
	}

	/**
	 * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s
	 * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection,
	 * by inserting them before the specified contribution item <code>contributionID</code>.
	 * If <code>ID</code> is <code>null</code>, they are simply added.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void populateManager(IContributionManager manager, Collection actions, String contributionID) {
		if (actions != null) {
			for (Iterator i = actions.iterator(); i.hasNext(); ) {
				IAction action = (IAction)i.next();
				if (contributionID != null) {
					manager.insertBefore(contributionID, action);
				}
				else {
					manager.add(action);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
//		// TODO Auto-generated method stub
//		super.fillActionBars(actionBars);
//		if (this.seffAction.isEnabled())
//			actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, seffAction);
	}

}
