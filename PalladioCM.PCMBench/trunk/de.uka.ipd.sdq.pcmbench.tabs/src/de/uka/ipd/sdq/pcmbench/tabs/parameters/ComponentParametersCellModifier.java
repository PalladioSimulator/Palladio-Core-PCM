package de.uka.ipd.sdq.pcmbench.tabs.parameters;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcmbench.tabs.generic.ObservableCellModifier;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * @author Roman Andrej
 */
public class ComponentParametersCellModifier extends ObservableCellModifier {

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
			setVariableUsage(((String) value).trim());
			break;
		case ComponentParametersEditorSection.STOEX_COLUMN_INDEX:
			setSpecification(((String) value).trim());
			break;
		default:
			break;
		}

	}
	
	/** Get the last reference from references chain. */
	private NamespaceReference getLastReference(NamespaceReference reference) {

		if (reference.getInnerReference_NamespaceReference() == null) {
			return reference;
		}

		return getLastReference((NamespaceReference) reference
				.getInnerReference_NamespaceReference());
	}
	
	/** Create chain of NamespaceReference/VariableReference. */
	private AbstractNamedReference createNamedReference(List<String> names,
			NamespaceReference reference) {

		AbstractNamedReference rootReference = null;

		int varRefIndex = names.size() - 2;

		// create 'NamespaceReference' chain
		for (int i = 0; i < varRefIndex; i++) {
			// create NamespaceReference
			NamespaceReference namespaceReference = StoexFactory.eINSTANCE
					.createNamespaceReference();
			// set reference name
			namespaceReference.setReferenceName(names.get(i));

			if (rootReference == null) {
				rootReference = namespaceReference;
			} else {
				getLastReference((NamespaceReference) rootReference)
						.setInnerReference_NamespaceReference(
								namespaceReference);
			}

		}

		VariableReference variableReference = StoexFactory.eINSTANCE
				.createVariableReference();
		// set reference name
		variableReference.setReferenceName(names.get(varRefIndex));

		if (rootReference == null) {
			rootReference = variableReference;
		} else {
			getLastReference((NamespaceReference) rootReference)
					.setInnerReference_NamespaceReference(variableReference);
		}
		return rootReference;
	}
	
	
	/** Update the VariableUsage. */
	private void setVariableUsage(final String value) {
		editingDomain = TransactionUtil.getEditingDomain(variableUsage);

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				List<String> names = Arrays.asList(value.split("\\."));
				// create NamedReference 
				AbstractNamedReference namedReference = createNamedReference(
						names, null);

				variableUsage.setNamedReference_VariableUsage(namedReference);
				// must be fixed (if not own VariableCharacterisation)!
				VariableCharacterisation characterisation = variableUsage
						.getVariableCharacterisation_VariableUsage().get(0);
				// set type of VariableCharacterisation
				characterisation.setType(VariableCharacterisationType
						.valueOf(names.get(names.size() - 1)));

			}
		};

		recCommand.setLabel("Set specification");
		editingDomain.getCommandStack().execute(recCommand);
		notifyObservers();
	}
	
	/** Update Specification. */
	private void setSpecification(final String value) {
		editingDomain = TransactionUtil.getEditingDomain(variableUsage);

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				PCMRandomVariable randomVariable = CoreFactory.eINSTANCE
						.createPCMRandomVariable();
				VariableCharacterisation characterisation = variableUsage
						.getVariableCharacterisation_VariableUsage().get(0);
				randomVariable.setSpecification(value);
				characterisation
						.setSpecification_VariableCharacterisation(randomVariable);
			}
		};

		recCommand.setLabel("Set specification");
		editingDomain.getCommandStack().execute(recCommand);
		notifyObservers();
	}
	
	
}
