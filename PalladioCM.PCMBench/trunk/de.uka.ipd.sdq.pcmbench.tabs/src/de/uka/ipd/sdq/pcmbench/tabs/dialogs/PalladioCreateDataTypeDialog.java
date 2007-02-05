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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

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

	private DataType editedDataType;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	/**
	 * @param parentShell
	 * @param editedDataType
	 */
	public PalladioCreateDataTypeDialog(Shell parentShell,
			DataType editedDataType) {
		super(parentShell);
		this.editedDataType = editedDataType;
		// initDialog(editedDataType);

	}

	private void initDialog(DataType inputType) {

		ParameterRepresentation representation = new ParameterRepresentation();

		if (inputType instanceof CollectionDataType) {
			CollectionDataType collectionDataType = (CollectionDataType) inputType;

			setNameField(collectionDataType.getEntityName());
			setTypeField(representation.setDataTypeToString(collectionDataType
					.getInnerType_CollectionDataType(), OperationsTabResources
					.getOperationsDecoratedFactory()));
		}

	}

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
				new DeleteInnerDataTypeActionListener(), editedDataType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#defeniereActionTypeButton(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void defeniereActionTypeButton(SelectionEvent e) {

		Shell shell = e.display.getActiveShell();
		ParameterRepresentation representation = new ParameterRepresentation();

		ArrayList filterList = new ArrayList();
		filterList.add(DataType.class);
		filterList.add(Repository.class);
		ArrayList additionalReferences = new ArrayList();

		ReturnTypeDialog dialog = new ReturnTypeDialog(shell, filterList,
				additionalReferences, editingDomain.getResourceSet());

		dialog.open();

		if (dialog.getResult() != null
				&& dialog.getResult() instanceof DataType) {
			selectedDataType = (DataType) dialog.getResult();

			if (selectedDataType != null)
				setTypeField(representation.setDataTypeToString(
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

				CollectionDataType collectionDataType;

				if (editedDataType instanceof CollectionDataType) {
					collectionDataType = (CollectionDataType) editedDataType;

				} else {
					collectionDataType = RepositoryFactory.eINSTANCE
							.createCollectionDataType();
				}

				if (selectedDataType != null)
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

				CompositeDataType compositeDataType;

				if (editedDataType instanceof CompositeDataType) {
					compositeDataType = (CompositeDataType) editedDataType;
				} else {
					compositeDataType = OperationsTabResources
							.getNewCompositeDataType();
				}

				if (compositeDataType == null)
					compositeDataType = RepositoryFactory.eINSTANCE
							.createCompositeDataType();

				compositeDataType.setEntityName(getEntityName());
				compositeDataType.setRepository_DataType(OperationsTabResources
						.getEditedRepository());
			}
		};

		recCommand.setDescription("Add new CompositeDataType");
		editingDomain.getCommandStack().execute(recCommand);
	}

}
