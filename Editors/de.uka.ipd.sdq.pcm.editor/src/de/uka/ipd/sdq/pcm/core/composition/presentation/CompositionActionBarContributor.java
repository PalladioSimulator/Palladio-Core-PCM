/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.presentation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.pcm.core.presentation.PalladioComponentModelEditorPlugin;

/**
 * @generated
 */
public class CompositionActionBarContributor extends EditingDomainActionBarContributor implements
        ISelectionChangedListener {
    /**
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * @generated
     */
    protected IEditorPart activeEditorPart;

    /**
     * @generated
     */
    protected ISelectionProvider selectionProvider;

    /**
     * @generated
     */
    protected IAction showPropertiesViewAction = new Action(
            PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) {
        @Override
        public void run() {
            try {
                getPage().showView("org.eclipse.ui.views.PropertySheet");
            } catch (PartInitException exception) {
                PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
            }
        }
    };

    /**
     * @generated
     */
    protected IAction refreshViewerAction = new Action(
            PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) {
        @Override
        public boolean isEnabled() {
            return activeEditorPart instanceof IViewerProvider;
        }

        @Override
        public void run() {
            if (activeEditorPart instanceof IViewerProvider) {
                Viewer viewer = ((IViewerProvider) activeEditorPart).getViewer();
                if (viewer != null) {
                    viewer.refresh();
                }
            }
        }
    };

    /**
     * @generated
     */
    protected Collection<IAction> createChildActions;

    /**
     * @generated
     */
    protected IMenuManager createChildMenuManager;

    /**
     * @generated
     */
    protected Collection<IAction> createSiblingActions;

    /**
     * @generated
     */
    protected IMenuManager createSiblingMenuManager;

    /**
     * @generated
     */
    public CompositionActionBarContributor() {
        super(ADDITIONS_LAST_STYLE);
        loadResourceAction = new LoadResourceAction();
        validateAction = new ValidateAction();
        controlAction = new ControlAction();
    }

    /**
     * @generated
     */
    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(new Separator("composition-settings"));
        toolBarManager.add(new Separator("composition-additions"));
    }

    /**
     * @generated
     */
    @Override
    public void contributeToMenu(IMenuManager menuManager) {
        super.contributeToMenu(menuManager);

        IMenuManager submenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CompositionEditor_menu"),
                "de.uka.ipd.sdq.pcm.core.compositionMenuID");
        menuManager.insertAfter("additions", submenuManager);
        submenuManager.add(new Separator("settings"));
        submenuManager.add(new Separator("actions"));
        submenuManager.add(new Separator("additions"));
        submenuManager.add(new Separator("additions-end"));

        // Prepare for CreateChild item addition or removal.
        //
        createChildMenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
        submenuManager.insertBefore("additions", createChildMenuManager);

        // Prepare for CreateSibling item addition or removal.
        //
        createSiblingMenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
        submenuManager.insertBefore("additions", createSiblingMenuManager);

        // Force an update because Eclipse hides empty menus now.
        //
        submenuManager.addMenuListener(new IMenuListener() {
            public void menuAboutToShow(IMenuManager menuManager) {
                menuManager.updateAll(true);
            }
        });

        addGlobalActions(submenuManager);
    }

    /**
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
        } else {
            selectionProvider = part.getSite().getSelectionProvider();
            selectionProvider.addSelectionChangedListener(this);

            // Fake a selection changed event to update the menus.
            //
            if (selectionProvider.getSelection() != null) {
                selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
            }
        }
    }

    /**
     * @generated
     */
    public void selectionChanged(SelectionChangedEvent event) {
        // Remove any menu items for old selection.
        //
        if (createChildMenuManager != null) {
            depopulateManager(createChildMenuManager, createChildActions);
        }
        if (createSiblingMenuManager != null) {
            depopulateManager(createSiblingMenuManager, createSiblingActions);
        }

        // Query the new selection for appropriate new child/sibling descriptors
        //
        Collection<?> newChildDescriptors = null;
        Collection<?> newSiblingDescriptors = null;

        ISelection selection = event.getSelection();
        if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
            Object object = ((IStructuredSelection) selection).getFirstElement();

            EditingDomain domain = ((IEditingDomainProvider) activeEditorPart).getEditingDomain();

            newChildDescriptors = domain.getNewChildDescriptors(object, null);
            newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
        }

        // Generate actions for selection; populate and redraw the menus.
        //
        createChildActions = generateCreateChildActions(newChildDescriptors, selection);
        createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);

        if (createChildMenuManager != null) {
            populateManager(createChildMenuManager, createChildActions, null);
            createChildMenuManager.update(true);
        }
        if (createSiblingMenuManager != null) {
            populateManager(createSiblingMenuManager, createSiblingActions, null);
            createSiblingMenuManager.update(true);
        }
    }

    /**
     * @generated
     */
    protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection) {
        Collection<IAction> actions = new ArrayList<IAction>();
        if (descriptors != null) {
            for (Object descriptor : descriptors) {
                actions.add(new CreateChildAction(activeEditorPart, selection, descriptor));
            }
        }
        return actions;
    }

    /**
     * @generated
     */
    protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection) {
        Collection<IAction> actions = new ArrayList<IAction>();
        if (descriptors != null) {
            for (Object descriptor : descriptors) {
                actions.add(new CreateSiblingAction(activeEditorPart, selection, descriptor));
            }
        }
        return actions;
    }

    /**
     * @generated
     */
    protected void populateManager(IContributionManager manager, Collection<? extends IAction> actions,
            String contributionID) {
        if (actions != null) {
            for (IAction action : actions) {
                if (contributionID != null) {
                    manager.insertBefore(contributionID, action);
                } else {
                    manager.add(action);
                }
            }
        }
    }

    /**
     * @generated
     */
    protected void depopulateManager(IContributionManager manager, Collection<? extends IAction> actions) {
        if (actions != null) {
            IContributionItem[] items = manager.getItems();
            for (int i = 0; i < items.length; i++) {
                // Look into SubContributionItems
                //
                IContributionItem contributionItem = items[i];
                while (contributionItem instanceof SubContributionItem) {
                    contributionItem = ((SubContributionItem) contributionItem).getInnerItem();
                }

                // Delete the ActionContributionItems with matching action.
                //
                if (contributionItem instanceof ActionContributionItem) {
                    IAction action = ((ActionContributionItem) contributionItem).getAction();
                    if (actions.contains(action)) {
                        manager.remove(contributionItem);
                    }
                }
            }
        }
    }

    /**
     * @generated
     */
    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        super.menuAboutToShow(menuManager);
        MenuManager submenuManager = null;

        submenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
        populateManager(submenuManager, createChildActions, null);
        menuManager.insertBefore("edit", submenuManager);

        submenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
        populateManager(submenuManager, createSiblingActions, null);
        menuManager.insertBefore("edit", submenuManager);
    }

    /**
     * @generated
     */
    @Override
    protected void addGlobalActions(IMenuManager menuManager) {
        menuManager.insertAfter("additions-end", new Separator("ui-actions"));
        menuManager.insertAfter("ui-actions", showPropertiesViewAction);

        refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());
        menuManager.insertAfter("ui-actions", refreshViewerAction);

        super.addGlobalActions(menuManager);
    }

    /**
     * @generated
     */
    @Override
    protected boolean removeAllReferencesOnDelete() {
        return true;
    }

}