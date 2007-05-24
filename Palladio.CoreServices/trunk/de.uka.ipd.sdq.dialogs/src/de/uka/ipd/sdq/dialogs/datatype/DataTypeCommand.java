package de.uka.ipd.sdq.dialogs.datatype;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;

/**
 * TODO
 * @author admin
 */
public class DataTypeCommand {
	
	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	final protected static TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(DialogRepository
							.getEditedRepository());
	

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCollectionDataType()
	 */
	public static void createCollectionDataType(final DataType dataType,
			final DataType innerDataType, final String entityName) {

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				CollectionDataType collectionDataType;

				if (dataType != null) {
					// Edite existet DataType
					collectionDataType = (CollectionDataType) dataType;
					String typeName = collectionDataType.getEntityName();
					DataType innerType = collectionDataType
							.getInnerType_CollectionDataType();

					if ((entityName != null) && (!typeName.equals(entityName)))
						collectionDataType.setEntityName(entityName);

					if ((innerDataType != null)
							&& (!innerType.equals(innerDataType)))
						collectionDataType
								.setInnerType_CollectionDataType(innerDataType);
				} else {
					// Create new DataType
					collectionDataType = RepositoryFactory.eINSTANCE
							.createCollectionDataType();
					collectionDataType.setRepository_DataType(DialogRepository
							.getEditedRepository());

					Assert.isNotNull(collectionDataType);
					Assert.isNotNull(innerDataType);
					Assert.isNotNull(entityName);

					collectionDataType.setEntityName(entityName);
					collectionDataType
							.setInnerType_CollectionDataType(innerDataType);
				}
			}
		};
		recCommand.setDescription("Add new/Edite CollectionDataType");
		editingDomain.getCommandStack().execute(recCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCompositeDataType()
	 */
	public static void createCompositeDataType(final DataType dataType,
			final String entityName) {
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				CompositeDataType compositeDataType;

				if (dataType != null) {
					// Edite existet DataType
					compositeDataType = (CompositeDataType) dataType;

					String typeName = compositeDataType.getEntityName();

					if ((entityName != null) && (!typeName.equals(entityName)))
						compositeDataType.setEntityName(entityName);

				} else {
					// Create new DataType
					compositeDataType = DialogRepository
							.getNewCompositeDataType();

					Assert.isNotNull(compositeDataType);
					Assert.isNotNull(entityName);

					compositeDataType.setEntityName(entityName);
					compositeDataType.setRepository_DataType(DialogRepository
							.getEditedRepository());
				}
			}
		};

		recCommand.setDescription("Add new CompositeDataType");
		editingDomain.getCommandStack().execute(recCommand);
	}
}
