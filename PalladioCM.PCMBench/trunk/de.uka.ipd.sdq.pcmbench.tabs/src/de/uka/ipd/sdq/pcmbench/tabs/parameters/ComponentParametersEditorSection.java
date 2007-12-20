/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs.parameters;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.dialogs.stoex.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * @author Roman Andrej
 *
 */
public class ComponentParametersEditorSection extends EditorSection {
	
	private VariableUsage selectedVariableUsage;

	public static final int ICON_COLUMN_INDEX = 0;
	public static final int VARIABLE_COLUMN_INDEX = 1;
	public static final int STOEX_COLUMN_INDEX = 2;
	
	/**
	 * Columns of a table, which is used into operations table
	 */
	public final static String PARAMETERS_ICON_COLUMN	= "";
	public final static String VARIABLE_COLUMN 			= "Variable Name";
	public final static String STOEX_COLUMN 			= "Specification";
	
	//	 Set column names of Tabele
	public static String[] columnNames = new String[] { PARAMETERS_ICON_COLUMN,
			VARIABLE_COLUMN, STOEX_COLUMN };
	
	public ComponentParametersEditorSection(Composite composite) {
		super(composite);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.EditorSection#createTable(org.eclipse.swt.widgets.Composite, org.eclipse.swt.widgets.ToolBar)
	 */
	@Override
	protected Table createTable(Composite composite, ToolBar toolBar) {
		// style the style of table to construct
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		Table table = new Table(composite, style);

		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 0);
		formData.right = new FormAttachment(toolBar, 6);
		formData.top = new FormAttachment(0, 0);
		formData.bottom = new FormAttachment(100, 0);

		table.setLayoutData(formData);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		final TableColumn iconColumn = new TableColumn(table, SWT.NONE);
		iconColumn.setWidth(25);
		iconColumn.setText(PARAMETERS_ICON_COLUMN);

		final TableColumn variableColumn = new TableColumn(table, SWT.NONE);
		variableColumn.setWidth(240);
		variableColumn.setText(VARIABLE_COLUMN);

		final TableColumn stoexColumn = new TableColumn(table, SWT.CENTER);
		stoexColumn.setWidth(100);
		stoexColumn.setText(STOEX_COLUMN);
		
		return table;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.EditorSection#createViewer(org.eclipse.swt.widgets.Table)
	 */
	@Override
	protected TableViewer createViewer(Table table) {
		
		final TableViewer viewer = new TableViewer(table);
		viewer.setUseHashlookup(true);
		viewer.setColumnProperties(columnNames);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];

		CellEditor textEditor = new TextCellEditor(table);
		editors[VARIABLE_COLUMN_INDEX] = textEditor;

		editors[STOEX_COLUMN_INDEX] = new DialogCellEditor(table) {

			/* (non-Javadoc)
			 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
			 */
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				Assert.isNotNull(selectedVariableUsage);
				EList<VariableCharacterisation> characterisations = selectedVariableUsage
						.getVariableCharacterisation_VariableUsage();
				RandomVariable randVar = (RandomVariable) characterisations
						.get(0).getSpecification_VariableCharacterisation();
				StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(
						cellEditorWindow.getShell(), getExpectedType(randVar),
						randVar);
				dialog.setInitialExpression(randVar);
				dialog.open();
				if (dialog.getReturnCode() == Dialog.OK) {
					return new PCMStoExPrettyPrintVisitor().prettyPrint(dialog
							.getResult());
				}

				return null;
			}
		};

		// Assign the cell editors to the viewe
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new ComponentParametersCellModifier());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (!event.getSelection().isEmpty()) {
					getDeleteButton().setEnabled(true);
					
					IStructuredSelection selection = (IStructuredSelection) event
							.getSelection();
					Object selected = selection.getFirstElement();
					
					Assert.isTrue(selected instanceof VariableUsage);

					selectedVariableUsage = (VariableUsage) selected;
				} else
					getDeleteButton().setEnabled(false);
			}
		});
		return viewer;
	}

	/**
	 * @return the selectedVariableUsage
	 */
	public VariableUsage getSelectedVariableUsage() {
		return selectedVariableUsage;
	}
	
	protected TypeEnum getExpectedType(RandomVariable rv) {
		TypeEnum expectedType = TypeEnum.ANY; 
		if (rv instanceof VariableCharacterisation){
			expectedType = StochasticExpressionEditDialog.getTypeFromVariableCharacterisation((VariableCharacterisation) rv);
		}
		return expectedType;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createAddButtonActionListener(java.lang.Object)
	 */
	@Override
	protected SelectionListener createAddButtonActionListener(Object input) {
		return new AddComponentParameterAction((AssemblyContext) input);
	}
}
