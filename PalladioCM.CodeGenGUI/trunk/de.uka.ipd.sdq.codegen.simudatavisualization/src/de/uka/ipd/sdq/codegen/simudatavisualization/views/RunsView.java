/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

/**
 * @author admin
 *
 */
public class RunsView extends ViewPart {

	public static TableViewer viewer;

	private String[] columnNames = new String[] { ICON_COLUMN,RUN_DATA_COLUMN};

	public final static String ICON_COLUMN	= "";
	public final static String RUN_DATA_COLUMN 	= "ExperimentDateTime";
	
	
	public RunsView() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(createTable(parent));
		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new TableViewContentProvider());
		viewer.setLabelProvider(new TableViewerLabelProvider());

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public Table createTable(Composite composite) {

		// style the style of table to construct
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		Table table = new Table(composite, style);

		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);

		table.setLayoutData(data);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// 1st column
		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("");
		column.setWidth(25);

		// n-te column with task Description
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText((String) columnNames[1]);
		column.setWidth(200);
		
		return table;
	}

}
