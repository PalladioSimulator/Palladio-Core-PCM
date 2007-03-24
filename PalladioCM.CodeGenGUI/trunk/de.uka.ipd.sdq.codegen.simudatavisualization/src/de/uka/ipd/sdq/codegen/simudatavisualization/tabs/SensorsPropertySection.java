/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuImages;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.ReportCongiguration;

/**
 * @author admin
 *
 */
public class SensorsPropertySection extends AbstractPropertySection {
	
	private TableViewer viewer;
	
	public static final int ICON_COLUMN_INDEX = 0;
	public static final int RUN_COLUMN_INDEX = 1;
	public static final int SENSORS_COLUMN_INDEX = 2;

	/**
	 * Columns of a table, which is used into ParameterEditDialog
	 */

	public final static String ICON_COLUMN = "";
	public final static String RUN_COLUMN = "Experiment Run";
	public final static String SENSORS_COLUMN = "Sensors";

	// Set column names of Tabele
	private static String[] columnNames = new String[] { ICON_COLUMN,
			RUN_COLUMN, SENSORS_COLUMN };

	// style the style of table to construct
	int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
	| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		// TODO Auto-generated method stub
		super.createControls(parent, aTabbedPropertySheetPage);
	
		Composite composite = getWidgetFactory()
			.createFlatFormComposite(parent);
		composite.setLayout(new FormLayout());
		
		
		/**
		 * Create the cell editors for Name, Type column
		 */
		CellEditor[] editors = new CellEditor[columnNames.length];
		
		Table table = new Table(composite, style);
		final FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(0, 120);
		fd_table.left = new FormAttachment(0, 5);
		fd_table.top = new FormAttachment(0, 4);
		table.setLayoutData(fd_table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		

		viewer = new TableViewer(table);
		//Table table = viewer.getTable();

		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new SensorsTabContentProvider());
		viewer.setLabelProvider(new SensorsTabLabelProvider());

		// Assign the cell editors to the viewer
		viewer.setCellEditors(editors);
		//viewer.setCellModifier(cellModifier);
		viewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						// TODO Auto-generated method stub
						
					}
				});

		
		// Definere the table columns
		final TableColumn zeroColumn = new TableColumn(table, SWT.NONE);
		zeroColumn.setResizable(false);
		zeroColumn.setWidth(30);

		final TableColumn runColumn = new TableColumn(table, SWT.NONE);
		runColumn.setWidth(100);
		runColumn.setText(RUN_COLUMN);

		final TableColumn sensorsColumn = new TableColumn(table, SWT.NONE);
		sensorsColumn.setWidth(200);
		sensorsColumn.setText(SENSORS_COLUMN);

		ReportCongiguration rconfig = new ReportCongiguration();
		// Set input fot TableViewer
		viewer.setInput(rconfig);

		ToolBar toolBar;
		toolBar = new ToolBar(composite, SWT.VERTICAL | SWT.FLAT | SWT.RIGHT);
		fd_table.right = new FormAttachment(toolBar, -5, SWT.LEFT);
		final FormData fd_toolBar = new FormData();
		fd_toolBar.left = new FormAttachment(100, -32);
		fd_toolBar.bottom = new FormAttachment(0, 120);
		fd_toolBar.right = new FormAttachment(100, -6);
		fd_toolBar.top = new FormAttachment(0, 4);
		toolBar.setLayoutData(fd_toolBar);

		ToolItem addRunItem = new ToolItem(toolBar, SWT.PUSH);
		addRunItem.setImage(SimuImages.imageRegistry
				.get(SimuImages.RUN));
		addRunItem.addSelectionListener(new AddRunEntryActionListener(rconfig));

		ToolItem deleteRunItem = new ToolItem(toolBar, SWT.PUSH);
		deleteRunItem.setImage( SimuImages.imageRegistry
				.get(SimuImages.RUN));
		deleteRunItem.setEnabled(false);
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
		// TODO Auto-generated method stub
		super.refresh();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		super.setInput(part, selection);
	}

	/**
	 * 
	 */
	public SensorsPropertySection() {
		// TODO Auto-generated constructor stub
	}

}
