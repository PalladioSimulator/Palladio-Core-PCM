/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.birt;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.ModelPackage;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.HorizontalAlignment;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.LegendItemType;
import org.eclipse.birt.chart.model.attribute.NumberFormatSpecifier;
import org.eclipse.birt.chart.model.attribute.Position;
import org.eclipse.birt.chart.model.attribute.TextAlignment;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.VerticalAlignment;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.attribute.impl.NumberFormatSpecifierImpl;
import org.eclipse.birt.chart.model.attribute.impl.TextAlignmentImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.DataElement;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.Query;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.TextDataSet;
import org.eclipse.birt.chart.model.data.impl.DataElementImpl;
import org.eclipse.birt.chart.model.data.impl.NumberDataElementImpl;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.QueryImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.layout.Legend;
import org.eclipse.birt.chart.model.type.BarSeries;
import org.eclipse.birt.chart.model.type.impl.AreaSeriesImpl;
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
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
		cwa = ChartWithAxesImpl.create();
		cwa.setType("Bar Chart");
		cwa.setSubType("Side-by-side");
		cwa.setUnits("ms");
		cwa.setUnitSpacing(0.0);
		
		cwa.getBlock().setBackground(ColorDefinitionImpl.WHITE());
		cwa.getBlock().getOutline().setVisible(true);
		cwa.getPlot().getClientArea().setBackground(ColorDefinitionImpl.YELLOW());
		cwa.getPlot().getOutline().setVisible(false);
		cwa.getPlot().setHorizontalSpacing(0);
		cwa.getPlot().setVerticalSpacing(0);
		
		cwa.getTitle().getLabel().getCaption().setValue("Response Time Histogram");
		
		Legend lg = cwa.getLegend();
		lg.getText().getFont().setSize(12);
		lg.setItemType(LegendItemType.SERIES_LITERAL);
		lg.setPosition(Position.BELOW_LITERAL);
		lg.setVisible(true);
		
		xAxisPrimary = cwa.getPrimaryBaseAxes()[0];
		xAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		xAxisPrimary.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);
		xAxisPrimary.getOrigin().setType(IntersectionType.VALUE_LITERAL);
		xAxisPrimary.getTitle().setVisible(false);
		
		yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);
		yAxisPrimary.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);
		yAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		NumberFormatSpecifier nfs = NumberFormatSpecifierImpl.create();
		nfs.setFractionDigits(2);
		yAxisPrimary.setFormatSpecifier(nfs);
		DataElement de = NumberDataElementImpl.create(0);
		yAxisPrimary.getScale().setMin(de);
		yAxisPrimary.getTitle().getCaption().getFont().setSize(9);
		TextAlignment ta = TextAlignmentImpl.create();
		ta.setHorizontalAlignment(HorizontalAlignment.CENTER_LITERAL);
		ta.setVerticalAlignment(VerticalAlignment.CENTER_LITERAL);
		yAxisPrimary.getTitle().getCaption().getFont().setAlignment(ta);
		yAxisPrimary.getTitle().setVisible(true);
		yAxisPrimary.getTitle().getCaption().setValue("Probability");
		
		//cwa = (ChartWithAxes) loadFromXMI(getConfigFile());
		// CUSTOMIZE THE X-AXIS
		//xAxisPrimary = cwa.getPrimaryBaseAxes()[0];

		// CUSTOMIZE THE Y-AXIS
		//yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);
	    //yAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		initChart();
		return cwa;
	}

	public ChartWithAxes initChart() {

		// INITIALIZE A COLLECTION WITH THE X-SERIES DATA
		// TODO
		Query q = QueryImpl.create("");
		NumberDataSet categoryValues = NumberDataSetImpl.create(new double[] { 0, 1, 2});

		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);
		seCategory.getDataDefinition().add(q);
		SeriesDefinition sdX = SeriesDefinitionImpl.create();
		sdX.getSeriesPalette().update(0);
		xAxisPrimary.getSeriesDefinitions().add(sdX);
		sdX.getSeries().add(seCategory);
		//sdX.getSeries().add(SeriesImpl.create());
		sdX.setQuery(q);
		
		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION
		//Series seriesX = (Series) (((SeriesDefinition) xAxisPrimary
		//		.getSeriesDefinitions().get(0)).getSeries().get(0));
		//seriesX.setDataSet(categoryValues);

//		// get the first entry from configuration object
//		RunEntry runEntry = reportConf.getRunEntrys().get(0);
//
//		AdapterRegistry.singleton().addAdapterFactory(
//				new TimeSpanSensorToDatasetAdapterFactory(runEntry));
		
		// ADD NEW SERIES AND SET DATA
		NumberDataSet orthovalues = null;
		// for (Sensor s : runEntry.getSensors()) {
			
//			orthovalues = NumberDataSetImpl.create(AdapterRegistry.singleton()
//					.getAdapter(s, Histogram.class));
			orthovalues = NumberDataSetImpl.create(new double[]{0.2,0.3,0.4});
			
			SeriesDefinition sdY = SeriesDefinitionImpl.create();
			sdY.getSeriesPalette().update(ColorDefinitionImpl.BLUE());

			Series series = BarSeriesImpl.create();
			series.setDataSet(orthovalues);
			series.setSeriesIdentifier("Series 1");
			series.getDataDefinition().add(q);
			series.getLabel().getCaption().setValue("Sensor");
			series.getLabel().setVisible(true);
			yAxisPrimary.getSeriesDefinitions().add(sdY);
			sdY.getSeries().add(series);
			//sdY.getSeries().add(SeriesImpl.create());
			sdY.setQuery(q);
		//}
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
