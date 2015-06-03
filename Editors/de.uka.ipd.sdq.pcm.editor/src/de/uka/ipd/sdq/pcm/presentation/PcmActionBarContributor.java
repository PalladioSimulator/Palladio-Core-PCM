/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.presentation;

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
public class PcmActionBarContributor extends EditingDomainActionBarContributor implements ISelectionChangedListener {

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
                PcmActionBarContributor.this.getPage().showView("org.eclipse.ui.views.PropertySheet");
            } catch (final PartInitException exception) {
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
            return PcmActionBarContributor.this.activeEditorPart instanceof IViewerProvider;
        }

        @Override
        public void run() {
            if (PcmActionBarContributor.this.activeEditorPart instanceof IViewerProvider) {
                final Viewer viewer = ((IViewerProvider) PcmActionBarContributor.this.activeEditorPart).getViewer();
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
    public PcmActionBarContributor() {
        super(ADDITIONS_LAST_STYLE);
        this.loadResourceAction = new LoadResourceAction();
        this.validateAction = new ValidateAction();
        this.controlAction = new ControlAction();
    }

    /**
     * @generated
     */
    @Override
    public void contributeToToolBar(final IToolBarManager toolBarManager) {
        toolBarManager.add(new Separator("pcm-settings"));
        toolBarManager.add(new Separator("pcm-additions"));
    }

    /**
     * @generated
     */
    @Override
    public void contributeToMenu(final IMenuManager menuManager) {
        super.contributeToMenu(menuManager);

        final IMenuManager submenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_PcmEditor_menu"), "de.uka.ipd.sdq.pcmMenuID");
        menuManager.insertAfter("additions", submenuManager);
        submenuManager.add(new Separator("settings"));
        submenuManager.add(new Separator("actions"));
        submenuManager.add(new Separator("additions"));
        submenuManager.add(new Separator("additions-end"));

        // Prepare for CreateChild item addition or removal.
        //
        this.createChildMenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
        submenuManager.insertBefore("additions", this.createChildMenuManager);

        // Prepare for CreateSibling item addition or removal.
        //
        this.createSiblingMenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
        submenuManager.insertBefore("additions", this.createSiblingMenuManager);

        // Force an update because Eclipse hides empty menus now.
        //
        submenuManager.addMenuListener(new IMenuListener() {

            @Override
            public void menuAboutToShow(final IMenuManager menuManager) {
                menuManager.updateAll(true);
            }
        });

        this.addGlobalActions(submenuManager);
    }

    /**
     * @generated
     */
    @Override
    public void setActiveEditor(final IEditorPart part) {
        super.setActiveEditor(part);
        this.activeEditorPart = part;

        // Switch to the new selection provider.
        //
        if (this.selectionProvider != null) {
            this.selectionProvider.removeSelectionChangedListener(this);
        }
        if (part == null) {
            this.selectionProvider = null;
        } else {
            this.selectionProvider = part.getSite().getSelectionProvider();
            this.selectionProvider.addSelectionChangedListener(this);

            // Fake a selection changed event to update the menus.
            //
            if (this.selectionProvider.getSelection() != null) {
                this.selectionChanged(new SelectionChangedEvent(this.selectionProvider, this.selectionProvider
                        .getSelection()));
            }
        }
    }

    /**
     * @generated
     */
    @Override
    public void selectionChanged(final SelectionChangedEvent event) {
        // Remove any menu items for old selection.
        //
        if (this.createChildMenuManager != null) {
            this.depopulateManager(this.createChildMenuManager, this.createChildActions);
        }
        if (this.createSiblingMenuManager != null) {
            this.depopulateManager(this.createSiblingMenuManager, this.createSiblingActions);
        }

        // Query the new selection for appropriate new child/sibling descriptors
        //
        Collection<?> newChildDescriptors = null;
        Collection<?> newSiblingDescriptors = null;

        final ISelection selection = event.getSelection();
        if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
            final Object object = ((IStructuredSelection) selection).getFirstElement();

            final EditingDomain domain = ((IEditingDomainProvider) this.activeEditorPart).getEditingDomain();

            newChildDescriptors = domain.getNewChildDescriptors(object, null);
            newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
        }

        // Generate actions for selection; populate and redraw the menus.
        //
        this.createChildActions = this.generateCreateChildActions(newChildDescriptors, selection);
        this.createSiblingActions = this.generateCreateSiblingActions(newSiblingDescriptors, selection);

        if (this.createChildMenuManager != null) {
            this.populateManager(this.createChildMenuManager, this.createChildActions, null);
            this.createChildMenuManager.update(true);
        }
        if (this.createSiblingMenuManager != null) {
            this.populateManager(this.createSiblingMenuManager, this.createSiblingActions, null);
            this.createSiblingMenuManager.update(true);
        }
    }

    /**
     * @generated
     */
    protected Collection<IAction> generateCreateChildActions(final Collection<?> descriptors, final ISelection selection) {
        final Collection<IAction> actions = new ArrayList<IAction>();
        if (descriptors != null) {
            for (final Object descriptor : descriptors) {
                actions.add(new CreateChildAction(this.activeEditorPart, selection, descriptor));
            }
        }
        return actions;
    }

    /**
     * @generated
     */
    protected Collection<IAction> generateCreateSiblingActions(final Collection<?> descriptors,
            final ISelection selection) {
        final Collection<IAction> actions = new ArrayList<IAction>();
        if (descriptors != null) {
            for (final Object descriptor : descriptors) {
                actions.add(new CreateSiblingAction(this.activeEditorPart, selection, descriptor));
            }
        }
        return actions;
    }

    /**
     * @generated
     */
    protected void populateManager(final IContributionManager manager, final Collection<? extends IAction> actions,
            final String contributionID) {
        if (actions != null) {
            for (final IAction action : actions) {
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
    protected void depopulateManager(final IContributionManager manager, final Collection<? extends IAction> actions) {
        if (actions != null) {
            final IContributionItem[] items = manager.getItems();
            for (final IContributionItem item : items) {
                // Look into SubContributionItems
                //
                IContributionItem contributionItem = item;
                while (contributionItem instanceof SubContributionItem) {
                    contributionItem = ((SubContributionItem) contributionItem).getInnerItem();
                }

                // Delete the ActionContributionItems with matching action.
                //
                if (contributionItem instanceof ActionContributionItem) {
                    final IAction action = ((ActionContributionItem) contributionItem).getAction();
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
    public void menuAboutToShow(final IMenuManager menuManager) {
        super.menuAboutToShow(menuManager);
        MenuManager submenuManager = null;

        submenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
        this.populateManager(submenuManager, this.createChildActions, null);
        menuManager.insertBefore("edit", submenuManager);

        submenuManager = new MenuManager(
                PalladioComponentModelEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
        this.populateManager(submenuManager, this.createSiblingActions, null);
        menuManager.insertBefore("edit", submenuManager);
    }

    /**
     * @generated
     */
    @Override
    protected void addGlobalActions(final IMenuManager menuManager) {
        menuManager.insertAfter("additions-end", new Separator("ui-actions"));
        menuManager.insertAfter("ui-actions", this.showPropertiesViewAction);

        this.refreshViewerAction.setEnabled(this.refreshViewerAction.isEnabled());
        menuManager.insertAfter("ui-actions", this.refreshViewerAction);

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