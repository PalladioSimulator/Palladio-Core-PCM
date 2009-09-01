package de.fzi.stanja.ui.preferences;

import java.util.List;


import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import de.fzi.stanja.ui.StanjaUiConstants;

/**
 * implements the analyzer table and table view in the preferences. 
 * @author Christina Pildner
 *
 */

public class AnalyzerFieldEditor extends FieldEditor {
	
	private Composite parent;
	
	private TableViewer tableViewer;
	private String[] tableColumnNames;
	private Table table;
	/**
	 * the list of the preference analyzer.
	 * the value of the active boolean are saved in the preference store 
	 */
	private final List<PreferenceAnalyzer> analyzers = PreferenceAnalyzer.getAnalyzerlist();
	private final IPreferenceStore store = StanjaUiConstants.STANJA_UI_PREFERENCE_STORE;
		
	public AnalyzerFieldEditor(String name, String labelText, Composite parent){
		init(name, labelText);
		this.parent = parent;
		this.tableColumnNames = new String[]{"", "Analyzer Name", "AnalyzerId " };
        createControl(parent);
		
	
	}
 
	@Override
	protected void adjustForNumColumns(int numColumns) {
		/* the same number of colums as the preferencepage */
		 ((GridData)table.getParent().getLayoutData()).horizontalSpan = numColumns; 
		
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		getLabelControl(parent);
		createTable();		
		createTableViewer();
		GridData gridData = new GridData();
		
		gridData.horizontalAlignment = GridData.FILL;
        int widthHint = convertHorizontalDLUsToPixels(table.getParent(),
                IDialogConstants.BUTTON_WIDTH);
        gridData.widthHint = Math.max(widthHint, table.getParent().computeSize(
                SWT.DEFAULT, SWT.DEFAULT, true).x);
        /*adapt the layout to the  */
        table.getParent().setLayoutData(gridData);
  	
	}
	
	private void createTable(){
		/*new composite for the table*/
		Composite tableComposite = new Composite(parent,SWT.NONE);
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION | SWT.VIRTUAL ;
		GridLayout layout = new GridLayout(2,false);
		layout.marginWidth = 0;
		tableComposite.setLayout(layout);
					
		table = new Table (tableComposite, style);
		GridData tableGridData = new GridData (SWT.FILL, SWT.FILL, true, true);
		tableGridData.grabExcessVerticalSpace = true;
		//tableGridData.heightHint=50;
		table.setLayoutData(tableGridData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
	
				
		/*1st column: analyzer active*/
		TableColumn columnActive = new TableColumn(table, SWT.CENTER);
		columnActive.setText(this.tableColumnNames[0]);
		columnActive.setWidth(30);

		/* 2nd column: analyzer name*/ 
		TableColumn columnAnalyzerName = new TableColumn(table, SWT.LEFT);
		columnAnalyzerName.setText(this.tableColumnNames[1]);
		columnAnalyzerName.setWidth(150);
		
		/* 3rd column: analyzer id*/ 
		TableColumn columnAnalyzerId = new TableColumn(table, SWT.LEFT);
		columnAnalyzerId.setText(this.tableColumnNames[2]);
		columnAnalyzerId.setWidth(250);
		
		
		
	}
	
	private void createTableViewer(){
		this.tableViewer = new TableViewer(table);
		this.tableViewer.setUseHashlookup(true);
		this.tableViewer.setColumnProperties(new String[]{"active", "name", "id"});

		/* create and set  the cell editors*/
		CellEditor[] editors = { new CheckboxCellEditor(this.table), null,  null};
		this.tableViewer.setCellEditors(editors);
		this.tableViewer.setContentProvider(new AnalyzerTableContentProvider());
		this.tableViewer.setLabelProvider(new AnalyzerLabelProvider(this.tableViewer));
		this.tableViewer.setCellModifier(new AnalyzerCellModifier(this.tableViewer));
		this.tableViewer.setInput(analyzers);
	}

	@Override
	protected void doLoad() {
	}

	@Override
	protected void doLoadDefault() {
	}

	@Override
	protected void doStore() {
		for(PreferenceAnalyzer analyzer : analyzers){
			store.setValue("ANALYZER_"+analyzer.getId(), analyzer.isActive());
			//System.out.println("Name: "+analyzer.getId()+" - Value: "+analyzer.isActive());
		}
	}
	
	
	@Override
	public int getNumberOfControls() {
		return 1;
	}

	class AnalyzerTableContentProvider implements IStructuredContentProvider{

		@Override
		public Object[] getElements(Object inputElement) {
			return analyzers.toArray();
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}
