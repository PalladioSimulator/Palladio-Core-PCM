package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.awt.Color;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uka.ipd.sdq.edp2.visualization.AbstractTransformation;
import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;
import de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;

/**
 * GUI controls for displaying options of {@link JFreeChartEditor}s. Shows and
 * allows to edit visual settings of the current Editor in the Eclipse
 * Properties View if an {@link JFreeChartEditor} is the currently active editor.
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

	/**
	 * Composite for all properties of all JFreeCharts
	 */
	private CommonJFreeChartPropertiesComposite commonPropertiesComposite;
	/**
	 * The last active editor;
	 */
	private JFreeChartEditor editor;
	/**
	 * A tree, which contains the editor's inputs and their transformations (as
	 * children)
	 */
	private ListViewer listViewer;

	/**
	 * The basic composite in this section.
	 */
	private Composite composite;

	/**
	 * The last selected input, the properties of which are displayed in the
	 * table.
	 */
	private IVisualizationInput lastSelectedInput;

	/**
	 * The table for displaying visual properties of the selected
	 * transformation.
	 */
	private Table visualPropertiesTable;

	/**
	 * Index of the column in the {@link #visualPropertiesTable} containing the
	 * properties' labels.
	 */
	private static int labelColumn = 0;
	/**
	 * Index of the column in the {@link #visualPropertiesTable} containing the
	 * properties' editable values.
	 */
	private static int editColumn = 1;

	/**
	 * Viewer for the table containing the visual properties of the selected
	 * transformation.
	 */
	private TableViewer visualPropertiesTableViewer;

	/**
	 * The property sheet page containing this section.
	 */
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
		composite.setSize(500, 250);
		createLayout(composite);

		Group groupSpecific = new Group(composite, SWT.NONE);
		groupSpecific.setText("Data Series Options");
		groupSpecific.setLayout(new GridLayout(3, false));

		// create empty input list
		listViewer = new InputElementList(groupSpecific, SWT.EMBEDDED, null)
				.getListViewer();
		Label arrowLabel = new Label(groupSpecific, SWT.EMBEDDED);
		arrowLabel.setText("-->");
		createPropertiesTable(groupSpecific);
	}

	private void createPropertiesTable(Composite parent) {

		// initialize the table, which shows the properties of transformations
		visualPropertiesTable = new Table(parent, SWT.SINGLE | SWT.BORDER
				| SWT.V_SCROLL | SWT.FULL_SELECTION);

		visualPropertiesTable.setLinesVisible(true);
		visualPropertiesTable.setHeaderVisible(true);

		// set the table layout
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gridData.heightHint = 168;
		gridData.widthHint = 250;
		visualPropertiesTable.setLayoutData(gridData);

		TableLayout tableLayout = new TableLayout();
		tableLayout.addColumnData(new ColumnWeightData(2));
		tableLayout.addColumnData(new ColumnWeightData(1));
		visualPropertiesTable.setLayout(tableLayout);

		visualPropertiesTableViewer = new TableViewer(visualPropertiesTable);
		TableViewerColumn keyColumn = new TableViewerColumn(
				visualPropertiesTableViewer, SWT.NONE);
		keyColumn.getColumn().setText("Property");

		TableViewerColumn valueColumn = new TableViewerColumn(
				visualPropertiesTableViewer, SWT.NONE);
		valueColumn.getColumn().setText("Value");

		// the editor for the cells

		visualPropertiesTable.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Rectangle clientArea = visualPropertiesTable.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = visualPropertiesTable.getTopIndex();
				while (index < visualPropertiesTable.getItemCount()) {
					boolean visible = false;
					TableItem item = visualPropertiesTable.getItem(index);
					// look if the mouse event is in the editable column
					Rectangle rect = item.getBounds(editColumn);
					if (rect.contains(pt)) {
						// color properties
						if (item.getText(labelColumn).equals(
								JFreeChartEditorInput.COLOR_KEY)) {
							openColorAndTransparencyDialog(item,
									visualPropertiesTable.getShell());
							// boolean properties
						} else if (item.getText(labelColumn).equals(
								HistogramEditorInput.ABSOLUTE_FREQUENCY_KEY)
								|| (item.getText(labelColumn)
										.equals(HistogramEditorInput.SHOW_ITEM_VALUES_KEY))) {
							openBooleanDialog(index);
						}
						// textual properties
						else {
							openTextDialog(index);
						}
						refreshPropertiesTable();
						return;
					}
					if (!visible && rect.intersects(clientArea)) {
						visible = true;
					}
					if (!visible)
						return;
					index++;
				}
			}
		});

	}

	protected void openTextDialog(final int index) {
		final TableEditor editor = new TableEditor(visualPropertiesTable);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;

		final Text text = new Text(visualPropertiesTable, SWT.NONE);
		Listener textListener = new Listener() {
			public void handleEvent(final Event e) {
				switch (e.type) {
				case SWT.FocusOut:
					text.dispose();
					e.doit = false;
					break;
				case SWT.Traverse:
					switch (e.detail) {
					case SWT.TRAVERSE_RETURN:
						visualPropertiesTable.getItem(index).setText(editColumn, text.getText());
						updateProperties(visualPropertiesTable.getItem(index).getText(labelColumn),
								text.getText());
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
		editor.setEditor(text, visualPropertiesTable.getItem(index), editColumn);
		text.setText(visualPropertiesTable.getItem(index).getText(editColumn));
		text.selectAll();
		text.setFocus();
	}

	protected void openBooleanDialog(final int index) {
		TableEditor editor = new TableEditor(visualPropertiesTable);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		final Combo comboBox = new Combo(visualPropertiesTable, SWT.DROP_DOWN);
		comboBox.setItems(new String[] { "true", "false" });
		//set the currently selected item to the value stored in the cell
		comboBox.select(visualPropertiesTable.getItem(index).getText(editColumn).equals("true") ? 0 : 1);

		final String key = visualPropertiesTable.getItem(index).getText(labelColumn);
		comboBox.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				visualPropertiesTable.getItem(index).setText(editColumn,
						comboBox.getItem(comboBox.getSelectionIndex()));
				updateProperties(key,
						comboBox.getItem(comboBox.getSelectionIndex()));
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				comboBox.dispose();
			}
		});
		comboBox.addListener(SWT.FocusOut, new Listener() {
			@Override
			public void handleEvent(Event event) {
				comboBox.dispose();
				event.doit = false;
				return;

			}
		});
		editor.setEditor(comboBox, visualPropertiesTable.getItem(index), editColumn);

	}

	protected void openColorAndTransparencyDialog(TableItem item, Shell shell) {
		ColorDialog colorPicker = new ColorDialog(
				visualPropertiesTable.getShell());
		colorPicker.setRGB(item.getBackground().getRGB());
		RGB rgbColor = colorPicker.open();
		if (rgbColor != null) {
			item.setBackground(editColumn, new org.eclipse.swt.graphics.Color(
					visualPropertiesTable.getDisplay(), rgbColor));
			updateProperties(
					item.getText(labelColumn),
					"#"
							+ Integer.toHexString(
									new Color(rgbColor.red, rgbColor.green,
											rgbColor.blue).getRGB()).substring(
									2));
		}

	}

	private void refreshPropertiesTable() {

		visualPropertiesTable.clearAll();
		visualPropertiesTable.setItemCount(0);

		HashMap<String, Object> properties = lastSelectedInput.getProperties();

		properties.remove(NAME_KEY);

		for (Object key : properties.keySet()) {
			TableItem item = new TableItem(visualPropertiesTable, SWT.NONE);
			item.setText(0, String.valueOf(key));
			item.setText(1, String.valueOf(properties.get(key)));
			if (String.valueOf(key).equals(JFreeChartEditorInput.COLOR_KEY)) {
				String hexColor = String.valueOf(properties.get(key));
				if (hexColor.equals(JFreeChartEditorInput.NO_COLOR)) {
					item.setText(1, "(default)");
				} else {
					item.setText(1, "");
					Color col = Color.decode(hexColor);
					item.setBackground(1, new org.eclipse.swt.graphics.Color(
							visualPropertiesTable.getDisplay(), col.getRed(),
							col.getGreen(), col.getBlue()));
				}
			}
		}

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
		// this.part = part;
		// this.selection = selection;
	}

	/**
	 * Retrieves the input of the last active editor. <code>null</code> if no
	 * editor was active during the current session.
	 * 
	 * @return
	 */
	private IVisualizationInputHandle<?> getInput() {
		return (IVisualizationInputHandle<?>) editor.getEditorInput();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		if (editorExists()) {
			// the common composite is identical for all IVisualizationInputs
			if (commonPropertiesComposite == null) {
				createCommonChartComposite();
			}
		}
		if (editorExists() && listViewer.getInput() == null) {
			listViewer.setInput(getInput());
			listViewer.addSelectionChangedListener(this);
		}
		listViewer.refresh();
		composite.layout();
	}

	private void createCommonChartComposite() {
		if (commonPropertiesComposite != null) {
			commonPropertiesComposite.dispose();
		}
		commonPropertiesComposite = (CommonJFreeChartPropertiesComposite) getInput()
				.getCommonPropertiesComposite(composite);
	}

	private void createLayout(Composite composite) {
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) listViewer
				.getSelection();
		lastSelectedInput = (IVisualizationInput) selection.getFirstElement();
		if (lastSelectedInput != null)
			refreshPropertiesTable();
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

	/**
	 * Update the properties of the selected input. Uses
	 * {@link AbstractTransformation#setProperties(HashMap)} to update the
	 * properties.
	 * 
	 * @param key
	 *            the key of the updated value as a String.
	 * @param value
	 *            the value as an Object.
	 */
	private void updateProperties(String key, Object value) {
		// get properties for keys and old values
		HashMap<String, Object> newProperties = lastSelectedInput
				.getProperties();
		logger.log(Level.INFO, "" + lastSelectedInput.getInputName()
				+ " updated with: " + key.toString() + ", " + value.toString());
		newProperties.put(key, value);
		lastSelectedInput.setProperties(newProperties);
		// update the input
		lastSelectedInput.updateInputData();
	}

}
