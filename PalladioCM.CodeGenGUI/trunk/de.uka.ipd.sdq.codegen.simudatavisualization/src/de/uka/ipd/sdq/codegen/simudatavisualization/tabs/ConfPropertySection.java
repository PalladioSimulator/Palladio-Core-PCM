/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.ModelPackage;
import org.eclipse.birt.chart.model.attribute.DataType;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.BaseSampleData;
import org.eclipse.birt.chart.model.data.DataFactory;
import org.eclipse.birt.chart.model.data.DataSet;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.OrthogonalSampleData;
import org.eclipse.birt.chart.model.data.Query;
import org.eclipse.birt.chart.model.data.SampleData;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.TextDataSet;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.QueryImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
import org.eclipse.birt.chart.model.type.BarSeries;
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
import org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider;
import org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider;
import org.eclipse.birt.chart.ui.swt.wizard.ChartWizard;
import org.eclipse.birt.chart.ui.swt.wizard.ChartWizardContext;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuPlugin;
import de.uka.ipd.sdq.codegen.simudatavisualization.actions.DataServiceProvider;
import de.uka.ipd.sdq.codegen.simudatavisualization.actions.UIServiceProvider;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.RunEntry;
import de.uka.ipd.sdq.codegen.simudatavisualization.views.ConfigEditorInput;
import de.uka.ipd.sdq.codegen.simudatavisualization.views.ReportView;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;

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
				EditorPart editor = (EditorPart) SimuPlugin.getDefault().getWorkbench()
					.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				ChartWithAxes cwa = ((ReportView) editor).getVisualization().getChart();
				run(composite.getShell(),cwa);
			}
		});
	}
	
	public void run(Shell shell, ChartWithAxes cwa) {
		ChartWizard wiz = new ChartWizard(shell);
		ChartWizardContext ctx = new ChartWizardContext(null);
		ctx.setModel(cwa);
		
		Axis xAxisPrimary = cwa.getPrimaryBaseAxes()[0];
		Axis yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);		

		DataSet xDs = ((Series)((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).getDataSet();
		DataSet yDs = ((Series)((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).getDataSet();
		((Series)((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).setDataSet(null);
		((Series)((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).setDataSet(null);
		SampleData sdt = DataFactory.eINSTANCE.createSampleData();
		BaseSampleData sdBAse = DataFactory.eINSTANCE.createBaseSampleData();
		sdBAse.setDataSetRepresentation("A");
		sdt.getBaseSampleData().add(sdBAse);
		OrthogonalSampleData sdOrth = DataFactory.eINSTANCE.createOrthogonalSampleData();
		sdOrth.setDataSetRepresentation("1");
		sdOrth.setSeriesDefinitionIndex(0);
		sdt.getOrthogonalSampleData().add(sdOrth);
		cwa.setSampleData(sdt);
		
		ctx.setDataServiceProvider( new DataServiceProvider());
		ctx.setUIServiceProvider(new UIServiceProvider());
		wiz.open(ctx);

		((Series)((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).setDataSet(xDs);
		((Series)((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).setDataSet(yDs);
		
		
		cleanEList(((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries());
		cleanEList(((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries());

		Query q = QueryImpl.create("");
		NumberDataSet categoryValues = NumberDataSetImpl.create(new double[] { 1, 2, 3});

		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);
		seCategory.getDataDefinition().add(q);
		((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries().add(seCategory);
		
		NumberDataSet orthovalues = null;
			orthovalues = NumberDataSetImpl.create(new double[]{0.2,0.3,0.4});
			
			BarSeries series = (BarSeries) BarSeriesImpl.create();
			series.setDataSet(orthovalues);
			series.getDataDefinition().add(q);
			series.getLabel().getCaption().setValue("Sensor");
			series.getLabel().setVisible(true);
			((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries().add(series);

			//series.setSeriesIdentifier(s.getSensorName() + " [ID:"
			//		+ s.getSensorID() + "]");

		
	}

	private void cleanEList(EList list){
		while (list.size() > 0)
			list.remove(0);
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
