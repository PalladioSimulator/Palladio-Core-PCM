package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;

/**
 * GUI controls for displaying options of {@link AbstractEditor}s. Shows and
 * allows to edit visual settings of the current Editor in the Eclipse
 * Properties View if an {@link AbstractEditor} is the currently active editor.
 * 
 * @author Roland Richter, Dominik Ernst
 * 
 */
public class DisplayPropertySection extends AbstractPropertySection {
	/** Logger */
	private static Logger logger = Logger
			.getLogger(DisplayPropertySection.class.getCanonicalName());

	/**
	 * Key which must be the same as the key under which the ID's / names of
	 * {@link IDataSink}s are stored.
	 */
	private final static String NAME_KEY = "elementName";
	/**
	 * The current input of the
	 */
	private JFreeChartEditorInput editorInput;
	/**
	 * The table to show all modifiable attributes.
	 */
	private Table propertyTable;
	/**
	 * Viewer for the {@code propertyTable};
	 */
	private TableViewer propertyTableViewer;
	/**
	 * The last active editor;
	 */
	private AbstractEditor editor;

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
		super.createControls(parent, aTabbedPropertySheetPage);

		Composite composite = getWidgetFactory()
				.createFlatFormComposite(parent);

		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.spacing = 2;
		layout.justify = true;
		layout.pack = true;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		layout.wrap = true;
		composite.setLayout(layout);

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

		propertyTable = new Table(composite, SWT.SINGLE | SWT.BORDER
				| SWT.V_SCROLL | SWT.FULL_SELECTION);

		propertyTable.setLinesVisible(true);
		propertyTable.setHeaderVisible(true);
		// set width and hight from the table
		propertyTable.setLayoutData(new RowData(300, 150));
		// set the weight of the table columns
		TableLayout tableLayout = new TableLayout();
		tableLayout.addColumnData(new ColumnWeightData(2));
		tableLayout.addColumnData(new ColumnWeightData(1));
		propertyTable.setLayout(tableLayout);

		propertyTableViewer = new TableViewer(propertyTable);
		TableViewerColumn labelColumn = new TableViewerColumn(
				propertyTableViewer, SWT.NONE);
		labelColumn.getColumn().setText("Property");

		TableViewerColumn valueColumn = new TableViewerColumn(
				propertyTableViewer, SWT.NONE);
		valueColumn.getColumn().setText("Value");
		
		// the editor for the cells
		final TableEditor tableEditor = new TableEditor(propertyTable);
		tableEditor.horizontalAlignment = SWT.LEFT;
		tableEditor.grabHorizontal = true;
		propertyTable.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Rectangle clientArea = propertyTable.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = propertyTable.getTopIndex();
				while (index < propertyTable.getItemCount()) {
					boolean visible = false;
					final TableItem item = propertyTable.getItem(index);

					// look if the mouse event is in an editable cell
					Rectangle rect = item.getBounds(1);
					if (rect.contains(pt)) {
						final int column = 1;
						final Text text = new Text(propertyTable, SWT.NONE);
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
										updateEditorSettings(item.getText(0),
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
						tableEditor.setEditor(text, item, 1);
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

		// get the current chart's settings and add them to the table
		refreshSettingsTable();
		

		/* This is the predefined Editor for JFreeChart properties in Swing - maybe usable??
		Composite swtAwtComponent = new Composite(parent, SWT.EMBEDDED);
		Frame frame = SWT_AWT.new_Frame( swtAwtComponent );
		Panel parentPanel = new Panel();
		frame.add(parentPanel);
		ChartEditorFactory editorFactory = new DefaultChartEditorFactory();
		ChartEditor chartEditor = editorFactory.createEditor(((JFreeChartEditorInput) getInput()).getChart());
		
		parentPanel.add((Component) chartEditor);
		*/
		
	}

	/**
	 * Method which handles the change of values in the table and updates the
	 * editor in accordance. TODO currently assumes the only possible editors to
	 * be {@link JFreeChartEditor}s.
	 * 
	 * @param key
	 *            The key of the changed property.
	 * @param value
	 *            The new values of the property.
	 */
	private void updateEditorSettings(String key, String value) {
		HashMap<String, Object> newProperties = getInput().getProperties();
		newProperties.put(key, value);
		getInput().setProperties(newProperties);
		// assumption: JFreeChartEditor
		((JFreeChartEditor) editor).updateChart();
		refreshSettingsTable();
		editor.setFocus();
	}

	/**
	 * Method which updates the {@code propertyTable}.
	 */
	private void refreshSettingsTable() {
		// clear the table
		propertyTable.clearAll();
		propertyTable.setItemCount(0);

		// retrieve the properties of the editor input
		HashMap<String, Object> properties = getInput().getProperties();

		// list of properties should not contain the element's identifier
		// (cannot and must not be modified)
		properties.remove(NAME_KEY);

		// write property key-value-pairs into table
		for (Object key : properties.keySet()) {
			TableItem item = new TableItem(propertyTable, SWT.NONE);
			item.setText(0, String.valueOf(key));
			item.setText(1, String.valueOf(properties.get(key)));
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
		super.setInput(part, selection);
	}

	/**
	 * Retrieves the input of the currently active editor.
	 * 
	 * @return the current {@link IDataSink}
	 */
	public IDataSink getInput() {
		editor = (AbstractEditor) Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IDataSink input = editor.getEditorInput();
		return input;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		refreshSettingsTable();
	}

}
