/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.util.Assert;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsPropertySectionTable;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabItemProviderAdapterFactory;


/**
 * @author Snowball
 * "Advanced" Property Section showing the original generated EMF
 * property sheet
 */
public class OperationsPropertySection
extends AbstractPropertySection {
	
	/**
	 * The Property Sheet Page used to display the standard properties
	 */
		
	private TableViewer tableViewer;
	private ComposedAdapterFactory adapterFactory;
	private OperationsPropertySectionTable sectionTable;

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
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
		
		sectionTable = new OperationsPropertySectionTable(composite);
		tableViewer = sectionTable.getTableViewer();
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory));
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new OperationsTabItemProviderAdapterFactory(adapterFactory)));
		
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Assert.isTrue(selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection)selection).getFirstElement();
		Assert.isTrue(input instanceof EObject);
		
		tableViewer.setInput(input);
		
		if (input instanceof Interface) {
			sectionTable.setToolBarListener((Interface) input);
		}
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#dispose()
	 */
	public void dispose() {
		super.dispose();
		
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		tableViewer.refresh();
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#shouldUseExtraSpace()
	 */
	public boolean shouldUseExtraSpace() {
		return true;
	}
}
