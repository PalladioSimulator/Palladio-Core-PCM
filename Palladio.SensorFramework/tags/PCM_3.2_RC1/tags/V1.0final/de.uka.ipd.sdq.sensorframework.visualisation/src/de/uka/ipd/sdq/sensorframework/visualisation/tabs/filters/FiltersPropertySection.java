package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import java.util.ArrayList;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.sensorframework.filter.FilteredCollectionRegistry;
import de.uka.ipd.sdq.sensorframework.filter.IFilteredCollectionFactory;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationImages;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ActionListSelectionDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

/**
 * This class defines the 'Filters' tab section, which makes a definition
 * possible of filter and their pure sequence for measured values indicated in
 * the opinion.
 * 
 * @author Roman Andrej
 */
public class FiltersPropertySection extends AbstractPropertySection {
	
	private ConfigEditorInput configObject;
	private TableViewer viewer;
	private ToolItem deleteItem, upItem, downItem;
	
	private IFilteredCollectionFactory selectedFactory;
	

	public static final int ICON_COLUMN_INDEX = 0;
	public static final int FILTERNAME_COLUMN_INDEX = 1;
	public static final int PARAMETER_TYPE_COLUMN_INDEX = 2;
	public static final int PARAMETER_DESCRIPTION_COLUMN_INDEX = 3;
	public static final int PARAMETER_VALUE_COLUMN_INDEX = 4;

	/**
	 * Columns of a table, which is used into ParameterEditDialog.
	 */
	public final static String ICON_COLUMN = "";
	public final static String FILTERNAME_COLUMN = "Filter name";
	public final static String PARAMETER_TYPE_COLUMN = "Parameter type";
	public final static String PARAMETER_DESCRIPTION_COLUMN = "Description";
	public final static String PARAMETER_VALUE_COLUMN = "Value";
	/** ToolBar width. */
	private final int toolbarWidth = 23;

	// Set column names of Tabele
	protected static String[] columnNames = new String[] { ICON_COLUMN, FILTERNAME_COLUMN, PARAMETER_TYPE_COLUMN,PARAMETER_DESCRIPTION_COLUMN, PARAMETER_VALUE_COLUMN };

	// style the style of table to construct
	int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
			| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		Composite composite = getWidgetFactory()
				.createFlatFormComposite(parent);
		composite.getParent().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		
		// create table
		final Table table = new Table(composite, style);
		final FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(100, 0);
		fd_table.top = new FormAttachment(0, 0);
		fd_table.left = new FormAttachment(0, 0);
		table.setLayoutData(fd_table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// create 'Viewer'
		viewer = new TableViewer(table);
		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new FiltersTabContentProvider());
		viewer.setLabelProvider(new FiltersTabLabelProvider());
		
		viewer.setCellModifier(new FiltersTabCellModifier(this));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) viewer.getSelection())
						.getFirstElement();
				if (object instanceof IFilteredCollectionFactory) {
					selectedFactory = (IFilteredCollectionFactory) object;
					upItem.setEnabled(true);
					downItem.setEnabled(true);
					deleteItem.setEnabled(true);

					int index = configObject.getFiltersManager().getFactories()
							.indexOf(selectedFactory);
					if (index == 0) {
						upItem.setEnabled(false);
					}
					if (index == configObject.getFiltersManager()
							.getFactories().size()-1) {
						downItem.setEnabled(false);
					}
				}
			}
		});

		// Create the cell editors for 'Parameters' column
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[PARAMETER_VALUE_COLUMN_INDEX] = new TextCellEditor(table);
		
		// Assign the cell editors to the viewer
		viewer.setCellEditors(editors);

		// create icon column
		final TableColumn iconColumn = new TableColumn(table, SWT.NONE);
		iconColumn.setWidth(30);
		iconColumn.setText(ICON_COLUMN);

		// create filter name column
		final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		nameColumn.setWidth(210);
		nameColumn.setText(FILTERNAME_COLUMN);

		// create parameter type column
		final TableColumn parametersColumn = new TableColumn(table, SWT.CENTER);
		parametersColumn.setWidth(100);
		parametersColumn.setText(PARAMETER_TYPE_COLUMN);
		
		// create parameter description column
		final TableColumn parameterDescColumn = new TableColumn(table, SWT.CENTER);
		parameterDescColumn.setWidth(140);
		parameterDescColumn.setText(PARAMETER_DESCRIPTION_COLUMN);
		
		// create parameter value column
		final TableColumn parameterValueColumn = new TableColumn(table, SWT.CENTER);
		parameterValueColumn.setWidth(80);
		parameterValueColumn.setText(PARAMETER_VALUE_COLUMN);
		
		// create tool bar
		final ToolBar toolBar = new ToolBar(composite, SWT.VERTICAL);
		fd_table.right = new FormAttachment(toolBar, 0 , SWT.LEFT);
		final FormData fd_toolBar = new FormData();
		fd_toolBar.bottom = new FormAttachment(100, 0);
		fd_toolBar.left = new FormAttachment(100, - toolbarWidth);
		fd_toolBar.right = new FormAttachment(100, 0);
		fd_toolBar.top = new FormAttachment(0, 0);
		toolBar.setLayoutData(fd_toolBar);

		// create 'Add' button
		ToolItem addRunItem = new ToolItem(toolBar, SWT.PUSH);
		addRunItem.setImage(VisualisationImages.imageRegistry.get(VisualisationImages.ADD));
		addRunItem.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent event) {
				IFilteredCollectionFactory factory = null;

				ActionListSelectionDialog dialog = new ActionListSelectionDialog(
						event.display.getActiveShell(),
						new FilterLabelProvider(), 250, 200);
				dialog.setElements(getDefinedFilters());
				dialog.open();
				Object[] results = dialog.getResult();

				if (results != null) {
					factory = (IFilteredCollectionFactory) results[0];
					// add the filtered collection to the FilteredCollectionsManager
					configObject.getFiltersManager().addFactory(factory);
					// refresh TabeleViewer
					refresh();
				}
			}
		});

		// create 'Up' button
		upItem = new ToolItem(toolBar, SWT.PUSH);
		upItem.setImage(VisualisationImages.imageRegistry.get(VisualisationImages.UP));
		upItem.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<IFilteredCollectionFactory> factories = configObject
						.getFiltersManager().getFactories();
				int index = factories.indexOf(selectedFactory);
				factories.remove(selectedFactory);
				factories.add(index - 1, selectedFactory);
				upItem.setEnabled(false);
				refresh();
			}
		});
		upItem.setEnabled(false);
		
		// create 'Down' button
		downItem = new ToolItem(toolBar, SWT.PUSH);
		downItem.setImage(VisualisationImages.imageRegistry.get(VisualisationImages.DOWN));
		downItem.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<IFilteredCollectionFactory> factories = configObject
						.getFiltersManager().getFactories();
				int index = factories.indexOf(selectedFactory);
				factories.remove(selectedFactory);
				factories.add(index + 1, selectedFactory);
				downItem.setEnabled(false);
				refresh();
			}
		});
		downItem.setEnabled(false);
		
		// create 'Delete' button
		deleteItem = new ToolItem(toolBar, SWT.PUSH);
		deleteItem.setImage(VisualisationImages.imageRegistry.get(VisualisationImages.DELETE));
		deleteItem.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent event) {
				// remove in viewer selected filter from 'FilterManager'
				configObject.getFiltersManager().removeFactory(selectedFactory);
				refresh();
			}
		});
		deleteItem.setEnabled(false);
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
	
	private Object[] getDefinedFilters() {
		return FilteredCollectionRegistry
				.singleton().getAllAvailableCollectionFactories().toArray();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		// send message to observer
		configObject.update(null, null);
		// refresh TableViewer (FilterTab)
		viewer.refresh();
	}
}

/** The Class define the LabelProvider for ActionListSelectionDialog. */
class FilterLabelProvider extends LabelProvider {
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IFilteredCollectionFactory) {
			IFilteredCollectionFactory factory = (IFilteredCollectionFactory) element;
			return factory.getFilterFactoryID();
		}
		return super.getText(element);
	}
}
