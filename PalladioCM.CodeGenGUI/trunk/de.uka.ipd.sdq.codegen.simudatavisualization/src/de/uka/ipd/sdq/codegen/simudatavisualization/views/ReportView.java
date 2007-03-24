/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * @author admin
 *
 */
public class ReportView extends ViewPart implements ITabbedPropertySheetPageContributor{
	
	private ListViewer viewer;
	/**
	 * 
	 */
	public ReportView() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new ListViewer(parent);
		
//		IDeviceRenderer idr = null;
//		final PluginSettings ps = PluginSettings.instance();
//		try {
//			idr = ps.getDevice("dv.SWT");
//		} catch (ChartException pex) {
//			DefaultLoggerImpl.instance().log(pex);
//		}
//		ChartWithAxes cwaEmpty = ChartWithAxesImpl.create();
//		cwaEmpty.getTitle().getLabel().getCaption().setValue("Hello Chart");
		getSite().setSelectionProvider(new ISelectionProvider(){

			@Override
			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public ISelection getSelection() {
				return new StructuredSelection(this);
			}

			@Override
			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setSelection(ISelection selection) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		 viewer.getControl().setFocus();

	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor#getContributorId()
	 */
	public String getContributorId() {
		return getSite().getId();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}
}
