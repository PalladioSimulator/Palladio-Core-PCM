/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.ModelPackage;
import org.eclipse.birt.chart.model.attribute.DataType;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.TextDataSet;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
import org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider;
import org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider;
import org.eclipse.birt.chart.ui.swt.wizard.ChartWizard;
import org.eclipse.birt.chart.ui.swt.wizard.ChartWizardContext;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuPlugin;
import de.uka.ipd.sdq.codegen.simudatavisualization.actions.DataServiceProvider;
import de.uka.ipd.sdq.codegen.simudatavisualization.actions.UIServiceProvider;

/**
 * @author admin
 * 
 */
public class ConfPropertySection extends AbstractPropertySection {

	protected PropertySheetPage page;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		// TODO Auto-generated method stub
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite composite = getWidgetFactory()
				.createFlatFormComposite(parent);
		
		final Label configLabel = new Label(composite, SWT.NONE);
		final FormData fd_configLabel = new FormData();
		fd_configLabel.bottom = new FormAttachment(0, 55);
		fd_configLabel.right = new FormAttachment(0, 235);
		fd_configLabel.top = new FormAttachment(0, 35);
		fd_configLabel.left = new FormAttachment(0, 50);
		configLabel.setLayoutData(fd_configLabel);
		configLabel.setText("Configuration of Chart View");

		Button button = new Button(composite, SWT.NONE);
		final FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(configLabel, -25, SWT.BOTTOM);
		fd_button.bottom = new FormAttachment(configLabel, 0, SWT.BOTTOM);
		fd_button.right = new FormAttachment(0, 275);
		fd_button.left = new FormAttachment(0, 245);
		button.setLayoutData(fd_button);
		button.setText("...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				run(composite.getShell());	
			}
		});
	}
	
	public void run(Shell parentShell) {
		
		ChartWithAxes cwa = (ChartWithAxes) loadFromXMI(getConfigFile());
		// CUSTOMIZE THE X-AXIS
		Axis xAxisPrimary = cwa.getPrimaryBaseAxes()[0];

		// CUSTOMIZE THE Y-AXIS
		Axis yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);

		// INITIALIZE A COLLECTION WITH THE X-SERIES DATA
		TextDataSet categoryValues = TextDataSetImpl.create(new String[]{"1","3","2"});

		// Series seCategory = SeriesImpl.create();
		// seCategory.setDataSet(categoryValues);

		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION
		Series seriesX = (Series) (((SeriesDefinition) xAxisPrimary
				.getSeriesDefinitions().get(0)).getSeries().get(0));
		//seriesX.setDataSet(categoryValues);
		//
		// INITIALIZE A COLLECTION WITH THE Y-SERIES DATA
		NumberDataSet orthoValues1 = null;
		for (int i=0; i<2; i++){
			orthoValues1 = NumberDataSetImpl.create(new double[]{1,2,3});
			Series series = (Series) (((SeriesDefinition) yAxisPrimary
						.getSeriesDefinitions().get(i)).getSeries().get(0));
			//series.setDataSet(orthoValues1);
		}
		ChartWizard wiz = new ChartWizard(parentShell);
		ChartWizardContext ctx = new ChartWizardContext(null);
		ctx.setModel(cwa);
		ctx.setDataServiceProvider( new DataServiceProvider());
		ctx.setUIServiceProvider(new UIServiceProvider());
		wiz.open(ctx);
		try {
			ctx.getModel().eResource().save(System.out, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static EObject loadFromXMI(String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extentions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI,
				ModelPackage.eINSTANCE);

		// Construct the URI for the instance file.
		// The argument is treated as a file path only if it denotes an existing
		// file. Otherwise, it's directly treated as a URL.
		File file = new File(fileName);
		URI uri = file.isFile()
				? URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(fileName);

		// Demand load resource for this file.
		Resource resource = resourceSet.getResource(uri, true);
		// System.out.println("Loaded " + uri);

		EObject eObject = (EObject) resource.getContents().get(0);
		return EcoreUtil.getRootContainer(eObject);
	}

	/**
	 * TODO
	 */
	public String getConfigFile() {
		Plugin plugin = SimuPlugin.getDefault();
		IPath path = new Path("conf/defalutconfig.xml");

		// where plugin is of type org.eclipse.core.runtime.Plugin:
		URL url = FileLocator.find(plugin.getBundle(), path, null);

		if (url != null)
			try {
				url = FileLocator.resolve(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return url.getFile().replaceFirst("/", "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return super.getSelection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		super.refresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		super.setInput(part, selection);
	}

}
