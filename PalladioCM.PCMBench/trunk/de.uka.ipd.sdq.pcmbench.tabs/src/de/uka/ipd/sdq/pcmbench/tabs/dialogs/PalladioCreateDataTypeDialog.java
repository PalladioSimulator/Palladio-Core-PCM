package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;
import de.uka.ipd.sdq.pcmbench.tabs.table.ParameterRepresentation;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * TODO
 * 
 * @author roman
 * 
 */
public class PalladioCreateDataTypeDialog extends CreateDataTypeDialog {

	private ComposedAdapterFactory adapterFactory;

	private ParametersDialogResources dialogResources;

	private DataType selectedDataType;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	public PalladioCreateDataTypeDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialog.CreateDataTypeDialog#getLoadedReposetorys()
	 */
	@Override
	public String[] getLoadedReposetorys() {
		EList resources = editingDomain.getResourceSet().getResources();
		ArrayList<String> tempList = new ArrayList<String>();

		// Provide a list with loaded resources without primitive DataType
		for (Iterator<Resource> it = resources.iterator(); it.hasNext();) {
			// TODO .get(0)??
			Repository repository = (Repository) (it.next()).getContents().get(
					0);

			String repositoryName = repository.getEntityName();
			if (!repositoryName.contains("PrimitiveTypes"))
				tempList.add(repositoryName);
		}

		// conver to String[]
		String[] comboItems = new String[tempList.size()];

		for (int i = 0; i < tempList.size(); i++)
			comboItems[i] = tempList.get(i);

		return comboItems;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#setEditedResource(java.lang.String)
	 */
	@Override
	public void setEditedResource(String repositoryName) {

		EList resources = editingDomain.getResourceSet().getResources();

		// Provide a list with loaded resources without primitive DataType
		for (Iterator<Resource> it = resources.iterator(); it.hasNext();) {
			// TODO .get(0)??
			Repository editedRepository = (Repository) (it.next())
					.getContents().get(0);
			String entityName = editedRepository.getEntityName();

			if (entityName.contains(repositoryName))
				OperationsTabResources.setEditedRepository(editedRepository);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialog.CreateDataTypeDialog#innerSectionCompositeDataType(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createInnerSectionCompositeGroup(Composite group) {

		dialogResources = new ParametersDialogResources();

		adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());

		dialogResources.createToolBarWithTableViewer(group,
				new AdapterFactoryContentProvider(adapterFactory),
				new AdapterFactoryLabelProvider(
						new DeclarationItemProviderAdapterFactory(
								new PalladioItemProviderAdapterFactory(
										adapterFactory))),
				new DeclarationCellModifier(),
				new AddInnerDataTypeActionListener(),
				DeleteParameterActionListener.getSingelton(),
				null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialog.CreateDataTypeDialog#innerTypeAction(org.eclipse.swt.widgets.Shell,
	 *      Text)
	 */
	@Override
	public void defeniereActionTypeButton(Shell shell, Text textField) {

		ParameterRepresentation representation = new ParameterRepresentation();

		ArrayList filterList = new ArrayList();
		filterList.add(DataType.class);
		filterList.add(Repository.class);
		ArrayList additionalReferences = new ArrayList();

		MyDialog dialog = new MyDialog(shell, filterList, additionalReferences,
				editingDomain.getResourceSet());

		dialog.open();

		if (dialog.getResult() != null
				&& dialog.getResult() instanceof DataType) {
			selectedDataType = (DataType) dialog.getResult();

			if (selectedDataType != null)
				textField.setText(representation.setDataTypeToString(
						selectedDataType, OperationsTabResources
								.getOperationsDecoratedFactory()));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCollectionDataType()
	 */
	@Override
	public void createCollectionDataType() {
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {

				CollectionDataType collectionDataType = RepositoryFactory.eINSTANCE
						.createCollectionDataType();

				Assert.isNotNull(selectedDataType);
				collectionDataType
						.setInnerType_CollectionDataType(selectedDataType);

				if (getEntityName() != null)
					collectionDataType.setEntityName(getEntityName());

				collectionDataType
						.setRepository_DataType(OperationsTabResources
								.getEditedRepository());
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
	@Override
	public void createCompositeDataType() {

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				CompositeDataType compositeDataType = OperationsTabResources
						.getNewCompositeDataType();
				compositeDataType.setEntityName(getEntityName());
				compositeDataType.setRepository_DataType(OperationsTabResources
						.getEditedRepository());
			}
		};

		recCommand.setDescription("Add new CompositeDataType");
		editingDomain.getCommandStack().execute(recCommand);
	}

}
