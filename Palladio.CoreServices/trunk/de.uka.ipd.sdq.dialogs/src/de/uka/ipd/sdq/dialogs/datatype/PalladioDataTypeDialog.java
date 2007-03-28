package de.uka.ipd.sdq.dialogs.datatype;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.dialogs.parameters.CreateEditorContents;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * TODO
 * 
 * @author roman
 * 
 */
public class PalladioDataTypeDialog extends DataTypeDialog {

	private ComposedAdapterFactory adapterFactory;

	private DataType innerDataType;
	private DataType editedDataType;

	ParameterRepresentation representation = new ParameterRepresentation();

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(DialogRepository.EDITING_DOMAIN_ID);

	/**
	 * @param parentShell
	 * @param editedDataType
	 */
	public PalladioDataTypeDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * @param parentShell
	 * @param dialogTitele
	 * @param reposetoryName
	 * @param entityName
	 * @param entityType
	 */
	public PalladioDataTypeDialog(Shell parentShell, DataType editedDataType) {
		super(parentShell);
		this.editedDataType = editedDataType;
		initDialog(editedDataType);
	}

	private void initDialog(DataType inputType) {

		String entityName;
		String entityInnerType;
		String reposetory;

		ParameterRepresentation representation = new ParameterRepresentation();

		if (inputType instanceof CollectionDataType) {
			CollectionDataType collectionDataType = (CollectionDataType) inputType;

			entityName = collectionDataType.getEntityName();
			reposetory = collectionDataType.getRepository_DataType()
					.getEntityName();

			entityInnerType = representation
					.setDataTypeToString(collectionDataType
							.getInnerType_CollectionDataType());

			// TODO
			super.init(collectionSignator, reposetory, entityName,
					entityInnerType);
		}

		if (inputType instanceof CompositeDataType) {
			CompositeDataType compositeDataType = (CompositeDataType) inputType;

			entityName = compositeDataType.getEntityName();
			reposetory = compositeDataType.getRepository_DataType()
					.getEntityName();

			// TODO
			super.init(compositeSignator, reposetory, entityName, null);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialog.CreateDataTypeDialog#getLoadedReposetorys()
	 */
	@Override
	public String[] getLoadedReposetorys() {
		EList<Resource> resources = editingDomain.getResourceSet()
				.getResources();
		List<String> tList = new ArrayList<String>();

		for (Resource r : resources) {
			URI uri = r.getURI();
			if (hasRepositoryExtension(uri) && !isPrimitiveTypesRepository(uri)) {
				Repository repository = (Repository) r.getContents().get(0);
				String repositoryName = repository.getEntityName();
				tList.add(repositoryName == null ? "<Unnamed Repository>"
						: repositoryName);
			}
		}
		// conver to String[]
		return (String[]) tList.toArray(new String[tList.size()]);
	}

	/**
	 * TODO
	 * 
	 * @param uri
	 * @return
	 */
	private boolean hasRepositoryExtension(URI uri) {
		if (uri.fileExtension().equals("repository"))
			return true;
		return false;
	}

	/**
	 * TODO
	 * 
	 * @param uri
	 * @return
	 */
	private boolean isPrimitiveTypesRepository(URI uri) {
		if (uri.path().contains("PrimitiveTypes"))
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#setEditedResource(java.lang.String)
	 */
	@Override
	public void setEditedResource(String repositoryName) {
		EList<Resource> resources = editingDomain.getResourceSet()
				.getResources();

		// Provide a list with loaded resources without primitive DataType
		for (Resource r : resources) {
			if (r.getContents().get(0) instanceof Repository) {
				Repository repository = (Repository) r.getContents().get(0);
				String entityName = repository.getEntityName() == null ? "<Unnamed Repository>"
						: repository.getEntityName();

				if (entityName.contains(repositoryName))
					DialogRepository.setEditedRepository(repository);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialog.CreateDataTypeDialog#innerSectionCompositeDataType(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createInnerSectionCompositeGroup(Composite group) {

		adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());

		new CreateEditorContents(group, new AdapterFactoryContentProvider(
				adapterFactory),
				new AdapterFactoryLabelProvider(
						new InnerDeclarationItemProviderAdapterFactory(
								new PalladioItemProviderAdapterFactory(
										adapterFactory))),
				new InnerDeclarationCellModifier(),
				new AddInnerDataTypeListener(this),
				new DeleteInnerDataTypeListener(this), editedDataType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#defeniereActionTypeButton(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public String getSelectedInnerType(SelectionEvent e) {

		String selectedType = "";
		Shell shell = e.display.getActiveShell();
		ParameterRepresentation representation = new ParameterRepresentation();

		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(DataType.class);
		filterList.add(Repository.class);
		ArrayList<Object> additionalReferences = new ArrayList<Object>();

		CallDataTypeDialog dialog = new CallDataTypeDialog(shell, filterList,
				additionalReferences, editingDomain.getResourceSet());

		dialog.open();

		if (dialog.getResult() != null
				&& dialog.getResult() instanceof DataType) {
			innerDataType = (DataType) dialog.getResult();

			selectedType = representation.setDataTypeToString(innerDataType);
		}
		return selectedType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCollectionDataType()
	 */
	@Override
	public void createCollectionDataType() {
		new DataTypeCommand(editedDataType, getEntityName())
				.createCollectionDataType(innerDataType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCompositeDataType()
	 */
	@Override
	public void createCompositeDataType() {
		new DataTypeCommand(editedDataType, getEntityName())
				.createCompositeDataType();
	}

	/**
	 * @return the editedDataType
	 */
	public DataType getEditedDataType() {
		return editedDataType;
	}

}
