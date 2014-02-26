/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui.wizards.datasource;

import java.util.HashMap;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**Allows to select the type of a data source.
 * All known (and selectable) data sources are available as constants.
 * @author groenda
 *
 */
public class SelectDataSourceTypePage extends WizardPage {
	public static final String SENSORFRAMEWORK_V1_DATA_SOURCE = "Sensorframework V1 data source";
	public static final String IN_MEMORY_DATA_SOURCE = "In-Memory data source";
	public static final String REMOTE_DATA_SOURCE = "Remote data source";
	public static final String FILE_DATA_SOURCE = "File data source";
	public static final String NO_TYPE_SELECTED = "";

	/** Maps controls and their decoration. Used to display validation errors. */
	private static HashMap<Control, ControlDecoration> decoratorMap = new HashMap<Control, ControlDecoration>();
	
	/** Contains the representation of the current selection. */
	private String selection;
	
	public SelectDataSourceTypePage() {
		super("wizardPage");
		
		setTitle("Select Type of Data Source");
		setDescription("Please select the type of the data source you want to open.");
		selection = NO_TYPE_SELECTED;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);

		Label label = new Label(container, SWT.NONE);
		label.setText("Type of data source: ");
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		
		final Combo selectedDataTypeCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		selectedDataTypeCombo.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {
				boolean success =false;
				selection = selectedDataTypeCombo.getText();
				if (selection.equals(FILE_DATA_SOURCE)) {
					success = true;
				} else if (selection.equals(IN_MEMORY_DATA_SOURCE)) {
					success = true;
				} else if (selection.equals(REMOTE_DATA_SOURCE)) {
					success = true;
				} else if (selection.equals(SENSORFRAMEWORK_V1_DATA_SOURCE)) {
					success = true;
				}
				ControlDecoration decoration = decoratorMap.get(selectedDataTypeCombo);
				if (decoration != null) {
					if (success) {
						decoration.hide();
					} else {
						decoration.setDescriptionText("Please select a data type.");
						decoration.show();
					}
				}
				setPageComplete(success);
			}
		});
		populateComboBox(selectedDataTypeCombo);
		createControlDecoration(selectedDataTypeCombo);

		// The additional spacing (default is 5,5) is for the decorations
		GridLayoutFactory.swtDefaults().numColumns(2).spacing(10, 5)
				.generateLayout(container);
	}

	/**Populates the combo box with all selectable data source types.
	 * @param selectedDataType Combo box to be populated.
	 */
	private void populateComboBox(Combo selectedDataType) {
		// Add default
		selectedDataType.add(FILE_DATA_SOURCE);
		selectedDataType.select(0);
		selection = FILE_DATA_SOURCE;
		// Add other types
		selectedDataType.add(REMOTE_DATA_SOURCE);
		selectedDataType.add(IN_MEMORY_DATA_SOURCE);
		selectedDataType.add(SENSORFRAMEWORK_V1_DATA_SOURCE);
	}

	/**Creates the decoration for the elements to allow showing validation messages.
	 * @param control The control which should get be decorated.
	 */
	private void createControlDecoration(Control control) {
		ControlDecoration controlDecoration = new ControlDecoration(control,
				SWT.LEFT | SWT.TOP);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
		controlDecoration.setImage(fieldDecoration.getImage());
		controlDecoration.hide();
		decoratorMap.put(control, controlDecoration);
	}

	/**Get the current selected data type.
	 * Returns an empty string if no data source type is selected.
	 * @return The string representing the selection.
	 */
	public String getSelection() {
		return selection;
	}

}
