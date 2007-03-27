package de.uka.ipd.sdq.pcmsolver.tests;
//package de.uka.ipd.sdq.dsolver.tests;
//
//import static org.junit.Assert.assertTrue;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Toolkit;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map.Entry;
//
//import javax.swing.JFrame;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.data.xy.DefaultTableXYDataset;
//import org.jfree.data.xy.XYSeries;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
//import de.uka.ipd.sdq.probfunction.math.IMappedSample;
//import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
//import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
//import de.uka.ipd.sdq.probfunction.math.IUnit;
//import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
//import de.uka.ipd.sdq.probfunction.math.impl.MappedBoxedPDFImpl;
//import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
//import de.uka.ipd.sdq.probfunction.math.impl.UnitImpl;
//import de.uka.ipd.sdq.probfunction.math.impl.MappedBoxedPDFImpl.Operation;
//
//import junit.framework.JUnit4TestAdapter;
//
//public class MappedBoxedPDFTest {
//
//	public static final double EPSILON_ERROR = 1e-10;
//	
//	private IBoxedPDF mbPDF01;
//	private IBoxedPDF mbPDF02;
//	private IBoxedPDF mbPDF03;
//	private IBoxedPDF mbPDF1;
//	private IBoxedPDF mbPDF2;
//	private IBoxedPDF mbPDF3;
//	
//	private static DefaultTableXYDataset dataset = new DefaultTableXYDataset(); 
//	
//	protected static final IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
//	
//	@Before
//	public void setUp(){
//
//		HashMap<String,Double> mappingX0 = new HashMap<String, Double>();
//		
//		HashMap<String,Double> mappingX1 = new HashMap<String, Double>();
//		mappingX1.put("X",1.0);
//		HashMap<String,Double> mappingX2 = new HashMap<String, Double>();
//		mappingX2.put("X",2.0);
//		HashMap<String,Double> mappingX3 = new HashMap<String, Double>();
//		mappingX3.put("X",3.0);
//		
//		HashMap<String,Double> mappingY1 = new HashMap<String, Double>();
//		mappingY1.put("Y",2.0);
//		HashMap<String,Double> mappingY2 = new HashMap<String, Double>();
//		mappingY2.put("Y",4.0);
//		HashMap<String,Double> mappingY3 = new HashMap<String, Double>();
//		mappingY3.put("Y",6.0);
//		
//		HashMap<String,Double> mappingZ1 = new HashMap<String, Double>();
//		mappingZ1.put("Z",3.0);
//		HashMap<String,Double> mappingZ2 = new HashMap<String, Double>();
//		mappingZ2.put("Z",4.0);
//		HashMap<String,Double> mappingZ3 = new HashMap<String, Double>();
//		mappingZ3.put("Z",5.0);
//		
//		List<IMappedSample> samples01 = new ArrayList<IMappedSample>();
//		samples01.add(pfFactory.createMappedContinuousSample(1, 0.2, (HashMap<String, Double>)mappingX0.clone()));
//		samples01.add(pfFactory.createMappedContinuousSample(2, 0.5, (HashMap<String, Double>)mappingX0.clone()));
//		samples01.add(pfFactory.createMappedContinuousSample(3, 0.3, (HashMap<String, Double>)mappingX0.clone()));
//		mbPDF01 = pfFactory.createMappedBoxedPDF(samples01, pfFactory.createDefaultUnit());
//		
//		List<IMappedSample> samples1 = new ArrayList<IMappedSample>();
//		samples1.add(pfFactory.createMappedContinuousSample(1, 0.2, mappingX1));
//		samples1.add(pfFactory.createMappedContinuousSample(2, 0.5, mappingX2));
//		samples1.add(pfFactory.createMappedContinuousSample(3, 0.3, mappingX3));
//		mbPDF1 = pfFactory.createMappedBoxedPDF(samples1, pfFactory.createDefaultUnit());
//		
//		List<IMappedSample> samples02 = new ArrayList<IMappedSample>();
//		samples02.add(pfFactory.createMappedContinuousSample(2, 0.5, (HashMap<String, Double>)mappingX0.clone()));
//		samples02.add(pfFactory.createMappedContinuousSample(4, 0.3, (HashMap<String, Double>)mappingX0.clone()));
//		samples02.add(pfFactory.createMappedContinuousSample(6, 0.2, (HashMap<String, Double>)mappingX0.clone()));
//		mbPDF02 = pfFactory.createMappedBoxedPDF(samples02, pfFactory.createDefaultUnit());
//		
//		List<IMappedSample> samples2 = new ArrayList<IMappedSample>();
//		samples2.add(pfFactory.createMappedContinuousSample(2, 0.5, mappingY1));
//		samples2.add(pfFactory.createMappedContinuousSample(4, 0.3, mappingY2));
//		samples2.add(pfFactory.createMappedContinuousSample(6, 0.2, mappingY3));
//		mbPDF2 = pfFactory.createMappedBoxedPDF(samples2, pfFactory.createDefaultUnit());
//
//		List<IMappedSample> samples03 = new ArrayList<IMappedSample>();
//		samples03.add(pfFactory.createMappedContinuousSample(3, 0.8, (HashMap<String, Double>)mappingX0.clone()));
//		samples03.add(pfFactory.createMappedContinuousSample(4, 0.1, (HashMap<String, Double>)mappingX0.clone()));
//		samples03.add(pfFactory.createMappedContinuousSample(5, 0.1, (HashMap<String, Double>)mappingX0.clone()));
//		mbPDF03 = pfFactory.createMappedBoxedPDF(samples03, pfFactory.createDefaultUnit());
//		
//		List<IMappedSample> samples3 = new ArrayList<IMappedSample>();
//		samples3.add(pfFactory.createMappedContinuousSample(3, 0.8, mappingZ1));
//		samples3.add(pfFactory.createMappedContinuousSample(4, 0.1, mappingZ2));
//		samples3.add(pfFactory.createMappedContinuousSample(5, 0.1, mappingZ3));
//		mbPDF3 = pfFactory.createMappedBoxedPDF(samples3, pfFactory.createDefaultUnit());
//		
//		HashMap<String, HashMap<Double,Double>> variables= new HashMap<String, HashMap<Double,Double>>();
//		HashMap<Double,Double> inner1 = new HashMap<Double,Double>();
//		inner1.put(1.0, 0.2);
//		inner1.put(2.0, 0.5);
//		inner1.put(3.0, 0.3);
//		variables.put("X", inner1);
//		HashMap<Double,Double> inner2 = new HashMap<Double,Double>();
//		inner2.put(2.0, 0.5);
//		inner2.put(4.0, 0.3);
//		inner2.put(6.0, 0.2);
//		variables.put("Y", inner2);
//		HashMap<Double,Double> inner3 = new HashMap<Double,Double>();
//		inner3.put(3.0, 0.8);
//		inner3.put(4.0, 0.1);
//		inner3.put(5.0, 0.1);
//		variables.put("Z", inner3);
//		((MappedBoxedPDFImpl)mbPDF1).variables = (HashMap<String, HashMap<Double,Double>>)variables.clone();
//		((MappedBoxedPDFImpl)mbPDF2).variables = (HashMap<String, HashMap<Double,Double>>)variables.clone();
//		
//
//		
//	}
//	
//	
//	@Test
//	public void operateXPlusXIndependent(){
//		MappedBoxedPDFImpl mbPDF00 = (MappedBoxedPDFImpl)mbPDF01;
//		
//		IProbabilityDensityFunction resultPDF = mbPDF00.operate(Operation.ADD, mbPDF00);
//		MappedBoxedPDFImpl resultMappedPDF = (MappedBoxedPDFImpl) resultPDF;
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(2.0),0.04));
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(3.0),0.2));
//		//visualize((MappedBoxedPDFImpl)resultPDF);
//	}
//	
//	@Test
//	public void operateXPlusX(){
//		MappedBoxedPDFImpl mbPDF11 = (MappedBoxedPDFImpl)mbPDF1;
//		
//		IProbabilityDensityFunction resultPDF = mbPDF11.operate(Operation.ADD, mbPDF11);
//		MappedBoxedPDFImpl resultMappedPDF = (MappedBoxedPDFImpl) resultPDF;
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(2.0),0.2));
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(4.0),0.5));
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(6.0),0.3));
//		//visualize((MappedBoxedPDFImpl)resultPDF);
//	}
//	
//	@Test
//	public void operateXPlusY(){
//		MappedBoxedPDFImpl mbPDF11 = (MappedBoxedPDFImpl)mbPDF1;
//		MappedBoxedPDFImpl mbPDF21 = (MappedBoxedPDFImpl)mbPDF2;
//		
//		IProbabilityDensityFunction XPlusY= mbPDF11.operate(Operation.ADD, (MappedBoxedPDFImpl)mbPDF21);
//		MappedBoxedPDFImpl result1 = (MappedBoxedPDFImpl) XPlusY;
//		assertTrue(equalsDouble(result1.getPoints().get(3.0),0.1));
//		assertTrue(equalsDouble(result1.getPoints().get(5.0),0.21));
//	}
//	
//	
//	@Test
//	public void operateXPlusY_Plus_XPlusY(){
//	
//		MappedBoxedPDFImpl mbPDF11 = (MappedBoxedPDFImpl)mbPDF1;
//		MappedBoxedPDFImpl mbPDF21 = (MappedBoxedPDFImpl)mbPDF2;
//		
//		IProbabilityDensityFunction XPlusY= mbPDF11.operate(Operation.ADD, (MappedBoxedPDFImpl)mbPDF21);
//		MappedBoxedPDFImpl result1 = (MappedBoxedPDFImpl) XPlusY;
//		result1.variables = (HashMap<String, HashMap<Double,Double>>)mbPDF11.variables.clone();
//		
//		IProbabilityDensityFunction resultPDF = result1.operate(Operation.ADD, result1);
//		MappedBoxedPDFImpl resultMappedPDF = (MappedBoxedPDFImpl) resultPDF;
//		HashMap<Double,Double> blah = resultMappedPDF.getPoints();
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(6.0),0.1));
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(8.0),0.25));
//		
//	}
//	
//	@Test
//	public void operateXPlusY_Plus_XPlusZ(){
//		
//		MappedBoxedPDFImpl mbPDF11 = (MappedBoxedPDFImpl)mbPDF1;
//		MappedBoxedPDFImpl mbPDF21 = (MappedBoxedPDFImpl)mbPDF2;
//		MappedBoxedPDFImpl mbPDF31 = (MappedBoxedPDFImpl)mbPDF3;
//		
//		IProbabilityDensityFunction XPlusY = mbPDF11.operate(Operation.ADD, (MappedBoxedPDFImpl)mbPDF21);
//		MappedBoxedPDFImpl result1 = (MappedBoxedPDFImpl) XPlusY;
//		result1.variables = (HashMap<String, HashMap<Double,Double>>)mbPDF11.variables.clone();
//		
//		IProbabilityDensityFunction XPlusZ = mbPDF11.operate(Operation.ADD, (MappedBoxedPDFImpl)mbPDF31);
//		MappedBoxedPDFImpl result2 = (MappedBoxedPDFImpl) XPlusZ;
//		result2.variables = (HashMap<String, HashMap<Double,Double>>)mbPDF11.variables.clone();
//		
//		IProbabilityDensityFunction resultPDF = result1.operate(Operation.ADD, result2);
//		MappedBoxedPDFImpl resultMappedPDF = (MappedBoxedPDFImpl) resultPDF;
//		
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(7.0),0.08));
//		assertTrue(equalsDouble(resultMappedPDF.getPoints().get(8.0),0.01));
//		
//		HashMap<Double,Double> points = resultMappedPDF.getPoints();
//		double sum = 0.0;
//		for (Double key : points.keySet()){
//			sum += points.get(key);
//		}
//		assertTrue(equalsDouble(sum,1.0));
//		
//		addToDataset(resultMappedPDF);
//		//visualize();
//		//visualize((MappedBoxedPDFImpl)resultPDF);
//	}
//	
//	@Test
//	public void operateXPlusY_Plus_XPlusZIndependent(){
//		
//		MappedBoxedPDFImpl mbPDF11 = (MappedBoxedPDFImpl)mbPDF01;
//		MappedBoxedPDFImpl mbPDF21 = (MappedBoxedPDFImpl)mbPDF02;
//		MappedBoxedPDFImpl mbPDF31 = (MappedBoxedPDFImpl)mbPDF03;
//		
//		IProbabilityDensityFunction XPlusY = mbPDF11.operate(Operation.ADD, (MappedBoxedPDFImpl)mbPDF21);
//		MappedBoxedPDFImpl result1 = (MappedBoxedPDFImpl) XPlusY;
//		result1.variables = (HashMap<String, HashMap<Double,Double>>)mbPDF11.variables.clone();
//		
//		IProbabilityDensityFunction XPlusZ = mbPDF11.operate(Operation.ADD, (MappedBoxedPDFImpl)mbPDF31);
//		MappedBoxedPDFImpl result2 = (MappedBoxedPDFImpl) XPlusZ;
//		result2.variables = (HashMap<String, HashMap<Double,Double>>)mbPDF11.variables.clone();
//		
//		IProbabilityDensityFunction resultPDF = result1.operate(Operation.ADD, result2);
//		MappedBoxedPDFImpl resultMappedPDF = (MappedBoxedPDFImpl) resultPDF;
//		
//		//assertTrue(equalsDouble(resultMappedPDF.getPoints().get(7.0),0.08));
//		//assertTrue(equalsDouble(resultMappedPDF.getPoints().get(8.0),0.01));
//		
//		HashMap<Double,Double> points = resultMappedPDF.getPoints();
//		double sum = 0.0;
//		for (Double key : points.keySet()){
//			sum += points.get(key);
//		}
//		assertTrue(equalsDouble(sum,1.0));
//		
//		addToDataset(resultMappedPDF);
//		visualize();
//	}
//
//	
//	public static boolean equalsDouble(double d1, double d2) {
//		boolean result = false;
//		if (d1 == Double.NaN && d2 == Double.NaN) {
//			result = true;
//		} else {
//			result = (Math.abs(d1 - d2) < EPSILON_ERROR);
//		}
//		return result;
//	}
//	
//	private void addToDataset(MappedBoxedPDFImpl mappedBoxedPDF){
//		//DefaultTableXYDataset dataset = new DefaultTableXYDataset();
//		
//		double distance = 1.0;
//		//mappedBoxedPDF = mappedBoxedPDF.getFunctionWithNewDistance(distance);
//		
//		XYSeries series = new XYSeries("Execution Time", true, false);
//
//		HashMap<Double,Double> points = mappedBoxedPDF.getPoints();
//		for (Double key : points.keySet()){
//			series.add(key, points.get(key));
//		}
//		dataset.addSeries(series);
//		dataset.setIntervalWidth(distance);
//		
//	}
//	
//	
//	private void visualize() {
//		JFreeChart myChart = ChartFactory.createHistogram(
//				"Test Time Histogram", 
//				"Time",
//				"Probability", 
//				dataset, 
//				PlotOrientation.VERTICAL, 
//				true, 
//				true,
//				true);
//
//		XYPlot plot = (XYPlot) myChart.getPlot();
//		plot.getRenderer().setSeriesPaint(0, Color.LIGHT_GRAY); // Foreground Series
//		plot.getRenderer().setSeriesPaint(1, Color.DARK_GRAY); // Background Series
//		plot.setForegroundAlpha(0.8f); // for transparency
//		//plot.getRangeAxis().setRange(0, 0.312d);
//		//plot.getDomainAxis().setRange(5.8, 18.2);
//		plot.getRangeAxis().setAutoRange(true);
//		plot.setBackgroundPaint(Color.white);
//
//		
//		ChartPanel chartPanel = new ChartPanel(myChart);
//
//		JFrame graphFrame = new JFrame("Execution Time");
//		graphFrame.setSize(800, 600);
//		graphFrame
//				.setLocation(
//						(Toolkit.getDefaultToolkit().getScreenSize().width - graphFrame
//								.getSize().width) / 2,
//						(Toolkit.getDefaultToolkit().getScreenSize().height - graphFrame
//								.getSize().height) / 2);
//		graphFrame.getContentPane().setLayout(new BorderLayout());
//		graphFrame.getContentPane().add(chartPanel, BorderLayout.CENTER);
//		graphFrame.setVisible(true);
//	}
//
//	public static junit.framework.Test suite() {
//		return new JUnit4TestAdapter(MappedBoxedPDFTest.class);
//	}
//	
//}
