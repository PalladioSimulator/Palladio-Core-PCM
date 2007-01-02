package de.uka.ipd.sdq.pcmbench.tabs.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
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

/**
 * TODO
 * @author roman
 * 
 */
public abstract class CreateDataTypeDialog extends TitleAreaDialog {
	/**
	 * Define the Title of Dialog
	 */
	private String TITEL = "Create new DataType..";
	
	private Group compositeGroup, collectionGroup;

	public CreateDataTypeDialog(Shell parentShell) {
		super(parentShell);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				false);
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
		reposetoryGroup.setText("Reposetory");
		reposetoryGroup.setLayoutData(new GridData(478, 30));
		reposetoryGroup.setLayout(new GridLayout());

		final Combo combo = new Combo(reposetoryGroup, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		// RadioButtons section
		final Group choiceTypeGroup = new Group(container, SWT.NONE);
		choiceTypeGroup.setText("Choice DataType");
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		choiceTypeGroup.setLayout(gridLayout);
		choiceTypeGroup.setLayoutData(new GridData(478, 28));
		
		// Create new Composite
		final Composite composite = new Composite(container, SWT.NONE);
		final StackLayout stackLayout = new StackLayout();
		composite.setLayout(stackLayout);
		composite.setLayoutData(new GridData(484, 139));
		
		// Create CompositeDataType button
		final Button compositeButton = new Button(choiceTypeGroup, SWT.RADIO);
		compositeButton.setLayoutData(new GridData(129, SWT.DEFAULT));
		compositeButton.setText("CompositeDataType");
		compositeButton.setSelection(true);
		compositeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = compositeGroup;
				composite.layout();
			}
		});

		// Create CollectionDataType button
		final Button collectionButton = new Button(choiceTypeGroup, SWT.RADIO);
		collectionButton.setText("CollectionDataType");
		collectionButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = collectionGroup;
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
		innerSectionCompositeDataType(collectionGroup);
		
		// Create CollectionDataType Group
		collectionGroup = new Group(composite, SWT.NONE);
		final GridLayout gridLayoutCollGroup = new GridLayout();
		gridLayoutCollGroup.numColumns = 2;
		collectionGroup.setLayout(gridLayoutCollGroup);
		collectionGroup.setText("innerType CollectionDataType");
		stackLayout.topControl = compositeGroup;
		
		/**
		 * Create inner section for CollectionDataType group
		 * It contains a text label and a button
		 */
		final Label typeLabel = new Label(collectionGroup, SWT.NONE);
		typeLabel.setText("Type... :");
		final Button button = new Button(collectionGroup, SWT.NONE);
		button.setLayoutData(new GridData(SWT.DEFAULT, 17));
		button.setText("...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				innerTypeAction(e.display.getActiveShell());
			}
		});
		
		// Create Separator
		final Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(482, SWT.DEFAULT));
		
		setTitle(TITEL);
		return container;
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

	/**
	 * TODO
	 * Give a loaded reposetorys
	 */
	public abstract String[] getLoadedReposetorys();
	
	/**
	 * TODO
	 * @param - parent Composite
	 */
	public abstract void innerSectionCompositeDataType(Composite group);
	
	/**
	 * TODO
	 * @param - active shell
	 */
	public abstract void innerTypeAction(Shell shell); 
}
