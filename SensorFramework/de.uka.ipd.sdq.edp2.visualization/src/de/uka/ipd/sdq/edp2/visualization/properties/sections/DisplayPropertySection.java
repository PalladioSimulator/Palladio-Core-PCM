package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.HashMap;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColorCellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInputHandle;

/**
 * GUI controls for displaying options of {@link AbstractEditor}s. Shows and
 * allows to edit visual settings of the current Editor in the Eclipse
 * Properties View if an {@link AbstractEditor} is the currently active editor.
 * 
 * @author Roland Richter, Dominik Ernst
 * 
 */
public class DisplayPropertySection implements ISelectionChangedListener,
		ISection {
	/** Logger */
	private static Logger logger = Logger
			.getLogger(DisplayPropertySection.class.getCanonicalName());

	/**
	 * Key, which must be the same as the key under which the ID's / names of
	 * {@link IDataSink}s are stored.
	 */
	private final static String NAME_KEY = "elementName";
	
	private final static String LABEL_KEY = "Label";
	private final static String COLOR_KEY = "Color";

	/**
	 * Composite for all properties of all JFreeCharts
	 */
	private Composite commonPropertiesComposite;
	/**
	 * Composite for the properties of the currently displayed chart.
	 */
	private Composite specificPropertiesComposite;
	/**
	 * The last active editor;
	 */
	private AbstractEditor editor;
	/**
	 * A tree, which contains the editor's inputs and their transformations (as
	 * children)
	 */
	private ListViewer listViewer;

	private Composite composite;

	private IVisualizationInput lastSelectedInput;

	private ISelection selection;

	/**
	 * The table for displaying visual properties of the selected
	 * transformation.
	 */
	private Table visualPropertiesTable;

	/**
	 * Viewer for the table containing the visual properties of the selected
	 * transformation.
	 */
	private TableViewer visualPropertiesTableViewer;

	private IWorkbenchPart part;

	private TabbedPropertySheetPage tabbedPropertySheetPage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		this.tabbedPropertySheetPage = aTabbedPropertySheetPage;
		composite = getWidgetFactory().createFlatFormComposite(parent);
		composite.setBackground(parent.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_BACKGROUND));
		composite.setSize(200, 250);
		createLayout(composite);
		// create empty input list
		listViewer = new InputElementList(composite, SWT.EMBEDDED, null)
				.getListViewer();
		createPropertiesTable(composite);
	}

	private void createPropertiesTable(Composite parent) {

		// initialize the table, which shows the properties of transformations
		visualPropertiesTable = new Table(parent, SWT.SINGLE | SWT.BORDER
				| SWT.V_SCROLL | SWT.FULL_SELECTION);

		visualPropertiesTable.setLinesVisible(true);
		visualPropertiesTable.setHeaderVisible(true);
		
		//table layout
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL,
				GridData.FILL_VERTICAL, false, true, 1, 1);
		gridData.heightHint = 220;
		gridData.widthHint = 230;
		visualPropertiesTable.setLayoutData(gridData);
		TableLayout tableLayout = new TableLayout();
		tableLayout.addColumnData(new ColumnWeightData(2));
		tableLayout.addColumnData(new ColumnWeightData(1));
		visualPropertiesTable.setLayout(tableLayout);
		
		
		Class<?>[] supportedClasses = { String.class, Boolean.class, Color.class,
            Integer.class, Double.class };

		visualPropertiesTableViewer = new TableViewer(visualPropertiesTable);
		TableViewerColumn labelColumn = new TableViewerColumn(
				visualPropertiesTableViewer, SWT.NONE);
		labelColumn.getColumn().setText("Property");

		TableViewerColumn valueColumn = new TableViewerColumn(
				visualPropertiesTableViewer, SWT.NONE);
		valueColumn.getColumn().setText("Value");

		CellEditor[] editors = new CellEditor[10];
		editors[0] = new TextCellEditor(visualPropertiesTable);
		editors[1] = new ColorCellEditor(visualPropertiesTable);
		
		visualPropertiesTableViewer.setCellEditors(editors);
		
		
		// the editor for the cells
		final TableEditor editor = new TableEditor(visualPropertiesTable);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		visualPropertiesTable.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Rectangle clientArea = visualPropertiesTable.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = visualPropertiesTable.getTopIndex();
				while (index < visualPropertiesTable.getItemCount()) {
					boolean visible = false;
					final TableItem item = visualPropertiesTable.getItem(index);

					// look if the mouse event is in an editable cell
					Rectangle rect = item.getBounds(1);
					if (rect.contains(pt)) {
						final int editColumn = 1;
						if (item.getText(0).equals(LABEL_KEY)) {

						}
						final Text text = new Text(visualPropertiesTable,
								SWT.NONE);
						Listener textListener = new Listener() {
							public void handleEvent(final Event e) {
								switch (e.type) {
								case SWT.FocusOut:
									item.setText(editColumn, text.getText());
									text.dispose();
									break;
								case SWT.Traverse:
									switch (e.detail) {
									case SWT.TRAVERSE_RETURN:
										item.setText(editColumn, text.getText());
										// updateProperties(
										// item.getText(0), text.getText());

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

		refreshPropertiesTable();

	}

	private void refreshPropertiesTable() {

		visualPropertiesTable.clearAll();
		visualPropertiesTable.setItemCount(0);

		TableItem labelItem = new TableItem(visualPropertiesTable, SWT.NONE);
		labelItem.setText(0, LABEL_KEY);
		TableItem colorItem = new TableItem(visualPropertiesTable, SWT.NONE);
		colorItem.setText(0, COLOR_KEY);

		/*
		 * HashMap<String, Object> properties = lastSelectedInput
		 * .getProperties();
		 * 
		 * properties.remove(NAME_KEY);
		 * 
		 * for (Object key : properties.keySet()) { TableItem item = new
		 * TableItem(visualPropertiesTable, SWT.NONE); item.setText(0,
		 * String.valueOf(key)); item.setText(1,
		 * String.valueOf(properties.get(key))); }
		 */
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
		this.part = part;
		this.selection = selection;
	}

	/**
	 * Retrieves the input of the last active editor. <code>null</code> if no
	 * editor was active during the current session.
	 * 
	 * @return
	 */
	private IVisualizationInputHandle getInput() {
		return (IVisualizationInputHandle) editor.getEditorInput();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		if (editorExists() && listViewer.getInput() == null) {
			listViewer.setInput(getInput());
			listViewer.addSelectionChangedListener(this);
		}
		if (editorExists()) {
			// the common composite is identical for all IVisualizationInputs
			if (commonPropertiesComposite == null) {
				createCommonChartComposite();
			}
		}
		refreshPropertiesTable();
		listViewer.refresh();
		composite.layout();
	}

	private void createSpecificChartComposite() {
		if (specificPropertiesComposite != null) {
			specificPropertiesComposite.dispose();
		}
		if (lastSelectedInput != null) {
			specificPropertiesComposite = lastSelectedInput
					.getSpecificPropertiesComposite(composite);
		}
	}

	private void createCommonChartComposite() {
		if (commonPropertiesComposite != null) {
			commonPropertiesComposite.dispose();
		}
		commonPropertiesComposite = getInput().getCommonPropertiesComposite(
				composite);
	}

	private void createLayout(Composite composite) {
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		composite.setLayout(layout);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) listViewer
				.getSelection();
		lastSelectedInput = (IVisualizationInput) selection.getFirstElement();
		refresh();
	}

	@Override
	public void aboutToBeHidden() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aboutToBeShown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMinimumHeight() {
		return SWT.DEFAULT;
	}

	private boolean editorExists() {
		IWorkbenchWindow window = Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow();
		if (window == null) {
			editor = null;
			return false;
		} else if (window.getActivePage() == null) {
			editor = null;
			return false;
		} else if (window.getActivePage().getActiveEditor() == null) {
			editor = null;
			return false;
		} else {
			editor = (JFreeChartEditor) window.getActivePage()
					.getActiveEditor();
			return true;
		}
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return false;
	}

	/**
	 * Get the widget factory for the property sheet page.
	 * 
	 * @return the widget factory.
	 */
	public TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return tabbedPropertySheetPage.getWidgetFactory();
	}

}
