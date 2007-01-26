package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
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
	private String TITEL = "Create new DataType..";

	private String MESSAGE = "";

	private String ERROR_MESSAGE = "DataType name is empty.";

	private String entityName;

	// TODO
	private String selectedButton = "CollectionDataType";

	private Button OKButton;

	private Group compositeGroup, collectionGroup;

	private Button compositeButton;

	private Button collectionButton;

	private Label nameLabelField;

	private Label typeLabelField;

	private Text nameField, typeField;

	private Button typeButton;

	public CreateDataTypeDialog(Shell parentShell) {
		super(parentShell);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(TITEL);
		setMessage(MESSAGE);

		Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Reposetory section
		final Group reposetoryGroup = new Group(container, SWT.NONE);
		reposetoryGroup.setText("Reposetory");
		reposetoryGroup.setLayoutData(new GridData(478, 30));
		reposetoryGroup.setLayout(new GridLayout());

		final Combo combo = new Combo(reposetoryGroup, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		combo.setItems(getLoadedReposetorys());
		combo.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				setEditedResource(combo.getText());
				setEnabled(true);
				
				if (nameField.getText() != null)
					setErrorMessage(ERROR_MESSAGE);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				setEditedResource(combo.getText());
				setEnabled(true);
				setErrorMessage(ERROR_MESSAGE);
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
		final Composite composite = new Composite(container, SWT.NONE);
		final StackLayout stackLayout = new StackLayout();
		composite.setLayout(stackLayout);
		composite.setLayoutData(new GridData(484, 139));

		// Create CollyectionDataType button
		collectionButton = new Button(choiceTypeGroup, SWT.RADIO);
		collectionButton.setLayoutData(new GridData(129, SWT.DEFAULT));
		collectionButton.setText("CollectionDataType");
		collectionButton.setSelection(true);
		collectionButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = collectionGroup;
				composite.layout();
				setSelectedButton(collectionButton.getText());
			}
		});
		new Label(choiceTypeGroup, SWT.NONE);

		// Create CompositeDataType button
		compositeButton = new Button(choiceTypeGroup, SWT.RADIO);
		compositeButton.setText("CompositeDataType");
		compositeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = compositeGroup;
				composite.layout();
				setSelectedButton(compositeButton.getText());
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
		nameField.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				setEntityName(nameField.getText());
			}

		});
		nameField.addFocusListener(new FocusAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.FocusListener#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (getEntityName() == null) {
					setEntityName(nameField.getText());
				}
			}
		});
		nameField.addModifyListener(new ModifyListener() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setEntityName(nameField.getText());
				setErrorMessage(null);
				setOKButtonEnabled();
			}
		});

		// Create CompositeDataType Group with FormLayout
		compositeGroup = new Group(composite, SWT.NONE);
		compositeGroup.setLayout(new FormLayout());
		compositeGroup.setText("innerDeclaration CompositeDataType");
		/**
		 * Create inner section for CompositeDataType group
		 */
		createInnerSectionCompositeGroup(compositeGroup);

		// Create CollectionDataType Group
		collectionGroup = new Group(composite, SWT.NONE);
		final GridLayout gridLayoutCollGroup = new GridLayout();
		gridLayoutCollGroup.numColumns = 3;
		collectionGroup.setLayout(gridLayoutCollGroup);
		collectionGroup.setText("innerType CollectionDataType");
		// set the visible group
		stackLayout.topControl = collectionGroup;

		/**
		 * Create inner section for CollectionDataType group It contains a text
		 * label and a button
		 */
		typeLabelField = new Label(collectionGroup, SWT.NONE);
		typeLabelField.setLayoutData(new GridData(40, SWT.DEFAULT));
		typeLabelField.setText("Type: ");

		typeField = new Text(collectionGroup, SWT.BORDER | SWT.SINGLE
				| SWT.READ_ONLY);
		typeField.setLayoutData(new GridData(200, 15));

		typeButton = new Button(collectionGroup, SWT.NONE);
		typeButton.setLayoutData(new GridData(SWT.DEFAULT, 20));
		typeButton.setText("Select...");
		typeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				defeniereActionTypeButton(e);
			}
		});

		// Create Separator
		final Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(482, SWT.DEFAULT));

		setEnabled(false);

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
		OKButton = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, false);
		OKButton.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (selectedButton.equals("CollectionDataType"))
					createCollectionDataType();
				if (selectedButton.equals("CompositeDataType"))
					createCompositeDataType();
			}
		});
		OKButton.setEnabled(false);
	}

	/**
	 * TODO
	 */
	protected void setOKButtonEnabled() {
		if (getEntityName() != null)
			OKButton.setEnabled(true);
	}

	/**
	 * TODO Give a loaded reposetorys
	 */
	public abstract String[] getLoadedReposetorys();

	/**
	 * TODO
	 * 
	 * @param -
	 *            parent Composite
	 */
	public abstract void createInnerSectionCompositeGroup(Composite group);

	/**
	 * TODO
	 * 
	 * @param -
	 *            active shell
	 */
	public abstract void defeniereActionTypeButton(SelectionEvent event);

	/**
	 * @param resource,
	 *            which edit to are selected.
	 */
	public abstract void setEditedResource(String resource);

	/**
	 * TODO
	 */
	public abstract void createCollectionDataType();

	public abstract void createCompositeDataType();

	/**
	 * @return the entityName
	 */
	protected String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName
	 *            the entityName to set
	 */
	protected void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * @return the selectedButton
	 */
	protected String getSelectedButton() {
		return selectedButton;
	}

	/**
	 * @param selectedButton
	 *            the selectedButton to set
	 */
	protected void setSelectedButton(String selectedButton) {
		this.selectedButton = selectedButton;
	}

	protected String getTypeField() {
		return typeField.getText();
	}

	protected void setTypeField(String text) {
		typeField.setText(text);
	}

	/**
	 * @param nameField
	 *            the nameField to set
	 */
	protected void setNameField(String text) {
		nameField.setText(text);
	}

	protected void setSelectedCollectionButton() {
		collectionButton.setSelection(true);
	}

	protected void setSelectedCompositeButton() {
		compositeButton.setSelection(true);
	}
}
