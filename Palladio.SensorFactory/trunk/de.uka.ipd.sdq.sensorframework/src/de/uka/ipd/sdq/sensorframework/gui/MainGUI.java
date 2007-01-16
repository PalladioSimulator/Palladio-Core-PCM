package de.uka.ipd.sdq.sensorframework.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jvnet.substance.SubstanceLookAndFeel;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanSensorToDatasetAdapterFactory;

class MyTreeNode extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2200975732823852734L;
	private String label;
	private Object metadata;

	public MyTreeNode(String label, Object metadata) {
		this.label = label;
		this.metadata = metadata;
	}

	public String getLabel() {
		return label;
	}

	public Object getMetadata() {
		return metadata;
	}
	
	public String toString(){
		return label;
	}
}

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9079833918588138895L;
	private JTree myTree = null;
	
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			MainGUI frame = new MainGUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private final JTabbedPane tabbedPane;
	
	/**
	 * Create the frame
	 */
	public MainGUI() {
		super();
		setTitle("SensorFactory Viewer");
		setName("mainFrame");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);

		tabbedPane = new JTabbedPane();
		splitPane.setRightComponent(tabbedPane);

		final JTree tree = new JTree();
		tree.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() > 1)
				{
					MyTreeNode node = (MyTreeNode) tree.getSelectionPath().getLastPathComponent();
					if (node.getMetadata() instanceof Sensor){
						displaySensor((Sensor)node.getMetadata());
					}
				}
				if (event.getButton() == MouseEvent.BUTTON3){
					JPopupMenu menu = new JPopupMenu();
					JMenu menuPopup = new JMenu("Add to diagram");
					menu.add(menuPopup);
					for (int i=0; i < tabbedPane.getTabCount(); i++) {
						JMenuItem subMenuItem = new JMenuItem(tabbedPane.getTitleAt(i));
						subMenuItem.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event) {
								MainGUI.this.addSensorToPane(event);	
							}
							
						});
						menuPopup.add(subMenuItem);
					}
					menu.show(event.getComponent(), event.getX(), event.getY());
				}
			}
		});
		splitPane.setLeftComponent(tree);
		myTree=tree;
		fillExperimentsTree();
	}
	
	protected void addSensorToPane(ActionEvent event) {
		String tabTitle = event.getActionCommand();
		MyTreeNode node = (MyTreeNode) myTree.getSelectionPath().getLastPathComponent();
		Sensor sensor = (Sensor) node.getMetadata();
		XYSeries density = (XYSeries)AdapterRegistry.singleton().getAdapter(sensor, XYSeries.class);
		for (int i=0; i<tabbedPane.getTabCount(); i++) {
			if(tabbedPane.getTitleAt(i).equals(tabTitle)) {
				MyChartPanel p = (MyChartPanel)tabbedPane.getComponentAt(i);
				((DefaultTableXYDataset)p.getChart().getXYPlot().getDataset()).addSeries(density);
			}
		}
	}

	protected void displaySensor(Sensor sensor) {
		System.out.println("Display Sensor "+sensor.getSensorName());
		XYSeries density = (XYSeries)AdapterRegistry.singleton().getAdapter(sensor, XYSeries.class);
		
		DefaultTableXYDataset densityDataset=new DefaultTableXYDataset();
		densityDataset.addSeries(density);
		densityDataset.setIntervalWidth(TimeSpanSensorToDatasetAdapterFactory.HISTOGRAM_CLASS_WIDTH);
		JFreeChart myChart = ChartFactory.createHistogram("Histogram of Sensor "+sensor.getSensorName(),"Time [s]","Probability", densityDataset,PlotOrientation.VERTICAL,true,true,true);
		MyChartPanel chartPanel = new MyChartPanel(myChart);

		XYPlot plot = (XYPlot)myChart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.setForegroundAlpha(0.8f); // for transparency
		
		chartPanel.putClientProperty(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,
				Boolean.TRUE);

		tabbedPane.addTab(sensor.getSensorName(),chartPanel);
	}

	private void fillExperimentsTree(){
		DefaultMutableTreeNode root =
	        new DefaultMutableTreeNode("Experiments");
		Collection<Experiment> experiments = ExperimentDAO.singleton().getExperiments();
		for(Experiment e:experiments) {
			MyTreeNode newNode =
		        new MyTreeNode(e.getExperimentName(),e);
			for(Sensor s:e.getSensors()){
				MyTreeNode newNode2 =
			        new MyTreeNode(s.getSensorName(),s);
				newNode.add(newNode2);
			}
			root.add(newNode);
		}
		myTree.setModel(new DefaultTreeModel(root));
	}

}
