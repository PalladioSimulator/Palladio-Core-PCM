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
import org.eclipse.emf.transaction.util.TransactionUtil;
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

/** @author roman */
public class PalladioDataTypeDialog extends DataTypeDialog {

	private ComposedAdapterFactory adapterFactory;

	private DataType innerDataType;
	private DataType editedDataType;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	protected TransactionalEditingDomain editingDomain = null;

	public PalladioDataTypeDialog(Shell parentShell,TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.editingDomain = editingDomain;
	}

	public PalladioDataTypeDialog(Shell parentShell, DataType editeDataType) {
		super(parentShell);
		this.editingDomain = TransactionUtil.getEditingDomain(editeDataType);
		this.editedDataType = editeDataType;
		initDialog(editeDataType);
	}

	/**call if datatype set (edite button)*/
	private void initDialog(DataType editeDataType) {

		String entityName;
		String entityInnerType;
		String reposetory;

		if (editeDataType instanceof CollectionDataType) {
			CollectionDataType collectionDataType = (CollectionDataType) editeDataType;

			entityName = collectionDataType.getEntityName();
			reposetory = collectionDataType.getRepository_DataType()
					.getEntityName();

			entityInnerType = ParameterRepresentation
					.setDataTypeToString(collectionDataType
							.getInnerType_CollectionDataType());

			// Call constructor of DataTypeDialog
			super.init(collectionSignator, reposetory, entityName,
					entityInnerType);
		}

		if (editeDataType instanceof CompositeDataType) {
			CompositeDataType compositeDataType = (CompositeDataType) editeDataType;

			entityName = compositeDataType.getEntityName();
			reposetory = compositeDataType.getRepository_DataType()
					.getEntityName();

			DialogRepository.setNewCompositeDataType(compositeDataType);
			// Call constructor of DataTypeDialog
			super.init(compositeSignator, reposetory, entityName, null);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialog.CreateDataTypeDialog#getLoadedReposetorys()
	 */
	@Override
	public String[] getLoadedReposetorys() {
		EList<Resource> resources = editingDomain.getResourceSet()
				.getResources();
		List<String> tList = new ArrayList<String>();

		for (Resource r : resources) {
			URI uri = r.getURI();
			if (hasRepositoryExtension(uri) && !isPrimitiveTypesRepository(uri)
					&& r.getContents().get(0) instanceof Repository) {
				Repository repository = (Repository) r.getContents().get(0);
				String repositoryName = repository.getEntityName();
				tList.add(repositoryName == null ? "<Unnamed Repository>"
						: repositoryName);
			}
		}
		// conver to String[]
		return (String[]) tList.toArray(new String[tList.size()]);
	}

	private boolean hasRepositoryExtension(URI uri) {
		if (uri.fileExtension().equals("repository"))
			return true;
		return false;
	}

	private boolean isPrimitiveTypesRepository(URI uri) {
		if (uri.path().contains("PrimitiveTypes"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#setEditedResource(java.lang.String)
	 */
	@Override
	public void setEditedResource(String repositoryName) {
		EList<Resource> resources = editingDomain.getResourceSet()
				.getResources();

		// Provide a list with loaded resources without primitive DataType
		for (Resource r : resources) {
			if (!r.getContents().isEmpty()
					&& r.getContents().get(0) instanceof Repository) {
				Repository repository = (Repository) r.getContents().get(0);
				String entityName = repository.getEntityName() == null ? "<Unnamed Repository>"
						: repository.getEntityName();

				if (entityName.contains(repositoryName))
					DialogRepository.setEditedRepository(repository);
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialog.CreateDataTypeDialog#innerSectionCompositeDataType(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createInnerSectionCompositeGroup(Composite group) {

		adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());

		CreateEditorContents editorContents = CreateEditorContents
				.create(group,editingDomain);
		editorContents
				.setViewerContentProvider(new AdapterFactoryContentProvider(
						adapterFactory));
		editorContents
				.setViewerLabelProvider(new AdapterFactoryLabelProvider(
						new InnerDeclarationItemProviderAdapterFactory(
								new PalladioItemProviderAdapterFactory(
										adapterFactory))));
		editorContents.setViewerCellModifier(new InnerDeclarationCellModifier(
				editorContents.getViewer()));
		editorContents.setAddButtonActionListener(new AddInnerDataTypeListener(
				this,editingDomain));
		editorContents
				.setDeleteButtonActionListener(new DeleteInnerDataTypeListener(
						this,editingDomain));
		editorContents.setUpButtonActionListener(new UpInnerDataTypeListener(
				this, editingDomain));
		editorContents.setDownButtonActionListener(new DownInnerDataTypeListener(
				this, editingDomain));
		editorContents.setViewerInput(editedDataType);
		
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#defeniereActionTypeButton(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public String getSelectedInnerType(SelectionEvent e) {

		String selectedType = "";

		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(DataType.class);
		filterList.add(Repository.class);

		CallDataTypeDialog dialog = new CallDataTypeDialog(e.display
				.getActiveShell(), filterList, new ArrayList<Object>(),
				editingDomain.getResourceSet());
		dialog.setProvidedService(DataType.class);
		dialog.open();

		if (dialog.getResult() != null
				&& dialog.getResult() instanceof DataType) {
			innerDataType = (DataType) dialog.getResult();

			selectedType = ParameterRepresentation
					.setDataTypeToString(innerDataType);
		}
		return selectedType;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCollectionDataType()
	 */
	@Override
	public void createCollectionDataType() {
		new DataTypeCommand(editingDomain).createCollectionDataType(
				editedDataType, innerDataType, getEntityName());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCompositeDataType()
	 */
	@Override
	public void createCompositeDataType() {
		new DataTypeCommand(editingDomain).createCompositeDataType(
				editedDataType, getEntityName());
	}

	public DataType getEditedDataType() {
		return editedDataType;
	}
}
