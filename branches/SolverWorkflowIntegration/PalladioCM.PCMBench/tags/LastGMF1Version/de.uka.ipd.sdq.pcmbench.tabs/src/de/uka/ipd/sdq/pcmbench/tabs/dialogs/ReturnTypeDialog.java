package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import java.util.Collection;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;

/**
 * @author roman
 * 
 */
public class ReturnTypeDialog extends PalladioSelectEObjectDialog {

	private DataType selectedDataType = null;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	protected Shell shell;

	/**
	 * @param parent
	 * @param filterList
	 * @param additionalChildReferences
	 * @param input
	 */
	public ReturnTypeDialog(Shell parent, Collection filterList,
			Collection additionalChildReferences, Object input) {
		super(parent, filterList, additionalChildReferences, input);
	}

	/**
	 * TODO
	 * 
	 * @param parent
	 * @param filterList
	 * @param input
	 */
	public ReturnTypeDialog(Shell parent, Collection filterList, Object input) {
		super(parent, filterList, input);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog#createContents()
	 */
	@Override
	protected void createContents() {

		super.createContents();

		/**
		 * Activire the ToolBar with items
		 * 
		 * @See de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog#enableToolBar(Boolean
		 *      addItemEnabled, boolean deleteItemEnabled, boolean
		 *      editItemEnabled)
		 */
		enableToolBar(true, false, false);

		TreeViewer treeViewer = getListViewer();
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				EObject selection = (EObject) sel.getFirstElement();

				enableToolBar(true, false, false);
				if ((selection instanceof CollectionDataType)
						|| (selection instanceof CompositeDataType)) {
					selectedDataType = (DataType) selection;
					enableToolBar(true, true, true);
				}
			}
		});

		setAddSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = e.widget.getDisplay().getActiveShell();
				PalladioCreateDataTypeDialog dialog = new PalladioCreateDataTypeDialog(
						shell);
				dialog.open();
			}

		});

		setDeleteSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {

				RecordingCommand recCommand = new RecordingCommand(
						editingDomain) {
					@Override
					protected void doExecute() {
						Assert.isNotNull(selectedDataType);

						Repository repository = selectedDataType
								.getRepository_DataType();

						EList datatypesRepository = repository
								.getDatatypes_Repository();
						datatypesRepository.remove(selectedDataType);

					}
				};

				recCommand.setDescription("Delete the DataType");
				editingDomain.getCommandStack().execute(recCommand);
				enableToolBar(true, false, false);
			}
		});

		setEditeSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {

				Assert.isNotNull(selectedDataType);
				Shell shell = e.widget.getDisplay().getActiveShell();
				PalladioCreateDataTypeDialog dialog = new PalladioCreateDataTypeDialog(
						shell, selectedDataType);
				dialog.open();

			}

		});
	}
}
