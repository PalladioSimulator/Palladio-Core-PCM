package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import de.uka.ipd.sdq.sensorframework.visualisation.editor.RunEntry;
import de.uka.ipd.sdq.sensorframework.visualisation.views.TreeContentProvider;

/**
 * TODO
 * @author admin
 *
 */
public class SensorsDialog extends TitleAreaDialog {

	private RunEntry entry;

	public static final int CHECK_COLUMN_INDEX = 0;
	public static final int SENSOR_ID_INDEX = 1;
	public static final int SENSOR_NAME_COLUMN_INDEX = 2;

	/**
	 * Columns of a table, which is used into ParameterEditDialog
	 */

	public final static String CHECK_COLUMN = "";
	public final static String SENSOR_ID_COLUMN = "Id";
	public final static String SENSOR_NAME_COLUMN = "Sensorname";

	// Set column names of Tabele
	public static String[] columnNames = new String[] { CHECK_COLUMN,
			SENSOR_ID_COLUMN, SENSOR_NAME_COLUMN };

	private Table table;

	/**
	 * Create the dialog
	 * 
	 * @param parentShell
	 */
	public SensorsDialog(Shell parentShell, RunEntry entry) {
		super(parentShell);
		this.entry = entry;
	}

	/**
	 * Create contents of the dialog
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final TableViewer tableViewer = new TableViewer(container, SWT.BORDER);
				//| SWT.CHECK);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn checkColumn = new TableColumn(table, SWT.LEFT);
		checkColumn.setWidth(24);
		checkColumn.setText(CHECK_COLUMN);

		final TableColumn experimentColumn = new TableColumn(table, SWT.LEFT);
		experimentColumn.setWidth(40);
		experimentColumn.setText(SENSOR_ID_COLUMN);

		final TableColumn sensorColumn = new TableColumn(table, SWT.LEFT);
		sensorColumn.setWidth(160);
		sensorColumn.setText(SENSOR_NAME_COLUMN);

		CellEditor[] editors = new CellEditor[columnNames.length];

		// Column 1 : Completed (Checkbox)
		editors[0] = new CheckboxCellEditor(table);

		tableViewer.addSelectionChangedListener(new ISelectionChangedListener(){

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				tableViewer.refresh();
			}
		});
		// Assign the cell editors to the viewer
		tableViewer.setColumnProperties(columnNames);
		tableViewer.setCellEditors(editors);
		tableViewer.setCellModifier(new SensorsDialogCellModifier(entry));
		tableViewer.setContentProvider(new SensorsDialogContentProvider());
		tableViewer.setLabelProvider(new SensorsDialogLabelProvider(entry));
		tableViewer.setInput(TreeContentProvider
				.getExperimentToExperimentRun(entry.getExperimentRun()));
		
		//
		return area;
	}

	/**
	 * Create contents of the button bar
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(400, 350);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select sensors");
	}

}
