package de.uka.ipd.sdq.pcmbench.tabs.parameters;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcmbench.tabs.generic.ObservableCellModifier;

/**
 * @author Roman Andrej
 */
public class ComponentParametersCellModifier extends ObservableCellModifier {

	private List<String> columnNames;
	private VariableUsage variableUsage;
	private VariableUsageWrapper wrapper;
	
	private AssemblyContext context;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	protected TransactionalEditingDomain editingDomain = null;
	
	public ComponentParametersCellModifier() {
		this.columnNames = Arrays
				.asList(ComponentParametersEditorSection.columnNames);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	public boolean canModify(Object element, String property) {

		int columnIndex = columnNames.indexOf(property);

		switch (columnIndex) {
		case ComponentParametersEditorSection.ICON_COLUMN_INDEX:
			return false;
		case ComponentParametersEditorSection.VARIABLE_COLUMN_INDEX:
			return false;
		case ComponentParametersEditorSection.STOEX_COLUMN_INDEX:
			return true;
		default:
			break;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object,
	 *      java.lang.String)
	 */
	public Object getValue(Object element, String property) {
		return (new ParametersTabItemProvider(null)).getColumnText(element,
				columnNames.indexOf(property));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {
		// Find the index of the column
		int columnIndex = columnNames.indexOf(property);

		Assert.isNotNull(element);
		TableItem item = (TableItem) element;

		wrapper = (VariableUsageWrapper) item.getData();
		variableUsage = wrapper.getVariableUsage();

		switch (columnIndex) {
		case ComponentParametersEditorSection.ICON_COLUMN_INDEX:
			break;
		case ComponentParametersEditorSection.VARIABLE_COLUMN_INDEX:
			break;
		case ComponentParametersEditorSection.STOEX_COLUMN_INDEX:
			setSpecification(((String) value).trim(), item);
			break;
		default:
			break;
		}

	}
	
	
	/** Update Specification. */
	private void setSpecification(final String value, TableItem item) {
		editingDomain = TransactionUtil.getEditingDomain(variableUsage);

		VariableCharacterisation variableCharacterisation = variableUsage
				.getVariableCharacterisation_VariableUsage().get(0);

		if (!variableCharacterisation
				.getSpecification_VariableCharacterisation().getSpecification()
				.equals(value)) {

			RecordingCommand recCommand = new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {

					// create/set RandomVariable
					PCMRandomVariable randomVariable = CoreFactory.eINSTANCE
							.createPCMRandomVariable();
					randomVariable.setSpecification(value);

					VariableUsage contexVariableUsage = null;

					// create VariableUsage for AssemblyContext
					ParameterUtil copier = new ParameterUtil();
					contexVariableUsage = (VariableUsage) copier.copy(variableUsage);
					copier.copyReferences();
					
					// create VariableCharacterisation for AssemblyContext
					VariableCharacterisation characterisation = contexVariableUsage
							.getVariableCharacterisation_VariableUsage().get(0);
					// set specification
					characterisation
							.setSpecification_VariableCharacterisation(randomVariable);
					// add edited VariableUsage to AssemblyContext
					context.getConfigParameterUsages_AssemblyContext().add(
							contexVariableUsage);
					
				}
			};

			recCommand.setLabel("Set specification");
			editingDomain.getCommandStack().execute(recCommand);
			// set color for TableItem
			setTableItemColor(item);
			// make TableItem edited
			wrapper.setEdited(true);
			// update observer
			notifyObservers(wrapper);
			
		}
	}
	
	
	private void setTableItemColor(TableItem item) {
		item.setForeground(item.getDisplay().getSystemColor(SWT.COLOR_BLACK));
	}
	
	/**
	 * @param context the context to set
	 */
	public void setContext(AssemblyContext context) {
		this.context = context;
	}
}
