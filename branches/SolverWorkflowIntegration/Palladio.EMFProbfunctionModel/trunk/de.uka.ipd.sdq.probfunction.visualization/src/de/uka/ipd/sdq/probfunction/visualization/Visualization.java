package de.uka.ipd.sdq.probfunction.visualization;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.ModelPackage;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.TextDataSet;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author Ihssane
 * 
 */
public class Visualization {

	public static final int UNDEFINED = -1;
	public static final double DEFAULT_DISTANCE = 0.1;
	public static final String DEFAULT_CONFIG_FILE = "src/de/uka/ipd/sdq/probfunction/math/visualization/resource/defalutconfig.xml";

	public enum ChartType {
		BARCHART, LINECHART
	};
	public enum AppType {
		SWING, SWT
	};

	private static final String EMPTY_TITLE = "";
	private static final ColorDefinition DEFAULt_BACKGROUND = ColorDefinitionImpl
			.WHITE();
	private IProbabilityFunctionFactory dfFactory = IProbabilityFunctionFactory.eINSTANCE;

	private IDeviceRenderer idr = null;
	private Chart cm = null;
	private AppType startAs = AppType.SWING;
	private ChartType chartTyp = ChartType.BARCHART;
	private List<FunctionWrapper> wrappers;
	private String srcFile = DEFAULT_CONFIG_FILE;
	private int pmfCounter = 0;
	private int pdfCounter = 0;
	private double maxValue = UNDEFINED;
	private double minValue = UNDEFINED;
	private int maxLength = Integer.MIN_VALUE;
	private double distance = DEFAULT_DISTANCE;

	private String frameTilte = EMPTY_TITLE;
	private String chartTitle = EMPTY_TITLE;
	private String xAxisTitle = EMPTY_TITLE;
	private String yAxisTitle = EMPTY_TITLE;
	private ColorDefinition backgroung = DEFAULt_BACKGROUND;
	private boolean isChartTilteVisible = false;
	private boolean isXAxisTitleVisible = false;
	private boolean isYAxisTitleVisible = false;

	public Visualization() {
		System.setProperty("STANDALONE", "true");
		wrappers = new ArrayList<FunctionWrapper>();
	}

	public static void main(String[] ihs) {
		Visualization scv = new Visualization();
		IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

		List<Double> samples = new ArrayList<Double>();
		List<Double> samples2 = new ArrayList<Double>();
		Collections.addAll(samples, 0.2, 0.1, 0.3, 0.4);
		Collections.addAll(samples2, 0.1, 0.4, 0.2, 0.3, 0.5, 0.6, 0.3);
		ISamplePDF s = null;
		s = pfFactory.createSamplePDFFromDouble(0.1, samples, null);

		scv.startAs(AppType.SWT);
		//deprecated (acc. to Ihssane)... scv.setChartTyp(ChartType.LINECHART);

		try {
			scv.addProbabilityFunction(s);
			scv.addProbabilityFunction(pfFactory.createSamplePDFFromDouble(0.1,
					samples2, null));

		} catch (UnorderedDomainException e) {
			e.printStackTrace();
		} catch (UnknownPDFTypeException e) {
			e.printStackTrace();
		} catch (DifferentDomainsException e) {
			e.printStackTrace();
		}

		scv
				.setSourceConfigFile("src/de/uka/ipd/sdq/probfunction/math/visualization/resource/defalutconfig2.xml");

		// scv.setMaxValue(0.4);
		// scv.setMinValue(0.1);

		// scv.exportChartToImage("chart.svg", ImageFormat.SVG);
		scv.visualize();

	}

	public void visualize() {
		createChart();
		if (startAs == AppType.SWT)
			renderOnSwt();
		else
			renderOnSwing();
	}

	private void renderOnSwt() {
		final PluginSettings ps = PluginSettings.instance();
		try {
			idr = ps.getDevice("dv.SWT");
		} catch (ChartException pex) {
			DefaultLoggerImpl.instance().log(pex);
		}

		ChartSwtViewer csv = new ChartSwtViewer(idr, cm);

		GridLayout gl = new GridLayout();
		gl.numColumns = 1;
		Display d = Display.getDefault();
		Shell sh = new Shell(d);
		sh.setSize(500, 500);
		sh.setLayout(gl);
		sh.setText(frameTilte);

		GridData gd = new GridData(GridData.FILL_BOTH);
		Canvas cCenter = new Canvas(sh, SWT.NONE);
		cCenter.setLayoutData(gd);
		cCenter.addPaintListener(csv);
		sh.open();
		while (!sh.isDisposed()) {
			if (!d.readAndDispatch()) {
				d.sleep();
			}
		}
	}

	private void renderOnSwing() {
		final PluginSettings ps = PluginSettings.instance();
		try {
			idr = ps.getDevice("dv.SWING");
		} catch (ChartException pex) {
			DefaultLoggerImpl.instance().log(pex);
		}
		ChartSwingViewer csv = new ChartSwingViewer(idr, cm);
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container co = jf.getContentPane();
		co.setLayout(new BorderLayout());
		co.add(csv, BorderLayout.CENTER);
		// CENTER WINDOW ON SCREEN, ETC
		Dimension dScreen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dApp = new Dimension(800, 700);
		jf.setSize(dApp);
		jf.setLocation((dScreen.width - dApp.width) / 2,
				(dScreen.height - dApp.height) / 2);
		jf.setTitle(frameTilte);
		jf.setVisible(true);
	}

	public void addProbabilityFunction(IProbabilityFunction pf)
			throws UnorderedDomainException, UnknownPDFTypeException,
			DifferentDomainsException {
		FunctionWrapper wrapper = new FunctionWrapper();
		if (pf instanceof IProbabilityMassFunction) {
			IProbabilityMassFunction pmf = (IProbabilityMassFunction) pf;
			if (!checkNewPMF(pmf))
				throw new DifferentDomainsException();
			wrapper.addPMF(pmf);
			pmfCounter++;
		} else if (pf instanceof IBoxedPDF) {
			IBoxedPDF boxedPDF = (IBoxedPDF) pf;
			addProbabilityFunction(dfFactory.transformToSamplePDF(boxedPDF));
			return;
		}
		if (pf instanceof ISamplePDF) {
			ISamplePDF samplePDF = null;
			try {
				samplePDF = ((ISamplePDF) pf)
						.getFunctionWithNewDistance(distance);
			} catch (NegativeDistanceException e) {
				e.printStackTrace();
			} catch (FunctionNotInTimeDomainException e) {
				e.printStackTrace();
			}
			if (!checkNewSamplePDF(samplePDF))
				throw new DifferentDomainsException();
			wrapper.addSamplePDF(samplePDF);
			maxLength = Math.max(maxLength, samplePDF.getValues().size());
			pdfCounter++;
		}
		wrappers.add(wrapper);
	}

	private boolean checkNewPMF(IProbabilityMassFunction pmf) {
		if (pdfCounter > 0)
			return false;

		if (!pmf.haveSameDomain((IProbabilityMassFunction) wrappers.get(0)
				.getOriginal()))
			return false;
		if (!pmf.hasOrderedDomain())
			return false;

		return true;
	}

	private boolean checkNewSamplePDF(ISamplePDF samplePDF) {
		if (pmfCounter > 0)
			return false;
		return true;
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

	private void createChart() {

		if (wrappers.size() == 0) {
			System.err.println("no data to visualize !");
			return;
		}

		for (FunctionWrapper w : wrappers) {
			w.setMax(maxValue);
			w.setMin(minValue);
			w.setValuesSize(maxLength);
		}

		EObject o = loadFromXMI(srcFile);
		// ChartWithAxes cwa = ChartWithAxesImpl.create();
		ChartWithAxes cwa1 = (ChartWithAxesImpl) o;

		// CUSTOMIZE THE X-AXIS
		Axis xAxisPrimary = cwa1.getPrimaryBaseAxes()[0];

		// CUSTOMIZE THE Y-AXIS
		Axis yAxisPrimary = cwa1.getPrimaryOrthogonalAxis(xAxisPrimary);

		// INITIALIZE A COLLECTION WITH THE X-SERIES DATA
		TextDataSet categoryValues = TextDataSetImpl.create(wrappers.get(0)
				.getValues());

		// Series seCategory = SeriesImpl.create();
		// seCategory.setDataSet(categoryValues);

		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION
		Series seriesX = (Series) (((SeriesDefinition) xAxisPrimary
				.getSeriesDefinitions().get(0)).getSeries().get(0));
		seriesX.setDataSet(categoryValues);
		//
		// INITIALIZE A COLLECTION WITH THE Y-SERIES DATA
		NumberDataSet orthoValues1 = null;
		int i = 0;
		for (FunctionWrapper wrapper : wrappers) {
			orthoValues1 = NumberDataSetImpl.create(wrapper.getProbabilities());
			Series series = (Series) (((SeriesDefinition) yAxisPrimary
					.getSeriesDefinitions().get(i)).getSeries().get(0));
			series.setDataSet(orthoValues1);
			i++;
		}
		cm = cwa1;
	}
	public void exportChartToImage(String fileName,
			ExportHandler.ImageFormat format) {
		if (wrappers.size() == 0) {
			System.err.println("no data to visualize !");
			return;
		}
		createChart();

		ExportHandler pngr = new ExportHandler(cm, format);
		pngr.exportChartToPNGImage(fileName);
	}

	/**
	 * 
	 */
	public void startAs(AppType app) {
		this.startAs = app;
	}

	/**
	 * @return the backgroung
	 */
	public ColorDefinition getBackgroung() {
		return backgroung;
	}

	/**
	 * @param backgroung
	 *            the backgroung to set
	 */
	public void setBackgroung(ColorDefinition backgroung) {
		this.backgroung = backgroung;
	}

	/**
	 * @return the chartTitle
	 */
	public String getChartTitle() {
		return chartTitle;
	}

	/**
	 * @param chartTitle
	 *            the chartTitle to set
	 */
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	/**
	 * @return the frameTilte
	 */
	public String getFrameTilte() {
		return frameTilte;
	}

	/**
	 * @param frameTilte
	 *            the frameTilte to set
	 */
	public void setFrameTilte(String frameTilte) {
		this.frameTilte = frameTilte;
	}

	/**
	 * @return the isChartTilteVisible
	 */
	public boolean isChartTilteVisible() {
		return isChartTilteVisible;
	}

	/**
	 * @param isChartTilteVisible
	 *            the isChartTilteVisible to set
	 */
	public void setChartTilteVisible(boolean isChartTilteVisible) {
		this.isChartTilteVisible = isChartTilteVisible;
	}

	/**
	 * @return the isXAxisTitleVisible
	 */
	public boolean isXAxisTitleVisible() {
		return isXAxisTitleVisible;
	}

	/**
	 * @param isXAxisTitleVisible
	 *            the isXAxisTitleVisible to set
	 */
	public void setXAxisTitleVisible(boolean isXAxisTitleVisible) {
		this.isXAxisTitleVisible = isXAxisTitleVisible;
	}

	/**
	 * @return the isYAxisTitleVisible
	 */
	public boolean isYAxisTitleVisible() {
		return isYAxisTitleVisible;
	}

	/**
	 * @param isYAxisTitleVisible
	 *            the isYAxisTitleVisible to set
	 */
	public void setYAxisTitleVisible(boolean isYAxisTitleVisible) {
		this.isYAxisTitleVisible = isYAxisTitleVisible;
	}

	/**
	 * @return the xAxisTitle
	 */
	public String getXAxisTitle() {
		return xAxisTitle;
	}

	/**
	 * @param axisTitle
	 *            the xAxisTitle to set
	 */
	public void setXAxisTitle(String axisTitle) {
		xAxisTitle = axisTitle;
	}

	/**
	 * @return the yAxisTitle
	 */
	public String getYAxisTitle() {
		return yAxisTitle;
	}

	/**
	 * @param axisTitle
	 *            the yAxisTitle to set
	 */
	public void setYAxisTitle(String axisTitle) {
		yAxisTitle = axisTitle;
	}

	/**
	 * @return the chartTyp
	 */
	public ChartType getChartTyp() {
		return chartTyp;
	}

	/**
	 * @param chartTyp
	 *            the chartTyp to set
	 */
	public void setChartTyp(ChartType chartTyp) {
		this.chartTyp = chartTyp;
	}

	/**
	 * @param maxValue
	 *            the maxValue to set
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @param minValue
	 *            the minValue to set
	 */
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the source File
	 */
	public String getSourceConfigFile() {
		return srcFile;
	}

	/**
	 * @param srcFile
	 *            the srcFile to set
	 */
	public void setSourceConfigFile(String srcFile) {
		this.srcFile = srcFile;
	}

}
