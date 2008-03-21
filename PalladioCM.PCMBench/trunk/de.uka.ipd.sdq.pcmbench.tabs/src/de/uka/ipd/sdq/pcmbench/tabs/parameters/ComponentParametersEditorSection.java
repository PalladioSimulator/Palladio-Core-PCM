/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs.parameters;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

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
	
	public static final int ICON_COLUMN_INDEX = 0;
	public static final int VARIABLE_COLUMN_INDEX = 1;
	public static final int STOEX_COLUMN_INDEX = 2;
	
	/**
	 * Columns of a table, which is used into operations table
	 */
	public final static String PARAMETERS_ICON_COLUMN	= "";
	public final static String VARIABLE_COLUMN 			= "Variable Name";
	public final static String STOEX_COLUMN 			= "Specification";
	
	/** Set column names of Tabele. */
	public static String[] columnNames = new String[] { PARAMETERS_ICON_COLUMN,
			VARIABLE_COLUMN, STOEX_COLUMN };
	/** Define the listener for Add-Button. */
	private AddComponentParameterAction addButtonListener;
	
	public ComponentParametersEditorSection(Composite composite) {
		super(composite);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createAddButtonActionListener(java.lang.Object)
	 */
	@Override
	protected SelectionListener createAddButtonActionListener() {
		addButtonListener = new AddComponentParameterAction();
		return addButtonListener;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createDeleteButtonListener()
	 */
	@Override
	protected SelectionListener createDeleteButtonListener() {
		return new DeleteComponentParameterAction();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createTableColumns(org.eclipse.swt.widgets.Table)
	 */
	@Override
	protected void createTableColumns(Table table) {
		final TableColumn iconColumn = new TableColumn(table, SWT.NONE);
		iconColumn.setWidth(25);
		iconColumn.setText(PARAMETERS_ICON_COLUMN);

		final TableColumn variableColumn = new TableColumn(table, SWT.NONE);
		variableColumn.setWidth(240);
		variableColumn.setText(VARIABLE_COLUMN);

		final TableColumn stoexColumn = new TableColumn(table, SWT.CENTER);
		stoexColumn.setWidth(100);
		stoexColumn.setText(STOEX_COLUMN);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createViewerCellEditors(org.eclipse.swt.widgets.Table)
	 */
	@Override
	protected CellEditor[] createViewerCellEditors(Table table) {
		CellEditor[] editors = new CellEditor[columnNames.length];

		CellEditor textEditor = new TextCellEditor(table);
		editors[VARIABLE_COLUMN_INDEX] = textEditor;

		editors[STOEX_COLUMN_INDEX] = new DialogCellEditor(table) {

			/* (non-Javadoc)
			 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
			 */
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				Assert.isNotNull(getSelectedVariableUsage());
				EList<VariableCharacterisation> characterisations = getSelectedVariableUsage()
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
		return editors;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#getTableColumnNames()
	 */
	@Override
	protected String[] getTableColumnNames() {
		return columnNames;
	}

	/**
	 * @return the selectedVariableUsage
	 */
	public VariableUsage getSelectedVariableUsage() {
		return (VariableUsage) getSelectedObject();
	}
	
	protected TypeEnum getExpectedType(RandomVariable rv) {
		TypeEnum expectedType = TypeEnum.ANY; 
		if (rv instanceof VariableCharacterisation){
			expectedType = StochasticExpressionEditDialog.getTypeFromVariableCharacterisation((VariableCharacterisation) rv);
		}
		return expectedType;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createViewerCellModifier()
	 */
	@Override
	protected ICellModifier createViewerCellModifier() {
		ComponentParametersCellModifier cellModifier = new ComponentParametersCellModifier();
		// Add EditorSection as Observer to cellModifier
		cellModifier.addObserver(this);
		return cellModifier;
	}

	/**
	 * @return the addButtonListener
	 */
	public AddComponentParameterAction getAddButtonListener() {
		return addButtonListener;
	}
}
