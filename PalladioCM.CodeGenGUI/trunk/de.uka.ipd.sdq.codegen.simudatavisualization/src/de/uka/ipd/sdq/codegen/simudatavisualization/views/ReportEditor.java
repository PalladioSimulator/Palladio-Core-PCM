package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuPlugin;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.ReportCongiguration;

public class ReportEditor extends EditorPart implements ITabbedPropertySheetPageContributor{
	
	public static String EDITOR_ID = "de.uka.ipd.sdq.codegen.simudatavisualization.views.ReportEditor";
	
	private ReportCongiguration configObject;
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
    	 setSite(site);
    	 setInput(input);
    	 
    	 // Create configuratio object
    	 configObject = new ReportCongiguration();
    	 SimuPlugin.getDefault().getConfigObjects().add(configObject);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		IDeviceRenderer idr = null;
		final PluginSettings ps = PluginSettings.instance();
		try {
			idr = ps.getDevice("dv.SWT");
		} catch (ChartException pex) {
			DefaultLoggerImpl.instance().log(pex);
		}
		ChartWithAxes cwaEmpty = ChartWithAxesImpl.create();
		cwaEmpty.getTitle().getLabel().getCaption().setValue("Hello Chart");
		
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
		
	}
	
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	@Override
	public void setFocus() {
	}

	@Override
	public String getContributorId() {
		return getSite().getId();
	}

	public ReportCongiguration getConfigObject() {
		return configObject;
	}

	

}
