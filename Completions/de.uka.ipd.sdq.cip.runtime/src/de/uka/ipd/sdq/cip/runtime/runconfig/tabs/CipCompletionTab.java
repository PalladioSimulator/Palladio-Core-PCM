/**
 * 
 */
package de.uka.ipd.sdq.cip.runtime.runconfig.tabs;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.cip.configuration.TransformationType;
import de.uka.ipd.sdq.cip.runtime.RunConfigImages;
import de.uka.ipd.sdq.cip.runtime.dialogs.EditCompletionDialog;
import de.uka.ipd.sdq.cip.runtime.wizards.NewCompletionWizard;

/**
 * @author thomass
 *
 */
public class CipCompletionTab extends AbstractCipLaunchConfigurationTab {
	
	ArrayList<Transformation> transformations;
	
	private CheckboxTableViewer completionsViewer;

	private Button newbutton;

	private Button removebutton;

	private Button editbutton;

	private Button upbutton;

	private Button downbutton;

	private Button checkLoggingButton;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		
		Composite mainComponent = new Composite(parent,SWT.NONE);
		setControl(mainComponent);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		
		mainComponent.setFont(parent.getFont());
		mainComponent.setLayout(layout);
		
		Label label = new Label(mainComponent,SWT.LEFT);
		label.setText("Transformations:");
		
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		label.setLayoutData(gd);

		completionsViewer = createTable(mainComponent,new String[]{"Active", "Name","Category", "Configuration File"});
		//createColumns(completionsViewer);
		
		newbutton = createPushButton(mainComponent, "N&ew...", null);
		newbutton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				newCompletion();
			}
		});
		editbutton = createPushButton(mainComponent, "E&dit...", null);
		editbutton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editCompletion();
			}
		});
		removebutton = createPushButton(mainComponent, "Rem&ove", null);
		removebutton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeCompletion();
			}
		});
		//createSeparator(mainComponent, 1);
		upbutton = createPushButton(mainComponent, "&Up", null);
		upbutton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				upCompletion();
			}
		});
		downbutton = createPushButton(mainComponent, "&Down", null);
		downbutton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				downCompletion();
			}
		});
		
		/** Logging group*/
		
		final Group loggingGroup = new Group(mainComponent, SWT.NONE);
		gd = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gd.horizontalSpan = 2;
		loggingGroup.setLayoutData(gd);
		loggingGroup.setText("QVT Logging");
		loggingGroup.setLayout(new GridLayout());
		checkLoggingButton = new Button(loggingGroup, SWT.CHECK);
		checkLoggingButton.setText("Enable verbose logging");
		checkLoggingButton.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				CipCompletionTab.this.setDirty(true);
				CipCompletionTab.this.updateLaunchConfigurationDialog();
			}
		});
		
	}

	protected void setTabModified() {
		this.setDirty(true);
		this.updateLaunchConfigurationDialog();
		updateButtons();
		
	}
	
	protected void updateButtons() {
		IStructuredSelection selection = (IStructuredSelection) completionsViewer.getSelection();
		if(!selection.iterator().hasNext())
		{
			downbutton.setEnabled(false);
			upbutton.setEnabled(false);
			editbutton.setEnabled(false);
			return;
		}
		
		Transformation transformation = (Transformation) selection.iterator().next();
		int pos = transformations.indexOf(transformation);
		if(pos < transformations.size()-1) 
			downbutton.setEnabled(true);
		else
			downbutton.setEnabled(false);
		if(pos > 0) 
			upbutton.setEnabled(true);
		else
			upbutton.setEnabled(false);
		
		if(!(transformation.getType() == TransformationType.REGISTERED && transformation.getCompletion().containsCategory(ConstantsContainer.PLAIN_COMPLETION)))
			editbutton.setEnabled(true);
		else 
			editbutton.setEnabled(false);
	}

	protected void downCompletion() {
		IStructuredSelection selection = (IStructuredSelection) completionsViewer.getSelection();
		if(!selection.iterator().hasNext())
			return;
		
		Transformation transformation = (Transformation) selection.iterator().next();
		int pos = transformations.indexOf(transformation);
		if(pos < transformations.size()) {
			transformations.set(pos, transformations.get(pos+1));
			transformations.set(pos+1, transformation);
			completionsViewer.refresh();
		}
		
	}

	protected void upCompletion() {
		IStructuredSelection selection = (IStructuredSelection) completionsViewer.getSelection();
		if(!selection.iterator().hasNext())
			return;
		
		Transformation transformation = (Transformation) selection.iterator().next();
		int pos = transformations.indexOf(transformation);
		if(pos > 0) {
			transformations.set(pos, transformations.get(pos-1));
			transformations.set(pos-1, transformation);
			completionsViewer.refresh();
		}
	}

	protected void editCompletion() {
		IStructuredSelection selection = (IStructuredSelection) completionsViewer.getSelection();
		if(!selection.iterator().hasNext())
			return;
		
		Transformation transformation = (Transformation) selection.iterator().next();
		
		EditCompletionDialog dialog = new EditCompletionDialog(getShell(),transformation);
		if(dialog.open() == EditCompletionDialog.OK) {
			completionsViewer.refresh();
		}
		
	}

	@SuppressWarnings("unchecked")
	protected void removeCompletion() {
		IStructuredSelection selection = (IStructuredSelection) completionsViewer.getSelection();
		completionsViewer.getControl().setRedraw(false);
		for(Iterator i = selection.iterator();i.hasNext();) {
			Transformation transformation = (Transformation) i.next();
			transformations.remove(transformation);
			completionsViewer.refresh();
		}
		setTabModified();
		completionsViewer.getControl().setRedraw(true);
		
	}

	protected void newCompletion() {
		NewCompletionWizard wizard = new NewCompletionWizard();
		WizardDialog dialog = new WizardDialog(getShell(), wizard);
		dialog.setPageSize(500,500);
		if(dialog.open() == WizardDialog.OK) {
			transformations.add(wizard.getTransformation());
			completionsViewer.refresh();
			setTabModified();
		}
	}
	
	private CheckboxTableViewer createTable(Composite mainComponent, String[] viewerColumnTitles) {
		final CheckboxTableViewer tableviewer;
		
		tableviewer = CheckboxTableViewer.newCheckList(mainComponent, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		createColumns(tableviewer, viewerColumnTitles);
		tableviewer.setContentProvider(new ArrayContentProvider());
		tableviewer.setLabelProvider(new TransformationsLabelProvider());
		tableviewer.setCheckStateProvider(new TransformationsCheckBoxProvider());
		transformations = new ArrayList<Transformation>();
		
		tableviewer.setInput(transformations);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.verticalSpan = 6;
		tableviewer.getTable().setLayoutData(gd);
		
		tableviewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				Transformation entry = (Transformation)event.getElement();
				entry.setEnabled(event.getChecked());
				updateLaunchConfigurationDialog();
			}
		});
		
		tableviewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtons();
			}
		});
		
		return tableviewer;
	}

	private void createColumns(TableViewer viewer, String[] viewerColumnTitles ) {
		int[] columnWidths = { 50, 200, 200, 200};
		
		for(int i = 0; i < viewerColumnTitles.length; ++i) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(viewerColumnTitles[i]);
			column.getColumn().setWidth(columnWidths[i]);
		}
		
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	@Override
	public String getName() {
		return "CIP Completions";
	}
	
	@Override
	public Image getImage() {
		return RunConfigImages.getCompletionTabImage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		ArrayList<String> config = new ArrayList<String>();
		transformations.clear();
		try {
			config = (ArrayList<String>) configuration.getAttribute(ConstantsContainer.COMPLETION_CONFIG,new ArrayList<String>());
		} catch (CoreException e) {
			e.printStackTrace();
		}
		for (String transformationconfig : config) {
			Transformation transformation = new Transformation();
			transformation.readFromDataString(transformationconfig);
			transformations.add(transformation);
		}
		try {
			checkLoggingButton.setSelection(configuration.getAttribute(
					ConstantsContainer.COMPLETION_QVT_VERBOSE_LOGGING, false));
		} catch (CoreException e) {
			checkLoggingButton.setSelection(false);
		}
		completionsViewer.refresh();
		updateButtons();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		ArrayList<String> config = new ArrayList<String>();
		for (Transformation transformation : transformations) {
			config.add(transformation.toDataString());
		}
		configuration.setAttribute(ConstantsContainer.COMPLETION_CONFIG, config);
		configuration.setAttribute(ConstantsContainer.COMPLETION_QVT_VERBOSE_LOGGING,
				checkLoggingButton.getSelection());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}
	
	private class TransformationsLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			Transformation transformation = (Transformation) element;
			
			switch (columnIndex) {
			case 1:
				if(transformation.getType() == TransformationType.REGISTERED)
					return transformation.getCompletion().getName();
				else if(transformation.getQVTFileURI() != null)
					return new Path(transformation.getQVTFileURI()).lastSegment();
				else
					return new Path(transformation.getFeatureFileURI()).lastSegment();
			case 2:
				ArrayList<String> categories = new ArrayList<String>();
				
				if(transformation.getType() == TransformationType.REGISTERED) {
					categories.add("Registered");
					categories.addAll(transformation.getCompletion().getCategories());
				}
				else {
					categories.add("UserDefined");
					categories.add(transformation.getType().toString());
				}
				return categories.toString();
			case 3:
				return transformation.getConfigFileURI();
			default:
				break;
			}
			return null;
		}
		
	}
	
	private class TransformationsCheckBoxProvider implements ICheckStateProvider {

		@Override
		public boolean isChecked(Object element) {
			Transformation transformation = (Transformation) element;
			return transformation.isEnabled();
		}

		@Override
		public boolean isGrayed(Object element) {
			return false;
		}
		
	}
	
	public static String openModelDialog(Shell shell){
		String ret = null;
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
        dialog.setTitle("Select a Resource:"); 
        dialog.setMessage("Select Models:"); 
        dialog.setInput(ResourcesPlugin.getWorkspace().getRoot()); 
        //dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
        if (dialog.open() == IDialogConstants.OK_ID) {
            Object[] resources = (Object[]) dialog.getResult();
            StringBuffer arg = new StringBuffer();
            IResource resource = null;
            for(int i = 0; i < (resources.length - 1); ++i){
            	resource = (IResource) resources[i];
            	arg.append(URI.createPlatformResourceURI(resource.getFullPath().toString(),true));
            	arg.append(" ");
            }
            resource = (IResource)resources[resources.length - 1];
            arg.append(URI.createPlatformResourceURI(resource.getFullPath().toString(),true));
            ret = arg.toString();
        }
        return ret;
	}

}
