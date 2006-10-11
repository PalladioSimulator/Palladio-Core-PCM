/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.visualization;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.ChartDimension;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.Position;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
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
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
import org.eclipse.birt.chart.script.IExternalContext;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;

/**
 * @author Ihssane
 * 
 */
public class Visualization implements PaintListener {

	
	private IDeviceRenderer idr = null;
	private Chart cm = null;

	private String frameTilte = EMPTY_TITLE;
	private String chartTitle = EMPTY_TITLE;
	private String xAxisTitle = EMPTY_TITLE;
	private String yAxisTitle = EMPTY_TITLE;
	private ColorDefinition backgroung = DEFAULt_BACKGROUND;
	private boolean isChartTilteVisible = false;
	private boolean isXAxisTitleVisible = false;
	private boolean isYAxisTitleVisible = false;
	

	private static final String EMPTY_TITLE = "";
	private static final ColorDefinition DEFAULt_BACKGROUND = ColorDefinitionImpl
			.WHITE();

	public Visualization() {
		System.setProperty("STANDALONE", "true");
		final PluginSettings ps = PluginSettings.instance();
		try {
			idr = ps.getDevice("dv.SWT");
		} catch (ChartException pex) {
			DefaultLoggerImpl.instance().log(pex);
		}
	}

	public static void main(String[] ihs) {
		Visualization scv = new Visualization();
		IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
		
		IBoxedPDF boxed = pfFactory.createBoxedPDF(null);
		boxed.getSamples().add(pfFactory.createContinuousSample(0.9, 0.3));
		boxed.getSamples().add(pfFactory.createContinuousSample(1.5, 0.4));
		boxed.getSamples().add(pfFactory.createContinuousSample(1.8, 0.2));
		boxed.getSamples().add(pfFactory.createContinuousSample(2.4, 0.1));
		scv.addProbabilityFunction(boxed);
		scv.visualize();

	}

	public void visualize() {
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
		cCenter.addPaintListener(this);
		sh.open();
		while (!sh.isDisposed()) {
			if (!d.readAndDispatch()) {
				d.sleep();
			}
		}
	}

	/**
	 * @param pmf
	 */
	public void addProbabilityFunction(IProbabilityMassFunction pmf) {
		List<Object> values = new ArrayList<Object>();
		List<Double> probs = new ArrayList<Double>();
		for (ISample s : pmf.getSamples()) {
			values.add(s.getValue());
			probs.add(s.getProbability());
		}
		createChart(values, probs);
	}

	/**
	 * @param spdf
	 */
	public void addProbabilityFunction(ISamplePDF spdf) {
		List<Object> values = new ArrayList<Object>();
		for (int i = 1; i <= spdf.getValues().size(); i++)
			values.add(new Double(i));
		createChart(values, spdf.getValuesAsDouble());
	}

	/**
	 * @param bpdf
	 */
	public void addProbabilityFunction(IBoxedPDF bpdf) {
		List<Object> values = new ArrayList<Object>();
		List<Double> probs = new ArrayList<Double>();
		for (IContinuousSample s : bpdf.getSamples()) {
			values.add(s.getValue());
			probs.add(s.getProbability());
		}
		createChart(values, probs);
	}

	@SuppressWarnings("unchecked")
	private void createChart(List<Object> values, List<Double> prob) {
		// BAR CHARTS ARE BASED ON CHARTS THAT CONTAIN AXES
		ChartWithAxes cwaBar = ChartWithAxesImpl.create();
		cwaBar.getBlock().setBackground(backgroung);
		cwaBar.getBlock().getOutline().setVisible(true);
		cwaBar.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);

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
		xAxisPrimary.setType(AxisType.TEXT_LITERAL);
		xAxisPrimary.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);
		xAxisPrimary.getOrigin().setType(IntersectionType.VALUE_LITERAL);
		xAxisPrimary.getTitle().getCaption().setValue(xAxisTitle);
		xAxisPrimary.getTitle().setVisible(isXAxisTitleVisible);

		// CUSTOMIZE THE Y-AXIS
		Axis yAxisPrimary = cwaBar.getPrimaryOrthogonalAxis(xAxisPrimary);
		yAxisPrimary.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);
		yAxisPrimary.getMajorGrid().setTickCount(2);
		yAxisPrimary.getMajorGrid().setTickSize(10);
		yAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		yAxisPrimary.getLabel().getCaption().getFont().setRotation(90);
		yAxisPrimary.getTitle().getCaption().setValue(yAxisTitle);
		yAxisPrimary.getTitle().setVisible(isYAxisTitleVisible);

		// INITIALIZE A COLLECTION WITH THE X-SERIES DATA
		// INITIALIZE A COLLECTION WITH THE Y-SERIES DATA

		TextDataSet categoryValues = TextDataSetImpl.create(values);
		NumberDataSet orthoValues1 = NumberDataSetImpl.create(prob);

		// CREATE THE CATEGORY BASE SERIES

		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);

		// CREATE THE VALUE ORTHOGONAL SERIES

		BarSeries bs1 = (BarSeries) BarSeriesImpl.create();
		bs1.setSeriesIdentifier("My Bar Series");
		bs1.setDataSet(orthoValues1);
		bs1.setRiserOutline(null);
		bs1.getLabel().setVisible(true);
		bs1.setLabelPosition(Position.INSIDE_LITERAL);

		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION

		SeriesDefinition sdX = SeriesDefinitionImpl.create();
		sdX.getSeriesPalette().update(0); // SET THE COLORS IN THE PALETTE
		xAxisPrimary.getSeriesDefinitions().add(sdX);
		sdX.getSeries().add(seCategory);

		// WRAP THE ORTHOGONAL SERIES IN THE X-AXIS SERIES DEFINITION

		SeriesDefinition sdY = SeriesDefinitionImpl.create();
		sdY.getSeriesPalette().update(1); // SET THE COLOR IN THE PALETTE
		yAxisPrimary.getSeriesDefinitions().add(sdY);
		sdY.getSeries().add(bs1);

		cm = cwaBar;
	}

	public void paintControl(PaintEvent pe) {
		idr.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, pe.gc);
		Composite co = (Composite) pe.getSource();
		Rectangle re = co.getClientArea();
		Bounds bo = BoundsImpl.create(re.x, re.y, re.width, re.height);
		bo.scale(72d / idr.getDisplayServer().getDpiResolution()); // BOUNDS

		Generator gr = Generator.instance();
		GeneratedChartState state;
		try {
			state = gr.build(idr.getDisplayServer(), cm, bo,
					(IExternalContext) null, null);
			gr.render(idr, state);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
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

}
