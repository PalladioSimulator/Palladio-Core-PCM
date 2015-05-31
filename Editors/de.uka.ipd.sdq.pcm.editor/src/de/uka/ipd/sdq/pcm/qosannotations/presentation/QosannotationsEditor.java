/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.presentation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.modelversioning.emfprofile.provider.EMFProfileItemProviderAdapterFactory;
import org.modelversioning.emfprofileapplication.provider.EMFProfileApplicationItemProviderAdapterFactory;
import org.palladiosimulator.mdsdprofiles.provider.MdsdprofilesItemProviderAdapterFactory;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

import de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.allocation.provider.AllocationItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.core.composition.provider.CompositionItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.core.presentation.PalladioComponentModelEditorPlugin;
import de.uka.ipd.sdq.pcm.core.provider.CoreItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.parameter.provider.ParameterItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.protocol.provider.ProtocolItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.provider.PcmItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.qosannotations.provider.QosannotationsItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.provider.QosPerformanceItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.provider.QosReliabilityItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.reliability.provider.ReliabilityItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.provider.ResourceenvironmentItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.resourcetype.provider.ResourcetypeItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.seff_performance.provider.SeffPerformanceItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.provider.SeffReliabilityItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.subsystem.provider.SubsystemItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.system.provider.SystemItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.usagemodel.provider.UsagemodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.propertytabs.PalladioAdapterFactoryContentProvider;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.probfunction.provider.ProbfunctionItemProviderAdapterFactory;
import de.uka.ipd.sdq.stoex.provider.StoexItemProviderAdapterFactory;
import de.uka.ipd.sdq.units.provider.UnitsItemProviderAdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;

/**
 * @generated
 */
public class QosannotationsEditor extends MultiPageEditorPart implements IEditingDomainProvider, ISelectionProvider,
        IMenuListener, IViewerProvider, IGotoMarker {
    /**
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * @generated
     */
    protected AdapterFactoryEditingDomain editingDomain;

    /**
     * This is the one adapter factory used for providing views of the model. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated not
     */
    protected AdapterFactory adapterFactory;

    /**
     * @generated
     */
    protected IContentOutlinePage contentOutlinePage;

    /**
     * @generated
     */
    protected IStatusLineManager contentOutlineStatusLineManager;

    /**
     * @generated
     */
    protected TreeViewer contentOutlineViewer;

    /**
     * This is the property sheet page.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();

    /**
     * @generated
     */
    protected TreeViewer selectionViewer;

    /**
     * @generated
     */
    protected TreeViewer parentViewer;

    /**
     * @generated
     */
    protected TreeViewer treeViewer;

    /**
     * @generated
     */
    protected ListViewer listViewer;

    /**
     * @generated
     */
    protected TableViewer tableViewer;

    /**
     * @generated
     */
    protected TreeViewer treeViewerWithColumns;

    /**
     * @generated
     */
    protected ViewerPane currentViewerPane;

    /**
     * @generated
     */
    protected Viewer currentViewer;

    /**
     * @generated
     */
    protected ISelectionChangedListener selectionChangedListener;

    /**
     * @generated
     */
    protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

    /**
     * @generated
     */
    protected ISelection editorSelection = StructuredSelection.EMPTY;

    /**
     * @generated
     */
    protected MarkerHelper markerHelper = new EditUIMarkerHelper();

    /**
     * @generated
     */
    protected IPartListener partListener = new IPartListener() {
        public void partActivated(IWorkbenchPart p) {
            if (p instanceof ContentOutline) {
                if (((ContentOutline) p).getCurrentPage() == contentOutlinePage) {
                    getActionBarContributor().setActiveEditor(QosannotationsEditor.this);

                    setCurrentViewer(contentOutlineViewer);
                }
            } else if (p instanceof PropertySheet) {
                if (propertySheetPages.contains(((PropertySheet) p).getCurrentPage())) {
                    getActionBarContributor().setActiveEditor(QosannotationsEditor.this);
                    handleActivate();
                }
            } else if (p == QosannotationsEditor.this) {
                handleActivate();
            }
        }

        public void partBroughtToTop(IWorkbenchPart p) {
            // Ignore.
        }

        public void partClosed(IWorkbenchPart p) {
            // Ignore.
        }

        public void partDeactivated(IWorkbenchPart p) {
            // Ignore.
        }

        public void partOpened(IWorkbenchPart p) {
            // Ignore.
        }
    };

    /**
     * @generated
     */
    protected Collection<Resource> removedResources = new ArrayList<Resource>();

    /**
     * @generated
     */
    protected Collection<Resource> changedResources = new ArrayList<Resource>();

    /**
     * @generated
     */
    protected Collection<Resource> savedResources = new ArrayList<Resource>();

    /**
     * @generated
     */
    protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

    /**
     * @generated
     */
    protected boolean updateProblemIndication = true;

    /**
     * @generated
     */
    protected EContentAdapter problemIndicationAdapter = new EContentAdapter() {
        @Override
        public void notifyChanged(Notification notification) {
            if (notification.getNotifier() instanceof Resource) {
                switch (notification.getFeatureID(Resource.class)) {
                case Resource.RESOURCE__IS_LOADED:
                case Resource.RESOURCE__ERRORS:
                case Resource.RESOURCE__WARNINGS: {
                    Resource resource = (Resource) notification.getNotifier();
                    Diagnostic diagnostic = analyzeResourceProblems(resource, null);
                    if (diagnostic.getSeverity() != Diagnostic.OK) {
                        resourceToDiagnosticMap.put(resource, diagnostic);
                    } else {
                        resourceToDiagnosticMap.remove(resource);
                    }

                    if (updateProblemIndication) {
                        getSite().getShell().getDisplay().asyncExec(new Runnable() {
                            public void run() {
                                updateProblemIndication();
                            }
                        });
                    }
                    break;
                }
                }
            } else {
                super.notifyChanged(notification);
            }
        }

        @Override
        protected void setTarget(Resource target) {
            basicSetTarget(target);
        }

        @Override
        protected void unsetTarget(Resource target) {
            basicUnsetTarget(target);
            resourceToDiagnosticMap.remove(target);
            if (updateProblemIndication) {
                getSite().getShell().getDisplay().asyncExec(new Runnable() {
                    public void run() {
                        updateProblemIndication();
                    }
                });
            }
        }
    };

    /**
     * @generated
     */
    protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
        public void resourceChanged(IResourceChangeEvent event) {
            IResourceDelta delta = event.getDelta();
            try {
                class ResourceDeltaVisitor implements IResourceDeltaVisitor {
                    protected ResourceSet resourceSet = editingDomain.getResourceSet();
                    protected Collection<Resource> changedResources = new ArrayList<Resource>();
                    protected Collection<Resource> removedResources = new ArrayList<Resource>();

                    public boolean visit(IResourceDelta delta) {
                        if (delta.getResource().getType() == IResource.FILE) {
                            if (delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.CHANGED
                                    && delta.getFlags() != IResourceDelta.MARKERS) {
                                Resource resource = resourceSet.getResource(
                                        URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
                                if (resource != null) {
                                    if (delta.getKind() == IResourceDelta.REMOVED) {
                                        removedResources.add(resource);
                                    } else if (!savedResources.remove(resource)) {
                                        changedResources.add(resource);
                                    }
                                }
                            }
                            return false;
                        }

                        return true;
                    }

                    public Collection<Resource> getChangedResources() {
                        return changedResources;
                    }

                    public Collection<Resource> getRemovedResources() {
                        return removedResources;
                    }
                }

                final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
                delta.accept(visitor);

                if (!visitor.getRemovedResources().isEmpty()) {
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {
                        public void run() {
                            removedResources.addAll(visitor.getRemovedResources());
                            if (!isDirty()) {
                                getSite().getPage().closeEditor(QosannotationsEditor.this, false);
                            }
                        }
                    });
                }

                if (!visitor.getChangedResources().isEmpty()) {
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {
                        public void run() {
                            changedResources.addAll(visitor.getChangedResources());
                            if (getSite().getPage().getActiveEditor() == QosannotationsEditor.this) {
                                handleActivate();
                            }
                        }
                    });
                }
            } catch (CoreException exception) {
                PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
            }
        }
    };

    /**
     * @generated
     */
    protected void handleActivate() {
        // Recompute the read only state.
        //
        if (editingDomain.getResourceToReadOnlyMap() != null) {
            editingDomain.getResourceToReadOnlyMap().clear();

            // Refresh any actions that may become enabled or disabled.
            //
            setSelection(getSelection());
        }

        if (!removedResources.isEmpty()) {
            if (handleDirtyConflict()) {
                getSite().getPage().closeEditor(QosannotationsEditor.this, false);
            } else {
                removedResources.clear();
                changedResources.clear();
                savedResources.clear();
            }
        } else if (!changedResources.isEmpty()) {
            changedResources.removeAll(savedResources);
            handleChangedResources();
            changedResources.clear();
            savedResources.clear();
        }
    }

    /**
     * @generated
     */
    protected void handleChangedResources() {
        if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict())) {
            if (isDirty()) {
                changedResources.addAll(editingDomain.getResourceSet().getResources());
            }
            editingDomain.getCommandStack().flush();

            updateProblemIndication = false;
            for (Resource resource : changedResources) {
                if (resource.isLoaded()) {
                    resource.unload();
                    try {
                        resource.load(Collections.EMPTY_MAP);
                    } catch (IOException exception) {
                        if (!resourceToDiagnosticMap.containsKey(resource)) {
                            resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
                        }
                    }
                }
            }

            if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
                setSelection(StructuredSelection.EMPTY);
            }

            updateProblemIndication = true;
            updateProblemIndication();
        }
    }

    /**
     * @generated
     */
    protected void updateProblemIndication() {
        if (updateProblemIndication) {
            BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, "de.uka.ipd.sdq.pcm.editor", 0, null,
                    new Object[] { editingDomain.getResourceSet() });
            for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values()) {
                if (childDiagnostic.getSeverity() != Diagnostic.OK) {
                    diagnostic.add(childDiagnostic);
                }
            }

            int lastEditorPage = getPageCount() - 1;
            if (lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart) {
                ((ProblemEditorPart) getEditor(lastEditorPage)).setDiagnostic(diagnostic);
                if (diagnostic.getSeverity() != Diagnostic.OK) {
                    setActivePage(lastEditorPage);
                }
            } else if (diagnostic.getSeverity() != Diagnostic.OK) {
                ProblemEditorPart problemEditorPart = new ProblemEditorPart();
                problemEditorPart.setDiagnostic(diagnostic);
                problemEditorPart.setMarkerHelper(markerHelper);
                try {
                    addPage(++lastEditorPage, problemEditorPart, getEditorInput());
                    setPageText(lastEditorPage, problemEditorPart.getPartName());
                    setActivePage(lastEditorPage);
                    showTabs();
                } catch (PartInitException exception) {
                    PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
                }
            }

            if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
                markerHelper.deleteMarkers(editingDomain.getResourceSet());
                if (diagnostic.getSeverity() != Diagnostic.OK) {
                    try {
                        markerHelper.createMarkers(diagnostic);
                    } catch (CoreException exception) {
                        PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
                    }
                }
            }
        }
    }

    /**
     * @generated
     */
    protected boolean handleDirtyConflict() {
        return MessageDialog.openQuestion(getSite().getShell(), getString("_UI_FileConflict_label"),
                getString("_WARN_FileConflict"));
    }

    /**
     * @generated
     */
    public QosannotationsEditor() {
        super();
        initializeEditingDomain();
    }

    /**
     * This sets up the editing domain for the model editor. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated not
     */
    protected void initializeEditingDomain() {
        // Create an adapter factory that yields item providers.
        //
        final ComposedAdapterFactory compAdapterFactory = new ComposedAdapterFactory(
                ComposedAdapterFactory.Descriptor.Registry.INSTANCE) {
            @Override
            public ComposeableAdapterFactory getRootAdapterFactory() {
                // TODO Auto-generated method stub
                return (PalladioItemProviderAdapterFactory) QosannotationsEditor.this.adapterFactory;
            }
        };

        compAdapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new CoreItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new EntityItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new CompositionItemProviderAdapterFactory());

        compAdapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ProtocolItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new SubsystemItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ParameterItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new SeffItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new QosPerformanceItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new AllocationItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ResourceenvironmentItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ResourcetypeItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new SystemItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new QosannotationsItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new SeffPerformanceItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ReliabilityItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new UsagemodelItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new IdentifierItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new StoexItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new UnitsItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ProbfunctionItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

        this.adapterFactory = new PalladioItemProviderAdapterFactory(compAdapterFactory);

        // Create the command stack that will notify this editor as commands are executed.
        //
        final BasicCommandStack commandStack = new BasicCommandStack();

        // Add a listener to set the most recent command's affected objects to be the selection of
        // the viewer with focus.
        //
        commandStack.addCommandStackListener(new CommandStackListener() {
            @Override
            public void commandStackChanged(final EventObject event) {
                QosannotationsEditor.this.getContainer().getDisplay().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        QosannotationsEditor.this.firePropertyChange(IEditorPart.PROP_DIRTY);

                        // Try to select the affected objects.
                        //
                        final Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
                        if (mostRecentCommand != null) {
                            QosannotationsEditor.this.setSelectionToViewer(mostRecentCommand.getAffectedObjects());
                        }
                        for (final PropertySheetPage propertySheetPage : QosannotationsEditor.this.propertySheetPages) {
                            if (!propertySheetPage.getControl().isDisposed()) {
                                propertySheetPage.refresh();
                            }
                        }
                    }
                });
            }
        });

        // Create the editing domain with a special command stack.
        //
        this.editingDomain = new AdapterFactoryEditingDomain(this.adapterFactory, commandStack,
                new HashMap<Resource, Boolean>());
    }

    /**
     * @generated
     */
    @Override
    protected void firePropertyChange(int action) {
        super.firePropertyChange(action);
    }

    /**
     * @generated
     */
    public void setSelectionToViewer(Collection<?> collection) {
        final Collection<?> theSelection = collection;
        // Make sure it's okay.
        //
        if (theSelection != null && !theSelection.isEmpty()) {
            Runnable runnable = new Runnable() {
                public void run() {
                    // Try to select the items in the current content viewer of the editor.
                    //
                    if (currentViewer != null) {
                        currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
                    }
                }
            };
            getSite().getShell().getDisplay().asyncExec(runnable);
        }
    }

    /**
     * @generated
     */
    @Override
    public EditingDomain getEditingDomain() {
        return editingDomain;
    }

    /**
     * @generated
     */
    public class ReverseAdapterFactoryContentProvider extends AdapterFactoryContentProvider {
        /**
         * @generated
         */
        public ReverseAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        /**
         * @generated
         */
        @Override
        public Object[] getElements(Object object) {
            Object parent = super.getParent(object);
            return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
        }

        /**
         * @generated
         */
        @Override
        public Object[] getChildren(Object object) {
            Object parent = super.getParent(object);
            return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
        }

        /**
         * @generated
         */
        @Override
        public boolean hasChildren(Object object) {
            Object parent = super.getParent(object);
            return parent != null;
        }

        /**
         * @generated
         */
        @Override
        public Object getParent(Object object) {
            return null;
        }
    }

    /**
     * @generated
     */
    public void setCurrentViewerPane(ViewerPane viewerPane) {
        if (currentViewerPane != viewerPane) {
            if (currentViewerPane != null) {
                currentViewerPane.showFocus(false);
            }
            currentViewerPane = viewerPane;
        }
        setCurrentViewer(currentViewerPane.getViewer());
    }

    /**
     * @generated
     */
    public void setCurrentViewer(Viewer viewer) {
        // If it is changing...
        //
        if (currentViewer != viewer) {
            if (selectionChangedListener == null) {
                // Create the listener on demand.
                //
                selectionChangedListener = new ISelectionChangedListener() {
                    // This just notifies those things that are affected by the section.
                    //
                    public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
                        setSelection(selectionChangedEvent.getSelection());
                    }
                };
            }

            // Stop listening to the old one.
            //
            if (currentViewer != null) {
                currentViewer.removeSelectionChangedListener(selectionChangedListener);
            }

            // Start listening to the new one.
            //
            if (viewer != null) {
                viewer.addSelectionChangedListener(selectionChangedListener);
            }

            // Remember it.
            //
            currentViewer = viewer;

            // Set the editors selection based on the current viewer's selection.
            //
            setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
        }
    }

    /**
     * @generated
     */
    @Override
    public Viewer getViewer() {
        return currentViewer;
    }

    /**
     * @generated
     */
    protected void createContextMenuFor(StructuredViewer viewer) {
        MenuManager contextMenu = new MenuManager("#PopUp");
        contextMenu.add(new Separator("additions"));
        contextMenu.setRemoveAllWhenShown(true);
        contextMenu.addMenuListener(this);
        Menu menu = contextMenu.createContextMenu(viewer.getControl());
        viewer.getControl().setMenu(menu);
        getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

        int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
        Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
        viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
        viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
    }

    /**
     * @generated
     */
    public void createModel() {
        URI resourceURI = EditUIUtil.getURI(getEditorInput());
        Exception exception = null;
        Resource resource = null;
        try {
            // Load the resource through the editing domain.
            //
            resource = editingDomain.getResourceSet().getResource(resourceURI, true);
        } catch (Exception e) {
            exception = e;
            resource = editingDomain.getResourceSet().getResource(resourceURI, false);
        }

        Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
        if (diagnostic.getSeverity() != Diagnostic.OK) {
            resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
        }
        editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);
    }

    /**
     * @generated
     */
    public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
        if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
            BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, "de.uka.ipd.sdq.pcm.editor", 0,
                    getString("_UI_CreateModelError_message", resource.getURI()),
                    new Object[] { exception == null ? (Object) resource : exception });
            basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
            return basicDiagnostic;
        } else if (exception != null) {
            return new BasicDiagnostic(Diagnostic.ERROR, "de.uka.ipd.sdq.pcm.editor", 0, getString(
                    "_UI_CreateModelError_message", resource.getURI()), new Object[] { exception });
        } else {
            return Diagnostic.OK_INSTANCE;
        }
    }

    /**
     * @generated
     */
    @Override
    public void createPages() {
        // Creates the model from the editor input
        //
        createModel();

        // Only creates the other pages if there is something that can be edited
        //
        if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
            // Create a page for the selection tree view.
            //
            {
                ViewerPane viewerPane = new ViewerPane(getSite().getPage(), QosannotationsEditor.this) {
                    @Override
                    public Viewer createViewer(Composite composite) {
                        Tree tree = new Tree(composite, SWT.MULTI);
                        TreeViewer newTreeViewer = new TreeViewer(tree);
                        return newTreeViewer;
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());

                selectionViewer = (TreeViewer) viewerPane.getViewer();
                selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

                selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
                selectionViewer.setInput(editingDomain.getResourceSet());
                selectionViewer.setSelection(
                        new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
                viewerPane.setTitle(editingDomain.getResourceSet());

                new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

                createContextMenuFor(selectionViewer);
                int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_SelectionPage_label"));
            }

            // Create a page for the parent tree view.
            //
            {
                ViewerPane viewerPane = new ViewerPane(getSite().getPage(), QosannotationsEditor.this) {
                    @Override
                    public Viewer createViewer(Composite composite) {
                        Tree tree = new Tree(composite, SWT.MULTI);
                        TreeViewer newTreeViewer = new TreeViewer(tree);
                        return newTreeViewer;
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());

                parentViewer = (TreeViewer) viewerPane.getViewer();
                parentViewer.setAutoExpandLevel(30);
                parentViewer.setContentProvider(new ReverseAdapterFactoryContentProvider(adapterFactory));
                parentViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

                createContextMenuFor(parentViewer);
                int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_ParentPage_label"));
            }

            // This is the page for the list viewer
            //
            {
                ViewerPane viewerPane = new ViewerPane(getSite().getPage(), QosannotationsEditor.this) {
                    @Override
                    public Viewer createViewer(Composite composite) {
                        return new ListViewer(composite);
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());
                listViewer = (ListViewer) viewerPane.getViewer();
                listViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
                listViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

                createContextMenuFor(listViewer);
                int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_ListPage_label"));
            }

            // This is the page for the tree viewer
            //
            {
                ViewerPane viewerPane = new ViewerPane(getSite().getPage(), QosannotationsEditor.this) {
                    @Override
                    public Viewer createViewer(Composite composite) {
                        return new TreeViewer(composite);
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());
                treeViewer = (TreeViewer) viewerPane.getViewer();
                treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
                treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

                new AdapterFactoryTreeEditor(treeViewer.getTree(), adapterFactory);

                createContextMenuFor(treeViewer);
                int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_TreePage_label"));
            }

            // This is the page for the table viewer.
            //
            {
                ViewerPane viewerPane = new ViewerPane(getSite().getPage(), QosannotationsEditor.this) {
                    @Override
                    public Viewer createViewer(Composite composite) {
                        return new TableViewer(composite);
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());
                tableViewer = (TableViewer) viewerPane.getViewer();

                Table table = tableViewer.getTable();
                TableLayout layout = new TableLayout();
                table.setLayout(layout);
                table.setHeaderVisible(true);
                table.setLinesVisible(true);

                TableColumn objectColumn = new TableColumn(table, SWT.NONE);
                layout.addColumnData(new ColumnWeightData(3, 100, true));
                objectColumn.setText(getString("_UI_ObjectColumn_label"));
                objectColumn.setResizable(true);

                TableColumn selfColumn = new TableColumn(table, SWT.NONE);
                layout.addColumnData(new ColumnWeightData(2, 100, true));
                selfColumn.setText(getString("_UI_SelfColumn_label"));
                selfColumn.setResizable(true);

                tableViewer.setColumnProperties(new String[] { "a", "b" });
                tableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
                tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

                createContextMenuFor(tableViewer);
                int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_TablePage_label"));
            }

            // This is the page for the table tree viewer.
            //
            {
                ViewerPane viewerPane = new ViewerPane(getSite().getPage(), QosannotationsEditor.this) {
                    @Override
                    public Viewer createViewer(Composite composite) {
                        return new TreeViewer(composite);
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());

                treeViewerWithColumns = (TreeViewer) viewerPane.getViewer();

                Tree tree = treeViewerWithColumns.getTree();
                tree.setLayoutData(new FillLayout());
                tree.setHeaderVisible(true);
                tree.setLinesVisible(true);

                TreeColumn objectColumn = new TreeColumn(tree, SWT.NONE);
                objectColumn.setText(getString("_UI_ObjectColumn_label"));
                objectColumn.setResizable(true);
                objectColumn.setWidth(250);

                TreeColumn selfColumn = new TreeColumn(tree, SWT.NONE);
                selfColumn.setText(getString("_UI_SelfColumn_label"));
                selfColumn.setResizable(true);
                selfColumn.setWidth(200);

                treeViewerWithColumns.setColumnProperties(new String[] { "a", "b" });
                treeViewerWithColumns.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
                treeViewerWithColumns.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

                createContextMenuFor(treeViewerWithColumns);
                int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_TreeWithColumnsPage_label"));
            }

            getSite().getShell().getDisplay().asyncExec(new Runnable() {
                public void run() {
                    setActivePage(0);
                }
            });
        }

        // Ensures that this editor will only display the page's tab
        // area if there are more than one page
        //
        getContainer().addControlListener(new ControlAdapter() {
            boolean guard = false;

            @Override
            public void controlResized(ControlEvent event) {
                if (!guard) {
                    guard = true;
                    hideTabs();
                    guard = false;
                }
            }
        });

        getSite().getShell().getDisplay().asyncExec(new Runnable() {
            public void run() {
                updateProblemIndication();
            }
        });
    }

    /**
     * @generated
     */
    protected void hideTabs() {
        if (getPageCount() <= 1) {
            setPageText(0, "");
            if (getContainer() instanceof CTabFolder) {
                ((CTabFolder) getContainer()).setTabHeight(1);
                Point point = getContainer().getSize();
                getContainer().setSize(point.x, point.y + 6);
            }
        }
    }

    /**
     * @generated
     */
    protected void showTabs() {
        if (getPageCount() > 1) {
            setPageText(0, getString("_UI_SelectionPage_label"));
            if (getContainer() instanceof CTabFolder) {
                ((CTabFolder) getContainer()).setTabHeight(SWT.DEFAULT);
                Point point = getContainer().getSize();
                getContainer().setSize(point.x, point.y - 6);
            }
        }
    }

    /**
     * @generated
     */
    @Override
    protected void pageChange(int pageIndex) {
        super.pageChange(pageIndex);

        if (contentOutlinePage != null) {
            handleContentOutlineSelection(contentOutlinePage.getSelection());
        }
    }

    /**
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getAdapter(Class key) {
        if (key.equals(IContentOutlinePage.class)) {
            return showOutlineView() ? getContentOutlinePage() : null;
        } else if (key.equals(IPropertySheetPage.class)) {
            return getPropertySheetPage();
        } else if (key.equals(IGotoMarker.class)) {
            return this;
        } else {
            return super.getAdapter(key);
        }
    }

    /**
     * @generated
     */
    public IContentOutlinePage getContentOutlinePage() {
        if (contentOutlinePage == null) {
            // The content outline is just a tree.
            //
            class MyContentOutlinePage extends ContentOutlinePage {
                @Override
                public void createControl(Composite parent) {
                    super.createControl(parent);
                    contentOutlineViewer = getTreeViewer();
                    contentOutlineViewer.addSelectionChangedListener(this);

                    // Set up the tree viewer.
                    //
                    contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
                    contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
                    contentOutlineViewer.setInput(editingDomain.getResourceSet());

                    // Make sure our popups work.
                    //
                    createContextMenuFor(contentOutlineViewer);

                    if (!editingDomain.getResourceSet().getResources().isEmpty()) {
                        // Select the root object in the view.
                        //
                        contentOutlineViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet()
                                .getResources().get(0)), true);
                    }
                }

                @Override
                public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager,
                        IStatusLineManager statusLineManager) {
                    super.makeContributions(menuManager, toolBarManager, statusLineManager);
                    contentOutlineStatusLineManager = statusLineManager;
                }

                @Override
                public void setActionBars(IActionBars actionBars) {
                    super.setActionBars(actionBars);
                    getActionBarContributor().shareGlobalActions(this, actionBars);
                }
            }

            contentOutlinePage = new MyContentOutlinePage();

            // Listen to selection so that we can handle it is a special way.
            //
            contentOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {
                // This ensures that we handle selections correctly.
                //
                public void selectionChanged(SelectionChangedEvent event) {
                    handleContentOutlineSelection(event.getSelection());
                }
            });
        }

        return contentOutlinePage;
    }

    /**
     * This accesses a cached version of the property sheet. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the property sheet page
     * @generated not
     */
    public IPropertySheetPage getPropertySheetPage() {

        if (this.propertySheetPages.isEmpty()) {
            final PropertySheetPage propertySheetPage = new ExtendedPropertySheetPage(this.editingDomain) {
                @Override
                public void setSelectionToViewer(final List<?> selection) {
                    QosannotationsEditor.this.setSelectionToViewer(selection);
                    QosannotationsEditor.this.setFocus();
                }

                @Override
                public void setActionBars(final IActionBars actionBars) {
                    super.setActionBars(actionBars);
                    QosannotationsEditor.this.getActionBarContributor().shareGlobalActions(this, actionBars);
                }
            };
            propertySheetPage.setPropertySourceProvider(new PalladioAdapterFactoryContentProvider(this.adapterFactory));
            this.propertySheetPages.add(propertySheetPage);
        }

        return this.propertySheetPages.get(0);
    }

    /**
     * @generated
     */
    public void handleContentOutlineSelection(ISelection selection) {
        if (currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
            Iterator<?> selectedElements = ((IStructuredSelection) selection).iterator();
            if (selectedElements.hasNext()) {
                // Get the first selected element.
                //
                Object selectedElement = selectedElements.next();

                // If it's the selection viewer, then we want it to select the same selection as this selection.
                //
                if (currentViewerPane.getViewer() == selectionViewer) {
                    ArrayList<Object> selectionList = new ArrayList<Object>();
                    selectionList.add(selectedElement);
                    while (selectedElements.hasNext()) {
                        selectionList.add(selectedElements.next());
                    }

                    // Set the selection to the widget.
                    //
                    selectionViewer.setSelection(new StructuredSelection(selectionList));
                } else {
                    // Set the input to the widget.
                    //
                    if (currentViewerPane.getViewer().getInput() != selectedElement) {
                        currentViewerPane.getViewer().setInput(selectedElement);
                        currentViewerPane.setTitle(selectedElement);
                    }
                }
            }
        }
    }

    /**
     * @generated
     */
    @Override
    public boolean isDirty() {
        return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
    }

    /**
     * @generated
     */
    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        // Save only resources that have actually changed.
        //
        final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
        saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

        // Do the work within an operation because this is a long running activity that modifies the workbench.
        //
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
            // This is the method that gets invoked when the operation runs.
            //
            @Override
            public void execute(IProgressMonitor monitor) {
                // Save the resources to the file system.
                //
                boolean first = true;
                for (Resource resource : editingDomain.getResourceSet().getResources()) {
                    if ((first || !resource.getContents().isEmpty() || isPersisted(resource))
                            && !editingDomain.isReadOnly(resource)) {
                        try {
                            long timeStamp = resource.getTimeStamp();
                            resource.save(saveOptions);
                            if (resource.getTimeStamp() != timeStamp) {
                                savedResources.add(resource);
                            }
                        } catch (Exception exception) {
                            resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
                        }
                        first = false;
                    }
                }
            }
        };

        updateProblemIndication = false;
        try {
            // This runs the options, and shows progress.
            //
            new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

            // Refresh the necessary state.
            //
            ((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
            firePropertyChange(IEditorPart.PROP_DIRTY);
        } catch (Exception exception) {
            // Something went wrong that shouldn't.
            //
            PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
        }
        updateProblemIndication = true;
        updateProblemIndication();
    }

    /**
     * @generated
     */
    protected boolean isPersisted(Resource resource) {
        boolean result = false;
        try {
            InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
            if (stream != null) {
                result = true;
                stream.close();
            }
        } catch (IOException e) {
            // Ignore
        }
        return result;
    }

    /**
     * @generated
     */
    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

    /**
     * @generated
     */
    @Override
    public void doSaveAs() {
        SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
        saveAsDialog.open();
        IPath path = saveAsDialog.getResult();
        if (path != null) {
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
            if (file != null) {
                doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
            }
        }
    }

    /**
     * @generated
     */
    protected void doSaveAs(URI uri, IEditorInput editorInput) {
        (editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
        setInputWithNotify(editorInput);
        setPartName(editorInput.getName());
        IProgressMonitor progressMonitor = getActionBars().getStatusLineManager() != null ? getActionBars()
                .getStatusLineManager().getProgressMonitor() : new NullProgressMonitor();
        doSave(progressMonitor);
    }

    /**
     * @generated
     */
    @Override
    public void gotoMarker(IMarker marker) {
        List<?> targetObjects = markerHelper.getTargetObjects(editingDomain, marker);
        if (!targetObjects.isEmpty()) {
            setSelectionToViewer(targetObjects);
        }
    }

    /**
     * @generated
     */
    @Override
    public void init(IEditorSite site, IEditorInput editorInput) {
        setSite(site);
        setInputWithNotify(editorInput);
        setPartName(editorInput.getName());
        site.setSelectionProvider(this);
        site.getPage().addPartListener(partListener);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener,
                IResourceChangeEvent.POST_CHANGE);
    }

    /**
     * @generated
     */
    @Override
    public void setFocus() {
        if (currentViewerPane != null) {
            currentViewerPane.setFocus();
        } else {
            getControl(getActivePage()).setFocus();
        }
    }

    /**
     * @generated
     */
    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        selectionChangedListeners.add(listener);
    }

    /**
     * @generated
     */
    @Override
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        selectionChangedListeners.remove(listener);
    }

    /**
     * @generated
     */
    @Override
    public ISelection getSelection() {
        return editorSelection;
    }

    /**
     * @generated
     */
    @Override
    public void setSelection(ISelection selection) {
        editorSelection = selection;

        for (ISelectionChangedListener listener : selectionChangedListeners) {
            listener.selectionChanged(new SelectionChangedEvent(this, selection));
        }
        setStatusLineManager(selection);
    }

    /**
     * @generated
     */
    public void setStatusLineManager(ISelection selection) {
        IStatusLineManager statusLineManager = currentViewer != null && currentViewer == contentOutlineViewer ? contentOutlineStatusLineManager
                : getActionBars().getStatusLineManager();

        if (statusLineManager != null) {
            if (selection instanceof IStructuredSelection) {
                Collection<?> collection = ((IStructuredSelection) selection).toList();
                switch (collection.size()) {
                case 0: {
                    statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
                    break;
                }
                case 1: {
                    String text = new AdapterFactoryItemDelegator(adapterFactory).getText(collection.iterator().next());
                    statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
                    break;
                }
                default: {
                    statusLineManager.setMessage(getString("_UI_MultiObjectSelected",
                            Integer.toString(collection.size())));
                    break;
                }
                }
            } else {
                statusLineManager.setMessage("");
            }
        }
    }

    /**
     * @generated
     */
    private static String getString(String key) {
        return PalladioComponentModelEditorPlugin.INSTANCE.getString(key);
    }

    /**
     * @generated
     */
    private static String getString(String key, Object s1) {
        return PalladioComponentModelEditorPlugin.INSTANCE.getString(key, new Object[] { s1 });
    }

    /**
     * @generated
     */
    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        ((IMenuListener) getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
    }

    /**
     * @generated
     */
    public EditingDomainActionBarContributor getActionBarContributor() {
        return (EditingDomainActionBarContributor) getEditorSite().getActionBarContributor();
    }

    /**
     * @generated
     */
    public IActionBars getActionBars() {
        return getActionBarContributor().getActionBars();
    }

    /**
     * @generated
     */
    public AdapterFactory getAdapterFactory() {
        return adapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated not
     */
    @Override
    public void dispose() {
        this.updateProblemIndication = false;

        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this.resourceChangeListener);

        this.getSite().getPage().removePartListener(this.partListener);

        ((PalladioItemProviderAdapterFactory) this.adapterFactory).dispose();

        if (this.getActionBarContributor().getActiveEditor() == this) {
            this.getActionBarContributor().setActiveEditor(null);
        }

        for (final PropertySheetPage propertySheetPage : this.propertySheetPages) {
            propertySheetPage.dispose();
        }

        if (this.contentOutlinePage != null) {
            this.contentOutlinePage.dispose();
        }

        super.dispose();
    }

    /**
     * @generated
     */
    protected boolean showOutlineView() {
        return true;
    }
}
