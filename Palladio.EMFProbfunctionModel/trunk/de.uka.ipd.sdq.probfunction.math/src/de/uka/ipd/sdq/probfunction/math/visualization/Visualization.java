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
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;

/**
 * @author Ihssane
 * 
 */
public class Visualization {

	public static final int SWING_APPL = 0;
	public static final int SWT_APPL = 1;
	public static final int BARCHART = 0;
	public static final int LINECHART = 1;
	private static final String EMPTY_TITLE = "";
	private static final ColorDefinition DEFAULt_BACKGROUND = ColorDefinitionImpl
			.WHITE();

	private IDeviceRenderer idr = null;
	private Chart cm = null;
	private int startAs = SWING_APPL;
	private int chartTyp = BARCHART;
	private int domainLength = 0;
	private List<Object> values;
	private List<Double> probabilities;

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

	}

	public static void main(String[] ihs) {
		Visualization scv = new Visualization();
		IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

		List<IContinuousSample> samples = new ArrayList<IContinuousSample>();
		Collections.addAll(samples, pfFactory.createContinuousSample(0.9, 0.2),
				pfFactory.createContinuousSample(1.5, 0.4), pfFactory
						.createContinuousSample(1.8, 0.2), pfFactory
						.createContinuousSample(2.4, 0.1), pfFactory
						.createContinuousSample(0.7, 0.1));
		IBoxedPDF boxed = null;
		try {
			boxed = pfFactory.createBoxedPDF(samples, null);
		} catch (DoubleSampleException e) {
			e.printStackTrace();
		}

		scv.startAs(Visualization.SWT_APPL);
		scv.setChartTyp(Visualization.BARCHART);
		// scv.setDomainLength(5);
		scv.addBoxedPDF(boxed);
		scv.exportChartToPNG("chart.png");
		scv.visualize();

	}

	private void createChart() {
		if (values == null || probabilities == null) {
			System.err.println("no data to visualize !");
			return;
		}
		createChart(values, probabilities);
	}
	
	public void visualize() {
		createChart();
		if (startAs == SWT_APPL)
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

	public void addProbabilityFunction(IProbabilityFunction pf) {
		if (pf instanceof IProbabilityMassFunction) {
			IProbabilityMassFunction pmf = (IProbabilityMassFunction) pf;
			addPMF(pmf);
		} else if (pf instanceof IBoxedPDF) {
			IBoxedPDF boxedPDF = (IBoxedPDF) pf;
			addBoxedPDF(boxedPDF);
		}
		if (pf instanceof ISamplePDF) {
			ISamplePDF samplePDF = (ISamplePDF) pf;
			addSamplePDF(samplePDF);
		}
	}

	/**
	 * @param pmf
	 */
	private void addPMF(IProbabilityMassFunction pmf) {
		List<Object> values = new ArrayList<Object>();
		List<Double> probs = new ArrayList<Double>();
		for (ISample s : pmf.getSamples()) {
			values.add(s.getValue());
			probs.add(s.getProbability());
		}
		this.values = values;
		this.probabilities = probs;
	}

	/**
	 * @param spdf
	 */
	private void addSamplePDF(ISamplePDF spdf) {
		List<Object> values = new ArrayList<Object>();
		for (int i = 1; i <= spdf.getValues().size(); i++)
			values.add(new Double(i));
		this.values = values;
		this.probabilities = spdf.getValuesAsDouble();
	}

	/**
	 * @param bpdf
	 */
	private void addBoxedPDF(IBoxedPDF bpdf) {
		List<Object> values = new ArrayList<Object>();
		List<Double> probs = new ArrayList<Double>();
		for (IContinuousSample s : bpdf.getSamples()) {
			values.add(s.getValue());
			probs.add(s.getProbability());
		}
		this.values = values;
		this.probabilities = probs;
	}

	@SuppressWarnings("unchecked")
	private void createChart(List<Object> values, List<Double> prob) {

		// BAR CHARTS ARE BASED ON CHARTS THAT CONTAIN AXES
		ChartWithAxes cwaBar = ChartWithAxesImpl.create();
		cwaBar.getBlock().setBackground(backgroung);
		cwaBar.getBlock().getOutline().setVisible(true);
		cwaBar.setDimension(ChartDimension.TWO_DIMENSIONAL_LITERAL);

		// CUSTOMIZE THE PLOT
		Plot p = cwaBar.getPlot();
		p.getClientArea().setBackground(
				ColorDefinitionImpl.create(255, 255, 225));
		p.getOutline().setVisible(true);
		cwaBar.getTitle().getLabel().getCaption().setValue(chartTitle);
		cwaBar.getTitle().setVisible(isChartTilteVisible);

		// CUSTOMIZE THE LEGEND
		cwaBar.getLegend().setVisible(false);
		// Legend lg = cwaBar.getLegend();
		// lg.getText().getFont().setSize(16);
		// lg.getInsets().set(10, 5, 0, 0);
		// lg.setAnchor(Anchor.NORTH_LITERAL);

		// CUSTOMIZE THE X-AXIS
		Axis xAxisPrimary = cwaBar.getPrimaryBaseAxes()[0];
		// xAxisPrimary.setType(AxisType.TEXT_LITERAL);
		// xAxisPrimary.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);
		// xAxisPrimary.getOrigin().setType(IntersectionType.VALUE_LITERAL);
		xAxisPrimary.getTitle().getCaption().setValue(xAxisTitle);
		xAxisPrimary.getTitle().setVisible(isXAxisTitleVisible);

		// CUSTOMIZE THE Y-AXIS
		Axis yAxisPrimary = cwaBar.getPrimaryOrthogonalAxis(xAxisPrimary);
		// yAxisPrimary.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);
		// yAxisPrimary.getMajorGrid().setTickCount(2);
		// yAxisPrimary.getMajorGrid().setTickSize(10);
		// yAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		// yAxisPrimary.getLabel().getCaption().getFont().setRotation(90);
		yAxisPrimary.getTitle().getCaption().setValue(yAxisTitle);
		yAxisPrimary.getTitle().setVisible(isYAxisTitleVisible);

		if (domainLength > 0 && domainLength <= values.size()) {
			values = values.subList(0, domainLength);
			prob = prob.subList(0, domainLength);
		}
		// INITIALIZE A COLLECTION WITH THE X-SERIES DATA
		TextDataSet categoryValues = TextDataSetImpl.create(values);

		// INITIALIZE A COLLECTION WITH THE Y-SERIES DATA
		NumberDataSet orthoValues1 = NumberDataSetImpl.create(prob);

		// CREATE THE CATEGORY BASE SERIES

		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);

		// CREATE THE VALUE ORTHOGONAL SERIES
		Series series = null;
		if (chartTyp == LINECHART) {
			series = (LineSeries) LineSeriesImpl.create();
			cwaBar.setDimension(ChartDimension.TWO_DIMENSIONAL_LITERAL);
		} else {
			series = (BarSeries) BarSeriesImpl.create();
			cwaBar
					.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);
		}

		// CREATE THE VALUE ORTHOGONAL SERIES
		series.setSeriesIdentifier("My Bar Series");
		series.setDataSet(orthoValues1);
		series.getLabel().setVisible(true);
		// series.setLabelPosition(Position.INSIDE_LITERAL);

		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION

		SeriesDefinition sdX = SeriesDefinitionImpl.create();
		sdX.getSeriesPalette().update(0); // SET THE COLORS IN THE PALETTE
		xAxisPrimary.getSeriesDefinitions().add(sdX);
		sdX.getSeries().add(seCategory);

		// WRAP THE ORTHOGONAL SERIES IN THE X-AXIS SERIES DEFINITION

		SeriesDefinition sdY = SeriesDefinitionImpl.create();
		sdY.getSeriesPalette().update(1); // SET THE COLOR IN THE PALETTE
		yAxisPrimary.getSeriesDefinitions().add(sdY);
		sdY.getSeries().add(series);

		cm = cwaBar;
	}

	public void exportChartToPNG(String fileName) {
		if (values == null || probabilities == null) {
			System.err.println("no data to visualize !");
			return;
		}
		createChart(values, probabilities);
		
		PNGExporter pngr = new PNGExporter(cm);
		pngr.exportChartToPNGImage(fileName);
	}

	/**
	 * 
	 */
	public void startAs(int app) {
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
	public int getChartTyp() {
		return chartTyp;
	}

	/**
	 * @param chartTyp
	 *            the chartTyp to set
	 */
	public void setChartTyp(int chartTyp) {
		if (chartTyp != BARCHART && chartTyp != LINECHART) {
			System.err.println("Illegal chart typ: " + chartTyp);
			return;
		}
		this.chartTyp = chartTyp;
	}

	/**
	 * @param domainLength
	 *            the domainLength to set
	 */
	public void setDomainLength(int domainLength) {
		this.domainLength = domainLength;
	}

}
