package de.uka.ipd.sdq.simucomframework.swingui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

/**
 * @author Snowball
 *
 */
public class MyChartPanel extends ChartPanel {

	private DefaultTableXYDataset myDataset;

	/**
	 * @param chart
	 */
	public MyChartPanel(JFreeChart chart) {
		super(chart);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param chart
	 * @param useBuffer
	 */
	public MyChartPanel(JFreeChart chart, boolean useBuffer) {
		super(chart, useBuffer);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param chart
	 * @param properties
	 * @param save
	 * @param print
	 * @param zoom
	 * @param tooltips
	 */
	public MyChartPanel(JFreeChart chart, boolean properties, boolean save,
			boolean print, boolean zoom, boolean tooltips) {
		super(chart, properties, save, print, zoom, tooltips);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param chart
	 * @param width
	 * @param height
	 * @param minimumDrawWidth
	 * @param minimumDrawHeight
	 * @param maximumDrawWidth
	 * @param maximumDrawHeight
	 * @param useBuffer
	 * @param properties
	 * @param save
	 * @param print
	 * @param zoom
	 * @param tooltips
	 */
	public MyChartPanel(JFreeChart chart, int width, int height,
			int minimumDrawWidth, int minimumDrawHeight, int maximumDrawWidth,
			int maximumDrawHeight, boolean useBuffer, boolean properties,
			boolean save, boolean print, boolean zoom, boolean tooltips) {
		super(chart, width, height, minimumDrawWidth, minimumDrawHeight,
				maximumDrawWidth, maximumDrawHeight, useBuffer, properties,
				save, print, zoom, tooltips);
		// TODO Auto-generated constructor stub
	}

	public MyChartPanel(JFreeChart myChart, DefaultTableXYDataset densityDataset) {
		this(myChart);
		this.myDataset = densityDataset;
	}

	@Override
	protected JPopupMenu createPopupMenu(boolean properties, 
               boolean save, 
               boolean print,
               boolean zoom) {
		JPopupMenu menu = super.createPopupMenu(properties, save, print, zoom);

		menu.addSeparator();
		JMenuItem loadCSV = new JMenuItem("Load CSV...");
		loadCSV.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				loadCSVSeries();
			}
			
		});
		menu.add(loadCSV);
		return menu;
	}

	protected void loadCSVSeries() {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			XYSeries series = new XYSeries("Probability [measuerd]",true,false);
			FileReader fileReader;
			BufferedReader bufferedReader;
			try {
				String row;
				fileReader = new FileReader(chooser.getSelectedFile());
				bufferedReader = new BufferedReader(fileReader);
				while((row=bufferedReader.readLine()) != null)
				{
					String[] parts = row.split(";");
					double x = Double.parseDouble(parts[0].replace(',','.'));
					double y = Double.parseDouble(parts[1].replace(',','.'));
					series.add(new XYDataItem(x,y));
				}
				myDataset.addSeries(series);
				XYPlot plot = (XYPlot)getChart().getPlot();
				
				plot.getRenderer().setSeriesPaint(0, Color.LIGHT_GRAY); 
				plot.getRenderer().setSeriesPaint(1, Color.DARK_GRAY.brighter()); 

				plot.setForegroundAlpha( 0.8f ); // for transparency

				this.repaint();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
