package de.uka.ipd.sdq.simucom.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.eclipse.uml2.Activity;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.simucom.component.Component;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;
import desmoj.core.statistic.Histogram;
import desmoj.core.statistic.ValueSupplier;

class ResponseTimeValueSupplier
extends ValueSupplier
{
	protected double lastValue;
	public ResponseTimeValueSupplier(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double value() {
		// TODO Auto-generated method stub
		return lastValue;
	}

	public void newResponseTimeMeassurment(double responseTime)
	{
		lastValue = responseTime;
		notifyStatistics(new Double(responseTime));
	}
}

public class User
extends SimProcess
implements Observer
{

	protected int thinkTime;
	protected boolean thinkFirst;
	protected Activity activity;
	protected Component interactionComponent;
	protected Histogram responseTimeDistribution = null;
	protected ResponseTimeValueSupplier supplier = new ResponseTimeValueSupplier("ResponseTimeSupplier");
	protected XYSeries series;
	protected JFrame graphFrame;
	protected JFreeChart myChart;
	protected ChartPanel chartPanel;
	
	public User(Model model, String name, boolean hasTrace) {
		super(model, name, hasTrace);

		graphFrame = new JFrame("Result: "+getName());
		DefaultTableXYDataset dataset=new DefaultTableXYDataset();
		series = new XYSeries(getName(),true,false);
		dataset.addSeries(series);
		dataset.setIntervalWidth(1);
		myChart = ChartFactory.createHistogram("Response Time Histogram of "+getName(),"Time [ms]","Number", dataset,PlotOrientation.VERTICAL,true,true,true);
		XYPlot plot = (XYPlot)myChart.getPlot();
		plot.getRangeAxis().setRange(0,400d);
		graphFrame.setSize(600,400);
		graphFrame.setLocation(
		        (Toolkit.getDefaultToolkit().getScreenSize().width-
		         graphFrame.getSize().width) / 2,
		        (Toolkit.getDefaultToolkit().getScreenSize().height-
		         graphFrame.getSize().height) / 2);		
		graphFrame.getContentPane().setLayout(new BorderLayout());
		chartPanel = new ChartPanel(myChart);
		graphFrame.getContentPane().add(chartPanel,BorderLayout.CENTER);
		graphFrame.setVisible(true);
	}

	public void init(Activity a, int thinkTime, boolean thinkFirst, Component interactionComponent)
	{
		this.thinkFirst = thinkFirst;
		this.thinkTime = thinkTime;
		this.activity = a;
		this.interactionComponent = interactionComponent;
		responseTimeDistribution = new Histogram(getModel(), "UserResponseTime", supplier ,0, 1500, 150, true, false);
		supplier.addObserver(this);
	}
	
	@Override
	public void lifeCycle() {
		ArrayList<HistoryElement> history = new ArrayList<HistoryElement>();
		UserActivityVisitor visitor = new UserActivityVisitor(this, history,
				interactionComponent);

		try {
			if (thinkFirst)
				this.hold(new SimTime(thinkTime));
			while (true) {
				double activityStart = this.currentTime().getTimeValue();
				visitor.visitActivity(activity);
				// responseTimeDistribution.update(this.currentTime().getTimeValue()-activityStart);
				supplier.newResponseTimeMeassurment(this.currentTime().getTimeValue()-activityStart);
				
				this.hold(new SimTime(thinkTime));
			}
		} catch (Exception ex) {
			System.out.println("Simulated User caused exception: "
					+ ex.getMessage());
			// System.exit(-1);
		}
	}

	public void update(Observable arg0, Object arg1) {
		int index = series.indexOf((Double)arg1);
		if (index >= 0)
		{
			Number oldValue = series.getY(index);
			series.update(index,(Number)(oldValue.intValue()+1));
		}
		else
			series.add((Number) arg1,(double)1);
		chartPanel.repaint();	
		//chartPanel.scale(new Rectangle2D(1.0,1.0));
	}
}

	