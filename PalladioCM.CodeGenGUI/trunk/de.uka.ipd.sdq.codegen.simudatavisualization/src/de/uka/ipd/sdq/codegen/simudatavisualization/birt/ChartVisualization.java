/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.birt;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.ModelPackage;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.TextDataSet;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
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

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuPlugin;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.TimeSpanSensorToDatasetAdapterFactory;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.RunEntry;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;

/**
 * @author admin
 * 
 */
public class ChartVisualization {

	private ChartWithAxes cwa;
	private Axis xAxisPrimary;
	private Axis yAxisPrimary;

	/**
	 * @param reportConf
	 */
	public ChartVisualization() {
		createDefaultChart();
	}

	public ChartWithAxes createDefaultChart() {
		// ChartWithAxes cwaEmpty = ChartWithAxesImpl.create();
		// cwaEmpty.getTitle().getLabel().getCaption().setValue("Hello Chart");

		cwa = (ChartWithAxes) loadFromXMI(getConfigFile());

		cwa.getTitle().getLabel().getCaption().setValue("It is a Test");
		// CUSTOMIZE THE X-AXIS
		xAxisPrimary = cwa.getPrimaryBaseAxes()[0];

		// CUSTOMIZE THE Y-AXIS
		yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);
		// yAxisPrimary.setType(AxisType.LINEAR_LITERAL);

		return cwa;
	}

	public ChartWithAxes initChart() {

		// INITIALIZE A COLLECTION WITH THE X-SERIES DATA
		// TODO
		TextDataSet categoryValues = TextDataSetImpl.create(new String[] { "1", "3", "2"});

		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);

		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION
		Series seriesX = (Series) (((SeriesDefinition) xAxisPrimary
				.getSeriesDefinitions().get(0)).getSeries().get(0));
		seriesX.setDataSet(categoryValues);

//		// get the first entry from configuration object
//		RunEntry runEntry = reportConf.getRunEntrys().get(0);
//
//		AdapterRegistry.singleton().addAdapterFactory(
//				new TimeSpanSensorToDatasetAdapterFactory(runEntry));
		
//		// ADD NEW SERIES AND SET DATA
//		NumberDataSet orthovalues = null;
//		for (Sensor s : runEntry.getSensors()) {
//			
//			orthovalues = NumberDataSetImpl.create(AdapterRegistry.singleton()
//					.getAdapter(s, Histogram.class));
//			
//			SeriesDefinition seriesDef = SeriesDefinitionImpl.create();
//			seriesDef.getSeriesPalette().update(ColorDefinitionImpl.BLUE());
//
//			Series series = SeriesImpl.create();
//			series.setSeriesIdentifier(s.getSensorName() + " [ID:"
//					+ s.getSensorID() + "]");
//			series.getLabel().setVisible(true);
//
//			series.setDataSet(orthovalues);
//			seriesDef.getSeries().add(series);
//			yAxisPrimary.getSeriesDefinitions().add(seriesDef);
//		}
		return cwa;
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
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath())
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

	/**
	 * @return the cwa
	 */
	public ChartWithAxes getChart() {
		return cwa;
	}
}
