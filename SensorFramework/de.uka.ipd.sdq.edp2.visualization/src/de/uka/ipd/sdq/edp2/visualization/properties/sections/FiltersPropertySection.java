package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.AbstractTransformation;
import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.PieChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInput;
import de.uka.ipd.sdq.edp2.visualization.filter.TeardownFilter;
import de.uka.ipd.sdq.edp2.visualization.filter.WarmupFilter;
import de.uka.ipd.sdq.edp2.visualization.wizards.AdapterWizard;
import de.uka.ipd.sdq.edp2.visualization.wizards.FilterWizard;

/**
 * GUI controls for Properties for {@link IFilter}. Used to display and edit
 * properties in Eclipse Properties View if an Visualization Editor is selected.
 * 
 * @author Roland Richter, Dominik Ernst
 * 
 */
public class FiltersPropertySection extends AbstractPropertySection {
	/** logger */
	private static Logger logger = Logger
			.getLogger(FiltersPropertySection.class.getCanonicalName());

	/**
	 * A list which contains the applied transformations
	 */
	private List list;
	/**
	 * A simple counter for the list
	 */
	private int counter = 0;
	/**
	 * The attributes table. It shows the attributes for the filter which is
	 * selected in the filtersList
	 */
	private Table transformationTable;
	
	/**
	 * Viewer for the table containing the list of transformations.
	 */
	private TableViewer transformationTableViewer;
	
	/**
	 * The current editor which is an {@link ITabbedPropertySheetPageContributor}.
	 */
	private AbstractEditor editor;

	/**
	 * Create the look and items of the properties. It is called, if one of the
	 * editors in the package visualization.editors is selected.
	 */
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {

		super.createControls(parent, aTabbedPropertySheetPage);

		Composite composite = getWidgetFactory()
				.createFlatFormComposite(parent);
		
		//properties view is only visible for abstract editors, so no type check is necessary
		editor = (AbstractEditor) Activator.getDefault().getWorkbench()
		.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		// set the input to what is actually selected in the editor
		setInput(editor, Activator.getDefault().getWorkbench()
						.getActiveWorkbenchWindow().getSelectionService()
						.getSelection(editor.getSite().getId()));
		
		// initialize the layout
		createLayout(composite);

		// generate the group for the applied transformations
		Group transformationGroup = createTransformationGroup(composite);

		// initialize the contents of the group
		initTransformationTable(transformationGroup);

		Group warumUpConfigGroup = createWarmupConfigurationGroup(composite);
		generatePropertieSectionForWarmup(warumUpConfigGroup);

		final Button buttonAdapter = new Button(composite, SWT.PUSH);
		buttonAdapter.setText("Add new Adapter..");
		buttonAdapter.pack();
		final Button buttonFilter = new Button(composite, SWT.PUSH);
		buttonFilter.setText("Add new Filter..");
		buttonFilter.pack();

		Listener btnListener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.widget == buttonAdapter) {
					AdapterWizard wizard = new AdapterWizard(getSource());
					IAdapter adapter = null;
					WizardDialog wdialog = new WizardDialog(Activator
							.getDefault().getWorkbench()
							.getActiveWorkbenchWindow().getShell(), wizard);
					wdialog.open();
					if (wdialog.getReturnCode() == Window.OK)
						adapter = wizard.getAdapter();

				} else if (event.widget == buttonFilter) {
					FilterWizard wizard = new FilterWizard(getSource());
					IFilter filter = null;
					WizardDialog wdialog = new WizardDialog(Activator
							.getDefault().getWorkbench()
							.getActiveWorkbenchWindow().getShell(), wizard);
					wdialog.open();
					if (wdialog.getReturnCode() == Window.OK)
						filter = wizard.getFilter();
				}
			}
		};
		buttonAdapter.addListener(SWT.Selection, btnListener);
		buttonFilter.addListener(SWT.Selection, btnListener);

	}

	/**
	 * Creates a RowLayout for this section of the properties
	 * 
	 * @param composite
	 *            It is the parent.
	 */
	private void createLayout(Composite composite) {
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.spacing = 2;
		layout.justify = true;
		layout.pack = true;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		layout.wrap = true;
		composite.setLayout(layout);
	}

	/**
	 * Creates and initializes the list of the applied filters and the
	 * properties table. A selection listener looks if one entry in the filter
	 * list is selected and if one is selected the
	 * {@link FiltersPropertySection#refreshPropertiesTable()} is called. A
	 * listener look for the properties table and call
	 * {@link FiltersPropertySection#updateProperties(String, Object)} of the
	 * value field is let out by pressing ENTER.
	 * 
	 * @param parentGroup
	 *            the parent GUI Object
	 */
	private void initTransformationTable(Group parentGroup) {
		// initialize the list of transformations with a selection listener
		list = new List(parentGroup, SWT.BORDER | SWT.SINGLE
				| SWT.V_SCROLL);
		list.setLayoutData(new RowData(140, 100));
		list.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				refreshPropertiesTable();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}
		});

		// initialize the table, which shows the properties of transformations
		transformationTable = new Table(parentGroup, SWT.SINGLE | SWT.BORDER
				| SWT.V_SCROLL | SWT.FULL_SELECTION);

		transformationTable.setLinesVisible(true);
		transformationTable.setHeaderVisible(true);
		// set width and hight from the table
		transformationTable.setLayoutData(new RowData(250, 150));
		// set the weight of the table columns
		TableLayout tableLayout = new TableLayout();
		tableLayout.addColumnData(new ColumnWeightData(2));
		tableLayout.addColumnData(new ColumnWeightData(1));
		transformationTable.setLayout(tableLayout);
		
		transformationTableViewer = new TableViewer(transformationTable);
		TableViewerColumn labelColumn = new TableViewerColumn(
				transformationTableViewer, SWT.NONE);
		labelColumn.getColumn().setText("Property");
		
		TableViewerColumn valueColumn = new TableViewerColumn(
				transformationTableViewer, SWT.NONE);
		valueColumn.getColumn().setText("Value");

		// the editor for the cells
		final TableEditor editor = new TableEditor(transformationTable);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		transformationTable.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Rectangle clientArea = transformationTable.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = transformationTable.getTopIndex();
				while (index < transformationTable.getItemCount()) {
					boolean visible = false;
					final TableItem item = transformationTable.getItem(index);

					// look if the mouse event is in an editable cell
					Rectangle rect = item.getBounds(1);
					if (rect.contains(pt)) {
						final int column = 1;
						final Text text = new Text(transformationTable, SWT.NONE);
						Listener textListener = new Listener() {
							public void handleEvent(final Event e) {
								switch (e.type) {
								case SWT.FocusOut:
									item.setText(column, text.getText());
									text.dispose();
									break;
								case SWT.Traverse:
									switch (e.detail) {
									case SWT.TRAVERSE_RETURN:
										item.setText(column, text.getText());
										updateProperties(
										// first column
												item.getText(0), text.getText());

									case SWT.TRAVERSE_ESCAPE:
										text.dispose();
										e.doit = false;
									}
									break;
								}
							}
						};
						text.addListener(SWT.FocusOut, textListener);
						text.addListener(SWT.Traverse, textListener);
						editor.setEditor(text, item, 1);
						text.setText(item.getText(1));
						text.selectAll();
						text.setFocus();
						return;
					}
					if (!visible && rect.intersects(clientArea)) {
						visible = true;
					}
					// }
					if (!visible)
						return;
					index++;
				}
			}
		});

	}

	/**
	 * Generates the properties section for a new {@link WarmupFilter}.
	 * 
	 * @param group
	 *            the parent GUI Object
	 */
	private void generatePropertieSectionForWarmup(Group group) {

		// add a selectable label
		String[] items = new String[2];
		items[0] = "dropped values";
		items[1] = "dropped values in percentage";
		final CCombo kindOfValues = getWidgetFactory().createCCombo(group,
				SWT.BORDER);
		kindOfValues.setItems(items);
		kindOfValues.setEditable(false);
		// add a texfield
		final Text txtDroppedValuesPercentage;
		txtDroppedValuesPercentage = getWidgetFactory().createText(group, "",
				SWT.BORDER);
		txtDroppedValuesPercentage.setTextLimit(20);
		// Add a Button
		Button newFilterButton = getWidgetFactory().createButton(group,
				"Add Warmupfilter", SWT.PUSH);
		newFilterButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				logger.log(Level.INFO, "new warmup filter");
				WarmupFilter newWarmupFilter = null;
				
				// get the active editor's input (can only be an AbstractEditor)
				IDataSink input = editor.getEditorInput();
				
				//create a new warmup filter with the source of the editors former input
				if (kindOfValues.getSelectionIndex() == 0) {
					newWarmupFilter = new WarmupFilter(input.getSource(),
							Integer.parseInt(txtDroppedValuesPercentage
									.getText()), 0);

				} else {
					newWarmupFilter = new WarmupFilter(input.getSource(), 0,
							Float.parseFloat(txtDroppedValuesPercentage
									.getText()));
				}
				logger.log(Level.INFO, "update editor input begin");
				input.setSource(newWarmupFilter);
				if (editor instanceof JFreeChartEditor){
					((JFreeChartEditor)editor).updateChart();
				}
				//editor.changeInput(input);
				editor.setFocus();
				logger.log(Level.INFO, "update editor input end");
				updateFilterList();

			}
		});

	}

	/**
	 * Creates and configures the layout of the group for the new WarumupFilter
	 * configurations.
	 * 
	 * @param composite
	 *            the parent GUI Object
	 * @return the GUI Group for the group Warmup Filter
	 */
	private Group createWarmupConfigurationGroup(Composite composite) {
		RowData data = new RowData();
		data.width = 400;
		data.height = 50;

		Group warmUpGroup = getWidgetFactory().createGroup(composite,
				"Warmup Filter");
		warmUpGroup.setLayout(new RowLayout());
		warmUpGroup.setLayoutData(data);
		return warmUpGroup;
	}

	/**
	 * To generate the properties section for a new {@link TeardownFilter}.
	 * 
	 * @param group
	 *            the parent GUI Object
	 */
	private void generatePropertieSectionForTeardown(Group group) {
		// add a selectable label
		String[] items = new String[2];
		items[0] = "dropped values";
		items[1] = "dropped values in percentage";
		final CCombo kindOfValues = getWidgetFactory().createCCombo(group,
				SWT.BORDER);
		kindOfValues.setItems(items);
		kindOfValues.setEditable(false);
		// add a textfield
		final Text txtDroppedValuesPercentage;
		txtDroppedValuesPercentage = getWidgetFactory().createText(group, "",
				SWT.BORDER);
		txtDroppedValuesPercentage.setTextLimit(20);
		// add a button
		Button newFilterButton = getWidgetFactory().createButton(group,
				"Add Teardownfilter", SWT.PUSH);
		newFilterButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				logger.log(Level.INFO, "new teardown filter");
				TeardownFilter newTeardownFilter = null;
				// get the active editor
				ScatterPlotEditor editor = (ScatterPlotEditor) Activator
						.getDefault().getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActiveEditor();
				// get the input of the editor
				ScatterPlotInput input = (ScatterPlotInput) editor
						.getEditorInput();

				if (kindOfValues.getSelectionIndex() == 0) {
					newTeardownFilter = new TeardownFilter(input.getSource(),
							Integer.parseInt(txtDroppedValuesPercentage
									.getText()), 0);

				} else {
					newTeardownFilter = new TeardownFilter(input.getSource(),
							0, Float.parseFloat(txtDroppedValuesPercentage
									.getText()));
				}

				logger.log(Level.INFO, "update editor input begin");
				input = new ScatterPlotInput(newTeardownFilter);
				editor.changeInput(input);
				editor.setFocus();
				logger.log(Level.INFO, "update editor input end");
				updateFilterList();

			}
		});

	}

	/**
	 * Creates and configures the layout of the group for the new TeardownFilter
	 * configurations.
	 * 
	 * @param composite
	 *            the parent GUI Object
	 * @return the GUI Group for the group Teardown Filter
	 */
	private Group createTeardownConfigurationGroup(Composite composite) {
		RowData data = new RowData();
		data.width = 400;
		data.height = 50;

		Group tearDownGroup = getWidgetFactory().createGroup(composite,
				"Teardown Filter");
		tearDownGroup.setLayout(new RowLayout());
		tearDownGroup.setLayoutData(data);
		return tearDownGroup;
	}

	/**
	 * Creates and configures the layout of the group for showing the currently applied transformations.
	 * 
	 * @param composite
	 *            the parent GUI Object
	 * @return the GUI Group for the group applied filters
	 */
	private Group createTransformationGroup(Composite composite) {
		RowData data = new RowData();
		data.width = 450;
		data.height = 125;

		Group filtersGroup = getWidgetFactory().createGroup(composite,
				"Current Transformations");
		RowLayout rl = new RowLayout(SWT.HORIZONTAL);
		rl.spacing = 15;
		filtersGroup.setLayout(rl);
		filtersGroup.setLayoutData(data);
		return filtersGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput
	 * (org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
	}

	/**
	 * To get the corresponding source from the actual used editor.
	 * 
	 * @return the source of the editor input. {@link IDataSink#getSource()} is
	 *         caled for the return value.
	 */
	public IDataSource getSource() {
		// get the active editor
		IEditorPart editor = Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		// get the input of the editor
		IDataSink input = (IDataSink) editor.getEditorInput();
		return input.getSource();
	}

	/**
	 * Update the filter list. It is called, if a new Filter is added with the
	 * button "Add ****filter". If somebody want to add a Filter, this method
	 * have to be called. Before it is called, the input of the editor had to be
	 * changed to the new input.
	 */
	public void updateFilterList() {
		logger.log(Level.INFO, "updateFiltersList");
		ScatterPlotEditor editor = (ScatterPlotEditor) Activator.getDefault()
				.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		ScatterPlotInput input = (ScatterPlotInput) editor.getEditorInput();
		if (input.getSource() instanceof IFilter) {
			logger.log(Level.INFO, "input.getSource() is a IFilter");
			String name = ((IFilter) input.getSource()).getName();
			list.add(name + " (" + counter + ")");
			counter++;
		}

	}

	/**
	 * Refresh the items in the filters properties table. It shows the
	 * properties of the selected filter in the list.
	 */
	private void refreshPropertiesTable() {
		IDataSink editorInput = editor.getEditorInput();
		if (editorInput.getSource() instanceof IFilter) {
			transformationTable.clearAll();
			transformationTable.setItemCount(0);
			int selectedItem = list.getSelectionIndex();
			HashMap<String, Object> map = null;
			
			IFilter tempData = (IFilter) editorInput.getSource();

			// iterate to the element until the element is reached
			for (int i = 1; i < list.getItemCount() - selectedItem; i++) {
				tempData = (IFilter) tempData.getSource();
			}
			// now in tempData is the selected filter
			map = tempData.getProperties();
			// in
			for (Object key : map.keySet()) {
				TableItem item = new TableItem(transformationTable, SWT.NONE);
				item.setText(0, String.valueOf(key));
				item.setText(1, String.valueOf(map.get(key)));

			}
		}

	}

	/**
	 * Update the properties of the selected filter. It use the method
	 * {@link AbstractTransformation#setProperties(HashMap)} to update the
	 * properties from the Filter.
	 * 
	 * @param key
	 *            the key as String.
	 * @param value
	 *            the value as an Object.
	 */
	private void updateProperties(String key, Object value) {
		logger.log(Level.INFO, "update property '" + key + "' : '" + value
				+ "'");
		
		// get the input of the editor
		IDataSink input = editor.getEditorInput();
		
		if (input instanceof IFilter) {
			int selectedItem = list.getSelectionIndex();
			IFilter tempData = (IFilter) input.getSource();

			// iterate to the element until the element is reached
			for (int i = 1; i < list.getItemCount() - selectedItem; i++) {
				tempData = (IFilter) tempData.getSource();
			}
			// now in tempData is the selected filter
			// set the properties
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put(key, value);
			tempData.setProperties(map);

			// update the editor
			logger.log(Level.INFO, "update editor input begin");
			((JFreeChartEditor) editor).updateChart();
			editor.setFocus();
			logger.log(Level.INFO, "update editor input end");
		}

	}

}
