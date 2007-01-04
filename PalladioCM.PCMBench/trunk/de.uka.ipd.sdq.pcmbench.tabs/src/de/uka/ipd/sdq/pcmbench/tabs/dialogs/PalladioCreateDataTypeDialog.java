package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * TODO
 * @author roman
 * 
 */
public class PalladioCreateDataTypeDialog extends CreateDataTypeDialog {

	private ComposedAdapterFactory adapterFactory;
	private ParametersDialogResources dialogResources;

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
		// TODO Auto-generated method stub
		EList resources = editingDomain.getResourceSet().getResources();
		Resource resource;
		String[] items = new String[resources.size()];
		int i = 0;
		for( Iterator<Resource> it = resources.iterator(); it.hasNext();  ){
			resource = it.next();
			items[i] = resource.toString();
			i++;
		}
		return items;
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

		dialogResources.createToolBarWithTableViewer( group,
				new AdapterFactoryContentProvider(adapterFactory),
				new AdapterFactoryLabelProvider(
						new ParametersItemProviderAdapterFactory(
								new PalladioItemProviderAdapterFactory(
										adapterFactory))),
				new AddInnerDataTypeActionListener(),
				DeleteParameterActionListener.getSingelton(),
				OperationsTabResources.getEditedSignature());

	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialog.CreateDataTypeDialog#innerTypeAction(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	public void defeniereActionTypeButton(Shell shell) {

		ArrayList filterList = new ArrayList();
		filterList.add(DataType.class);
		filterList.add(Repository.class);
		ArrayList additionalReferences = new ArrayList();

		MyDialog dialog = new MyDialog(shell, filterList, additionalReferences,
				editingDomain.getResourceSet());
		dialog.open();
/*
		if (dialog.getResult() == null)
			return null;
		if (!(dialog.getResult() instanceof DataType))
			return null;

		return dialog.getResult();*/

	}

}
