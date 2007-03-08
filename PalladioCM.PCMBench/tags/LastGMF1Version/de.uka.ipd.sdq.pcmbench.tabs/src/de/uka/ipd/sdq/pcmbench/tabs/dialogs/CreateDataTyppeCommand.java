package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;

/**
 * TODO
 * @author admin
 */
public class CreateDataTyppeCommand {

	private DataType dataType;
	private String dataTypeName;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	/**
	 * @param dataType
	 * @param dataTypeName
	 */
	public CreateDataTyppeCommand(DataType dataType, String dataTypeName) {
		this.dataType = dataType;
		this.dataTypeName = dataTypeName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCollectionDataType()
	 */
	public void createCollectionDataType(final DataType innerDataType) {
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				CollectionDataType collectionDataType;

				if (dataType != null) {
					collectionDataType = (CollectionDataType) dataType;
				} else {
					collectionDataType = RepositoryFactory.eINSTANCE
							.createCollectionDataType();
					collectionDataType
							.setRepository_DataType(OperationsTabResources
									.getEditedRepository());
				}
				
				Assert.isNotNull(collectionDataType);
				Assert.isNotNull(dataTypeName);
				collectionDataType.setEntityName(dataTypeName);
				Assert.isNotNull(innerDataType);
				collectionDataType
						.setInnerType_CollectionDataType(innerDataType);
			}
		};
		recCommand.setDescription("Add new CollectionDataType");
		editingDomain.getCommandStack().execute(recCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCompositeDataType()
	 */
	public void createCompositeDataType() {
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				CompositeDataType compositeDataType;

				if (dataType != null) {
					compositeDataType = (CompositeDataType) dataType;
				} else {
					compositeDataType = OperationsTabResources
							.getNewCompositeDataType();
				}

				Assert.isNotNull(compositeDataType);
				Assert.isNotNull(dataTypeName);
				compositeDataType.setEntityName(dataTypeName);
				compositeDataType.setRepository_DataType(OperationsTabResources
						.getEditedRepository());
			}
		};

		recCommand.setDescription("Add new CompositeDataType");
		editingDomain.getCommandStack().execute(recCommand);
	}
}
