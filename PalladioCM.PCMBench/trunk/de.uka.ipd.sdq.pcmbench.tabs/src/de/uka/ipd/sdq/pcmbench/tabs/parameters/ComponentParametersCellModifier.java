/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs.parameters;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * @author Roman Andrej
 *
 */
public class ComponentParametersCellModifier implements ICellModifier {

	private List<String> columnNames;
	private VariableUsage variableUsage;

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
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
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
			
			variableUsage = (VariableUsage) item.getData();
			
			switch (columnIndex) {
			case ComponentParametersEditorSection.ICON_COLUMN_INDEX:
				break;
			case ComponentParametersEditorSection.VARIABLE_COLUMN_INDEX:
				break;
			case ComponentParametersEditorSection.STOEX_COLUMN_INDEX:
				setSpecification(((String) value).trim());
				break;
			default:
				break;
			}

	}
	
	private void setSpecification(final String value) {
		editingDomain = TransactionUtil.getEditingDomain(variableUsage);

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				PCMRandomVariable randomVariable = CoreFactory.eINSTANCE.createPCMRandomVariable();
				VariableCharacterisation characterisation = variableUsage
						.getVariableCharacterisation_VariableUsage().get(0);
				randomVariable.setSpecification(value);
				characterisation.setSpecification_VariableCharacterisation(randomVariable);
			}
		};

		// if (!value.equals(signature.getServiceName())) {
		// recCommand.setDescription("Edit Signature Property");
		recCommand.setLabel("Set specification");
		editingDomain.getCommandStack().execute(recCommand);
		// }

	}
}
