package de.uka.ipd.sdq.pcm.dialogs.datatype;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.pcm.dialogs.Messages;

/**
 * The dialogue is used in the PCM Bench for the production by Collection or Composite data types.
 * 
 * @author Roman Andrej
 */
public abstract class DataTypeDialog extends TitleAreaDialog {

    /** Edited entity properties */
    private String entityName;

    /**
     * help value define edit DataType (collectionSignator ,compositeSignator)
     */
    private DataTypeEnum editeDataType;

    private Composite composite;
    private Group compositeGroup, collectionGroup;
    private Button compositeButton;
    private Button collectionButton;
    private Label nameLabelField;
    private Label typeLabelField;
    private Text nameField, typeField;
    private Button typeButton;
    private StackLayout stackLayout;
    private Combo combo;
    private Shell shell;

    public DataTypeDialog(Shell parentShell) {
        super(parentShell);
    }

    /**
     * The method is called with the editing of the type of DataType.
     * 
     * @param repositoryName
     *            - the repository name of editing DataType
     * @param entityName
     *            - the name of the editing DataType
     * @param entityInnerType
     *            - the inner type of the editing DataType
     */
    protected void init(DataTypeEnum dataTyp, String repositoryName, String entityName, String entityInnerType) {
        this.entityName = entityName;
        this.editeDataType = dataTyp;

        setTitle(Messages.DataTypeDialog_EditTitle);
        shell.setText(Messages.DataTypeDialog_ShellEditTitle);

        if (dataTyp == DataTypeEnum.COLLECTION)
            setTopCollectionLayout();
        if (dataTyp == DataTypeEnum.COMPOSITE)
            setTopCompositeLayout();

        // Initialization the SWT elements with edit DataType attributes
        combo.setText(repositoryName);
        combo.setEnabled(false);
        nameField.setText(entityName);
        if (entityInnerType != null)
            typeField.setText(entityInnerType);

        setEnabled(true);
        setOKButtonDisabled();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        shell = newShell;
        newShell.setText(Messages.DataTypeDialog_ShellNewTitle);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent) {

        Composite area = (Composite) super.createDialogArea(parent);
        final Composite container = new Composite(area, SWT.NONE);
        container.setLayout(new GridLayout());
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        // Reposetory section
        final Group reposetoryGroup = new Group(container, SWT.NONE);
        reposetoryGroup.setText("Repository");
        reposetoryGroup.setLayoutData(new GridData(478, 30));
        reposetoryGroup.setLayout(new GridLayout());

        combo = new Combo(reposetoryGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
        combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        combo.addSelectionListener(new SelectionAdapter() {

            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.
             * SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                setEditedResource(combo.getText());
                setEnabled(true);
                validateInput();
            }

            /*
             * (non-Javadoc)
             * 
             * @see
             * org.eclipse.swt.events.SelectionAdapter#widgetDefaultSelected(org.eclipse.swt.events
             * .SelectionEvent)
             */
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                setEditedResource(combo.getText());
                setEnabled(true);
                validateInput();
            }
        });
        combo.setItems(getLoadedRepositories());

        // RadioButtons section
        final Group choiceTypeGroup = new Group(container, SWT.SHADOW_ETCHED_IN);
        choiceTypeGroup.setText("Choose DataType");
        final GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 2;
        choiceTypeGroup.setLayout(gridLayout);
        choiceTypeGroup.setLayoutData(new GridData(478, 74));

        // Create new Composite
        composite = new Composite(container, SWT.NONE);
        stackLayout = new StackLayout();
        composite.setLayout(stackLayout);
        composite.setLayoutData(new GridData(484, 139));

        // Create CollyectionDataType button
        collectionButton = new Button(choiceTypeGroup, SWT.RADIO);
        collectionButton.setLayoutData(new GridData(129, SWT.DEFAULT));
        collectionButton.setText("CollectionDataType");
        collectionButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setTopCollectionLayout();
                validateInput();
            }
        });
        new Label(choiceTypeGroup, SWT.NONE);

        // Create CompositeDataType button
        compositeButton = new Button(choiceTypeGroup, SWT.RADIO);
        compositeButton.setText("CompositeDataType");
        compositeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setTopCompositeLayout();
                validateInput();
            }
        });
        new Label(choiceTypeGroup, SWT.NONE);

        nameLabelField = new Label(choiceTypeGroup, SWT.NONE);
        final GridData gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
        gridData.widthHint = 107;
        nameLabelField.setLayoutData(gridData);
        nameLabelField.setText("Name:");

        nameField = new Text(choiceTypeGroup, SWT.BORDER);
        final GridData gdNameField = new GridData(SWT.LEFT, SWT.CENTER, true, false);
        gdNameField.widthHint = 334;
        nameField.setLayoutData(gdNameField);
        nameField.addModifyListener(new ModifyListener() {

            /*
             * (non-Javadoc)
             * 
             * @see
             * org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
             */
            public void modifyText(ModifyEvent e) {
                validateInput();
            }
        });

        // Create CompositeDataType Group with FormLayout
        compositeGroup = new Group(composite, SWT.NONE);
        compositeGroup.setLayout(new FormLayout());
        compositeGroup.setText("innerDeclaration CompositeDataType");

        // Create inner section for CompositeDataType group
        createInnerSectionCompositeGroup(compositeGroup);

        // Create CollectionDataType Group
        collectionGroup = new Group(composite, SWT.NONE);
        final GridLayout gridLayoutCollGroup = new GridLayout();
        gridLayoutCollGroup.numColumns = 3;
        collectionGroup.setLayout(gridLayoutCollGroup);
        collectionGroup.setText("innerType CollectionDataType");

        // Create inner section for CollectionDataType group
        typeLabelField = new Label(collectionGroup, SWT.NONE);
        typeLabelField.setLayoutData(new GridData(40, SWT.DEFAULT));
        typeLabelField.setText("Type: ");

        typeField = new Text(collectionGroup, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY);
        typeField.setLayoutData(new GridData(200, 15));
        typeField.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                validateInput();
            }
        });

        typeButton = new Button(collectionGroup, SWT.NONE);
        typeButton.setLayoutData(new GridData(SWT.DEFAULT, 20));
        typeButton.setText("Select...");
        typeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                typeField.setText(getSelectedInnerType(e));
            }
        });

        // Create Separator
        final Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
        label.setLayoutData(new GridData(482, SWT.DEFAULT));

        // set dialog default preferences
        setTitle(Messages.DataTypeDialog_NewTitle);
        setTopCollectionLayout();
        setEnabled(false);

        return container;
    }

    /**
     * Enables the receiver all component if the argument is true, and disables it otherwise.
     * 
     * @param enabled
     *            the new enabled state
     */
    public void setEnabled(boolean enabled) {
        compositeButton.setEnabled(enabled);
        collectionButton.setEnabled(enabled);
        typeLabelField.setEnabled(enabled);
        typeField.setEnabled(enabled);
        typeButton.setEnabled(enabled);
        nameLabelField.setEnabled(enabled);
        nameField.setEnabled(enabled);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
     */
    @Override
    protected Point getInitialSize() {
        return new Point(500, 446);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
        getButton(IDialogConstants.OK_ID).addSelectionListener(new SelectionAdapter() {

            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.
             * SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (editeDataType == DataTypeEnum.COLLECTION)
                    createCollectionDataType();
                if (editeDataType == DataTypeEnum.COMPOSITE)
                    createCompositeDataType();
            }
        });
        setOKButtonDisabled();
    }

    protected void setOKButtonEnabled() {
        getButton(IDialogConstants.OK_ID).setEnabled(true);
    }

    protected void setOKButtonDisabled() {
        getButton(IDialogConstants.OK_ID).setEnabled(false);
    }

    /** The method define the list with a loaded repository */
    public abstract String[] getLoadedRepositories();

    /** The method create the editing area for CompositeDataType */
    public abstract void createInnerSectionCompositeGroup(Composite group);

    public abstract String getSelectedInnerType(SelectionEvent event);

    public abstract void setEditedResource(String resource);

    /** The method create a new CollectionDataType */
    public abstract void createCollectionDataType();

    /** The method create a new CompositeDataType */
    public abstract void createCompositeDataType();

    public abstract boolean validateCompositeDataType();

    protected String getEntityName() {
        return entityName;
    }

    /**
     * The method specified in topControl is visible and all other controls are not visible.
     */
    protected void setTopCompositeLayout() {
        collectionButton.setSelection(false);
        compositeButton.setSelection(true);
        stackLayout.topControl = compositeGroup;
        composite.layout();
        editeDataType = DataTypeEnum.COMPOSITE;
    }

    protected void setTopCollectionLayout() {
        compositeButton.setSelection(false);
        collectionButton.setSelection(true);
        stackLayout.topControl = collectionGroup;
        composite.layout();
        editeDataType = DataTypeEnum.COLLECTION;
    }

    /**
     * The method examines whether the straight editing DataTYpe type has all parameters.
     */
    public void validateInput() {
        entityName = nameField.getText();

        if (entityName.equals("")) {
            setOKButtonDisabled();
            setErrorMessage(Messages.DataTypeDialog_ErrorMsgName);
            return;
        }

        if (collectionButton.getSelection() && typeField.getText().equals("")) {
            setOKButtonDisabled();
            setErrorMessage(Messages.DataTypeDialog_ErrorMsgInner);
        } else if (compositeButton.getSelection() && !validateCompositeDataType()) {
            setOKButtonDisabled();
        } else {
            setErrorMessage(null);
            setOKButtonEnabled();
        }
    }
}
