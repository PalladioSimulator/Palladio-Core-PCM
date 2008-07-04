package de.uka.ipd.sdq.featureinstance;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;

import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.Node;
import de.uka.ipd.sdq.featuremodel.impl.FeatureGroupImpl;
import de.uka.ipd.sdq.featuremodel.impl.FeatureImpl;

public class FeatureModelInstanceEditor extends MultiPageEditorPart {

    private int currentXPos = 10;
    private int currentYPos = 20;
    private int height = 0;
    private URI fileUri;
	
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (!(input instanceof IFileEditorInput)) {
            throw new PartInitException("Invalid");
		}
		else {
			IFile selected = ((IFileEditorInput)input).getFile();
			fileUri = URI.createPlatformResourceURI(selected.getFullPath().toString(), true); 
		}
        super.init(site, input);
	}

	
	@Override
	protected void createPages() {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("FeatDiag", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();
		
		// Get the resource
		Resource resource = resSet.getResource(fileUri, true);
		
		// Get the first model element and cast it to the right type
		FeatureDiagram newDiagram = (FeatureDiagram) resource.getContents().get(0);
		
		Composite composite = new Composite(getContainer(), SWT.NONE);
        composite.setLayout(null);
        
        composite = paintNodes(composite, (FeatureImpl)newDiagram.getRootFeature());
        
		int index = addPage(composite);
        setPageText(index, "MUH");
	}

	public Composite paintNodes (Composite comp, FeatureImpl rootN) {
		if ((currentXPos-10)/40 > height) {
			height = (currentXPos-10)/40;
		}
		if (!(rootN.getClass().getSimpleName().equals("FeatureGroup") || rootN.getClass().getSimpleName().equals("FeatureGroupImpl"))) {
			Button currentButton = new Button(comp, SWT.CHECK);
			currentButton.setText(rootN.getName());
			currentButton.setSize(currentButton.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			if (rootN.isIsMandatory()) {
				currentButton.setSelection(true);
			}
			currentButton.setLocation(currentXPos, currentYPos);
			currentYPos += 20;
			
			EList<Node> children = rootN.getChildren();
			Iterator<Node> iter = children.iterator();
			currentXPos += 40;
			while (iter.hasNext()) {
				Node next = iter.next();
				if (next.getClass().getSimpleName().equals("FeatureGroupImpl") || next.getClass().getSimpleName().equals("FeatureGroup")) {
					paintFeatureGroup(comp, next);
				}
				else {
					paintNodes(comp,(FeatureImpl)next);
				}
			}
			currentXPos -= 40;
			return comp;
		}
		else {
			paintFeatureGroup(comp, rootN);
		}
		return comp;
	}
	
	public Composite paintFeatureGroup (Composite comp, Node groupNode) {
		FeatureGroupImpl group = (FeatureGroupImpl)groupNode;
		int min = group.getMin();
		int max = group.getMax();
		Composite nodeGroup = new Composite(comp,SWT.NONE);

		if (min == 1 && max == 1) {
			nodeGroup.setLocation(currentXPos, currentYPos);
			currentXPos = 0;
			currentYPos = 0;
			
			EList<Feature> nodeList = group.getChildren();
			Iterator<Feature> nodeIter = nodeList.iterator();

			while (nodeIter.hasNext()) {
				Feature currentFeature = nodeIter.next();
				Button currentButton = new Button(nodeGroup, SWT.RADIO);
				currentButton.setText(currentFeature.getName());
				currentButton.setSize(currentButton.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				if (currentFeature.isIsMandatory()) {
					currentButton.setSelection(true);
				}
				currentButton.setLocation(currentXPos, currentYPos);
				currentYPos += 20;
				
				EList<Node> children = currentFeature.getChildren();
				Iterator<Node> iter = children.iterator();
				currentXPos += 40;
				while (iter.hasNext()) {
					Node next = iter.next();
					if (next.getClass().getSimpleName().equals("FeatureGroupImpl") || next.getClass().getSimpleName().equals("FeatureGroup")) {
						paintFeatureGroup(nodeGroup, next);
					}
					else {
						paintNodes(nodeGroup,(FeatureImpl)next);
					}
				}
				currentXPos -= 40;
			}
			nodeGroup.setSize(nodeGroup.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		}
	
		currentXPos = nodeGroup.getLocation().x;
		currentYPos = currentYPos + nodeGroup.getLocation().y;
		return comp;
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}


	public FeatureModelInstanceEditor() {
		super();
	}

}
