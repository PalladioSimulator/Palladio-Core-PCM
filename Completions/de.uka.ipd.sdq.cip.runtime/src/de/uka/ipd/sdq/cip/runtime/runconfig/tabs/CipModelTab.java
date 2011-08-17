package de.uka.ipd.sdq.cip.runtime.runconfig.tabs;

import java.util.ArrayList;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


public class CipModelTab extends AbstractCipLaunchConfigurationTab {

	private class ModelList {
		public String name;
		public ArrayList<String> models; 
		
		public ModelList(String name) {
			models = new ArrayList<String>();
			this.name = name;
		}
	}
	
	private TreeViewer modelfilesViewer;
	private ModelList[] modelList; 
	
	@Override
	public void createControl(Composite parent) {
		Composite mainComponent = new Composite(parent,SWT.NONE);
		setControl(mainComponent);
		
		mainComponent.setFont(parent.getFont());
		
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		mainComponent.setLayout(layout);
		
		Label label = new Label(mainComponent,SWT.LEFT);
		label.setText("Transformations:");
		GridData gd = new GridData(SWT.FILL,SWT.TOP,true,false);
		gd.horizontalSpan = 3;
		label.setLayoutData(gd);
		modelfilesViewer = createTree(mainComponent);
		gd = new GridData(SWT.FILL,SWT.FILL,true,false);
		//gd.horizontalSpan = ;
		modelfilesViewer.getTree().setLayoutData(gd);
		
	}

	private TreeViewer createTree(Composite mainComponent) {
		
		final TreeViewer treeviewer;
		
		treeviewer = new TreeViewer(mainComponent,SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		treeviewer.setLabelProvider(new ModelInputOutputLabelProvider());
		treeviewer.setContentProvider(new ModelInputOutputContentProvider());
		modelList = new ModelList[2];
		modelList[0] = new ModelList("Input Models");
		modelList[1] = new ModelList("Output Models");
		treeviewer.setInput(modelList);
		return treeviewer;
	}

	@Override
	public String getName() {
		return "CIP Input/Output Models";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}
	
	public class ModelInputOutputContentProvider extends ArrayContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof ModelList)
			{
				ModelList modelList = (ModelList) parentElement;
				return modelList.models.toArray();
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if(element instanceof ModelList)
			{
				ModelList modelList = (ModelList) element;
				return modelList.models.size() > 0;
			}
			return false;
		}
		
	}
	
	public class ModelInputOutputLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if(element instanceof ModelList)
			{
				ModelList modelList = (ModelList) element;
				return modelList.name;
			}
			return (String)element;
		}
		
	}

}
