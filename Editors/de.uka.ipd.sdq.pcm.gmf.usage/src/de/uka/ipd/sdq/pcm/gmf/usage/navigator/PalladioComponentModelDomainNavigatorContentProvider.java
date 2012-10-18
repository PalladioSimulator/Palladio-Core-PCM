/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;

/**
 * The Class PalladioComponentModelDomainNavigatorContentProvider.
 *
 * @generated
 */
public class PalladioComponentModelDomainNavigatorContentProvider implements ICommonContentProvider {

    /** The my adapter fctory content provier. @generated */
    private AdapterFactoryContentProvider myAdapterFctoryContentProvier;

    /** The Constant EMPTY_ARRAY. @generated */
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /** The my viewer. @generated */
    private Viewer myViewer;

    /** The my editing domain. @generated */
    private AdapterFactoryEditingDomain myEditingDomain;

    /** The my workspace synchronizer. @generated */
    private WorkspaceSynchronizer myWorkspaceSynchronizer;

    /** The my viewer refresh runnable. @generated */
    private Runnable myViewerRefreshRunnable;

    /**
     * Instantiates a new palladio component model domain navigator content provider.
     *
     * @generated
     */
    public PalladioComponentModelDomainNavigatorContentProvider() {
        myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(
                PalladioComponentModelUsageDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
        TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
        myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
        myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
            public Object get(Object key) {
                if (!containsKey(key)) {
                    put(key, Boolean.TRUE);
                }
                return super.get(key);
            }
        });
        myViewerRefreshRunnable = new Runnable() {
            public void run() {
                if (myViewer != null) {
                    myViewer.refresh();
                }
            }
        };
        myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
            public void dispose() {
            }

            public boolean handleResourceChanged(final Resource resource) {
                for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
                    Resource nextResource = (Resource) it.next();
                    nextResource.unload();
                }
                if (myViewer != null) {
                    myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
                }
                return true;
            }

            public boolean handleResourceDeleted(Resource resource) {
                for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
                    Resource nextResource = (Resource) it.next();
                    nextResource.unload();
                }
                if (myViewer != null) {
                    myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
                }
                return true;
            }

            public boolean handleResourceMoved(Resource resource, final URI newURI) {
                for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
                    Resource nextResource = (Resource) it.next();
                    nextResource.unload();
                }
                if (myViewer != null) {
                    myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
                }
                return true;
            }
        });
    }

    /**
     * Dispose.
     *
     * @generated
     */
    public void dispose() {
        myWorkspaceSynchronizer.dispose();
        myWorkspaceSynchronizer = null;
        myViewerRefreshRunnable = null;
        for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
            Resource resource = (Resource) it.next();
            resource.unload();
        }
        ((TransactionalEditingDomain) myEditingDomain).dispose();
        myEditingDomain = null;
    }

    /**
     * Input changed.
     *
     * @param viewer the viewer
     * @param oldInput the old input
     * @param newInput the new input
     * @generated
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        myViewer = viewer;
    }

    /**
     * Gets the elements.
     *
     * @param inputElement the input element
     * @return the elements
     * @generated
     */
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    /**
     * Restore state.
     *
     * @param aMemento the a memento
     * @generated
     */
    public void restoreState(IMemento aMemento) {
    }

    /**
     * Save state.
     *
     * @param aMemento the a memento
     * @generated
     */
    public void saveState(IMemento aMemento) {
    }

    /**
     * Inits the.
     *
     * @param aConfig the a config
     * @generated
     */
    public void init(ICommonContentExtensionSite aConfig) {
    }

    /**
     * Gets the children.
     *
     * @param parentElement the parent element
     * @return the children
     * @generated
     */
    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof IFile) {
            IFile file = (IFile) parentElement;
            URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
            Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
            return wrapEObjects(myAdapterFctoryContentProvier.getChildren(resource), parentElement);
        }

        if (parentElement instanceof PalladioComponentModelDomainNavigatorItem) {
            return wrapEObjects(
                    myAdapterFctoryContentProvier.getChildren(((PalladioComponentModelDomainNavigatorItem) parentElement)
                            .getEObject()), parentElement);
        }
        return EMPTY_ARRAY;
    }

    /**
     * Wrap e objects.
     *
     * @param objects the objects
     * @param parentElement the parent element
     * @return the object[]
     * @generated
     */
    public Object[] wrapEObjects(Object[] objects, Object parentElement) {
        Collection result = new ArrayList();
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof EObject) {
                result.add(new PalladioComponentModelDomainNavigatorItem((EObject) objects[i], parentElement,
                        myAdapterFctoryContentProvier));
            }
        }
        return result.toArray();
    }

    /**
     * Gets the parent.
     *
     * @param element the element
     * @return the parent
     * @generated
     */
    public Object getParent(Object element) {
        if (element instanceof PalladioComponentModelAbstractNavigatorItem) {
            PalladioComponentModelAbstractNavigatorItem abstractNavigatorItem = (PalladioComponentModelAbstractNavigatorItem) element;
            return abstractNavigatorItem.getParent();
        }
        return null;
    }

    /**
     * Checks for children.
     *
     * @param element the element
     * @return true, if successful
     * @generated
     */
    public boolean hasChildren(Object element) {
        return element instanceof IFile || getChildren(element).length > 0;
    }

}
