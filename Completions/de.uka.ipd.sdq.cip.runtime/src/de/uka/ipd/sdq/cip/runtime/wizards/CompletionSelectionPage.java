/**
 * 
 */
package de.uka.ipd.sdq.cip.runtime.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

import de.uka.ipd.sdq.cip.completions.RegisteredCompletion;
import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.runtime.RunConfigImages;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.FeatureConfig;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.UserDefined;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.UserDefinedID;

/**
 * @author thomass
 *
 */
public class CompletionSelectionPage extends WizardPage/* implements SelectionListener*/{


	private FilteredTree completionTree;
	private TreeViewer completionTreeViewer;
	private List<CompletionConfigNode> completionConfigNodes;

	protected CompletionSelectionPage(String pageName) {
		super(pageName);
		completionConfigNodes = new ArrayList<CompletionConfigNode>();
		try {
			completionConfigNodes.add(CompletionConfigNode.createWorkspaceNode());
		} catch (CoreException e) {
			e.printStackTrace();
		}
		completionConfigNodes.add(CompletionConfigNode.createRegisteredNode());
		completionConfigNodes.add(CompletionConfigNode.createUserDefinedNode());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite mainComponent = new Composite(parent, SWT.NONE);
		
		GridLayout mainlayout = new GridLayout();
		mainComponent.setLayout(mainlayout);
		
		completionTree = new FilteredTree(mainComponent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL, new PatternFilter(), true);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		completionTree.setLayoutData(gd);
		completionTreeViewer = completionTree.getViewer();
		
		completionTreeViewer.setContentProvider(new CompletionTypeTreeContentProvider());
		completionTreeViewer.setLabelProvider(new CompletionTypeTreeLabelProvider());
		completionTreeViewer.addSelectionChangedListener(new CompletionTypeSelectionListener());
		completionTreeViewer.setInput(completionConfigNodes);
		setControl(mainComponent);

	}
	
	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
	}
	
	@Override
	public boolean canFlipToNextPage() {
		IStructuredSelection selection = (IStructuredSelection) completionTreeViewer.getSelection();
		Object element = selection.getFirstElement();
		
		if(element == null)
			return false;
		
		if(element instanceof FeatureConfig) 
			return false;
		
		if(element instanceof RegisteredCompletion) {
			RegisteredCompletion completion = (RegisteredCompletion) element;
			if(!completion.containsCategory(ConstantsContainer.PLAIN_COMPLETION)) {
				return true;
			}
		}
		
		if(element instanceof UserDefined) {
			return true;
		}
		
		return false;
	}
	
	public boolean canFinish() {
		IStructuredSelection selection = (IStructuredSelection) completionTreeViewer.getSelection();
		Object element = selection.getFirstElement();
		
		if(element instanceof FeatureConfig)
			return true;
		
		if(element instanceof RegisteredCompletion) {
			RegisteredCompletion completion = (RegisteredCompletion) element;
			if(completion.containsCategory(ConstantsContainer.PLAIN_COMPLETION)) {
				return true;
			}
		}
		
		return false;
	}	
	
	Object getSelection() {
		IStructuredSelection selection = (IStructuredSelection) completionTreeViewer.getSelection();
		Object element = selection.getFirstElement();
		
		return element;
	}

	private class CompletionTypeSelectionListener implements ISelectionChangedListener {

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			getWizard().getContainer().updateButtons();
		}
		
	}
	
	private class CompletionTypeTreeContentProvider implements ITreeContentProvider{
		
		@Override
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof CompletionConfigNode)
				return ((CompletionConfigNode)parentElement).getChildren();
			return null;
		}
	
		@Override
		public Object getParent(Object element) {
				return null; 
		}
	
		@Override
		public boolean hasChildren(Object element) {
			if(element instanceof CompletionConfigNode)
				return true;
			return false;
		}
	
		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof List<?>)
				return ((List<?>) inputElement).toArray();
			return null;
		}
	
		@Override
		public void dispose() {			
		}
	
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	/**
	 * @author thomass
	 *
	 */
	public class CompletionTypeTreeLabelProvider extends LabelProvider implements ILabelProvider{

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(Object element) {
			if(element instanceof CompletionConfigNode)
				return RunConfigImages.getFolderIcon();
			if(element instanceof RegisteredCompletion) {
				if(((RegisteredCompletion)element).containsCategory(ConstantsContainer.MARK_COMPLETION))
					return RunConfigImages.getAnnotationIcon();
			}
			if(element instanceof UserDefined) {
				if(((UserDefined)element).getID() == UserDefinedID.ANNOTATED)
					return RunConfigImages.getAnnotationNewIcon();
			}
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			if(element instanceof CompletionConfigNode)
				return ((CompletionConfigNode) element).getCaption();
			else if(element instanceof FeatureConfig)
				return ((FeatureConfig) element).getName();
			else if(element instanceof RegisteredCompletion)
				return ((RegisteredCompletion) element).getName();
			else if(element instanceof UserDefined)
				return ((UserDefined) element).getCaption();
			return null;
		}


	}

}
