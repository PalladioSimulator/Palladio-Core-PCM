package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.AbstractTransformation;
import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.AbstractAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.AbstractFilter;
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
public class TransformationsPropertySection extends AbstractPropertySection
		implements ISelectionChangedListener {
	/** logger */
	private final static Logger logger = Logger
			.getLogger(TransformationsPropertySection.class.getCanonicalName());

	/**
	 * Key which must be the same as the key under which the ID's / names of
	 * {@link AbstractTransformation}s are stored.
	 */
	private final static String NAME_KEY = "elementName";

	/**
	 * A tree, which contains the editor's inputs and their transformations (as
	 * children)
	 */
	private TreeViewer treeViewer;
	/**
	 * A simple counter for the list
	 */
	private int counter = 0;
	/**
	 * The table for displaying attributes of a selected transformation.
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
	
	private AbstractTransformation lastSelection;

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

		/*
		 * try {
		 * 
		 * editor =
		 * Activator.getDefault().getWorkbench().getActiveWorkbenchWindow
		 * ().getActivePage();
		 * 
		 * // NPE may happen if the properties view is restored or opened while
		 * // the editor is still or already closed } catch
		 * (NullPointerException npe) {
		 * 
		 * logger.log(Level.SEVERE,
		 * "Tried to open properties view without an active editor!"); throw new
		 * RuntimeException(); }
		 * 
		 * // set the input to what is actually selected in the editor
		 * setInput(editor, Activator.getDefault().getWorkbench()
		 * .getActiveWorkbenchWindow().getSelectionService().getSelection(
		 * editor.getSite().getId()));
		 */
		// initialize the layout
		createLayout(composite);

		updateEditorReference();
		treeViewer = new InputSelectionTree(composite, SWT.EMBEDDED, editor
				.getEditorInputHandle()).getTreeViewer();

		treeViewer.addSelectionChangedListener(this);

		// initialize the contents of the group
		initTransformationTable(composite);

		final Button buttonAdapter = new Button(composite, SWT.PUSH);
		buttonAdapter.setText("Add new Adapter..");
		buttonAdapter.pack();
		final Button buttonFilter = new Button(composite, SWT.PUSH);
		buttonFilter.setText("Add new Filter..");
		buttonFilter.pack();

		Listener btnListener = new Listener() {

		//TODO fix references on previous transformations etc.
			@Override
			public void handleEvent(Event event) {
				
				if (event.widget == buttonAdapter) {
					AdapterWizard wizard = new AdapterWizard(lastSelection);
					AbstractAdapter adapter = null;
					WizardDialog wdialog = new WizardDialog(Activator
							.getDefault().getWorkbench()
							.getActiveWorkbenchWindow().getShell(), wizard);
					wdialog.open();
					if (wdialog.getReturnCode() == Window.OK) {
						adapter = wizard.getAdapter();
						handleSemanticChange(adapter);
					}

				} else if (event.widget == buttonFilter) {
					FilterWizard wizard = new FilterWizard(lastSelection);
					AbstractFilter filter = null;
					WizardDialog wdialog = new WizardDialog(Activator
							.getDefault().getWorkbench()
							.getActiveWorkbenchWindow().getShell(), wizard);
					wdialog.open();
					if (wdialog.getReturnCode() == Window.OK) {
						filter = wizard.getFilter();
					}
				}

				/*
				 * if (editor instanceof JFreeChartEditor) { ((JFreeChartEditor)
				 * editor).updateChart(); }
				 */
				editor.setFocus();
			}
		};
		buttonAdapter.addListener(SWT.Selection, btnListener);
		buttonFilter.addListener(SWT.Selection, btnListener);

	}

	private void handleSemanticChange(AbstractAdapter adapter) {
		// TODO perform actual check on compatible editors for new input.
		/*
		 * boolean result = MessageDialog .openQuestion(
		 * Activator.getDefault().getWorkbench()
		 * .getActiveWorkbenchWindow().getShell(), "Semantics of Data Changed",
		 * "The applied data transformation cannot be displayed in the current dataset."
		 * +
		 * "A new dataset must be created to replace it. Do you want to proceed?"
		 * );
		 * 
		 * if (result) {
		 * 
		 * IDataSink newInput = new HistogramEditorInput(adapter); }
		 */
	}

	/**
	 * Creates a RowLayout for this section of the properties
	 * 
	 * @param composite
	 *            It is the parent.
	 */
	private void createLayout(Composite composite) {
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 2;
		layout.marginHeight = 2;
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
	private void initTransformationTable(Composite parent) {

		// initialize the table, which shows the properties of transformations
		transformationTable = new Table(parent, SWT.SINGLE | SWT.BORDER
				| SWT.V_SCROLL | SWT.FULL_SELECTION);

		transformationTable.setLinesVisible(true);
		transformationTable.setHeaderVisible(true);
		transformationTable.setLayoutData(new GridData(250,123));
		// set width and height of the table
		//transformationTable.setLayoutData(new RowData(250, 123));
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

	private void updateEditorReference() {
		if (Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
				.getActivePage() == null) {
		} else {
			editor = (AbstractEditor) Activator.getDefault().getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
		}
	}

	/**
	 * Refresh the items in the filters properties table. It shows the
	 * properties of the selected filter in the list.
	 * 
	 * @param abstractTransformation
	 */
	private void refreshPropertiesTable() {

		transformationTable.clearAll();
		transformationTable.setItemCount(0);

		HashMap<String, Object> properties = lastSelection
				.getProperties();

		properties.remove(NAME_KEY);

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
		// get properties for keys and old values
		HashMap<String, Object> newProperties = lastSelection.getProperties();
		logger.log(Level.INFO, ""+lastSelection.getName()+" updated with: "+key.toString()+", " + value.toString());
		newProperties.put(key, value);
		lastSelection.setProperties(newProperties);
		lastSelection.transformData();

		((JFreeChartEditor) editor).updateChart();
		editor.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		treeViewer.refresh();
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		ITreeSelection selection = (ITreeSelection) event
				.getSelectionProvider().getSelection();
		if (selection.getFirstElement() instanceof AbstractTransformation) {
			lastSelection = (AbstractTransformation) selection.getFirstElement();
			refreshPropertiesTable();
		}
	}

}
