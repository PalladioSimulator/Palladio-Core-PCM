/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**
 * @generated
 */
public class PalladioComponentModelNewDiagramFileWizard extends Wizard {

    /**
     * @generated
     */
    private WizardNewFileCreationPage myFileCreationPage;

    /**
     * @generated
     */
    private ModelElementSelectionPage diagramRootElementSelectionPage;

    /**
     * @generated
     */
    private final TransactionalEditingDomain myEditingDomain;

    /** The my diagram filename selection page. @generated not */
    private final WizardNewFileCreationPage myDiagramFilenameSelectionPage;

    /** The my diagram root element selection page. @generated not */
    private final DiagramRootElementSelectionPage myDiagramRootElementSelectionPage;

    /**
     * Instantiates a new palladio component model new diagram file wizard.
     * 
     * @param domainModelURI
     *            the domain model uri
     * @param diagramRoot
     *            the diagram root
     * @param editingDomain
     *            the editing domain
     * @generated not
     */
    public PalladioComponentModelNewDiagramFileWizard(URI domainModelURI, EObject diagramRoot,
            TransactionalEditingDomain editingDomain) {
        assert domainModelURI != null : "Domain model uri must be specified"; //$NON-NLS-1$
        assert diagramRoot != null : "Doagram root element must be specified"; //$NON-NLS-1$
        assert editingDomain != null : "Editing domain must be specified"; //$NON-NLS-1$

        myDiagramFilenameSelectionPage = new WizardNewFileCreationPage(
                Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageName, StructuredSelection.EMPTY);
        myDiagramFilenameSelectionPage.setTitle(Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageTitle);
        myDiagramFilenameSelectionPage.setDescription(NLS.bind(
                Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageDescription,
                ResourceDemandingSEFFEditPart.MODEL_ID));
        // force correct file extension
        myDiagramFilenameSelectionPage.setFileExtension("seff_diagram");

        IPath filePath;
        if (domainModelURI.isPlatformResource()) {
            filePath = new Path(domainModelURI.trimSegments(1).toPlatformString(true));
        } else if (domainModelURI.isFile()) {
            filePath = new Path(domainModelURI.trimSegments(1).toFileString());
        } else {
            // TODO : use some default path
            throw new IllegalArgumentException("Unsupported URI: " + domainModelURI); //$NON-NLS-1$
        }
        myDiagramFilenameSelectionPage.setContainerFullPath(filePath);

        myDiagramRootElementSelectionPage = new DiagramRootElementSelectionPage(
                Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageName, diagramRoot);
        myDiagramRootElementSelectionPage
                .setTitle(Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageTitle);
        myDiagramRootElementSelectionPage
                .setDescription(Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageDescription);

        myEditingDomain = editingDomain;
    }

    /**
     * Adds the pages.
     * 
     * @generated not
     */
    @Override
    public void addPages() {
        addPage(myDiagramRootElementSelectionPage);
        addPage(myDiagramFilenameSelectionPage);
    }

    /**
     * Perform finish.
     * 
     * @return true, if successful
     * @generated not
     */
    @Override
    public boolean performFinish() {
        List<IFile> affectedFiles = new LinkedList<IFile>();
        IFile diagramFile = myDiagramFilenameSelectionPage.createNewFile();
        try {
            diagramFile.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
        } catch (CoreException e) {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Unable to set charset for diagram file", e); //$NON-NLS-1$
        }
        affectedFiles.add(diagramFile);
        org.eclipse.emf.common.util.URI diagramModelURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(
                diagramFile.getFullPath().toString(), true);
        ResourceSet resourceSet = myEditingDomain.getResourceSet();
        final Resource diagramResource = resourceSet.createResource(diagramModelURI);
        AbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain,
                "Initializing diagram contents", affectedFiles) { //$NON-NLS-1$

            @Override
            protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                int diagramVID = PalladioComponentModelVisualIDRegistry
                        .getDiagramVisualID(myDiagramRootElementSelectionPage.getSeff());
                if (diagramVID != ResourceDemandingSEFFEditPart.VISUAL_ID) {
                    return CommandResult
                            .newErrorCommandResult("Incorrect model object stored as a root resource object"); //$NON-NLS-1$
                }
                Diagram diagram = ViewService.createDiagram(myDiagramRootElementSelectionPage.getSeff(),
                        ResourceDemandingSEFFEditPart.MODEL_ID,
                        PalladioComponentModelSeffDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
                diagramResource.getContents().add(diagram);
                return CommandResult.newOKCommandResult();
            }
        };
        try {
            OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
            diagramResource.save(Collections.EMPTY_MAP);
            PalladioComponentModelDiagramEditorUtil.openDiagram(diagramResource);
        } catch (ExecutionException e) {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Unable to create model and diagram", e); //$NON-NLS-1$
        } catch (IOException ex) {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Save operation failed for: " + diagramModelURI, ex); //$NON-NLS-1$
        } catch (PartInitException ex) {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * The Class DiagramRootElementSelectionPage.
     * 
     * @generated not
     */
    private class DiagramRootElementSelectionPage extends WizardPage {

        /**
         * @generated
         */
        protected DiagramRootElementSelectionPage(String pageName) {
            super(pageName);
        }

        /** The my combo. */
        private Combo myCombo;

        /** The my found seffs. */
        private List<ResourceDemandingSEFF> myFoundSeffs;

        /** The my diagram root. */
        private EObject myDiagramRoot;

        /** The my seff. */
        private ResourceDemandingSEFF mySeff;

        /**
         * Instantiates a new diagram root element selection page.
         * 
         * @param pageName
         *            the page name
         * @param diagramRoot
         *            the diagram root
         * @generated not
         */
        protected DiagramRootElementSelectionPage(String pageName, EObject diagramRoot) {
            super(pageName);
            myCombo = null;
            myFoundSeffs = new Vector<ResourceDemandingSEFF>();
            myDiagramRoot = diagramRoot;
            mySeff = null;
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
         */
        /**
         * Creates the control.
         * 
         * @param parent
         *            the parent
         * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
         */
        @Override
        public void createControl(Composite parent) {
            initializeDialogUnits(parent);
            Composite topLevel = new Composite(parent, SWT.NONE);
            topLevel.setLayout(new GridLayout());
            topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
            topLevel.setFont(parent.getFont());
            setControl(topLevel);
            createPageContent(topLevel);
            setPageComplete(validatePage());
        }

        /**
         * Creates the page content.
         * 
         * @param parent
         *            the parent
         */
        private void createPageContent(Composite parent) {
            Composite panel = new Composite(parent, SWT.NONE);
            panel.setLayoutData(new GridData(GridData.FILL_BOTH));
            GridLayout layout = new GridLayout();
            panel.setLayout(layout);

            Label label = new Label(panel, SWT.NONE);
            label.setText("Select Resource Demanding SEFF:");
            label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

            myCombo = new Combo(panel, SWT.DROP_DOWN | SWT.READ_ONLY);
            findSeffs();
            populateComboBox();
            myCombo.addSelectionListener(new ComboSelectionListener());
        }

        /**
         * Populate combo box.
         */
        private void populateComboBox() {
            if (myCombo == null) {
                return;
            }

            myCombo.removeAll();
            for (ResourceDemandingSEFF seff : myFoundSeffs) {
                myCombo.add("Container: " + getComponentNameFromSEFF(seff) + " - SEFF " + getServiceNameFromSEFF(seff)
                        + " id: " + seff.getId());
            }
        }

        /**
         * helper function to determine the name of the component of a seff. Assumes the seff can
         * only be contained in a BasicComponent.
         * 
         * @param seff
         *            any seff
         * @return the name of the component the seff belongs to or "" if the seff is not contained
         *         in a BasicComponent
         */
        protected String getComponentNameFromSEFF(ResourceDemandingSEFF seff) {
            EObject container = seff.eContainer();
            if (container instanceof BasicComponent) {
                BasicComponent component = (BasicComponent) container;
                return component.getEntityName();
            } else {
                return "";
            }
        }

        /**
         * helper function to determine the name of the service of a seff.
         * 
         * @param seff
         *            any seff
         * @return the name of the service the seff belongs to or "" if the seff belongs to no
         *         service
         * @generated not
         */
        protected String getServiceNameFromSEFF(ResourceDemandingSEFF seff) {
            return (seff.getDescribedService__SEFF() == null ? "" : seff.getDescribedService__SEFF().getEntityName());
        }

        /**
         * Find seffs.
         */
        private void findSeffs() {

            myFoundSeffs.clear();
            TreeIterator<EObject> it = myDiagramRoot.eAllContents();

            while (it.hasNext()) {
                EObject possibleSeff = it.next();
                if (possibleSeff instanceof ResourceDemandingSEFF) {
                    myFoundSeffs.add((ResourceDemandingSEFF) possibleSeff);
                }
            }
        }

        /**
         * @generated
         */
        protected String getSelectionTitle() {
            return Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageSelectionTitle;
        }

        /**
         * Gets the seff.
         * 
         * @return the seff
         */
        protected ResourceDemandingSEFF getSeff() {
            return mySeff;
        }

        /**
         * Validate page.
         * 
         * @return true, if successful
         * @generated not
         */
        protected boolean validatePage() {
            mySeff = null;
            if (myCombo.getSelectionIndex() == -1) {
                return false;
            }

            try {
                mySeff = myFoundSeffs.get(myCombo.getSelectionIndex());
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            // propose a name in the diagram filename selection page
            String filename = getComponentNameFromSEFF(mySeff) + "." + getServiceNameFromSEFF(mySeff) + ".seff_diagram";
            myDiagramFilenameSelectionPage.setFileName(filename);

            return true;
        }

        /**
         * The listener interface for receiving comboSelection events. The class that is interested
         * in processing a comboSelection event implements this interface, and the object created
         * with that class is registered with a component using the component's
         * <code>addComboSelectionListener<code> method. When
         * the comboSelection event occurs, that object's appropriate
         * method is invoked.
         * 
         * @see ComboSelectionEvent
         */
        private class ComboSelectionListener implements SelectionListener {

            /*
             * (non-Javadoc)
             * 
             * @see
             * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events
             * .SelectionEvent)
             */
            /**
             * Widget default selected.
             * 
             * @param e
             *            the e
             * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                setPageComplete(validatePage());
            }

            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.
             * SelectionEvent)
             */
            /**
             * Widget selected.
             * 
             * @param e
             *            the e
             * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                setPageComplete(validatePage());
            }

        }
    }
}
