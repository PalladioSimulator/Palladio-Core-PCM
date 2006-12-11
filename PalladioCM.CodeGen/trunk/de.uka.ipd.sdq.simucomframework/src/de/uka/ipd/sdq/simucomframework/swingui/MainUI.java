package de.uka.ipd.sdq.simucomframework.swingui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jvnet.substance.SubstanceLookAndFeel;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.ISensorObserver;
import de.uka.ipd.sdq.simucomframework.sensors.SensorAddedEvent;
import de.uka.ipd.sdq.simucomframework.sensors.SensorFactory;

class ValueSupplierObserver implements Observer
{
	public static final double HISTOGRAM_CLASS_WIDTH = 0.1;
	XYSeries series = null;
	
	public ValueSupplierObserver(XYSeries series)
	{
		this.series = series;
	}
	
	public void update(Observable o, Object newValue)
	{
		int histogramClass = (int)((((Double)newValue)+HISTOGRAM_CLASS_WIDTH/2) / HISTOGRAM_CLASS_WIDTH);
		int index = series.indexOf(histogramClass*HISTOGRAM_CLASS_WIDTH);
		if (index >= 0)
		{
			Number oldValue = series.getY(index);
			series.update(index,(Number)(oldValue.intValue()+1));
		}
		else
			series.add(histogramClass*HISTOGRAM_CLASS_WIDTH,(double)1);
	}
}

public class MainUI extends JFrame {

	JProgressBar progressBar = null;
	JSplitPane splitPane = null;
	SimuComModel myModel = null;
	JList sensorList = null;
	JTabbedPane tabbedPane = null;
	DefaultListModel myListModel = null;
	
	private HashMap<String,DefaultTableXYDataset>datasets = new HashMap<String,DefaultTableXYDataset>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainUI(SimuComModel model)
	{
		super("SimuCom Monitor");
		try {
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			System.out.println("The substance GUI lib is required for execution but was not found in the classpath!");
			e1.printStackTrace();
			System.exit(-1);
		}
		
		this.myModel = model;
		
		this.setLayout(new BorderLayout());

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		progressBar = new JProgressBar(0,(int)model.getExperiment().getStopTime().getTimeValue());
		progressBar.setStringPainted(true);
		progressBar.setPreferredSize(new Dimension(-1,50));
		progressBar.setMinimumSize(new Dimension(-1,50));
		model.getExperiment().getSimClock().addObserver(new Observer(){
			 public void update(Observable o, Object arg)
			 {
				 int currentTime = (int)myModel.currentTime().getTimeValue();
				 progressBar.setValue(currentTime);
			 }
		});
		this.add(progressBar,BorderLayout.SOUTH);

		myListModel = new DefaultListModel();
		sensorList = new JList(myListModel);
		sensorList.setMinimumSize(new Dimension(100,-1));
		SensorFactory.singleton().addSensorObserver(new ISensorObserver(){
			public void sensorAddedEvent(SensorAddedEvent e)
			{
				myListModel.addElement(e.getId());
				addXYSeries(e);
			}
		});
		sensorList.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e) {
              if (e.getClickCount() == 2) {
                 int index = sensorList.locationToIndex(e.getPoint());
                 openTabForId((String)myListModel.getElementAt(index));
              }
          }
        });
		
		tabbedPane = new JTabbedPane();
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sensorList,tabbedPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(0.25);
		this.add(splitPane,BorderLayout.CENTER);
		
		
		this.setSize(800,600);
		this.setLocation(
		        (Toolkit.getDefaultToolkit().getScreenSize().width-
		         getSize().width) / 2,
		        (Toolkit.getDefaultToolkit().getScreenSize().height-
		         getSize().height) / 2);		
	}
	
	private void openTabForId(String id)
	{
		if (tabbedPane.indexOfTab(id) < 0)
		{
			DefaultTableXYDataset dataset = datasets.get(id);
			XYSeries density = normalizeSeries(dataset.getSeries(0));
			
			DefaultTableXYDataset densityDataset=new DefaultTableXYDataset();
			densityDataset.addSeries(density);
			densityDataset.setIntervalWidth(ValueSupplierObserver.HISTOGRAM_CLASS_WIDTH);
			JFreeChart myChart = ChartFactory.createHistogram("Histogram of Sensor "+id,"Time [s]","Probability", densityDataset,PlotOrientation.VERTICAL,true,true,true);
//			JFreeChart myChart = ChartFactory.createXYLineChart("Histogram of Sensor "+id,"Time [s]","Number", densityDataset,PlotOrientation.VERTICAL,true,true,true);
			ChartPanel chartPanel = new MyChartPanel(myChart,densityDataset);
	
			XYPlot plot = (XYPlot)myChart.getPlot();
			plot.getRangeAxis().setAutoRange(true);
			
			chartPanel.putClientProperty(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,
					Boolean.TRUE);
	
			tabbedPane.addTab(id,chartPanel);
		}
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(id));
	}
	
	private void addXYSeries(SensorAddedEvent e)
	{
		DefaultTableXYDataset dataset=new DefaultTableXYDataset();
		XYSeries series = new XYSeries(e.getId(),true,false);
		dataset.addSeries(series);
		dataset.setIntervalWidth(ValueSupplierObserver.HISTOGRAM_CLASS_WIDTH);
		datasets.put(e.getId(),dataset);
		e.getSupplier().addObserver(new ValueSupplierObserver(series));
	}
	
	private XYSeries normalizeSeries(XYSeries series)
	{
		XYSeries result = new XYSeries("Probability [simulated]",true,false);
		int numberOfObservations = 0;
		XYSeries workingSeries = null;
		try {
			workingSeries = (XYSeries) series.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		for (int i = 0, n=workingSeries.getItemCount(); i < n; i++)
		{
			numberOfObservations += workingSeries.getDataItem(i).getY().intValue();
		}
		for (int i = 0, n=workingSeries.getItemCount(); i < n; i++)
		{
			Number x = workingSeries.getDataItem(i).getX();
			double y = workingSeries.getDataItem(i).getY().doubleValue()/numberOfObservations;
			result.add(new XYDataItem(x,y));
		}
		return result;
	}
}
