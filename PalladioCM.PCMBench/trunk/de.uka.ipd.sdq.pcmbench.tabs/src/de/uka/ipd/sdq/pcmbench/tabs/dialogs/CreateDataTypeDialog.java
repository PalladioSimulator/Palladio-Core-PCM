package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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
 * @author roman
 * 
 */
public abstract class CreateDataTypeDialog extends TitleAreaDialog {
	/**
	 * Define the Titleand Message of Dialog
	 */
	private String TITEL = "Create new DataType..";
	private String MESSAGE = "";
	
	/**
	 * TODO
	 */
	protected String entityName;
	

	/**
	 * TODO
	 */
	private Button OKButton;
	private Group compositeGroup, collectionGroup;
	private Button compositeButton;
	private Button collectionButton;
	private Label nameLabel, typeLabel;
	private Text nameText, typeText;
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
		combo.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				setEditedResource(combo.getText());
				setEnabled();
			}

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				setEditedResource(combo.getText());
				setEnabled();
			}
			
		});
		
		// RadioButtons section
		final Group choiceTypeGroup = new Group(container, SWT.SHADOW_ETCHED_IN);
		choiceTypeGroup.setText("Choice DataType");
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		choiceTypeGroup.setLayout(gridLayout);
		choiceTypeGroup.setLayoutData(new GridData(478, 28));
		//choiceTypeGroup.pack();
		
		// Create new Composite
		final Composite composite = new Composite(container, SWT.NONE);
		final StackLayout stackLayout = new StackLayout();
		composite.setLayout(stackLayout);
		composite.setLayoutData(new GridData(484, 139));
		
		
//		 Create CollyectionDataType button
		collectionButton = new Button(choiceTypeGroup, SWT.RADIO);
		collectionButton.setLayoutData(new GridData(129, SWT.DEFAULT));
		collectionButton.setText("CollectionDataType");
		collectionButton.setSelection(true);
		collectionButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = collectionGroup;
				composite.layout();
			}
		});
		
		// Create CompositeDataType button
		compositeButton = new Button(choiceTypeGroup, SWT.RADIO);
		compositeButton.setText("CompositeDataType");
		compositeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = compositeGroup;
				composite.layout();
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
		 * Create inner section for CollectionDataType group
		 * It contains a text label and a button
		 */
		typeLabel = new Label(collectionGroup, SWT.NONE);
		typeLabel.setLayoutData(new GridData(40, SWT.DEFAULT));
		typeLabel.setText("Type: ");

		typeText = new Text(collectionGroup, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY);
		typeText.setLayoutData(new GridData(200, 15));
		
		typeButton = new Button(collectionGroup, SWT.NONE);
		typeButton.setLayoutData(new GridData(SWT.DEFAULT, 20));
		typeButton.setText("Select...");
		typeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				defeniereActionTypeButton(e.display.getActiveShell(), typeText);
			}
		});

		nameLabel = new Label(collectionGroup, SWT.NONE);
		nameLabel.setText("Name: ");
		nameText = new Text(collectionGroup, SWT.BORDER | SWT.SINGLE);
		nameText.setLayoutData( new GridData(200, 15));
		nameText.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				entityName = nameText.getText();
				OKButton.setEnabled(true);
			}
		});
		nameText.addFocusListener(new FocusAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.FocusListener#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (entityName == null){
					entityName = nameText.getText();
					OKButton.setEnabled(true);
				}
			}
		});

		// Create Separator
		final Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(482, SWT.DEFAULT));
		
		//------- setEnabled(false) ---------
		compositeButton.setEnabled(false);
		collectionButton.setEnabled(false);
		typeLabel.setEnabled(false);
 		typeText.setEnabled(false);
 		typeButton.setEnabled(false);
 		nameLabel.setEnabled(false);
		nameText.setEnabled(false);
		
		return container;
	}
	
	// make all component enbled
	public void setEnabled() {
		         compositeButton.setEnabled(true);
		         collectionButton.setEnabled(true);
		 		 typeLabel.setEnabled(true);
		 		 typeText.setEnabled(true);
		 		 typeButton.setEnabled(true);
		 		 nameLabel.setEnabled(true);
		 		 nameText.setEnabled(true);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(500, 400);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL,
				false);
		OKButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				false);
		
		OKButton.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				defeniereActionOKButton();
			}
			
		});
		OKButton.setEnabled(false);
	}

	/**
	 * TODO
	 * Give a loaded reposetorys
	 */
	public abstract String[] getLoadedReposetorys();
	
	/**
	 * TODO
	 * @param - parent Composite
	 */
	public abstract void createInnerSectionCompositeGroup(Composite group);
	
	/**
	 * TODO
	 * @param - active shell
	 */
	public abstract void defeniereActionTypeButton(Shell shell, Text field); 
	
	/**
	 * @param resource, which edit to are selected.
	 */
	public abstract void setEditedResource(String resource);
	/**
	 * TODO
	 */
	public abstract void defeniereActionOKButton();
	
}
