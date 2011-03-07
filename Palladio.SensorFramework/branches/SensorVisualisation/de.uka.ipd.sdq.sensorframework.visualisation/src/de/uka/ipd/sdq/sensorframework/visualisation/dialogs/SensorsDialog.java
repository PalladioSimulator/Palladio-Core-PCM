package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;

/**
 * TODO
 * @author admin
 *
 */
public class SensorsDialog extends TitleAreaDialog {

	private ConfigEntry entry;

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

	public SensorsDialog(Shell parentShell, ConfigEntry entry) {
		super(parentShell);
		this.entry = entry;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
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
		sensorColumn.setWidth(260);
		sensorColumn.setText(SENSOR_NAME_COLUMN);

		CellEditor[] editors = new CellEditor[columnNames.length];

		// Column 1 : Completed (Checkbox)
		editors[0] = new CheckboxCellEditor(table);

		tableViewer.addSelectionChangedListener(new ISelectionChangedListener(){

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
		tableViewer.setComparator(new ViewerComparator() {
		    
		    @Override
		    public int compare(Viewer viewer, Object e1, Object e2) {
		        if (e1 instanceof Sensor  && e2 instanceof Sensor ) {
		            return ((Sensor ) e1).getSensorName().compareToIgnoreCase(
		                   ((Sensor ) e2).getSensorName());
		        }
		        throw new IllegalArgumentException("Not comparable: " + e1 + " " + e2);
		    }

		});

		tableViewer.setInput(entry);
		
		//
		return area;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(400, 350);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select sensors");
	}
}
