/**
 * 
 */
package de.uka.ipd.sdq.cip.launchconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.completions.CompletionEntry;
import de.uka.ipd.sdq.cip.completions.CompletionType;





/**
 * 
 * 
 * @author Thomas Schuischel
 */
public class CompletionTab extends
		AbstractLaunchConfigurationTab {
	
	private Text fInputModelSet;
	//private Text fOutputModelSet;
	private Text fTracesDirectory;
	private Button fCustomTracesDirectory;
	private Button customBrowseButton;
	private Button fIntermediateModels;
	private CheckboxTableViewer fTransformations;
	private ModifyListener modifyListener;
	private SelectionListener selectionListener;
	private ArrayList<CompletionEntry> completionEntrys;

	
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setTabModified();
			}
		};
		selectionListener = new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				setTabModified();
				fTracesDirectory.setEnabled(fCustomTracesDirectory.getSelection());
				customBrowseButton.setEnabled(fCustomTracesDirectory.getSelection());
			}
		};
		
		Composite mainComponent = new Composite(parent,SWT.NONE);
		setControl(mainComponent);
		
		mainComponent.setFont(parent.getFont());
		
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		mainComponent.setLayout(layout);
		
		/*Label label = new Label(mainComponent,SWT.LEFT);
		label.setText("Input Models:");
		fInputModelSet = createText(mainComponent);
		createBrowseButton(mainComponent, fInputModelSet);*/
		
		/*label = new Label(mainComponent,SWT.LEFT);
		label.setText("Output Models:");
		fOutputModelSet = createText(mainComponent);
		createBrowseButton(mainComponent, fOutputModelSet);*/
		
		Label label = new Label(mainComponent,SWT.LEFT);
		label.setText("Transformations:");
		GridData gd = new GridData(SWT.FILL,SWT.TOP,true,false);
		gd.horizontalSpan = 3;
		label.setLayoutData(gd);
		fTransformations = createTable(mainComponent,new String[]{"Completion","Annotation"});
		//createTableButtons(mainComponent,fTransformations);
		
		fCustomTracesDirectory = new Button(mainComponent,SWT.CHECK);
		fCustomTracesDirectory.setText("Traces Directory:");
		fCustomTracesDirectory.addSelectionListener(selectionListener);
		fTracesDirectory = createText(mainComponent);
		customBrowseButton = createBrowseButton(mainComponent, fTracesDirectory);
		
		fIntermediateModels = new Button(mainComponent,SWT.CHECK);
		fIntermediateModels.setText("Delete intermediate model folder");
		fIntermediateModels.addSelectionListener(selectionListener);
		

		
		
		/*fQvtFile = createTextLine(mainComponent, modifyListener, "QVT File:",new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
                dialog.setTitle("Select a Resource:"); 
                dialog.setMessage("Select a resource to redirect output to:");
                //ResourcePatternFilter filter = new ResourcePatternFilter();
                //filter.setPatterns(new String[]{"*.qvt"});
                //dialog.addFilter(filter);
                dialog.setInput(ResourcesPlugin.getWorkspace().getRoot()); 
                //dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
                if (dialog.open() == IDialogConstants.OK_ID) {
                    IResource resource = (IResource) dialog.getFirstResult();
                    String arg = resource.getLocationURI().toString();
                    fQvtFile.setText(arg);
                }
            }
		});*/
		
		/*fOutputModelSet = createTextLine(mainComponent, modifyListener, "Second Set of Models:",new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
                dialog.setTitle("Select a Resource:"); 
                dialog.setMessage("Select the second Set of Models:"); 
                dialog.setInput(ResourcesPlugin.getWorkspace().getRoot()); 
                //dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
                if (dialog.open() == IDialogConstants.OK_ID) {
                    IResource resource = (IResource) dialog.getFirstResult();
                    String arg = resource.getFullPath().toString();
                    fOutputModelSet.setText(arg);
                }
            }
		});*/
		/*fTracesDirectory = createOptTextLine(mainComponent, modifyListener, "Traces Directory:",new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				IContainer container = null;
				//IContainer[] containers;
				//containers = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(URI.create("fTracesDirectory"));
				//if(containers.length > 0)
				//	container = containers[0];
				ContainerSelectionDialog dialog = new ContainerSelectionDialog (getShell(), container, true,"Select a Directory:");
                dialog.setTitle("Select a Directory:"); 
                dialog.setMessage("Select the Traces Directory:");  
                //dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
                if (dialog.open() == IDialogConstants.OK_ID) {
                	Object[] object =  dialog.getResult();
                	Path path = (Path) object[0];
                	String arg = path.toString();
                    fTracesDirectory.setText(arg);
                }
            }
		});*/
		//fExecDirection = createComboLine(mainComponent, "Execution Direction:");
		//fMetaModels = createListLine(mainComponent, "Metamodels:");
		
	
	}
	
	public Text createText(Composite parent){	
		final Text text = new Text(parent,SWT.SINGLE | SWT.BORDER);
		text.setFont(parent.getFont());
		text.addModifyListener(modifyListener);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    	text.setLayoutData(gd);
		return text;
	}
	
	public Button createBrowseButton(Composite parent, Text text){
		Button button = new Button(parent,SWT.PUSH);
		button.setText("Browse");
		button.addSelectionListener(new BrowseButtonSelectionAdapter(text));
		return button;
	}
	
	public CheckboxTableViewer createTable(Composite parent,final String[] columnHeader){
		
		final CheckboxTableViewer tableviewer;
		Table table = new Table(parent, SWT.CHECK | SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		table.setLayoutData(gd);
		
		table.setFont(parent.getFont());
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		for(int i = 0; i < columnHeader.length;++i)
		{
			TableColumn tc = new TableColumn(table, SWT.NONE);
			tc.setText(columnHeader[i]);
			if(i==1)
				tc.setWidth(300);
			else
				tc.setWidth(250);
		}
		
		tableviewer = new CheckboxTableViewer(table);
		tableviewer.setContentProvider(new TransformationContentProvider());
		tableviewer.setLabelProvider(new TransformationsLabelProvider());
		tableviewer.setColumnProperties(columnHeader);
		
		CellEditor[] cellEditors = new CellEditor[2];
		cellEditors[0] = null;//new TextCellEditor();
		cellEditors[1] = new AnnotationCellEditor(table);
		tableviewer.setCellEditors(cellEditors);
		
		tableviewer.addCheckStateListener(new ICheckStateListener() {
				public void checkStateChanged(CheckStateChangedEvent event) {
					CompletionEntry entry = (CompletionEntry)event.getElement();
					entry.setActive(event.getChecked());
					updateLaunchConfigurationDialog();
				}
			});
		
		tableviewer.setCellModifier(new ICellModifier(){
			@Override
			public boolean canModify(Object element, String property) {
				// Get the index first. 
		        int index = -1;
		        for(int i=0; i<columnHeader.length; i++) {
		          if(columnHeader[i].equals(property)) {
		            index = i;
		            break;
		          }
		        }
		        
		        switch(index) {
		          case 0:
		            return false;
		          case 1:
		            return true;
		        }
		        return false;
			}

			@Override
			public Object getValue(Object element, String property) {
				// Get the index first. 
		        int index = -1;
		        for(int i=0; i<columnHeader.length; i++) {
		          if(columnHeader[i].equals(property)) {
		            index = i;
		            break;
		          }
		        }
		        CompletionEntry entry = (CompletionEntry)element;
		        
		        switch(index) {
		          case 0:
		            return entry.getType().getName();
		          case 1:
		            return entry.getFeatureFile();
		        }
				return null;
			}

			@Override
			public void modify(Object element, String property, Object value) {
				 // Get the index first. 
		        int index = -1;
		        for(int i=0; i<columnHeader.length; i++) {
		          if(columnHeader[i].equals(property)) {
		            index = i;
		            break;
		          }
		        }
		        
		        CompletionEntry entry = null;
		        if(element instanceof Item) {
		          TableItem item = (TableItem)element;
		          entry = (CompletionEntry)item.getData();
		        }else{
		          entry = (CompletionEntry)element;
		        }
		        
		        switch(index) {
		          case 0:
		            //entry.id = (String)value;
		            break;
		          case 1:
		            entry.setFeatureFile((String)value);
		            setTabModified();
		            break;
		        }
		        
		        tableviewer.update(entry, null);
			}
			
		});
		return tableviewer;
	}
	
	public void createTableButtons(Composite parent,TableViewer tableviewer){
		Composite buttongroup = new Composite(parent, SWT.NONE);
		
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.fill = true;
		buttongroup.setLayout(layout);
		
		final Button addButton = new Button(buttongroup,SWT.PUSH);
		addButton.setText("Add...");
		//addButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		//addButton.addSelectionListener(new SelectionAdapter () {
		//	public void widgetSelected(SelectionEvent e) {
		//		openMetaModelDialog();
				/*ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
                dialog.setTitle("Select a Resource:"); 
                dialog.setMessage("Select Metamodels:"); 
                dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
                //dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
                if (dialog.open() == IDialogConstants.OK_ID) {
                    IResource resource = (IResource) dialog.getFirstResult();
                    String arg = resource.getFullPath().toString();
                    list.add(arg);
                    setTabModified();
                }*/
        //    }
		//});
		final Button removeButton = new Button(buttongroup,SWT.PUSH);
		removeButton.setText("Remove");
		//removeButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		/*removeButton.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index != -1)
					list.remove(index);
					setTabModified();
            }
		});*/
		final Button upButton = new Button(buttongroup,SWT.PUSH);
		upButton.setText("Up");
		//upButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		/*upButton.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index != -1)
				{
					String oldItem = list.getItem(index-1);
					String newItem = list.getItem(index);
					list.setItem(index-1, newItem);
					list.setItem(index, oldItem);
					list.setSelection(index-1);
					setTabModified();
				}
            }
		});*/
		final Button downButton = new Button(buttongroup,SWT.PUSH);
		downButton.setText("Down");
		//downButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		/*downButton.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index != -1)
				{
					String oldItem = list.getItem(index+1);
					String newItem = list.getItem(index);
					list.setItem(index+1, newItem);
					list.setItem(index, oldItem);
					list.setSelection(index+1);
					setTabModified();
				}
            }
		});*/
		
		removeButton.setEnabled(false);
		upButton.setEnabled(false);
		downButton.setEnabled(false);
		
		/*list.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index != -1)
				{
					removeButton.setEnabled(true);
					if(index > 0)
						upButton.setEnabled(true);
					else
						upButton.setEnabled(false);
					if(index < list.getItems().length-1)
						downButton.setEnabled(true);
					else
						downButton.setEnabled(false);
				}
				else
				{
					removeButton.setEnabled(false);
					upButton.setEnabled(false);
					downButton.setEnabled(false);
				}
            }
		});*/
	}
	
	public Text createOptTextLine(Composite parent, ModifyListener modifyListener, String labelCaption, SelectionListener selectionListener){	
		Button opt = new Button(parent,SWT.CHECK);
		opt.setText(labelCaption);
		final Text text = new Text(parent,SWT.SINGLE | SWT.BORDER);
		text.setFont(parent.getFont());
		text.addModifyListener(modifyListener);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    	text.setLayoutData(gd);
		Button button = new Button(parent,SWT.PUSH);
		button.setText("Browse");
		if(selectionListener != null)
			button.addSelectionListener(selectionListener);
		return text;
	}
	
	public Combo createComboLine(Composite parent,String labelCaption){	
		Label label = new Label(parent,SWT.LEFT);
		label.setText(labelCaption);
		Combo combo = new Combo(parent,SWT.NONE);
		combo.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    	combo.setLayoutData(gd);
		Button button = new Button(parent,SWT.PUSH);
		button.setText("Browse");
		button.setVisible(false);
		
		return combo;
	}
	
/*	public List createListLine(Composite parent,String labelCaption){
		Group fileInputGroup = new Group(parent, SWT.NONE);
		final GridLayout glFileInputGroup = new GridLayout();
		glFileInputGroup.numColumns = 2;
		fileInputGroup.setLayout(glFileInputGroup);
		fileInputGroup.setText(labelCaption); //The group name
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd.horizontalSpan = 3;
		fileInputGroup.setLayoutData(gd);
		
		final List list = new List(fileInputGroup,SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		list.setFont(parent.getFont());
		gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.verticalSpan = 5;
		list.setLayoutData(gd);
		
		final Button addButton = new Button(fileInputGroup,SWT.PUSH);
		addButton.setText("Add...");
		addButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		addButton.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				openMetaModelDialog();
//				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
//                dialog.setTitle("Select a Resource:"); 
//                dialog.setMessage("Select Metamodels:"); 
//                dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
//                //dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
//                if (dialog.open() == IDialogConstants.OK_ID) {
//                    IResource resource = (IResource) dialog.getFirstResult();
//                    String arg = resource.getFullPath().toString();
//                    list.add(arg);
//                    setTabModified();
//                }
            }
		});
		final Button removeButton = new Button(fileInputGroup,SWT.PUSH);
		removeButton.setText("Remove");
		removeButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		removeButton.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index != -1)
					list.remove(index);
					setTabModified();
            }
		});
		final Button upButton = new Button(fileInputGroup,SWT.PUSH);
		upButton.setText("Up");
		upButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		upButton.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index != -1)
				{
					String oldItem = list.getItem(index-1);
					String newItem = list.getItem(index);
					list.setItem(index-1, newItem);
					list.setItem(index, oldItem);
					list.setSelection(index-1);
					setTabModified();
				}
            }
		});
		final Button downButton = new Button(fileInputGroup,SWT.PUSH);
		downButton.setText("Down");
		downButton.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		downButton.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index != -1)
				{
					String oldItem = list.getItem(index+1);
					String newItem = list.getItem(index);
					list.setItem(index+1, newItem);
					list.setItem(index, oldItem);
					list.setSelection(index+1);
					setTabModified();
				}
            }
		});
		
		removeButton.setEnabled(false);
		upButton.setEnabled(false);
		downButton.setEnabled(false);
		
		list.addSelectionListener(new SelectionAdapter () {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index != -1)
				{
					removeButton.setEnabled(true);
					if(index > 0)
						upButton.setEnabled(true);
					else
						upButton.setEnabled(false);
					if(index < list.getItems().length-1)
						downButton.setEnabled(true);
					else
						downButton.setEnabled(false);
				}
				else
				{
					removeButton.setEnabled(false);
					upButton.setEnabled(false);
					downButton.setEnabled(false);
				}
            }
		});
		
		
		return list;
	}*/
	
	public void setTabModified(){
		CompletionTab.this.setDirty(true);
		CompletionTab.this.updateLaunchConfigurationDialog();
	}
	
	public void openMetaModelDialog(){
		//MetaModelSelectionDialog selectionDialog = new MetaModelSelectionDialog(getShell());
		//selectionDialog.open();
		/*ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
        dialog.setTitle("Select a Resource:"); 
        dialog.setMessage("Select Metamodels:"); 
        dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
        //dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
        if (dialog.open() == IDialogConstants.OK_ID) {
            IResource resource = (IResource) dialog.getFirstResult();
            String arg = resource.getFullPath().toString();
            list.add(arg);
            setTabModified();
        }*/
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	@Override
	public String getName() {
		return "Completion";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			Map<String,String> completionSets = configuration.getAttribute(
					ConstantsContainer.COMPLETION, new HashMap<String,String>());
			
			completionEntrys = CompletionType.getCompletionEntrys(completionSets);
			
		} catch (CoreException e) {
			Activator.errorLogger(getName(),"Completion", e.getMessage());
		}
		fTransformations.setInput(completionEntrys);
		ArrayList<CompletionEntry> selectedEntrys = new ArrayList<CompletionEntry>();
		Iterator<CompletionEntry> iterator = completionEntrys.iterator();
		while(iterator.hasNext()){
			CompletionEntry entry = iterator.next();
			if(entry.isActive())
				selectedEntrys.add(entry);
		}
		fTransformations.setCheckedElements(selectedEntrys.toArray(new CompletionEntry[0]));
		fTracesDirectory.setEnabled(fCustomTracesDirectory.getSelection());
		customBrowseButton.setEnabled(fCustomTracesDirectory.getSelection());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		Map<String, String> completionConfig = new HashMap<String, String>();
		Iterator<CompletionEntry> iterator = completionEntrys.iterator();
		while(iterator.hasNext()){
			CompletionEntry entry = iterator.next();
			completionConfig.put(entry.getType().getId(), entry.toConfigString());
		}
		configuration.setAttribute(
				ConstantsContainer.COMPLETION,
				completionConfig);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
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
	
	class BrowseButtonSelectionAdapter extends SelectionAdapter{
		
		private Text text;
		public BrowseButtonSelectionAdapter(Text text) {
			this.text = text;
		}
		public void widgetSelected(SelectionEvent e) {
            text.setText(openModelDialog(getShell()));
        }
	}

	class TransformationContentProvider implements IStructuredContentProvider{

		@SuppressWarnings("unchecked")
		@Override
		public Object[] getElements(Object inputElement) {
			CompletionEntry[] elements = null;
			try {
				ArrayList<CompletionEntry> elementsList = (ArrayList<CompletionEntry>) inputElement;
				elements = elementsList.toArray(new CompletionEntry[0]);
			} catch (ClassCastException e) {
				e.printStackTrace();
				Activator.errorLogger(getName(),"Transform Content Provider", e.getMessage());
			}
			return elements;
		}

		@Override
		public void dispose() {}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
		
	}

	class TransformationsLabelProvider extends LabelProvider implements ITableLabelProvider{

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			String text = null;
			CompletionEntry completion = (CompletionEntry)element;
			
			switch (columnIndex) {
			case 0:
				text = completion.getType().getName();
				break;
			case 1:
				text = completion.getFeatureFile();
				break;	
			default:
				break;
			}
			return text;
		}
		
	}
	
	class AnnotationCellEditor extends DialogCellEditor {

		/**
		 * @param parent
		 */
		public AnnotationCellEditor(Composite parent) {
			super(parent);
		}

		@Override
		protected Object openDialogBox(Control cellEditorWindow) {
			String str = CompletionTab.openModelDialog(cellEditorWindow.getShell());
			return str;
		}
		
	}

	@Override
	public Image getImage() {
		return RunConfigImages.getCompletionTabImage();
	}
}
