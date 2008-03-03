/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import javax.swing.text.TableView;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * @author Roman Andrej
 *
 */
public class FilterparameterSection extends AbstractPropertySection {

	/**
	 * The Property Sheet Page used to display the standard properties.
	 */
	protected PropertySheetPage page;
	
	/** Style the style of table to construct. */
	int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
			| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;
	

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory()
			.createFlatFormComposite(parent);
		//Table table = new Table(composite, style);
//		final FormData fd_table = new FormData();
//		fd_table.left = new FormAttachment(0, 0);
//		fd_table.right = new FormAttachment(100, 0);
//		fd_table.top = new FormAttachment(0, 0);
//		fd_table.bottom = new FormAttachment(100, 0);
//		table.setLayoutData(fd_table);

		page = new PropertySheetPage();
		
		page.createControl(composite);
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		page.getControl().setLayoutData(data);
		
		
		
		
//		adapterFactory = new ComposedAdapterFactory();
//		adapterFactory
//			.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
//		adapterFactory
//			.addAdapterFactory(new SeffItemProviderAdapterFactory());
//		adapterFactory
//			.addAdapterFactory(new ResourceItemProviderAdapterFactory());
//		adapterFactory
//				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
//		
//		page
//		.setPropertySourceProvider(new AdapterFactoryContentProvider(
//				adapterFactory));
	}
	

}
