package de.uka.ipd.sdq.pcmbench.tabs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public abstract class EditorSection {
	
	private Composite composite;
	private ToolItem addButton, deleteButton;
	private TableViewer viewer;
	
	/**
	 * @param composite
	 */
	public EditorSection(Composite composite) {
		composite.getParent().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		this.composite = composite;
		createSection();
	}
	
	private void createSection(){
		ToolBar toolBar = createToolBar(composite);
		Table table = createTable(composite, toolBar);
		viewer = createViewer(table);
	}
	
	protected abstract Table createTable(Composite composite, ToolBar toolBar);
	protected abstract TableViewer createViewer(Table table); 
	
	protected ToolBar createToolBar(Composite composite) {

		ToolBar toolBar = new ToolBar(composite, SWT.VERTICAL | SWT.FLAT | SWT.RIGHT);
		FormData formData = new FormData();
		formData.left = new FormAttachment(96, 0);
		formData.top = new FormAttachment(0, 0);
		formData.right = new FormAttachment(100, 0);
		formData.bottom = new FormAttachment(100, 0);
		toolBar.setLayoutData(formData);

		/** Create Add-Button by ToolBar */
		addButton = new ToolItem(toolBar, SWT.PUSH);
		addButton.setImage(PCMBenchTabsImages.imageRegistry
				.get(PCMBenchTabsImages.ADD_SIGN));

		/** Create Delete-Button by ToolBar */
		deleteButton = new ToolItem(toolBar, SWT.PUSH);
		deleteButton.setImage( PCMBenchTabsImages.imageRegistry
				.get(PCMBenchTabsImages.DELETE_SIGN));
		deleteButton.setEnabled(false);

		return toolBar;
	}
	
	/** Set a SelectionListener for the Delete-Button */
	public void setDeleteButtonSelectionListener(SelectionListener listener){
		Assert.isNotNull(deleteButton);
		deleteButton.addSelectionListener(listener);
	}
	
	/** Set a SelectionListener for the Add-Button */
	public void setAddButtonSelectionListener(SelectionListener listener){
		Assert.isNotNull(addButton);
		addButton.addSelectionListener(listener);
	}
	
	/** Set a ContentProvider for the TableViewer */
	public void setViewerContentProvider(IContentProvider contentProvider){
		Assert.isNotNull(viewer);
		viewer.setContentProvider(contentProvider);
	}
	
	/** Set a LabelProvider for the TableViewer */
	public void setViewerLabelProvider(IBaseLabelProvider labelProvider){
		Assert.isNotNull(viewer);
		viewer.setLabelProvider(labelProvider);
	}

	/**
	 * @return the addButton
	 */
	public ToolItem getAddButton() {
		return addButton;
	}

	/**
	 * @return the deleteButton
	 */
	public ToolItem getDeleteButton() {
		return deleteButton;
	}

	/**
	 * @return the viewer
	 */
	public TableViewer getViewer() {
		return viewer;
	}
}
