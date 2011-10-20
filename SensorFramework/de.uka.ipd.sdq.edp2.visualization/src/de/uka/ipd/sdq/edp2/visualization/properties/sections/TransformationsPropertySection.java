package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
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
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
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
import de.uka.ipd.sdq.edp2.visualization.wizards.AdapterWizard;
import de.uka.ipd.sdq.edp2.visualization.wizards.FilterWizard;

/**
 * GUI controls for {@link AbstractTransformation}s. Used to display and edit
 * properties of applied data transformations in the Eclipse Properties View if
 * an {@link AbstractEditor} is the currently active editor.
 * 
 * @author Roland Richter, Dominik Ernst
 * 
 */
public class TransformationsPropertySection extends AbstractPropertySection {
	/** logger */
	private final static Logger logger = Logger
			.getLogger(TransformationsPropertySection.class.getCanonicalName());

	/**
	 * Key which must be the same as the key under which the ID's / names of
	 * {@link AbstractTransformation}s are stored.
	 */
	private final static String NAME_KEY = "elementName";

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
	 * The current editor which is an
	 * {@link ITabbedPropertySheetPageContributor}.
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

		try {
			// properties view is only visible for abstract editors, so no type
			// check is necessary
			editor = (AbstractEditor) Activator.getDefault().getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			// NPE may happen if the properties view is restored or opened while
			// the editor is still or already closed
		} catch (NullPointerException npe) {
			
			logger.log(Level.SEVERE,
					"Tried to open properties view without an active editor!");
			throw new RuntimeException();
		}

		// set the input to what is actually selected in the editor
		setInput(editor, Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getSelectionService().getSelection(
						editor.getSite().getId()));

		// initialize the layout
		createLayout(composite);

		// generate the group for the applied transformations
		Group transformationGroup = createTransformationGroup(composite);

		// initialize the contents of the group
		initTransformationTable(transformationGroup);

		final Button buttonAdapter = new Button(composite, SWT.PUSH);
		buttonAdapter.setText("Add new Adapter..");
		buttonAdapter.pack();
		final Button buttonFilter = new Button(composite, SWT.PUSH);
		buttonFilter.setText("Add new Filter..");
		buttonFilter.pack();

		Listener btnListener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				IDataSink input = editor.getEditorInput();
				if (event.widget == buttonAdapter) {
					AdapterWizard wizard = new AdapterWizard(getSource());
					IAdapter adapter = null;
					WizardDialog wdialog = new WizardDialog(Activator
							.getDefault().getWorkbench()
							.getActiveWorkbenchWindow().getShell(), wizard);
					wdialog.open();
					if (wdialog.getReturnCode() == Window.OK) {
						adapter = wizard.getAdapter();
						handleSemanticChange(adapter);
					}

				} else if (event.widget == buttonFilter) {
					FilterWizard wizard = new FilterWizard(getSource());
					IFilter filter = null;
					WizardDialog wdialog = new WizardDialog(Activator
							.getDefault().getWorkbench()
							.getActiveWorkbenchWindow().getShell(), wizard);
					wdialog.open();
					if (wdialog.getReturnCode() == Window.OK) {
						filter = wizard.getFilter();
						input.setSource(filter);
					}
				}

				if (editor instanceof JFreeChartEditor) {
					((JFreeChartEditor) editor).updateChart();
				}
				editor.setFocus();
				updateTransformationsList();
			}
		};
		buttonAdapter.addListener(SWT.Selection, btnListener);
		buttonFilter.addListener(SWT.Selection, btnListener);
		updateTransformationsList();

	}

	private void handleSemanticChange(IAdapter adapter) {
		// TODO perform actual check on compatible editors for new input.
		boolean result = MessageDialog
				.openQuestion(
						Activator.getDefault().getWorkbench()
								.getActiveWorkbenchWindow().getShell(),
						"Semantics of Data Changed",
						"The applied data transformation cannot be displayed in the current editor."
								+ "It will be closed and a new Editor is opened. Do you want to proceed?");

		if (result) {
			IDataSink newInput = new HistogramEditorInput(adapter);
			Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().closeEditor(editor, false);
			try {
				editor = (AbstractEditor) Activator
						.getDefault()
						.getWorkbench()
						.getActiveWorkbenchWindow()
						.getActivePage()
						.openEditor(newInput,
								"de.uka.ipd.sdq.edp2.visualization.editors.Histogram");

			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	 * {@link TransformationsPropertySection#refreshPropertiesTable()} is
	 * called. A listener look for the properties table and call
	 * {@link TransformationsPropertySection#updateProperties(String, Object)}
	 * of the value field is let out by pressing ENTER.
	 * 
	 * @param parentGroup
	 *            the parent GUI Object
	 */
	private void initTransformationTable(Group parentGroup) {
		// initialize the list of transformations with a selection listener
		list = new List(parentGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
		list.setLayoutData(new RowData(175, 140));
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
		transformationTable.setLayoutData(new RowData(250, 123));
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
						final Text text = new Text(transformationTable,
								SWT.NONE);
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
	 * Creates and configures the layout of the group for showing the currently
	 * applied transformations.
	 * 
	 * @param composite
	 *            the parent GUI Object
	 * @return the GUI Group for the group applied filters
	 */
	private Group createTransformationGroup(Composite composite) {
		RowData data = new RowData();
		data.width = 550;
		data.height = 155;

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
		editor = (AbstractEditor) Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IDataSink input = editor.getEditorInput();
		return input.getSource();
	}

	/**
	 * Update the filter list. It is called, if a new Filter is added with the
	 * button "Add ****filter". If somebody want to add a Filter, this method
	 * have to be called. Before it is called, the input of the editor had to be
	 * changed to the new input.
	 */
	public void updateTransformationsList() {

		AbstractTransformation transformation = null;

		if (!list.isDisposed()) {
			list.removeAll();

			counter = 0;

			// check if there are any transformations at all
			if (getSource() instanceof AbstractTransformation) {
				transformation = (AbstractTransformation) getSource();
				list.add(transformation.getName());
				counter++;
				// iterate over remaining transformations
				while (transformation.getSource() instanceof AbstractTransformation) {
					transformation = (AbstractTransformation) transformation
							.getSource();
					list.add(transformation.getName());
					counter++;
				}
			}
			logger.log(Level.INFO, "Number of transformations: " + counter);
		}

	}

	/**
	 * Refresh the items in the filters properties table. It shows the
	 * properties of the selected filter in the list.
	 */
	private void refreshPropertiesTable() {
		// clear the table
		transformationTable.clearAll();
		transformationTable.setItemCount(0);

		// get the index of the selected transformation
		AbstractTransformation selectedTransformation = (AbstractTransformation) getSource();
		int selection = list.getSelectionIndex();
		int i = 0;

		// iterate to the selected item over the editor input's source-chain
		while (i < selection) {
			i++;
			selectedTransformation = (AbstractTransformation) selectedTransformation
					.getSource();
		}

		// retrieve the properties of the selected transformation
		HashMap<String, Object> properties = selectedTransformation
				.getProperties();

		// list of properties should not contain the element's identifier
		// (cannot and must not be modified)
		properties.remove(NAME_KEY);

		// write property key-value-pairs into table
		for (Object key : properties.keySet()) {
			TableItem item = new TableItem(transformationTable, SWT.NONE);
			item.setText(0, String.valueOf(key));
			item.setText(1, String.valueOf(properties.get(key)));
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

		// get the index of the selected transformation
		AbstractTransformation selectedTransformation = (AbstractTransformation) getSource();
		int selection = list.getSelectionIndex();
		int i = 0;

		// iterate to the selected item over the editor inputs source-chain
		while (i < selection) {
			i++;
			selectedTransformation = (AbstractTransformation) selectedTransformation
					.getSource();
		}

		// get properties for keys and old values
		HashMap<String, Object> newProperties = selectedTransformation
				.getProperties();
		newProperties.put(key, value);
		selectedTransformation.setProperties(newProperties);
		selectedTransformation.transformData();

		((JFreeChartEditor) editor).updateChart();
		editor.setFocus();
		refreshPropertiesTable();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		updateTransformationsList();
	}

}
