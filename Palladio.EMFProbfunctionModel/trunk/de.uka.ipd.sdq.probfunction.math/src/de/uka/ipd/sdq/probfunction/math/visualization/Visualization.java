
package de.uka.ipd.sdq.probfunction.math.visualization;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.ChartDimension;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
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
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.layout.Plot;
import org.eclipse.birt.chart.model.type.BarSeries;
import org.eclipse.birt.chart.model.type.LineSeries;
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
import org.eclipse.birt.chart.model.type.impl.LineSeriesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
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
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author Ihssane
 * 
 */
public class Visualization {

	public static final int UNDEFINED = -1;

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
	private int pmfCounter = 0;
	private int pdfCounter = 0;
	private double maxValue = UNDEFINED;
	private double minValue = UNDEFINED;
	private int maxLength = Integer.MIN_VALUE;
	// private double distance;

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
		Collections.addAll(samples2, 0.1, 0.4, 0.2, 0.3, 0.5, 0.6);
		ISamplePDF s = null;
		s = pfFactory.createSamplePDFFromDouble(0.1, samples, null);

		scv.startAs(AppType.SWT);
		scv.setChartTyp(ChartType.LINECHART);

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
		scv.setMaxValue(0.4);
		scv.setMinValue(0.1);
//		 scv.exportChartToPNG("chart.png");
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
			ISamplePDF samplePDF = (ISamplePDF) pf;
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

	@SuppressWarnings({"unchecked", "deprecation"})
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

		ChartWithAxes cwa = ChartWithAxesImpl.create();
		cwa.getBlock().setBackground(backgroung);
		cwa.getBlock().getOutline().setVisible(true);
		cwa.setDimension(ChartDimension.TWO_DIMENSIONAL_LITERAL);

		// CUSTOMIZE THE PLOT
		Plot p = cwa.getPlot();
		p.getClientArea().setBackground(
				ColorDefinitionImpl.create(255, 255, 225));
		p.getOutline().setVisible(true);
		cwa.getTitle().getLabel().getCaption().setValue(chartTitle);
		cwa.getTitle().setVisible(isChartTilteVisible);

		// CUSTOMIZE THE LEGEND
		cwa.getLegend().setVisible(false);

		// CUSTOMIZE THE X-AXIS
		Axis xAxisPrimary = cwa.getPrimaryBaseAxes()[0];
		xAxisPrimary.getTitle().getCaption().setValue(xAxisTitle);
		xAxisPrimary.getTitle().setVisible(isXAxisTitleVisible);

		// CUSTOMIZE THE Y-AXIS
		Axis yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);
//		yAxisPrimary.getMajorGrid().setTickSize(0.1);
//		yAxisPrimary.setFormatSpecifier(new FormatSpecifierImpl().)
		yAxisPrimary.getTitle().getCaption().setValue(yAxisTitle);
		yAxisPrimary.getTitle().setVisible(isYAxisTitleVisible);

		// INITIALIZE A COLLECTION WITH THE X-SERIES DATA
		TextDataSet categoryValues = TextDataSetImpl.create(wrappers.get(0)
				.getValues());

		// CREATE THE CATEGORY BASE SERIES

		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);
		// INITIALIZE A COLLECTION WITH THE Y-SERIES DATA

		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION

		SeriesDefinition sdX = SeriesDefinitionImpl.create();
		sdX.getSeriesPalette().update(0); // SET THE COLORS IN THE PALETTE
		xAxisPrimary.getSeriesDefinitions().add(sdX);
		sdX.getSeries().add(seCategory);

		NumberDataSet orthoValues1 = null;
		Series series = null;
		for (FunctionWrapper wrapper : wrappers) {
			orthoValues1 = NumberDataSetImpl.create(wrapper.getProbabilities());
			// CREATE THE VALUE ORTHOGONAL SERIES
			if (chartTyp == ChartType.LINECHART) {
				series = (LineSeries) LineSeriesImpl.create();
				cwa.setDimension(ChartDimension.TWO_DIMENSIONAL_LITERAL);
				((LineSeries) series).setConnectMissingValue(true);
				((LineSeries) series).getMarker().setVisible(false);
				
			} else {
				series = (BarSeries) BarSeriesImpl.create();
				cwa
						.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);
			}
			// CREATE THE VALUE ORTHOGONAL SERIES
			series.setSeriesIdentifier("My Bar Series");
			series.setDataSet(orthoValues1);
			series.getLabel().setVisible(false);

			// WRAP THE ORTHOGONAL SERIES IN THE X-AXIS SERIES DEFINITION

			SeriesDefinition sdY = SeriesDefinitionImpl.create();
			sdY.getSeriesPalette().update(1); // SET THE COLOR IN THE PALETTE
			yAxisPrimary.getSeriesDefinitions().add(sdY);
			sdY.getSeries().add(series);
		}
		cm = cwa;
	}
	public void exportChartToPNG(String fileName) {
		if (wrappers.size() == 0) {
			System.err.println("no data to visualize !");
			return;
		}
		createChart();

		PNGExporter pngr = new PNGExporter(cm);
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

}
