package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

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

/**
 * TODO
 * 
 * @author roman
 * 
 */
public abstract class CreateDataTypeDialog extends TitleAreaDialog {
	/**
	 * Define the Title,Message and ErrorMassage of Dialog
	 */
	protected String collectionSignator = "COLLECTION";
	protected String compositeSignator = "COMPOSITE";
	private String dialogTitleNew = "Create new DataType..";
	private String dialogTitleEdite = "Edite DataType..";
	private String errorNsgName = "DataType name is empty.";
	private String errorMsgInner = "Inner type/declaration is empty";
	
	/**
	 * Edited entity properies
	 */
	private String entityName;
	private String entityType;
	private String reposetoryName;
	/**
	 *  help value define edite DataType (collectionSignator ,compositeSignator)
	 */
	private String editeDataType;

	// TODO
	private Button okButton;
	private Composite composite;
	protected Group compositeGroup, collectionGroup;
	private Button compositeButton;
	private Button collectionButton;
	private Label nameLabelField;
	private Label typeLabelField;
	private Text nameField, typeField;
	private Button typeButton;
	private StackLayout stackLayout;

	public CreateDataTypeDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * TODO
	 * 
	 * @param reposetoryName
	 * @param entityName
	 * @param entityInnerType
	 */
	protected void init(String editeDataType, String reposetoryName,
			String entityName, String entityInnerType) {
		this.reposetoryName = reposetoryName;
		this.entityName = entityName;
		this.entityType = entityInnerType;
		this.editeDataType = editeDataType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
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

		final Combo combo = new Combo(reposetoryGroup, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		combo.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				setEditedResource(combo.getText());
				setEnabled(true);

				if (nameField.getText().equals(""))
					setErrorMessage(errorNsgName);
			}

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				setEditedResource(combo.getText());
				setEnabled(true);
				if (nameField.getText().equals(""))
					setErrorMessage(errorNsgName);
			}

		});

		// RadioButtons section
		final Group choiceTypeGroup = new Group(container, SWT.SHADOW_ETCHED_IN);
		choiceTypeGroup.setText("Choice DataType");
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
			public void widgetSelected(SelectionEvent e) {
				setTopCollectionLayout();
			}
		});
		new Label(choiceTypeGroup, SWT.NONE);

		// Create CompositeDataType button
		compositeButton = new Button(choiceTypeGroup, SWT.RADIO);
		compositeButton.setText("CompositeDataType");
		compositeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setTopCompositeLayout();
			}
		});
		new Label(choiceTypeGroup, SWT.NONE);

		nameLabelField = new Label(choiceTypeGroup, SWT.NONE);
		final GridData gridData = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false);
		gridData.widthHint = 107;
		nameLabelField.setLayoutData(gridData);
		nameLabelField.setText("Name:");

		nameField = new Text(choiceTypeGroup, SWT.BORDER);
		final GridData gdNameField = new GridData(SWT.LEFT, SWT.CENTER, true,
				false);
		gdNameField.widthHint = 334;
		nameField.setLayoutData(gdNameField);
		// TODO
		if (entityName != null)
			nameField.setText(entityName);
		
		nameField.addModifyListener(new ModifyListener() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				entityName = nameField.getText();
				setErrorMessage(null);
				
				if (collectionButton.isEnabled() && typeField.getText().equals(""))
					setErrorMessage(errorMsgInner);
				if (!typeField.getText().equals(""))
					setOKButtonEnabled();
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

		typeField = new Text(collectionGroup, SWT.BORDER | SWT.SINGLE
				| SWT.READ_ONLY);
		typeField.setLayoutData(new GridData(200, 15));
		if (entityType != null)
			typeField.setText(entityType);
		typeField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
					setErrorMessage(null);
					setOKButtonEnabled();
			}
		});

		typeButton = new Button(collectionGroup, SWT.NONE);
		typeButton.setLayoutData(new GridData(SWT.DEFAULT, 20));
		typeButton.setText("Select...");
		typeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				typeField.setText(getSelectedInnerType(e));
			}
		});

		// Create Separator
		final Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(482, SWT.DEFAULT));

		if (editeDataType != null) {
			setTitle(dialogTitleEdite);
			combo.setText(reposetoryName);
			combo.setEnabled(false);
			
			collectionButton.setEnabled(false);
			compositeButton.setEnabled(false);

			if (editeDataType.equals(collectionSignator))
				setTopCollectionLayout();
			if (editeDataType.equals(compositeSignator))
				setTopCompositeLayout();

		} else {
			setTitle(dialogTitleNew);
			combo.setItems(getLoadedReposetorys());
			setTopCollectionLayout();
			setEnabled(false);
		}

		return container;
	}

	/**
	 * Enables the receiver all component if the argument is true, and disables
	 * it otherwise.
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
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		okButton = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, false);
		okButton.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (editeDataType.equals(collectionSignator))
					createCollectionDataType();
				if (editeDataType.equals(compositeSignator))
					createCompositeDataType();
			}
		});
		okButton.setEnabled(false);
	}

	/**
	 * TODO
	 */
	protected void setOKButtonEnabled() {
			okButton.setEnabled(true);
	}
	
	protected void setOKButtonDisabled() {
			okButton.setEnabled(false);
	}

	/**
	 * TODO Give a loaded reposetorys
	 */
	public abstract String[] getLoadedReposetorys();

	public abstract void createInnerSectionCompositeGroup(Composite group);

	public abstract String getSelectedInnerType(SelectionEvent event);

	public abstract void setEditedResource(String resource);

	public abstract void createCollectionDataType();

	public abstract void createCompositeDataType();

	/**
	 * @return the entityName
	 */
	protected String getEntityName() {
		return entityName;
	}

	protected void callErrorMsgInner() {
		setErrorMessage(errorMsgInner);
	}

	/**
	 * TODO
	 */
	protected void setTopCompositeLayout() {
		collectionButton.setSelection(false);
		compositeButton.setSelection(true);
		stackLayout.topControl = compositeGroup;
		composite.layout();
		editeDataType = compositeSignator;
	}

	protected void setTopCollectionLayout() {
		compositeButton.setSelection(false);
		collectionButton.setSelection(true);
		stackLayout.topControl = collectionGroup;
		composite.layout();
		editeDataType = collectionSignator;
	}
}
