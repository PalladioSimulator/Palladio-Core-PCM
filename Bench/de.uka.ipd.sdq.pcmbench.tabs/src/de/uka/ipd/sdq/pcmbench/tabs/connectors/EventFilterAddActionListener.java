package de.uka.ipd.sdq.pcmbench.tabs.connectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;

public class EventFilterAddActionListener  extends SelectionAdapter {

	/**
	 * Define the selected connector. The filter condition is set not during the class
	 * production, separates later.
	 */
	private Connector selectedConnector;

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(selectedConnector);
		if (((selectedConnector instanceof EventChannelSinkConnector) 
				&& (((EventChannelSinkConnector) selectedConnector).getFilterCondition__EventChannelSinkConnector()==null)
			||((selectedConnector instanceof AssemblyEventConnector) 
					&& (((AssemblyEventConnector) selectedConnector).getFilterCondition__AssemblyEventConnector()==null)))){
		
			/**
			 * The transactional editing domain which is used to get the commands
			 * and alter the model
			 */
			TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(selectedConnector);

			RecordingCommand recCommand = new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
				
					PCMRandomVariable randomVariable = CoreFactory.eINSTANCE
						.createPCMRandomVariable();
					randomVariable.setSpecification("true");
				
					if (selectedConnector instanceof EventChannelSinkConnector)
						((EventChannelSinkConnector) selectedConnector).setFilterCondition__EventChannelSinkConnector(randomVariable);
					if (selectedConnector instanceof AssemblyEventConnector)
						((AssemblyEventConnector) selectedConnector).setFilterCondition__AssemblyEventConnector(randomVariable);
				}
			};

		recCommand.setDescription("Add new event filter");
		editingDomain.getCommandStack().execute(recCommand);
		}
	}


	/**
	 * @param selectedConnector The connector containing the filter condition that should be set
	 */
	public void setSelectedConnector(Connector selectedConnector) {
		this.selectedConnector = selectedConnector;
	}
}
