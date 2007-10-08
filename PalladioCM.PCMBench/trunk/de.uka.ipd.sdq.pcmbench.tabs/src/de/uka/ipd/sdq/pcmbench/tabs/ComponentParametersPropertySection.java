/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.tabs.parameters.ComponentParametersEditorSection;
import de.uka.ipd.sdq.pcmbench.tabs.parameters.ParametersTabItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * @author Roman Andrej
 *
 */
public class ComponentParametersPropertySection extends AbstractPropertySection {
	
	/**
	 * The Property Sheet Page used to display the standard properties
	 */
	private ComposedAdapterFactory adapterFactory;
	private ComponentParametersEditorSection editorSection;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		Composite composite = getWidgetFactory()
			.createFlatFormComposite(parent);
		
		adapterFactory = new ComposedAdapterFactory();
		adapterFactory
		.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
		adapterFactory
		.addAdapterFactory(new SeffItemProviderAdapterFactory());
		adapterFactory
		.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
		.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		editorSection = new ComponentParametersEditorSection(composite);
		editorSection.setViewerContentProvider(new AdapterFactoryContentProvider(
				adapterFactory));
		editorSection.setViewerLabelProvider(new AdapterFactoryLabelProvider(
				new ParametersTabItemProviderAdapterFactory(
						new PalladioItemProviderAdapterFactory(adapterFactory))));


	
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Assert.isTrue(selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection) selection).getFirstElement();
		
		if (input instanceof GraphicalEditPart){
			GraphicalEditPart ep = (GraphicalEditPart)input;
			input = ep.getModel();
		}
		if (input instanceof View){
			input = ((View)input).getElement();
		}
		
//		if (input instanceof AssemblyContext) {
//			AssemblyContext context = (AssemblyContext) input;
//			EList<VariableUsage> variables = context
//					.getComponentParameterUsage_AssemblyContext();
//		}
				
		Assert.isTrue(input instanceof EObject);
		editorSection.getViewer().setInput(input);
	}
}
