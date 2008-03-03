package de.uka.ipd.sdq.sensorframework.visualisation.tabs.sensors;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationImages;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ExperimentRunsDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.SensorsDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;
import de.uka.ipd.sdq.sensorframework.visualisation.views.TreeObject;

/**
 * @author Roman Andrej
 */
public class SensorsPropertySection extends AbstractPropertySection implements
		Observer {

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable subject, Object signal) {
		if (subject instanceof ConfigEditorInput)
			refresh();
	}

	private ConfigEditorInput configObject;
	private ConfigEntry selectedEntry;
	private TableViewer viewer;
	private ToolItem deleteRunItem;

	public static final int ICON_COLUMN_INDEX = 0;
	public static final int CONTEXT_COLUMN_INDEX = 1;
	public static final int RUN_COLUMN_INDEX = 2;
	public static final int SENSORS_COLUMN_INDEX = 3;

	/**
	 * Columns of a table, which is used into ParameterEditDialog
	 */
	public final static String ICON_COLUMN = "";
	public final static String CONTEXT_COLUMN = "Context";
	public final static String RUN_COLUMN = "Experiment Datetime";
	public final static String SENSORS_COLUMN = "Sensors";

	/** ToolBar width. */
	private final int toolbarWidth = 24;
	
	// Set column names of Tabele
	protected static String[] columnNames = new String[] { ICON_COLUMN,
			CONTEXT_COLUMN, RUN_COLUMN, SENSORS_COLUMN };

	// style the style of table to construct
	int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
			| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		Composite composite = getWidgetFactory()
				.createFlatFormComposite(parent);
		composite.getParent().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		/**
		 * Create the cell editors for Name, Type column
		 */
		CellEditor[] editors = new CellEditor[columnNames.length];

		Table table = new Table(composite, style);
		final FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(100, 0);
		fd_table.left = new FormAttachment(0, 0);
		fd_table.top = new FormAttachment(0, 0);
		table.setLayoutData(fd_table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		viewer = new TableViewer(table);

		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new SensorsTabContentProvider());
		viewer.setLabelProvider(new SensorsTabLabelProvider());
		viewer.setCellModifier(new SensorsTabCellModifier());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) viewer.getSelection())
						.getFirstElement();
				selectedEntry = (ConfigEntry) object;
				
				if (selectedEntry != null)
					deleteRunItem.setEnabled(true);
				else deleteRunItem.setEnabled(false);
			}
		});
		editors[SENSORS_COLUMN_INDEX] = new DialogCellEditor(table) {

			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				SensorsDialog dialog = new SensorsDialog(cellEditorWindow
						.getShell(), selectedEntry);

				if (dialog.open() == Dialog.OK)
					viewer.refresh();
				return null;
			}
		};
		// Assign the cell editors to the viewer
		viewer.setCellEditors(editors);
		
		// Definere the table columns
		final TableColumn zeroColumn = new TableColumn(table, SWT.NONE);
		zeroColumn.setResizable(false);
		zeroColumn.setWidth(30);

		final TableColumn contextColumn = new TableColumn(table, SWT.NONE);
		contextColumn.setWidth(100);
		contextColumn.setText(CONTEXT_COLUMN);

		final TableColumn runColumn = new TableColumn(table, SWT.NONE);
		runColumn.setWidth(140);
		runColumn.setText(RUN_COLUMN);

		final TableColumn sensorsColumn = new TableColumn(table, SWT.NONE);
		sensorsColumn.setWidth(200);
		sensorsColumn.setText(SENSORS_COLUMN);

		final ToolBar toolBar = new ToolBar(composite, SWT.VERTICAL);
		fd_table.right = new FormAttachment(toolBar, 0, SWT.LEFT);
		final FormData fd_toolBar = new FormData();
		fd_toolBar.left = new FormAttachment(100, - toolbarWidth);
		fd_toolBar.bottom = new FormAttachment(100, 0);
		fd_toolBar.right = new FormAttachment(100, 0);
		fd_toolBar.top = new FormAttachment(0, 0);
		toolBar.setLayoutData(fd_toolBar);

		ToolItem addRunItem = new ToolItem(toolBar, SWT.PUSH);
		addRunItem.setImage(VisualisationImages.imageRegistry.get(VisualisationImages.ADD));
		addRunItem.addSelectionListener(new SelectionAdapter() {
		
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ExperimentRunsDialog dialog = new ExperimentRunsDialog(
						e.display.getActiveShell());
				if (dialog.open() == Window.OK && dialog.getResult() != null) {
					TreeObject object = dialog.getResult();
					ConfigEntry configEntry = new ConfigEntry(
							object.getDatasource(),
							(ExperimentRun) object.getObject(), object
									.getExperiment(), null);
					configObject.addConfigEntry(configEntry);
					viewer.refresh();
				}
			}
		});

		deleteRunItem = new ToolItem(toolBar, SWT.PUSH);
		deleteRunItem.setImage(VisualisationImages.imageRegistry.get(VisualisationImages.DELETE));
		deleteRunItem.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				configObject.removeConfigEntry(selectedEntry);
			}
			
		});
		deleteRunItem.setEnabled(false);

		/** set Observer to the ConfigObject */
		AbstractReportView view = (AbstractReportView) VisualisationPlugin.getDefault()
				.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		configObject = (ConfigEditorInput) view.getEditorInput();
		configObject.addObserver(this);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return super.getSelection();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		viewer.refresh();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		if (part instanceof AbstractReportView) {
			AbstractReportView view = (AbstractReportView) part;
			configObject = (ConfigEditorInput) view.getEditorInput();
			viewer.setInput(configObject);
		}
	}
}
